/*package com.payment.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplateApplication {
	
	@Autowired
	ServiceErrorHandler errorHandler;
	
	String request="{\n" + 
			"  \"Document\": {\n" + 
			"    \"FIToFICstmrCdtTrf\": {\n" + 
			"      \"GrpHdr\": {\n" + 
			"        \"MsgId\": \"AAAA/151109-CCT/AUD/443\",\n" + 
			"        \"CreDtTm\": \"2015-11-09T10:09:13\",\n" + 
			"        \"NbOfTxs\": \"1\",\n" + 
			"        \"SttlmInf\": { \"SttlmMtd\": \"INDA\" },\n" + 
			"        \"InstgAgt\": {\n" + 
			"          \"FinInstnId\": { \"BICFI\": \"012345\" }\n" + 
			"        },\n" + 
			"        \"InstdAgt\": {\n" + 
			"          \"FinInstnId\": { \"BICFI\": \"BBBBIE2D\" }\n" + 
			"        }\n" + 
			"      },\n" + 
			"      \"CdtTrfTxInf\": {\n" + 
			"        \"PmtId\": {\n" + 
			"          \"InstrId\": \"AAAA/151109-CCT/AUD/443/1\",\n" + 
			"          \"EndToEndId\": \"CROPS/SX-25T/2015-10-13\",\n" + 
			"          \"TxId\": \"AAAA/151109-CCT/AUD/443/1\"\n" + 
			"        },\n" + 
			"        \"IntrBkSttlmAmt\": {\n" + 
			"          \"Ccy\": \"AUD\",\n" + 
			"          \"Amount\": \"1\"\n" + 
			"        },\n" + 
			"        \"IntrBkSttlmDt\": \"2015-11-09\",\n" + 
			"        \"InstdAmt\": {\n" + 
			"          \"Ccy\": \"AUD\",\n" + 
			"          \"Amount\": \"750000\"\n" + 
			"        },\n" + 
			"        \"ChrgBr\": \"SHAR\",\n" + 
			"        \"Dbtr\": {\n" + 
			"          \"Nm\": \"Biogenetics - HQ\",\n" + 
			"          \"PstlAdr\": {\n" + 
			"            \"StrtNm\": \"Corn Street\",\n" + 
			"            \"BldgNb\": \"13\",\n" + 
			"            \"PstCd\": \"W6 8DR\",\n" + 
			"            \"TwnNm\": \"London\",\n" + 
			"            \"Ctry\": \"GB\"\n" + 
			"          }\n" + 
			"        },\n" + 
			"        \"DbtrAcct\": {\n" + 
			"          \"Id\": {\n" + 
			"            \"Othr\": { \"Id\": \"46373892034012\" }\n" + 
			"          }\n" + 
			"        },\n" + 
			"        \"DbtrAgt\": {\n" + 
			"          \"FinInstnId\": { \"BICFI\": \"AAAAGB2L\" }\n" + 
			"        },\n" + 
			"        \"CdtrAgt\": {\n" + 
			"          \"FinInstnId\": { \"BICFI\": \"BBBBIE2D\" }\n" + 
			"        },\n" + 
			"        \"Cdtr\": {\n" + 
			"          \"Nm\": \"Seed Inc.\",\n" + 
			"          \"PstlAdr\": {\n" + 
			"            \"StrtNm\": \"Grain Lane\",\n" + 
			"            \"BldgNb\": \"27\",\n" + 
			"            \"TwnNm\": \"Dublin\",\n" + 
			"            \"Ctry\": \"IE\"\n" + 
			"          }\n" + 
			"        },\n" + 
			"        \"CdtrAcct\": {\n" + 
			"          \"Id\": {\n" + 
			"            \"Othr\": { \"Id\": \"46373892034012\" }\n" + 
			"          }\n" + 
			"        },\n" + 
			"        \"Purp\": { \"Cd\": \"GDDS\" },\n" + 
			"        \"RmtInf\": {\n" + 
			"          \"Strd\": {\n" + 
			"            \"RfrdDocInf\": {\n" + 
			"              \"Tp\": {\n" + 
			"                \"CdOrPrtry\": { \"Cd\": \"CINV\" }\n" + 
			"              },\n" + 
			"              \"Nb\": \"SX-25T\",\n" + 
			"              \"RltdDt\": \"2015-10-13\"\n" + 
			"            }\n" + 
			"          }\n" + 
			"        }\n" + 
			"      }\n" + 
			"    }\n" + 
			"  }\n" + 
			"}";

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			 HttpHeaders headers = new HttpHeaders();
			 headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> request = new HttpEntity<String>(this.request,headers);
			restTemplate.setErrorHandler(errorHandler);

			ResponseEntity<String> response = restTemplate
			  .exchange("http://localhost:8080/pacs/validate", HttpMethod.POST, request, String.class);
			
			ResponseEntity<String> response = restTemplate
					  .exchange("http://192.168.56.1:8192/persistane-api/save", HttpMethod.POST, request, String.class);
			
			System.out.println("Response :: "+response.getBody());
		};
	}
}
*/