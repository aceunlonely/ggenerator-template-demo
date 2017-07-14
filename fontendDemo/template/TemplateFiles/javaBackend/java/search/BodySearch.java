package com.dcjet.javaBackendDemo.search;

import com.dcjet.javaBackendDemo.base.BackendBaseSearch;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>手册设立料件表查询条件实体</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
public class ZtythHbImgSearch extends BackendBaseSearch {
	private static final long serialVersionUID = 1L;

	private String headOid; //手册表头OID
	
	private String gNo; //序号
	
	private String useType; //记录号
	
	private String codeT; //商品编码(后两位为附加编号)
	
	private String gName; //商品名称
	
	private String modifyMark; //处理标志(0—不变、1—修改、2—删除、3—新增)
	
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

	public String getHeadOid() {
		return headOid;
	}

	public void setHeadOid(String headOid) {
		this.headOid = headOid;
	}
}
