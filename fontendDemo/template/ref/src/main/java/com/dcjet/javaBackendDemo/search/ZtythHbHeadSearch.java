package com.dcjet.javaBackendDemo.search;

import com.dcjet.javaBackendDemo.base.BackendBaseSearch;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>手册设立表头查询条件实体</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
public class ZtythHbHeadSearch extends BackendBaseSearch{
	private static final long serialVersionUID = 1L;
	
	private String oid; //唯一标示
	 
	private String copEmsNo; //企业编码
	 
	private String hbNo; //手册编号
	
	private String serialNo; //流水号
	
	private String expiryDateBegin; //有效开始日期
	
	private String expiryDateEnd; //有效结束日期
	
	private String state; //状态
	
	private String riskState; //风险担保金状态

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

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
}
