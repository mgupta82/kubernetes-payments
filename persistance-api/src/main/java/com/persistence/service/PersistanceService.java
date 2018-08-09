package com.persistence.service;

import com.persistence.json.RequestJsonObj;
import com.persistence.message.PersistanceResponseMessage;

public interface PersistanceService {
	
	public PersistanceResponseMessage processDataObj(RequestJsonObj requestJsonObj);

}
