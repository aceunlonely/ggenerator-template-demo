package com.dcjet.javaBackendDemo.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.dcjet.apollo.framework.entity.BaseEntity;
import com.dcjet.apollo.framework.utils.validation.ByteLength;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>手册设立表头实体</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
@TableName("T_ZTYTH_HB_HEAD")
public class ZtythHbHeadEntity extends BaseEntity<ZtythHbHeadEntity>  {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 唯一标示
	 */
	@TableId(type=IdType.UUID, value="OID")
	private String oid;

	/**
	 * 企业编码
	 */
	@TableField("COMP_NO")
	@NotEmpty(message="compNo不能为空！")
	@ByteLength(max = 10, message = "compNo长度超过限制！")
	private String compNo;
	
	/**
	 * 流水号
	 */
	@TableField("SERIAL_NO")
	@ByteLength(max = 20, message = "serialNo长度超过限制！")
	private String serialNo;
	
	/**
	 * 企业内部编号
	 */
	@TableField("COP_EMS_NO")
	@NotEmpty(message="copEmsNo不能为空！")
	@ByteLength(max = 20, message = "copEmsNo长度超过限制！")
	private String copEmsNo;
	
	/**
	 * 手册编号
	 */
	@TableField("HB_NO")
	@ByteLength(max = 12, message = "hbNo长度超过限制！")
	private String hbNo;
	
	/**
	 * 备案资料库编号
	 */
	@TableField("HB_BASE_NO")
	@NotEmpty(message="hbBaseNo不能为空！")
	@ByteLength(max = 12, message = "hbBaseNo长度超过限制！")
	private String hbBaseNo;

	/**
	 * 主管海关
	 */
	@TableField("MASTER_CUSTOMS")
	@NotEmpty(message="masterCustoms不能为空！")
	@ByteLength(max = 4, message = "masterCustoms长度超过限制！")
	private String masterCustoms;

	/**
	 * 经营单位编码
	 */
	@TableField("TRADE_CODE")
	@NotEmpty(message="tradeCode不能为空！")
	@ByteLength(max = 10, message = "tradeCode长度超过限制！")
	private String tradeCode;


	/**
	 * 经营单位名称
	 */
	@TableField("TRADE_NAME")
	@ByteLength(max = 100, message = "tradeName长度超过限制！")
	private String tradeName;
	
	/**
	 * 经营单位企业管理类别
	 */
	@TableField("TRADE_AEOTYPE")
	@NotEmpty(message="tradeAeotype不能为空！")
	@ByteLength(max = 1, message = "tradeAeotype长度超过限制！")
	private String tradeAeotype;
	
	/**
	 * 加工单位编码
	 */
	@TableField("OWNER_CODE")
	@NotEmpty(message="ownerCode不能为空！")
	@ByteLength(max = 10, message = "ownerCode长度超过限制！")
	private String ownerCode;

	/**
	 * 加工单位名称
	 */
	@TableField("OWNER_NAME")
	@ByteLength(max = 100, message = "ownerName长度超过限制！")
	private String ownerName;
	
	/**
	 * 加工单位企业管理类别
	 */
	@TableField("OWNER_AEOTYPE")
	@NotEmpty(message="ownerAeotype不能为空！")
	@ByteLength(max = 1, message = "ownerAeotype长度超过限制！")
	private String ownerAeotype;

	/**
	 * 企业联系人
	 */
	@TableField("CONTACT_PERSON")
	@NotEmpty(message="contactPerson不能为空！")
	@ByteLength(max = 50, message = "contactPerson长度超过限制！")
	private String contactPerson;

	/**
	 * 联系电话
	 */
	@TableField("CONTACT_PHONE")
	@NotEmpty(message="contactPhone不能为空！")
	@ByteLength(max = 50, message = "contactPhone长度超过限制！")
	private String contactPhone;
	
	/**
	 * 厂房情况(0-自建、1-租赁)
	 */
	@TableField("PLANT_CONDITIO")
	@NotEmpty(message="plantConditio不能为空！")
	@ByteLength(max = 3, message = "plantConditio长度超过限制！")
	private String plantConditio;
	
	/**
	 * 处理标志(0—不变、1—修改、2—删除、3—新增)
	 */
	@TableField("MODIFY_MARK")
	@NotEmpty(message="modifyMark不能为空！")
	@ByteLength(max = 50, message = "modifyMark长度超过限制！")
	private String modifyMark;

	/**
	 * 是否首办：0-否；1-是
	 */
	@TableField("IS_FIRST")
	@NotEmpty(message="isFirst不能为空！")
	@ByteLength(max = 1, message = "isFirst长度超过限制！")
	private String isFirst;
	
