package com.dcjet.javaBackendDemo.search;

import com.dcjet.javaBackendDemo.base.BackendBaseSearch;

public class BodySearch extends BackendBaseSearch {
	private static final long serialVersionUID = 1L;

	private String headOid;
	
	private String gNo;
	
	private String useType;
	
	private String codeT;
	
	private String gName;
	
	private String modifyMark;
	
	private String applyState;

	public String getgNo() {
		return gNo;
	}

	public void setgNo(String gNo) {
		this.gNo = gNo;
	}

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public String getCodeT() {
		return codeT;
	}

	public void setCodeT(String codeT) {
		this.codeT = codeT;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getModifyMark() {
		return modifyMark;
	}

	public void setModifyMark(String modifyMark) {
		this.modifyMark = modifyMark;
	}

	public String getApplyState() {
		return applyState;
	}

	public void setApplyState(String applyState) {
		this.applyState = applyState;
	}

	public String getHeadOid() {
		return headOid;
	}

	public void setHeadOid(String headOid) {
		this.headOid = headOid;
	}
}
