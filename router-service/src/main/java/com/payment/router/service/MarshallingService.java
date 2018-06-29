package com.payment.router.service;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarshallingService {
	
	@Autowired
	private Marshaller  marshaller;
	
	
	public <T> String marshallXml(final T obj) throws XmlMappingException, IOException {
		StringWriter sw = new StringWriter();
		Result result = new StreamResult(sw);
		marshaller.marshal(obj, result);
		return sw.toString();
	}


	@SuppressWarnings("unchecked")
	public <T> T unmarshallXml(final String xml) throws XmlMappingException, IOException {
		return (T) ((Unmarshaller)marshaller).unmarshal(new StreamSource(new StringReader(xml)));
	}	

}