	/**
	 * 经营单位地址
	 */
	@TableField("TRADE_ADDRESS")
	@NotEmpty(message="tradeAddress不能为空！")
	@ByteLength(max = 100, message = "tradeAddress长度超过限制！")
	private String tradeAddress;
	
	/**
	 * 加工单位地址
	 */
	@TableField("OWNER_ADDRESS")
	@NotEmpty(message="ownerAddress不能为空！")
	@ByteLength(max = 100, message = "ownerAddress长度超过限制！")
	private String ownerAddress;

	/**
	 * 主管外经部门
	 */
	@TableField("MASTER_FTC")
	@NotEmpty(message="masterFtc不能为空！")
	@ByteLength(max = 10, message = "masterFtc长度超过限制！")
	private String masterFtc;

	/**
	 * 台帐银行0-纸质台账 1-中国银行 2-工商银行
	 */
	@TableField("ACCOUNT_BANK")
	@NotEmpty(message="accountBank不能为空！")
	@ByteLength(max = 2, message = "accountBank长度超过限制！")
	private String accountBank;

	/**
	 * 管理对象 0以经营单位为管理对象 1以加工单位为管理对象
	 */
	@TableField("MANAGE_OBJECT")
	@NotEmpty(message="manageObject不能为空！")
	@ByteLength(max = 50, message = "manageObject长度超过限制！")
	private String manageObject;

	/**
	 * 收货地区
	 */
	@TableField("RECEIVE_AREA")
	@NotEmpty(message="receiveArea不能为空！")
	@ByteLength(max = 10, message = "receiveArea长度超过限制！")
	private String receiveArea;
	       
	/**
	 * 经办人
	 */
	@TableField("OPERATOR")
	@NotEmpty(message="operator不能为空！")
	@ByteLength(max = 20, message = "operator长度超过限制！")
	private String operator;
	
	/**
	 * 电话
	 */
	@TableField("PHONE")
	@NotEmpty(message="phone不能为空！")
	@ByteLength(max = 50, message = "phone长度超过限制！")
	private String phone;
	
	/**
	 * 外商公司名称
	 */
	@TableField("FOREIGN_CO_NAME")
	@ByteLength(max = 50, message = "foreignCoName长度超过限制！")
	private String foreignCoName;
	
	/**
	 * 未结案手册数
	 */
	@TableField("USE_HB_COUNT")
	@NotEmpty(message="useHbCount不能为空！")
	@ByteLength(max = 10,  message = "useHbCount长度超过限制！")
	private String useHbCount;

	/**
	 * 单耗申报环节
	 */
	@TableField("EQUIP_MODE")
	@NotEmpty(message="equipMode不能为空！")
	@ByteLength(max = 1, message = "equipMode长度超过限制！")
	private String equipMode;

	/**
	 * 手册办理类型(异地、一般、违规、涉私)
	 */
	@TableField("HB_TYPE")
	@NotEmpty(message="hbType不能为空！")
	@ByteLength(max = 10, message = "hbType长度超过限制！")
	private String hbType;
	
	/**
	 * 贸易方式
	 */
	@TableField("TRADE_MODE")
	@NotEmpty(message="tradeMode不能为空！")
	@ByteLength(max = 1, message = "tradeMode长度超过限制！")
	private String tradeMode;

	/**
	 * 征免性质
	 */
	@TableField("CUT_MODE")
	@NotEmpty(message="cutMode不能为空！")
	@ByteLength(max = 4, message = "cutMode长度超过限制！")
	private String cutMode;

	/**
	 * 贸易国别
	 */
	@TableField("TRADE_COUNTRY")
	@ByteLength(max = 3, message = "tradeCountry长度超过限制！")
	private String tradeCountry;

	/**
	 * 加工种类
	 */
	@TableField("PRODUCE_TYPE")
	@NotEmpty(message="produceType不能为空！")
	@ByteLength(max = 2, message = "produceType长度超过限制！")
	private String produceType;

	/**
	 * 内销比例
	 */
	@TableField("IN_RATIO")
	@Digits(integer = 14, fraction = 5,  message = "inRatio长度超过限制！")
	private BigDecimal inRatio;

	/**
	 * 批准文号
	 */
	@TableField("EMS_APPR_NO")
	@NotEmpty(message="emsApprNo不能为空！")
	@ByteLength(max = 100, message = "emsApprNo长度超过限制！")
	private String emsApprNo;

