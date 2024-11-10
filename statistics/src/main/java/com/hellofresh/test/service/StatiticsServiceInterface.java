package com.hellofresh.test.service;

import java.util.Calendar;

import com.hellofresh.test.domain.StatitcsCalcException;
/**
 * 
 * @author Poornima Vadakeyil
 * The service interface
 */
public interface StatiticsServiceInterface {
	/**
	 * Service method to load the stats data
	 * @param eventDetails
	 * @throws StatitcsCalcException 
	 */
	void loadStaticsData(String[] eventDetails) throws StatitcsCalcException;
	/**
	 * 
	 * @param lastMinute The time till which data to be considered
	 * @return calculated stats data in the comma seperated format
	 * @throws StatitcsCalcException
	 */
	String calculateStaticsData(Calendar lastMinute) throws StatitcsCalcException;
	
}
