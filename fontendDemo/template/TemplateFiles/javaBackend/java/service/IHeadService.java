package com.dcjet.${data.solution.solutionName}.service;


import java.util.ArrayList;

import com.dcjet.${data.solution.solutionName}.base.IBackendService;
import com.dcjet.${data.solution.solutionName}.entity.${data.moduleName}HeadEntity;
import com.dcjet.${data.solution.solutionName}.search.${data.moduleName}HeadSearch;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>表头服务接口</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
public interface I${data.moduleName}HeadService extends IBackendService<${data.moduleName}HeadEntity> {


	ArrayList<${data.moduleName}HeadEntity>  selectHeadListBySearch(${data.moduleName}HeadSearch search);
	
	int selectHeadListCountBySearch(${data.moduleName}HeadSearch search);
			
	ArrayList<${data.moduleName}HeadEntity> selectHeadListForExport(${data.moduleName}HeadSearch search);

	
}
