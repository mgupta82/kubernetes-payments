package com.payment.router.service;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.router.jms.MessageProducer;
import com.payment.router.mapper.DocumentMapper;

import iso.std.iso._20022.tech.xsd.pacs_002_001.Document;
import iso.std.iso._20022.tech.xsd.pacs_002_001.FIToFIPaymentStatusReportV09;
import iso.std.iso._20022.tech.xsd.pacs_002_001.GroupHeader53;
import iso.std.iso._20022.tech.xsd.pacs_002_001.ObjectFactory;
import iso.std.iso._20022.tech.xsd.pacs_002_001.OriginalGroupHeader13;
import iso.std.iso._20022.tech.xsd.pacs_002_001.OriginalTransactionReference27;
import iso.std.iso._20022.tech.xsd.pacs_002_001.Party35Choice;
import iso.std.iso._20022.tech.xsd.pacs_002_001.PaymentTransaction91;

@Service
public class CoreService {
	
	@Autowired
	MessageProducer messageProducer;
	
	ObjectFactory objectFactory = new ObjectFactory();
	
	@Autowired
	DocumentMapper documentMapper;
	
	public CoreService() {
		documentMapper = Mappers.getMapper(DocumentMapper.class);
	}
	
	public void process(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input) throws DatatypeConfigurationException {
		Document document = objectFactory.createDocument();
		
		FIToFIPaymentStatusReportV09 paymentStatusReport = objectFactory.createFIToFIPaymentStatusReportV09();
		document.setFIToFIPmtStsRpt(paymentStatusReport);
		
		GroupHeader53 groupHeader = objectFactory.createGroupHeader53();
		paymentStatusReport.setGrpHdr(groupHeader);
		
		groupHeader.setMsgId("BBB");
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
		paymentTransaction.setStsId("success");
		paymentTransaction.setOrgnlEndToEndId(input.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getPmtId().getEndToEndId());
		paymentTransaction.setOrgnlTxId(input.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getPmtId().getTxId());
		paymentTransaction.setTxSts("SUCS");
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
		
		messageProducer.send(document);
	}

}
