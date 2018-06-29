package com.payment.router.service;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrchestrationService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrchestrationService.class);
	
	@Autowired
	CoreService coreService;	
	
	public void process(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input,String messageId) throws Exception {
		
		//TODO : Step 1: Call Transformation Service
		
		//TODO : Step 2: Audit Service for Transformation
		
		//TODO : Step 3: Call Persistence Service
		
		//TODO : Step 4: Audit Service for Persistence
		
		//TODO : Step 5: Call Validation Service
		
		//TODO : Step 6: Audit Service Validation 
		
		//TODO : Step 7: Call Core Service
		logger.info("Calling Core Service for request message : "+messageId);
		coreService.process(input,messageId);
        logger.info("Core Response generated successfully for request message : "+messageId);
		
		//TODO : Step 8: Audit Service for Core
		
	}

}
