package com.practicaljava.retryinboot.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practicaljava.retryinboot.service.RetrySpringBootService;

@RestController
public class RetrySpringBootController {
	
	@Autowired
	private RetrySpringBootService retrySpringBootService;
	
	@GetMapping(value = "/nationality")
	public String getCountryNameBasedOnPersonName(@RequestParam("name") String personName) throws Exception {
		if(StringUtils.isEmpty(personName)) {
			return "wrong input";
		}
		try {
		
			return retrySpringBootService.getCountryNameBasedOnPersonName(personName);
			
		} catch (Exception e) {
			throw new Exception(" Exception occurred while fetching country name ");
		}
		 
	}

}
