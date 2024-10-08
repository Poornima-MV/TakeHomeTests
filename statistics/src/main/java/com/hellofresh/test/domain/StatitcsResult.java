package com.hellofresh.test.domain;

/**
 * @author Poornima Vadakeyil
 * Domain class to hold the stats calculation result
 */
public class StatitcsResult {
	
	Integer total =0;
	Float totalX = 0.0f;
	Float averageX =0.0f;
	Long totalY =0L;
	Long averageY =0L;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Float getTotalX() {
		return totalX;
	}
	public void setTotalX(Float totalX) {
		this.totalX = totalX;
	}
	public Float getAverageX() {
		return averageX;
	}
	public void setAverageX(Float averageX) {
		this.averageX = averageX;
	}
	public Long getTotalY() {
		return totalY;
	}
	public void setTotalY(Long totalY) {
		this.totalY = totalY;
	}
	public Long getAverageY() {
		return averageY;
	}
	public void setAverageY(Long averageY) {
		this.averageY = averageY;
	}

}
