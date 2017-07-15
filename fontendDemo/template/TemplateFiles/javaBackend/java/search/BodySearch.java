package com.dcjet.${ddata.solution.solutionName}.search;

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
	/**
	 * ${di.FIELDDESC}
	 */
	${di|generateEntityField}

	public String get${di.FIELDNAME|firstUpperCase}() {
		return ${di.FIELDNAME|getDcm};
	}

	public void set${di.FIELDNAME|firstUpperCase}(String ${di.FIELDNAME|getDcm}) {
		this.${di.FIELDNAME|getDcm} = ${di.FIELDNAME|getDcm};
	}
		{@/if}
    {@/each}
}
