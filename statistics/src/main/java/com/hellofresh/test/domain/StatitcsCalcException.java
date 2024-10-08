package com.hellofresh.test.domain;

/**
 * 
 * @author Poornima Vadakeyil
 * Custom Exception class
 */
public class StatitcsCalcException extends Exception{

	private static final long serialVersionUID = 3739554581005776772L;

	public StatitcsCalcException(String errorMessage) {
        super(errorMessage);
    }
	

}
