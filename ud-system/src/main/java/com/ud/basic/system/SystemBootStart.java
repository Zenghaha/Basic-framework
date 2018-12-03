package com.ud.basic.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.ud")
@EnableAsync
@EnableTransactionManagement
public class SystemBootStart 
{
	@Bean
	RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory httpClientFactory = new SimpleClientHttpRequestFactory();
        httpClientFactory.setConnectTimeout(35000);
        httpClientFactory.setReadTimeout(35000);
	    return new RestTemplate(httpClientFactory);
	}
	
	public static void main( String[] args ){
    	SpringApplication.run(SystemBootStart.class, args);
    }
}
