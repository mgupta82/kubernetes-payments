package com.anzpoc.core.utility;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

//import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.util.ResourceUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * 
 * @author karuna
 *
 */
public class ValidateUtility {

	//private static final Logger LOG = Logger.getLogger(ValidateUtility.class);
	
	private static String XSD_PATH = "classpath:xsd/";
	
	
	
	/**
	 * 
	 * @param XSDFileName
	 * @param XML
	 * @return
	 */
	public static boolean isXMLValid(String XSDFileName, String XML) 
	{
        final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try 
        {
        	File file = ResourceUtils.getFile(XSD_PATH + XSDFileName);            
            final Schema schema = factory.newSchema(file);
            final Validator validator =  schema.newValidator();
            validator.validate(new StreamSource(new ByteArrayInputStream(XML.getBytes())));
        } 
        catch(FileNotFoundException ex) {
        	ex.printStackTrace();
            return false;
        }
        catch(IOException ioex) {
        	ioex.printStackTrace();
            return false;
        }
        catch (SAXException e) 
        {
        	e.printStackTrace();
            return false;
        }
        return true;
    }
	
	/**
	 * 
	 * @param xml
	 * @return
	 */
	public static String getMsgFormatType(String xml)
	{
		String msgFormat = null;
		try
		{
			Document doc = parseXmlFile(xml);
			if(doc != null) {
				String nodeValue = doc.getFirstChild().getAttributes().getNamedItem("xmlns").toString();				
				msgFormat = nodeValue.substring(nodeValue.lastIndexOf("pacs") ).replace('"', ' ');
				System.out.println(msgFormat);
			}			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return msgFormat;
	}
	

	/**
	 * 
	 * @param in
	 * @return
	 */
	private static Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	
	/**
	 * 
	 * @param XSDFileName
	 * @param XML
	 * @return
	 */
	public static JSONObject transformXMLToJSON(String xmlString) 
	{
		JSONObject soapDatainJsonObject = new JSONObject();
		try 
		{
			System.out.println(xmlString);
			Document doc = parseXmlFile(xmlString);
			
			if(doc.getFirstChild().getAttributes().getNamedItem("xmlns") != null ) {
				doc.getFirstChild().getAttributes().removeNamedItem("xmlns");
			}
			if(doc.getFirstChild().getAttributes().getNamedItem("xmlns:xsi") !=null) {
				doc.getFirstChild().getAttributes().removeNamedItem("xmlns:xsi");
			}
			if(doc.getFirstChild().getAttributes().getNamedItem("xmlns:ns2")!=null) {
				doc.getFirstChild().getAttributes().removeNamedItem("xmlns:ns2");
			}
			
			if(doc.getFirstChild().getAttributes().getNamedItem("xsi:schemaLocation")!=null) {
				doc.getFirstChild().getAttributes().removeNamedItem("xsi:schemaLocation");
			}
			Transformer	transformer = TransformerFactory.newInstance().newTransformer();
		 
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "no");
			
			//initialize StreamResult with File object to save to file
			StreamResult result = new StreamResult(new StringWriter());
			DOMSource source = new DOMSource(doc);
			transformer.transform(source, result);
			
			String xmlString1 = result.getWriter().toString();
			//System.out.println(xmlString1);
			String tempJsonStr = XML.toJSONObject(xmlString1.replace("\\\\","")).toString();
			soapDatainJsonObject = new JSONObject(tempJsonStr.replace("content", "Amount"));
			
			//soapDatainJsonObject.put("Document", value)
			
		} catch (TransformerException e) {
			e.printStackTrace();
		}catch ( TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(soapDatainJsonObject);
		return soapDatainJsonObject;
	}

}
