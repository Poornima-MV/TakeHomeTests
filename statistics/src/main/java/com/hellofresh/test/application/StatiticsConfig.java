package com.hellofresh.test.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hellofresh.test.domain.StatiticsHolder;
/**
 * 
 * @author Poornima Vadakeyil
 * Config class contains the singleton Bean to hold the statics data
 */
@Configuration
public class StatiticsConfig {
	
	/**
	 * 
	 * @return singleton statics holder bean
	 */
	@Bean(name = "statiticsHolder")
	public StatiticsHolder statiticsHolder() {
		return new StatiticsHolder();
	}
	
	
}
