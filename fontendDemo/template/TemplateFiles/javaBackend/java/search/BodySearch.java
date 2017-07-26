package com.dcjet.${ddata.solution.solutionName}.search;

import java.math.BigDecimal;
import java.util.Date;

import com.dcjet.${ddata.solution.solutionName}.base.BackendBaseSearch;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>表体查询条件实体</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
public class ${data.moduleName}BodySearch extends BackendBaseSearch {
	private static final long serialVersionUID = 1L;

	{@each data.fields.rows as di, index}  
		{@if di.isQueryConditionShow == "Y"}   
			{@if di.DBTYPE == "datetime" || di.DBTYPE == "date" }
	/**
	 * ${di.FIELDDESC}开始
	 */
	private String ${di.FIELDNAME|getDcm}Begin;

	/**
	 * ${di.FIELDDESC}结束
	 */
	private String ${di.FIELDNAME|getDcm}End;

			{@else}
	/**
	 * ${di.FIELDDESC}
	 */
	${di|generateEntityField}
			{@/if}
		{@/if}

	{@/each}

	{@each data.fields.rows as di, index}

	{@if di.isQueryConditionShow == "Y"}  

		{@if di.DBTYPE == "datetime" || di.DBTYPE == "date" }

	public String get${di.FIELDNAME|getDcmFirstUpper}Begin() {
		return ${di.FIELDNAME|getDcm}Begin;
	}

	public void set${di.FIELDNAME|getDcmFirstUpper}Begin(String ${di.FIELDNAME|getDcm}Begin) {
		this.${di.FIELDNAME|getDcm}Begin = ${di.FIELDNAME|getDcm}Begin;
	}

	public String get${di.FIELDNAME|getDcmFirstUpper}End() {
		return ${di.FIELDNAME|getDcm}End;
	}

	public void set${di.FIELDNAME|getDcmFirstUpper}End(String ${di.FIELDNAME|getDcm}End) {
		this.${di.FIELDNAME|getDcm}End = ${di.FIELDNAME|getDcm}End;
	}

		{@else}

	public ${di|getEntityFieldType} get${di.FIELDNAME|getDcmFirstUpper}() {
		return ${di.FIELDNAME|getDcm};
	}

	public void set${di.FIELDNAME|getDcmFirstUpper}(${di|getEntityFieldType} ${di.FIELDNAME|getDcm}) {
		this.${di.FIELDNAME|getDcm} = ${di.FIELDNAME|getDcm};
	}
		{@/if}
	{@/if}

	{@/each}
}
