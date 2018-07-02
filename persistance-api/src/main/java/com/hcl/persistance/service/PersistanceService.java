package com.hcl.persistance.service;

import com.hcl.persistance.json.RequestJsonObj;
import com.hcl.persistance.message.PersistanceResponseMessage;

public interface PersistanceService {
	
	public PersistanceResponseMessage processDataObj(RequestJsonObj requestJsonObj);

}
