package com.dcjet.javaBackendDemo.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.dcjet.apollo.framework.entity.BaseEntity;
import com.dcjet.apollo.framework.utils.validation.ByteLength;

/**
 * 实体
 * @author Administrator
 *
 */
@TableName("T_ZTYTH_HB_EXG")
public class BodyEntity extends BaseEntity<BodyEntity> {
	private static final long serialVersionUID = 1L;

	/*
	 * 唯一标示
	 */
	@TableField("OID")
	@NotEmpty(message="OID不能为空！")
	@ByteLength(max = 32, message = "OID长度超过限制！")
	private String oid;
	
	/*
	 * 手册编号
	 */
	@TableField("HB_NO")
	@ByteLength(max = 12, message = "hbNo长度超过限制！")
	private String hbNo;
	
	@TableField("G_NO")
	@NotEmpty(message="序号不能为空！")
	private BigDecimal gNo;

	@TableField("CODE_T")
	@NotEmpty(message="商品编码不能为空！")
	@ByteLength(max = 10, message = "商品编码长度超过限制！")
	private String codeT;

	@TableField("G_NAME")
	@NotEmpty(message="商品名称不能为空！")
	@ByteLength(max = 50, message = "商品名称长度超过限制！")
	private String gName;
	
	@TableField("G_MODEL")
	@ByteLength(max = 255, message = "规格型号长度超过限制！")
	private String gModel;

	@TableField("UNIT")
	@NotEmpty(message="申报计量单位不能为空！")
	@ByteLength(max = 50, message = "申报计量单位长度超过限制！")
	private String unit;
	
	@TableField("UNIT_1")
	@NotEmpty(message="法定计量单位不能为空！")
	@ByteLength(max = 50, message = "法定计量单位长度超过限制！")
	private String unit1;
	
	@TableField("COUNTRY_CODE")
	@NotEmpty(message="产销国不能为空！")
	@ByteLength(max = 50, message = "产销国长度超过限制！")
	private String countryCode;


	@TableField("DEC_PRICE")
	@NotEmpty(message="申报单价不能为空！")
	@ByteLength(max = 18, message = "申报单价长度超过限制！")
	private String decPrice;
	
	@TableField("CURR")
	@NotEmpty(message="币制不能为空！")
	@ByteLength(max = 50, message = "币制长度超过限制！")
	private String curr;

	@TableField("QTY")
	@NotEmpty(message="申报数量不能为空！")
	private BigDecimal qty;


	@TableField("USE_TYPE")
	@NotEmpty(message="记录号不能为空！")
	private BigDecimal useType;
	
	@TableField("NOTE")
	@ByteLength(max = 50, message = "备注长度超过限制！")
	private String note;

	@TableField("MODIFY_MARK")
	@NotEmpty(message="处理标志不能为空！")
	@ByteLength(max = 50, message = "处理标志长度超过限制！")
	private String modifyMark;

	@TableField("APPR_AMT")
	@NotEmpty(message="总价不能为空！")
	private BigDecimal apprAmt;
	
	@TableField("DUTY_MODE")
	@ByteLength(max = 50, message = "征免方式长度超过限制！")
	private String dutyMode;

	@TableField("APPLY_STATE")
	@NotEmpty(message="申报状态不能为空！")
	@ByteLength(max = 50, message = "申报状态长度超过限制！")
	private String applyState;

	@TableField("HEAD_OID")
	@NotEmpty(message="手册表头OID不能为空！")
	@ByteLength(max = 36, message = "手册表头OID长度超过限制！")
	private String headOid;

	@TableField("INSERT_TIME")
	@NotEmpty(message="插入日期不能为空！")
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date insertTime;

	@TableField("INSERT_USER")
	@NotEmpty(message="新增用户不能为空！")
	@ByteLength(max = 20, message = "新增用户长度超过限制！")
	private String insertUser;

	@TableField("DBSOURCE")
	@NotEmpty(message="DBSOURCE不能为空！")
	private String dbsource;

	@TableField("对应成品变更表OID")
	@ByteLength(max = 36, message = "对应成品变更表OID长度超过限制！")
	private String exgChangeOid;

	@TableField("UPDATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date updateTime;
	
	@TableField("UPDATE_USER")
	@ByteLength(max = 20, message = "UpdateUser长度超过限制！")
	private String updateUser;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getHbNo() {
		return hbNo;
	}

	public void setHbNo(String hbNo) {
		this.hbNo = hbNo;
	}

	public BigDecimal getgNo() {
		return gNo;
	}

	public void setgNo(BigDecimal gNo) {
		this.gNo = gNo;
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

	public String getgModel() {
		return gModel;
	}

	public void setgModel(String gModel) {
		this.gModel = gModel;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnit1() {
		return unit1;
	}

	public void setUnit1(String unit1) {
		this.unit1 = unit1;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDecPrice() {
		return decPrice;
	}

	public void setDecPrice(String decPrice) {
		this.decPrice = decPrice;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public BigDecimal getUseType() {
		return useType;
	}

	public void setUseType(BigDecimal useType) {
		this.useType = useType;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getModifyMark() {
		return modifyMark;
	}

	public void setModifyMark(String modifyMark) {
		this.modifyMark = modifyMark;
	}

	public BigDecimal getApprAmt() {
		return apprAmt;
	}

	public void setApprAmt(BigDecimal apprAmt) {
		this.apprAmt = apprAmt;
	}

	public String getDutyMode() {
		return dutyMode;
	}

	public void setDutyMode(String dutyMode) {
		this.dutyMode = dutyMode;
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

	public String getExgChangeOid() {
		return exgChangeOid;
	}

	public void setExgChangeOid(String exgChangeOid) {
		this.exgChangeOid = exgChangeOid;
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
	
	

}
