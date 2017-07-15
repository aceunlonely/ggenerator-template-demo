package com.dcjet.${data.solution.solutionName}.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcjet.${data.solution.solutionName}.base.BackendService;
import com.dcjet.${data.solution.solutionName}.dao.${data.moduleName}HeadMapper;
import com.dcjet.${data.solution.solutionName}.entity.${data.moduleName}HeadEntity;
import com.dcjet.${data.solution.solutionName}.search.${data.moduleName}HeadSearch;
import com.dcjet.${data.solution.solutionName}.service.I${data.moduleName}HeadService;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>表头服务实现接口</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
@Service("${data.moduleName}HeadService")
public class ${data.moduleName}HeadService extends BackendService<${data.moduleName}HeadEntity> implements I${data.moduleName}HeadService {
	@Autowired
	${data.moduleName}HeadMapper ${data.moduleName|firstLowerCase}HeadMapper;
		
	@Override
	public ArrayList<${data.moduleName}HeadEntity> selectHeadListBySearch(${data.moduleName}HeadSearch search) {
		return ${data.moduleName|firstLowerCase}HeadMapper.selectHeadListBySearch(search);
	}

	@Override
	public int selectHeadListCountBySearch(${data.moduleName}HeadSearch search) {
		return ${data.moduleName|firstLowerCase}HeadMapper.selectHeadListCountBySearch(search);
	}

	@Override
	public ArrayList<${data.moduleName}HeadEntity> selectHeadListForExport(${data.moduleName}HeadSearch search) {
		return ${data.moduleName|firstLowerCase}HeadMapper.selectHeadListForExport(search);
	}
}