	/**
	 * 审批机关
	 */
	@TableField("APPROVE_ORG")
	@ByteLength(max = 100, message = "approveOrg长度超过限制！")
	private String approveOrg;

	/**
	 * 协议号
	 */
	@TableField("AGREE_NO")
	@ByteLength(max = 32, message = "agreeNo长度超过限制！")
	private String agreeNo;

	/**
	 * 进口合同号
	 */
	@TableField("CONTR_IN")
	@NotEmpty(message="contrIn不能为空！")
	@ByteLength(max = 20, message = "contrIn长度超过限制！")
	private String contrIn;
	
	/**
	 * 进口总值
	 */
	@TableField("APPR_IMG_AMT")
	@Digits(integer = 14, fraction = 5, message = "apprImgAmt长度超过限制！")
	private BigDecimal apprImgAmt;
	
	/**
	 * 进口币制
	 */
	@TableField("IM_CURR")
	@NotEmpty(message="imCurr不能为空！")
	@ByteLength(max = 3, message = "imCurr长度超过限制！")
	private String imCurr;
	
	/**
	 * 出口合同号
	 */
	@TableField("CONTR_OUT")
	@ByteLength(max = 32, message = "contrOut长度超过限制！")
	private String contrOut;
	
	/**
	 * 出口总值
	 */
	@TableField("APPR_EXG_AMT")
	@Digits(integer = 14, fraction = 5,  message = "apprExgAmt长度超过限制！")
	private BigDecimal apprExgAmt;

	/**
	 * 出口币制
	 */
	@TableField("EX_CURR")
	@NotEmpty(message="XXXXX不能为空！")
	@ByteLength(max = 3, message = "exCurr长度超过限制！")
	private String exCurr;

	/**
	 * 进口期限
	 */
	@TableField("IMPORT_PERIOD")
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date importPeriod;

