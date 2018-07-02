package com.hcl.persistance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.persistance.json.RequestJsonObj;
import com.hcl.persistance.message.PersistanceResponseMessage;
import com.hcl.persistance.service.PersistanceService;

@RestController
@RequestMapping("/persistance-api")
public class PersistanceServiceRestController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersistanceService persistenceService;
	
	@PostMapping("/save")
	public PersistanceResponseMessage persistPacsObj(@RequestBody RequestJsonObj reqJsonObj) {
		try {
			logger.debug("----> " + reqJsonObj.getDocument().getFIToFICstmrCdtTrf().getGrpHdr().getMsgId());
			PersistanceResponseMessage message = persistenceService.processDataObj(reqJsonObj);
			return message;
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getCause());
			return new PersistanceResponseMessage("0002", "Parsing error",
					"error");
		}
	}

}
