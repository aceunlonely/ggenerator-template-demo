package com.dcjet.${ddata.solution.solutionName}.service;


import java.util.ArrayList;
import com.dcjet.${ddata.solution.solutionName}.base.IBackendService;
import com.dcjet.${ddata.solution.solutionName}.entity.${data.moduleName}BodyEntity;
import com.dcjet.${ddata.solution.solutionName}.search.${data.moduleName}BodySearch;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>表体服务接口</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
public interface I${data.moduleName}BodyService extends IBackendService<${data.moduleName}BodyEntity> {

	
	ArrayList<${data.moduleName}BodyEntity> selectBodyListBySearch(${data.moduleName}BodySearch search);
	
	
	int selectBodyListCountBySearch(${data.moduleName}BodySearch search);
	

	ArrayList<${data.moduleName}BodyEntity> selectBodyListForExport(${data.moduleName}BodySearch search);

}
