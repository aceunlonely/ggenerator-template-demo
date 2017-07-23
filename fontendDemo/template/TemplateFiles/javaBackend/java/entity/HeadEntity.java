package com.dcjet.${ddata.solution.solutionName}.entity;

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
 * <h3>表头实体</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
@TableName("${data.dataSourceNameTable}")
public class ${data.moduleName}HeadEntity extends BaseEntity<${data.moduleName}HeadEntity>  {
	private static final long serialVersionUID = 1L;
	
	{@each data.fields.rows as di, index}   
	/**
	 * ${di.FIELDDESC}
	 */
	{@if di.PRIMARYKEY == "1" }
	@TableId(type=IdType.UUID, value="${di.FIELDNAME}")
	{@/if}
	@TableField("${di.FIELDNAME}")
	{@if di.ISNULL == "0"}
	@NotEmpty(message="${di.FIELDDESC}不能为空！")
	{@/if}
	{@if (di.DBTYPE=="varchar" || di.DBTYPE=="nvarchar"  || di.DBTYPE=="nchar") && di.controlType =="1" && di.LENGTH }
	@ByteLength(max = ${di.LENGTH}, message = "${di.FIELDDESC}长度超过限制！")
	{@/if}
	{@if di.DBTYPE=="number" || di.DBTYPE=="numeric" }
	@Digits(integer = ${di.INTLENGTH}, fraction = ${di.SCALE}, message = "${di.FIELDDESC}数字范围超过限制！")
	{@/if}
	${di|generateEntityField}

    {@/each}

	{@each data.fields.rows as di, index}
		public ${di|getEntityFieldType} get${di.FIELDNAME|getDcmFirstUpper}() {
		return ${di.FIELDNAME|getDcm};
	}

	public void set${di.FIELDNAME|getDcmFirstUpper}(${di|getEntityFieldType} ${di.FIELDNAME|getDcm}) {
		this.${di.FIELDNAME|getDcm} = ${di.FIELDNAME|getDcm};
	}

	{@/each}
}
