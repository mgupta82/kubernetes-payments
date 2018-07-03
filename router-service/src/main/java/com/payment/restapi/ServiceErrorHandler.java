/*package com.payment.restapi;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class ServiceErrorHandler implements ResponseErrorHandler{
	
	Logger log=LogManager.getLogger(ServiceErrorHandler.class);

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
        return (
        		response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR 
                || response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR || 
                response.getStatusCode().series() == HttpStatus.Series.REDIRECTION);
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		if (response.getStatusCode()
		          .series() == HttpStatus.Series.SERVER_ERROR) {
					log.error("Server error");
		            // handle SERVER_ERROR
		        } else if (response.getStatusCode()
		          .series() == HttpStatus.Series.CLIENT_ERROR) {
		        	//handle CLIENT error
		        	log.error("client error");
		            if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
		                //handle Not found error
		            	log.error("Not found error");
		            }
		        }
		
	}

}
*/