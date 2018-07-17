package com.anzpoc.core;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.anzpoc.core.utility.CommonUtility;
import com.anzpoc.core.utility.Constant;
import com.anzpoc.core.utility.ValidateUtility;
//import com.relops.snowflake.Snowflake;



@RestController
@RequestMapping("/anz/transform")
public class ANZEnterpriseTransformationService {
	

	/**
	 * 
	 * @param bsbNo
	 * @return
	 * 
	 */
	@RequestMapping(value="/pacsmsg", method = RequestMethod.POST,consumes={MediaType.APPLICATION_XML_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody String /*ResponseEntity<String> */ validateAndTransformXML(@RequestBody String pacsMsgXML)
	{
		JSONObject jsonResponse = null;
		try
		{
			//1. validate xml against xsd
			String msgFormatType = Constant.PACS_008_MSG_FORMAT + Constant.XSD_STR;//ValidateUtility.getMsgFormatType(pacsMsgXML).trim();
			
			//boolean isSupportedFlag = CommonUtility.checkIfPaymentTypeSupported(msgFormatType);
			//if(isSupportedFlag) 
			//{
				boolean isValidXML = ValidateUtility.isXMLValid(msgFormatType, pacsMsgXML);
				
				//2. transform xml to json
				if(isValidXML) {
					jsonResponse = ValidateUtility.transformXMLToJSON(pacsMsgXML);
					
					//4. generate puid using snowflake
					//The node id is a manually assigned value between 0 and 1023 which is used to 
					//differentiate different snowflakes when used in a multi-node cluster.
					/*int nodeId = 1001;
					Snowflake snowflakeObj = new Snowflake(nodeId);
					long snowFlakeGenPUID = snowflakeObj.next();					
					jsonResponse.put("puid", String.valueOf(snowFlakeGenPUID));	*/		
				}				
				else {
					jsonResponse = new JSONObject();
					jsonResponse.put(Constant.REASON_CODE, Constant.VALIDATION_PARSING_ERROR_CODE);
					jsonResponse.put(Constant.REASON_DESC, Constant.VALIDATION_PARSING_ERROR_DESC);
				}
				
			//}
			/*else {
				jsonResponse = new JSONObject();
				jsonResponse.put(Constant.REASON_CODE, Constant.VALIDATION_PARSING_ERROR_CODE);
				jsonResponse.put(Constant.REASON_DESC, Constant.VALIDATION_PARSING_ERROR_DESC);
			}*/
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return jsonResponse.toString(); // new ResponseEntity<String>(jsonRequest.toString(), HttpStatus.OK);
	}
	
	
	
}
