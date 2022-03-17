package com.practicaljava.retryinboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
public class RetryConfig {
	
	@Value("${findNationality_url}")
	private String nationalityUrl;
	
	@Value("${backup_url}")
	private String backupUrl;
	
	@Bean
	public String nationalityUrl() {
		return this.nationalityUrl;
	}
	
	@Bean
	public String backupUrl() {
		return this.backupUrl;
	}

}
