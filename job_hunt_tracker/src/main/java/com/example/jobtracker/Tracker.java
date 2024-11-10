package com.example.jobtracker;

import java.util.Date;

public class Tracker {
	
	private String companyName;
	private Date applicationDate;
	private String profileURL;
	private String interviewProceeded;
	
	private Date interviewDate;
	private String interviewers;
	private String interviewRound;
	
	private String interviewQuestions;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getProfileURL() {
		return profileURL;
	}

	public void setProfileURL(String profileURL) {
		this.profileURL = profileURL;
	}

	public String getInterviewProceeded() {
		return interviewProceeded;
	}

	public void setInterviewProceeded(String interviewProceeded) {
		this.interviewProceeded = interviewProceeded;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public String getInterviewers() {
		return interviewers;
	}

	public void setInterviewers(String interviewers) {
		this.interviewers = interviewers;
	}

	public String getInterviewRound() {
		return interviewRound;
	}

	public void setInterviewRound(String interviewRound) {
		this.interviewRound = interviewRound;
	}

	public String getInterviewQuestions() {
		return interviewQuestions;
	}

	public void setInterviewQuestions(String interviewQuestions) {
		this.interviewQuestions = interviewQuestions;
	}

	public Tracker(String companyName, Date applicationDate, String profileURL, String interviewProceeded,
			Date interviewDate, String interviewers, String interviewRound, String interviewQuestions) {
		super();
		this.companyName = companyName;
		this.applicationDate = applicationDate;
		this.profileURL = profileURL;
		this.interviewProceeded = interviewProceeded;
		this.interviewDate = interviewDate;
		this.interviewers = interviewers;
		this.interviewRound = interviewRound;
		this.interviewQuestions = interviewQuestions;
	}

	public Tracker() {
		super();
	}

	@Override
	public String toString() {
		return "Tracker [companyName=" + companyName + ", applicationDate=" + applicationDate + ", profileURL="
				+ profileURL + ", interviewProceeded=" + interviewProceeded + ", interviewDate=" + interviewDate
				+ ", interviewers=" + interviewers + ", interviewRound=" + interviewRound + ", interviewQuestions="
				+ interviewQuestions + "]";
	}
	
	

}
