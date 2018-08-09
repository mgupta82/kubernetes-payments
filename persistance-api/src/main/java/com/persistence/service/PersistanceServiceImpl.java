package com.persistence.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.persistence.entity.PersistanceTransaction;
import com.persistence.json.RequestJsonObj;
import com.persistence.message.PersistanceResponseMessage;
import com.persistence.repository.PersistanceRepository;

@Service
public class PersistanceServiceImpl implements PersistanceService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersistanceRepository persistanceRepository;

	ObjectMapper mapper = new ObjectMapper();

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); // 2015-11-09T10:09:13

	@Override
	@Transactional
	public PersistanceResponseMessage processDataObj(RequestJsonObj requestJsonObj) {

		try {
			PersistanceTransaction persistanceTransaction = prepDataObj(requestJsonObj);
			if (!persistanceRepository.existsByMsgId(persistanceTransaction.getMsg_Id())) {
				persistanceRepository.save(persistanceTransaction);
				return new PersistanceResponseMessage("0000", "success", "success");
			}

		} catch (JsonProcessingException e) {
			logger.error(e.getMessage(), e);
			return new PersistanceResponseMessage("0001", "Parsing error", "error");
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			return new PersistanceResponseMessage("0001", "Parsing error", "error");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new PersistanceResponseMessage("0001", "Persistence error", "error");
		}
		return new PersistanceResponseMessage("0001", "Persistence error", "error");
	}

	private PersistanceTransaction prepDataObj(RequestJsonObj requestJsonObj)
			throws ParseException, JsonProcessingException {
		PersistanceTransaction persistanceTransaction = new PersistanceTransaction();
		persistanceTransaction.setMsg_Id(requestJsonObj.getDocument().getFIToFICstmrCdtTrf().getGrpHdr().getMsgId());
		persistanceTransaction.setTrx_Id(requestJsonObj.getDocument().getFIToFICstmrCdtTrf().getGrpHdr().getMsgId());
		persistanceTransaction.setCreditDateTime(new Timestamp(dateFormat
				.parse(requestJsonObj.getDocument().getFIToFICstmrCdtTrf().getGrpHdr().getCreDtTm()).getTime()));
		persistanceTransaction.setBsb(requestJsonObj.getDocument().getFIToFICstmrCdtTrf().getGrpHdr().getInstgAgt()
				.getFinInstnId().getBICFI());
		persistanceTransaction.setBranchId(requestJsonObj.getDocument().getFIToFICstmrCdtTrf().getGrpHdr().getInstdAgt()
				.getFinInstnId().getBICFI());
		persistanceTransaction.setSum_amt(Float.parseFloat(
				requestJsonObj.getDocument().getFIToFICstmrCdtTrf().getCdtTrfTxInf().getIntrBkSttlmAmt().getAmount()));
		persistanceTransaction.setStlmntAmt(Float.parseFloat(
				requestJsonObj.getDocument().getFIToFICstmrCdtTrf().getCdtTrfTxInf().getInstdAmt().getAmount()));
		persistanceTransaction.setCreditor_acc(Long.valueOf(requestJsonObj.getDocument().getFIToFICstmrCdtTrf()
				.getCdtTrfTxInf().getCdtrAcct().getId().getOthr().getId()));
		persistanceTransaction.setDebtor_acc(Long.valueOf(requestJsonObj.getDocument().getFIToFICstmrCdtTrf()
				.getCdtTrfTxInf().getDbtrAcct().getId().getOthr().getId()));
		persistanceTransaction.setCreditor_name(
				requestJsonObj.getDocument().getFIToFICstmrCdtTrf().getCdtTrfTxInf().getCdtr().getNm());
		persistanceTransaction
				.setDebtor_name(requestJsonObj.getDocument().getFIToFICstmrCdtTrf().getCdtTrfTxInf().getDbtr().getNm());
		persistanceTransaction.setCurrency(
				requestJsonObj.getDocument().getFIToFICstmrCdtTrf().getCdtTrfTxInf().getIntrBkSttlmAmt().getCcy());
		persistanceTransaction.setRequest_obj(mapper.writeValueAsString(requestJsonObj));
		return persistanceTransaction;
	}

}
