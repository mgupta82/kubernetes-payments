package com.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pacsmessages")
public class PacsMessage {

    @Id
    private String messageId;

    private String request_obj;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getRequest_obj() {
		return request_obj;
	}

	public void setRequest_obj(String request_obj) {
		this.request_obj = request_obj;
	}

   
}
