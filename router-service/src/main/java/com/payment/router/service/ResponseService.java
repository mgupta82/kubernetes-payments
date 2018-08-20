package com.payment.router.service;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Service;

import com.payment.router.jms.MessageProducer;
import com.payment.router.mapper.DocumentMapper;
import com.payment.router.model.Transaction;

import iso.std.iso._20022.tech.xsd.pacs_002_001.Document;
import iso.std.iso._20022.tech.xsd.pacs_002_001.FIToFIPaymentStatusReportV09;
import iso.std.iso._20022.tech.xsd.pacs_002_001.GroupHeader53;
import iso.std.iso._20022.tech.xsd.pacs_002_001.ObjectFactory;
import iso.std.iso._20022.tech.xsd.pacs_002_001.OriginalGroupHeader13;
import iso.std.iso._20022.tech.xsd.pacs_002_001.OriginalTransactionReference27;
import iso.std.iso._20022.tech.xsd.pacs_002_001.Party35Choice;
import iso.std.iso._20022.tech.xsd.pacs_002_001.PaymentTransaction91;
import iso.std.iso._20022.tech.xsd.pacs_002_001.StatusReason6Choice;
import iso.std.iso._20022.tech.xsd.pacs_002_001.StatusReasonInformation11;

@Service
public class ResponseService {
	
	private static final Logger logger = LoggerFactory.getLogger(ResponseService.class);
	
	@Autowired
	MessageProducer messageProducer;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	MarshallingService marshallingService;	
	
	@Autowired
	DocumentMapper documentMapper;	
	
	ObjectFactory objectFactory = new ObjectFactory();
	
	private final static String bankName = "BBBB";
	
	public ResponseService() {
		documentMapper = Mappers.getMapper(DocumentMapper.class);
	}

	private String generateMessageId(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input,String messageId) {
		//hack for POC
		StringBuffer id  = new StringBuffer(bankName);
		id.append("/").append(new Date().getTime());
		return id.toString();
		
	}
	
