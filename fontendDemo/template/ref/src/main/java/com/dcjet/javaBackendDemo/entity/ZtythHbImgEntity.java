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
 * <h3>手册设立料件表表体</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
@TableName("T_ZTYTH_HB_IMG")
public class ZtythHbImgEntity extends BaseEntity<ZtythHbImgEntity> {
	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标示
	 */
	@TableId(type=IdType.UUID, value="OID")
	private String oid;
	
	/**
	 * 手册编号
	 */
	@TableField("HB_NO")
	@ByteLength(max = 12, message = "hbNo长度超过限制！")
	private String hbNo;
	
	/**
	 * 序号
	 */
	@TableField("G_NO")
	@NotEmpty(message="序号不能为空！")
	private String gNo;

	/**
	 * 商品编码
	 */
	@TableField("CODE_T")
	@NotEmpty(message="商品编码不能为空！")
	@ByteLength(max = 10, message = "商品编码长度超过限制！")
	private String codeT;

	/**
	 * 商品名称
	 */
	@TableField("G_NAME")
	@NotEmpty(message="商品名称不能为空！")
	@ByteLength(max = 50, message = "商品名称长度超过限制！")
	private String gName;
	
	/**
	 * 规格型号
	 */
	@TableField("G_MODEL")
	@ByteLength(max = 255, message = "规格型号长度超过限制！")
	private String gModel;

	/**
	 * 申报计量单位
	 */
	@TableField("UNIT")
	@NotEmpty(message="申报计量单位不能为空！")
	@ByteLength(max = 50, message = "申报计量单位长度超过限制！")
	private String unit;
	
	/**
	 * 法定计量单位
	 */
	@TableField("UNIT_1")
	@NotEmpty(message="法定计量单位不能为空！")
	@ByteLength(max = 50, message = "法定计量单位长度超过限制！")
	private String unit1;
	
	/**
	 * 产销国
	 */
	@TableField("COUNTRY_CODE")
	@NotEmpty(message="产销国不能为空！")
	@ByteLength(max = 50, message = "产销国长度超过限制！")
	private String countryCode;

	/**
	 * 申报单价
	 */
	@TableField("DEC_PRICE")
	@NotEmpty(message="申报单价不能为空！")
	@ByteLength(max = 18, message = "申报单价长度超过限制！")
	private String decPrice;
	
	/**
	 * 币制
	 */
	@TableField("CURR")
	@NotEmpty(message="币制不能为空！")
	@ByteLength(max = 50, message = "币制长度超过限制！")
	private String curr;

	/**
	 * 申报数量
	 */
	@TableField("QTY")
	@Digits(integer = 14, fraction = 5, message="申报数量不能为空！")
	private BigDecimal qty;

	/**
	 * 记录号
	 */
	@TableField("USE_TYPE")
	@NotEmpty(message="记录号不能为空！")
	private String useType;
	
	/**
	 * 备注
	 */
	@TableField("NOTE")
	@ByteLength(max = 50, message = "备注长度超过限制！")
	private String note;

	/**
	 * 处理标志
	 */
	@TableField("MODIFY_MARK")
	@ByteLength(max = 50, message = "处理标志长度超过限制！")
	private String modifyMark;

	/**
	 * 总价
	 */
	@TableField("APPR_AMT")
	@Digits(integer = 14, fraction = 5, message="总价不能为空！")
	private BigDecimal apprAmt;
	
	/**
	 * 征免方式
	 */
	@TableField("DUTY_MODE")
	@ByteLength(max = 1, message = "征免方式长度超过限制！")
	private String dutyMode;

	/**
	 * 手册表头OID
	 */
	@TableField("HEAD_OID")
	@NotEmpty(message="手册表头OID不能为空！")
	@ByteLength(max = 36, message = "手册表头OID长度超过限制！")
	private String headOid;

	/**
	 * 插入日期
	 */
	@TableField("INSERT_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date insertTime;

	/**
	 * 新增用户
	 */
	@TableField("INSERT_USER")
	@ByteLength(max = 20, message = "新增用户长度超过限制！")
	private String insertUser;

	/**
	 * 0录入1导入
	 */
	@TableField("DBSOURCE")
	private String dbsource;

	/**
	 * 对应料件变更表OID
	 */
	@TableField("IMG_CHANGE_OID")
	@ByteLength(max = 36, message = "对应料件变更表OID长度超过限制！")
	private String imgChangeOid;

	/**
	 * 修改日期
	 */
	@TableField("UPDATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date updateTime;
	
	/**
	 * 修改用户
	 */
	@TableField("UPDATE_USER")
	@ByteLength(max = 20, message = "修改用户长度超过限制！")
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

	public String getGNo() {
		return gNo;
	}

	public void setGNo(String gNo) {
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

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
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

	public String getImgChangeOid() {
		return imgChangeOid;
	}

	public void setImgChangeOid(String imgChangeOid) {
		this.imgChangeOid = imgChangeOid;
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
