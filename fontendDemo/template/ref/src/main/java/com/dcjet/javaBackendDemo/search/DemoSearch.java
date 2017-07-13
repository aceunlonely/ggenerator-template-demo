package com.dcjet.javaBackendDemo.search;

import com.dcjet.javaBackendDemo.base.BackendBaseSearch;

public class DemoSearch extends BackendBaseSearch{
	private static final long serialVersionUID = 1L;
	
	private String copEmsNo;
	
	private String hbNo;
	
	private String serialNo;
	
	private String expiryDateBegin;
	
	private String expiryDateEnd;
	
	private String state;
	
	private String riskState;

	public String getCopEmsNo() {
		return copEmsNo;
	}

	public void setCopEmsNo(String copEmsNo) {
		this.copEmsNo = copEmsNo;
	}

	public String getHbNo() {
		return hbNo;
	}

	public void setHbNo(String hbNo) {
		this.hbNo = hbNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getExpiryDateBegin() {
		return expiryDateBegin;
	}

	public void setExpiryDateBegin(String expiryDateBegin) {
		this.expiryDateBegin = expiryDateBegin;
	}

	public String getExpiryDateEnd() {
		return expiryDateEnd;
	}

	public void setExpiryDateEnd(String expiryDateEnd) {
		this.expiryDateEnd = expiryDateEnd;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRiskState() {
		return riskState;
	}

	public void setRiskState(String riskState) {
		this.riskState = riskState;
	}
}
