package com.anzpoc.core.utility;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

//import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;


public class CommonUtility {
	
	//private static final Logger LOG = Logger.getLogger(CommonUtility.class);
	
	static Locale locale = new Locale(Constant.LOCALE_LANG, Constant.LOCALE_COUNTRY);
	static String NEW_FORMAT = "dd-MM-yyyy HH:mm:ss";	
	
	
	/**
	 * this method use for - getting value of key from properties file 
	 * @param key
	 * @param readFileName
	 * @return
	 */
	public static final String getValueFromPropeties(String key, String fileName)
	{
		Properties properties = null; 
		String keyValue	= null;
		try
		{
			properties 	= PropertiesLoaderUtils.loadProperties(new ClassPathResource(fileName + Constant.PROPERTIES_FILE_TYPE));
			keyValue	= properties.getProperty(key);
		}
		catch(IOException e)
		{
			e.getStackTrace();
		}
		return keyValue;
	}
	
	/**
	 * 
	 * @param paymentMsgType
	 * @return
	 */
	public static boolean checkIfPaymentTypeSupported(String paymentMsgType)
	{
		boolean isSupported = false;
		
		String[] msgFormats = getValueFromPropeties(Constant.PAYMENT_MSG_PACS_SUPPORTED_FORMAT, Constant.PAYMENT_MSG_FILE).split(",");
		List<String> msgFormatList = Arrays.asList(msgFormats);
		
		Iterator<String> msgFormatItr = msgFormatList.iterator();
		while(msgFormatItr.hasNext())
		{
			String loMsgFormat = msgFormatItr.next();
			if(paymentMsgType.trim().equalsIgnoreCase(loMsgFormat.trim())) {
				isSupported = true;
				break;
			}
			else isSupported = false;
		}
		return isSupported;
	}
	
	
	
}
