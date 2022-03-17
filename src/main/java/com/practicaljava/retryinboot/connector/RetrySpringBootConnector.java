package com.practicaljava.retryinboot.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RetrySpringBootConnector {

	private RestTemplate restTemplate = new RestTemplate();
	private String nationalityUrl;
	private String backupUrl;
	
	@Autowired
	public RetrySpringBootConnector(String nationalityUrl, String backupUrl) {
		this.nationalityUrl = nationalityUrl;
		this.backupUrl = backupUrl;
	}
	
	@Retryable(value = { RestClientException.class }, maxAttempts = 3)
	public String getCountryNameBasedOnPersonName(String personName) throws Exception {
		
		try {
			
		    String countryFinderUrl = UriComponentsBuilder.fromHttpUrl(nationalityUrl)
		    		.queryParam("name", personName).build().toString();
            System.out.println(" countryFinderUrl is  ::::: "+countryFinderUrl);
            
			return restTemplate.getForObject(countryFinderUrl, String.class);
		} catch (RestClientException e) {
			throw new RestClientException("Exception occurred while fetching nationality "+ e.getMessage());
		}
	}
	
	@Recover
	public String callBackFunction() {
		System.out.println(" In callBackFunction ::::: "+backupUrl);
		return restTemplate.getForObject(backupUrl, String.class);
	}
	
}
