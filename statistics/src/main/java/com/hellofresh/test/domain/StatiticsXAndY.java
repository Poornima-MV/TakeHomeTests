package com.hellofresh.test.domain;
/**
 * 
 * @author Poornima Vadakeyil
 * X and Y data for a particular time
 *
 */
public class StatiticsXAndY {

	public StatiticsXAndY(Float xValue, Long yValue) {
		super();
		this.xValue = xValue;
		YValue = yValue;
	}
	private Float xValue;
	private Long YValue;
	public Float getxValue() {
		return xValue;
	}
	public void setxValue(Float xValue) {
		this.xValue = xValue;
	}
	public Long getYValue() {
		return YValue;
	}
	public void setYValue(Long yValue) {
		YValue = yValue;
	}
	
	@Override
	public String toString() {
		return "StatiticsXAndY [xValue=" + xValue + ", YValue=" + YValue + "]";
	}
	
}
