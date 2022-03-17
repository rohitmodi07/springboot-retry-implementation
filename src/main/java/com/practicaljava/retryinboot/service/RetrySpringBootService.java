package com.practicaljava.retryinboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicaljava.retryinboot.connector.RetrySpringBootConnector;

@Service
public class RetrySpringBootService {
	
	private RetrySpringBootConnector retrySpringBootConnector;
	
	@Autowired
	public RetrySpringBootService(RetrySpringBootConnector retrySpringBootConnector) {
		this.retrySpringBootConnector = retrySpringBootConnector;
	}
	
	public String getCountryNameBasedOnPersonName(String personName) throws Exception {
		return retrySpringBootConnector.getCountryNameBasedOnPersonName(personName);
	}

}
