package com.dcjet.${ddata.solution.solutionName}.search;

import java.math.BigDecimal;
import java.util.Date;

import com.dcjet.${ddata.solution.solutionName}.base.BackendBaseSearch;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>表头查询条件实体</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
public class ${data.moduleName}HeadSearch extends BackendBaseSearch{
	private static final long serialVersionUID = 1L;
	
	{@each data.fields.rows as di, index}  
		{@if di.isQueryConditionShow == "Y"}   
	/**
	 * ${di.FIELDDESC}
	 */
	${di|generateEntityField}
		{@/if}
    {@/each}

	{@each data.fields.rows as di, index}

	{@if di.isQueryConditionShow == "Y"}  
	
	public ${di|getEntityFieldType} get${di.FIELDNAME|getDcmFirstUpper}() {
		return ${di.FIELDNAME|getDcm};
	}

	public void set${di.FIELDNAME|getDcmFirstUpper}(${di|getEntityFieldType} ${di.FIELDNAME|getDcm}) {
		this.${di.FIELDNAME|getDcm} = ${di.FIELDNAME|getDcm};
	}
	
	{@/if}

	{@/each}
}
