package com.dcjet.${ddata.solution.solutionName}.service.impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dcjet.${ddata.solution.solutionName}.base.BackendService;
import com.dcjet.${ddata.solution.solutionName}.dao.${data.moduleName}BodyMapper;
import com.dcjet.${ddata.solution.solutionName}.entity.${data.moduleName}BodyEntity;
import com.dcjet.${ddata.solution.solutionName}.search.${data.moduleName}BodySearch;
import com.dcjet.${ddata.solution.solutionName}.service.I${data.moduleName}BodyService;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>表体服务实现接口</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
@Service("${data.moduleName}BodyService")
public class ${data.moduleName}BodyService extends BackendService<${data.moduleName}BodyEntity> implements I${data.moduleName}BodyService {
	@Autowired
	${data.moduleName}BodyMapper ${data.moduleName|firstLowerCase}BodyMapper;
		
	@Override
	public ArrayList<${data.moduleName}BodyEntity> selectBodyListBySearch(${data.moduleName}BodySearch search) {
		return ${data.moduleName|firstLowerCase}BodyMapper.selectBodyListBySearch(search);
	}

	@Override
	public int selectBodyListCountBySearch(${data.moduleName}BodySearch search) {
		return ${data.moduleName|firstLowerCase}BodyMapper.selectBodyListCountBySearch(search);
	}
	
	@Override
	public ArrayList<${data.moduleName}BodyEntity> selectBodyListForExport(${data.moduleName}BodySearch search) {
		return ${data.moduleName|firstLowerCase}BodyMapper.selectBodyListForExport(search);
	}
}