	private Document generatePlaybackResponse(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input,String messageId,boolean isSuccess) throws DatatypeConfigurationException {
		Document document = objectFactory.createDocument();
		
		FIToFIPaymentStatusReportV09 paymentStatusReport = objectFactory.createFIToFIPaymentStatusReportV09();
		document.setFIToFIPmtStsRpt(paymentStatusReport);
		
		GroupHeader53 groupHeader = objectFactory.createGroupHeader53();
		paymentStatusReport.setGrpHdr(groupHeader);
		
		groupHeader.setMsgId(generateMessageId(input,messageId));
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		groupHeader.setCreDtTm(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
		groupHeader.setInstgAgt(documentMapper.convert(input.getFIToFICstmrCdtTrf().getGrpHdr().getInstdAgt()));
		groupHeader.setInstdAgt(documentMapper.convert(input.getFIToFICstmrCdtTrf().getGrpHdr().getInstgAgt()));
		
		OriginalGroupHeader13 originalGroupHeader = objectFactory.createOriginalGroupHeader13();
		paymentStatusReport.getOrgnlGrpInfAndSts().add(originalGroupHeader);
		originalGroupHeader.setOrgnlMsgId(input.getFIToFICstmrCdtTrf().getGrpHdr().getMsgId());
		originalGroupHeader.setOrgnlMsgNmId("pacs.008.001.07");
		originalGroupHeader.setOrgnlCreDtTm(input.getFIToFICstmrCdtTrf().getGrpHdr().getCreDtTm());
		
		PaymentTransaction91 paymentTransaction = objectFactory.createPaymentTransaction91();
		paymentStatusReport.getTxInfAndSts().add(paymentTransaction);
		if(isSuccess)
			paymentTransaction.setStsId("success");
		else
			paymentTransaction.setStsId("failure");
		
		paymentTransaction.setOrgnlEndToEndId(input.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getPmtId().getEndToEndId());
		paymentTransaction.setOrgnlTxId(input.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getPmtId().getTxId());
		if(isSuccess)
			paymentTransaction.setTxSts("SUCS");
		else
			paymentTransaction.setTxSts("RJCT");
		OriginalTransactionReference27 originalTransactionReference = objectFactory.createOriginalTransactionReference27();
		paymentTransaction.setOrgnlTxRef(originalTransactionReference);
		originalTransactionReference.setIntrBkSttlmAmt(documentMapper.convert(input.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getIntrBkSttlmAmt()));
		originalTransactionReference.setIntrBkSttlmDt(input.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getIntrBkSttlmDt());
		originalTransactionReference.setReqdColltnDt(input.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getIntrBkSttlmDt());
		
		Party35Choice dbtr = objectFactory.createParty35Choice();
		originalTransactionReference.setDbtr(dbtr);
		dbtr.setPty(documentMapper.convert(input.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getDbtr()));
		
		Party35Choice cdtr = objectFactory.createParty35Choice();
		originalTransactionReference.setCdtr(cdtr);
		cdtr.setPty(documentMapper.convert(input.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getCdtr()));		
		
		return document;
	}
	
	private Document processSuccess(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input,String messageId,String corrId) throws DatatypeConfigurationException {
		Document document = generatePlaybackResponse(input,messageId,true);	
		messageProducer.send(document,corrId);
		return document;
	}
	
	private Document processFailure(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input,String messageId,ErrorCode errorCode,String corrId) throws DatatypeConfigurationException {
		
		Document document = generatePlaybackResponse(input,messageId,false);	
		
		PaymentTransaction91 paymentTransaction = document.getFIToFIPmtStsRpt().getTxInfAndSts().get(0);
		
		StatusReasonInformation11 statusReasonInfo = objectFactory.createStatusReasonInformation11();
		paymentTransaction.getStsRsnInf().add(statusReasonInfo);
		
		StatusReason6Choice reason = objectFactory.createStatusReason6Choice();
		statusReasonInfo.setRsn(reason);
		
		reason.setCd(errorCode.getReasonCode());
		
		//TODO : Any Special handling for each case
		switch(errorCode){
		
			case PERSISTENCE_ERROR : 
								break;
								
			case PARSING_ERROR : 
								break;
				
			case INVALID_BSB : 
								break;
				
			case INVALID_AMOUNT : 
								break;
				
			case DUPLICATE_REQUEST : 
								break;
				
			default : 
								break;				
								
		}
		
		messageProducer.send(document,corrId);
		return document;
	}
	
	private void processPlayback(Transaction transaction,String corrId) throws XmlMappingException, IOException {
		messageProducer.send(marshallingService.unmarshallXml(transaction.getResponsexml()),corrId);	
	}
	
	
	/**
	 * 
	 * @param request
	 * @param messageId
	 * @param errorCode
	 * @param paymentTransaction
	 */
	public void sendNack(iso.std.iso._20022.tech.xsd.pacs_008_001.Document request,String messageId,ErrorCode errorCode,Transaction transaction,String corrId) {
		logger.info("Sending NACK for : "+messageId);
		try {
			Document response = processFailure(request, messageId, errorCode,corrId);
			logger.info("NACK sent successfully  : "+messageId);
			logger.info("Correlation ID  : "+corrId);
        	if(transaction!=null) {
        		transaction.setStatus("NACK");
        		transaction.setResponsexml(marshallingService.marshallXml(response));
        		transactionService.updatePaymentRequest(transaction, messageId);
        	}			
		}catch(Exception ex) {
			logger.error("Severe Error : Failed to Send NACK . Please reconcile manually : "+ex);
		}

	}
	
	/**
	 * 
	 * @param request
	 * @param messageId
	 * @param paymentTransaction
	 */
	public void sendAck(iso.std.iso._20022.tech.xsd.pacs_008_001.Document request,String messageId,Transaction transaction,String corrId) {
		logger.info("Sending ACK for : "+messageId);
		try {
			Document response = processSuccess(request, messageId,corrId);
			logger.info("ACK sent successfully  : "+messageId);
			logger.info("Correlation ID  : "+corrId);
			transaction.setStatus("ACK");
			transaction.setResponsexml(marshallingService.marshallXml(response));
			transactionService.updatePaymentRequest(transaction, messageId);			
		}catch(Exception ex) {
			logger.error("Severe Error : Failed to Send ACK. Please reconcile manually : "+ex);
		}
	}
	
	/**
	 * 
	 * @param paymentTransaction
	 * @param messageId
	 */
	public void playbackResponse(Transaction transaction,String messageId,String corrId) {
		logger.info("Playing back response : "+messageId);
		try {
			logger.info("responsexml: "+messageId + ":"+transaction.getResponsexml());
			logger.info("Correlation ID ::"+corrId);
			processPlayback(transaction,corrId);
			logger.info("Response played back for  : "+messageId);
		}catch(Exception ex) {
			logger.error("Severe Error : Failed to play back response : "+ex);
		}		
	}	

}