	/**
	 * 有效日期
	 */
	@TableField("EXPIRY_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date expiryDate;

	/**
	 * 进出口岸
	 */
	@TableField("IE_PORT")
	@ByteLength(max = 100, message = "iePort长度超过限制！")
	private String iePort;

	/**
	 * 备注
	 */
	@TableField("NOTE")
	@ByteLength(max = 255, message = "note长度超过限制！")
	private String note;
	
	/**
	 * 状态
	 */
	@TableField("STATE")
	@ByteLength(max = 5, message = "state长度超过限制！")
	private String state;

	/**
	 * 风险担保金状态
	 */
	@TableField("RISK_STATE")
	@ByteLength(max = 5, message = "riskState长度超过限制！")
	private String riskState;
	
	/**
	 * 申报日期
	 */
	@TableField("SEND_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date sendTime;

	/**
	 * 结案日期
	 */
	@TableField("END_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date endTime;
	
	/**
	 * 新增日期
	 */
	@TableField("INSERT_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date insertTime;
	
	/**
	 * 新增用户
	 */
	@TableField("INSERT_USER")
	@ByteLength(max = 20, message = "insertUser长度超过限制！")
	private String insertUser;

	/**
	 * 数据来源0录入1导入
	 */
	@TableField("DBSOURCE")
	@ByteLength(max = 1, message = "dbsource长度超过限制！")
	private String dbsource;
	
	/**
	 * 变更表OID，处理标志为修改时有值
	 */
	@TableField("HEAD_CHANGE_OID")
	@ByteLength(max = 36, message = "headChangeOid长度超过限制！")
	private String headChangeOid;

	/**
	 * 修改时间
	 */
	@TableField("UPDATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date updateTime;

	/**
	 * 修改人
	 */
	@TableField("UPDATE_USER")
	@ByteLength(max = 20, message = "updateUser长度超过限制！")
	private String updateUser;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getCompNo() {
		return compNo;
	}

	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

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

	public String getHbBaseNo() {
		return hbBaseNo;
	}

	public void setHbBaseNo(String hbBaseNo) {
		this.hbBaseNo = hbBaseNo;
	}

	public String getMasterCustoms() {
		return masterCustoms;
	}

	public void setMasterCustoms(String masterCustoms) {
		this.masterCustoms = masterCustoms;
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getTradeAeotype() {
		return tradeAeotype;
	}

	public void setTradeAeotype(String tradeAeotype) {
		this.tradeAeotype = tradeAeotype;
	}

	public String getOwnerCode() {
		return ownerCode;
	}

	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerAeotype() {
		return ownerAeotype;
	}

	public void setOwnerAeotype(String ownerAeotype) {
		this.ownerAeotype = ownerAeotype;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getPlantConditio() {
		return plantConditio;
	}

	public void setPlantConditio(String plantConditio) {
		this.plantConditio = plantConditio;
	}

	public String getModifyMark() {
		return modifyMark;
	}

	public void setModifyMark(String modifyMark) {
		this.modifyMark = modifyMark;
	}

	public String getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}

	public String getTradeAddress() {
		return tradeAddress;
	}

	public void setTradeAddress(String tradeAddress) {
		this.tradeAddress = tradeAddress;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public String getMasterFtc() {
		return masterFtc;
	}

	public void setMasterFtc(String masterFtc) {
		this.masterFtc = masterFtc;
	}

	public String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}

	public String getManageObject() {
		return manageObject;
	}

	public void setManageObject(String manageObject) {
		this.manageObject = manageObject;
	}

	public String getReceiveArea() {
		return receiveArea;
	}

	public void setReceiveArea(String receiveArea) {
		this.receiveArea = receiveArea;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getForeignCoName() {
		return foreignCoName;
	}

	public void setForeignCoName(String foreignCoName) {
		this.foreignCoName = foreignCoName;
	}

	public String getUseHbCount() {
		return useHbCount;
	}

	public void setUseHbCount(String useHbCount) {
		this.useHbCount = useHbCount;
	}

	public String getEquipMode() {
		return equipMode;
	}

	public void setEquipMode(String equipMode) {
		this.equipMode = equipMode;
	}

	public String getHbType() {
		return hbType;
	}

	public void setHbType(String hbType) {
		this.hbType = hbType;
	}

	public String getTradeMode() {
		return tradeMode;
	}

	public void setTradeMode(String tradeMode) {
		this.tradeMode = tradeMode;
	}

	public String getCutMode() {
		return cutMode;
	}

	public void setCutMode(String cutMode) {
		this.cutMode = cutMode;
	}

	public String getTradeCountry() {
		return tradeCountry;
	}

	public void setTradeCountry(String tradeCountry) {
		this.tradeCountry = tradeCountry;
	}

	public String getProduceType() {
		return produceType;
	}

	public void setProduceType(String produceType) {
		this.produceType = produceType;
	}

	public BigDecimal getInRatio() {
		return inRatio;
	}

	public void setInRatio(BigDecimal inRatio) {
		this.inRatio = inRatio;
	}

	public String getEmsApprNo() {
		return emsApprNo;
	}

	public void setEmsApprNo(String emsApprNo) {
		this.emsApprNo = emsApprNo;
	}

	public String getApproveOrg() {
		return approveOrg;
	}

	public void setApproveOrg(String approveOrg) {
		this.approveOrg = approveOrg;
	}

	public String getAgreeNo() {
		return agreeNo;
	}

	public void setAgreeNo(String agreeNo) {
		this.agreeNo = agreeNo;
	}

	public String getContrIn() {
		return contrIn;
	}

	public void setContrIn(String contrIn) {
		this.contrIn = contrIn;
	}

	public BigDecimal getApprImgAmt() {
		return apprImgAmt;
	}

	public void setApprImgAmt(BigDecimal apprImgAmt) {
		this.apprImgAmt = apprImgAmt;
	}

	public String getImCurr() {
		return imCurr;
	}

	public void setImCurr(String imCurr) {
		this.imCurr = imCurr;
	}

	public String getContrOut() {
		return contrOut;
	}

	public void setContrOut(String contrOut) {
		this.contrOut = contrOut;
	}

	public BigDecimal getApprExgAmt() {
		return apprExgAmt;
	}

	public void setApprExgAmt(BigDecimal apprExgAmt) {
		this.apprExgAmt = apprExgAmt;
	}

	public String getExCurr() {
		return exCurr;
	}

	public void setExCurr(String exCurr) {
		this.exCurr = exCurr;
	}

	public Date getImportPeriod() {
		return importPeriod;
	}

	public void setImportPeriod(Date importPeriod) {
		this.importPeriod = importPeriod;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getIePort() {
		return iePort;
	}

	public void setIePort(String iePort) {
		this.iePort = iePort;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public String getInsertUser() {
		return insertUser;
	}

	public void setInsertUser(String insertUser) {
		this.insertUser = insertUser;
	}

	public String getDbsource() {
		return dbsource;
	}

	public void setDbsource(String dbsource) {
		this.dbsource = dbsource;
	}

	public String getHeadChangeOid() {
		return headChangeOid;
	}

	public void setHeadChangeOid(String headChangeOid) {
		this.headChangeOid = headChangeOid;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(((ZtythHbHeadEntity)obj).oid== this.oid)
			return true;
		return false;
	}
}
