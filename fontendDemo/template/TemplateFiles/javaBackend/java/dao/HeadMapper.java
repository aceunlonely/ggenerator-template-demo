package com.dcjet.${data.solution.solutionName}.dao;

import java.util.ArrayList;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dcjet.${data.solution.solutionName}.entity.${data.moduleName}HeadEntity;
import com.dcjet.${data.solution.solutionName}.search.${data.moduleName}HeadSearch;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>数据接口</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
public interface ${data.moduleName}HeadMapper extends BaseMapper<${data.moduleName}HeadEntity> {
	/**
	 * 根据查询条件获取分页信息
	 * @param search 查询条件
	 * @return
	 */
	ArrayList<${data.moduleName}HeadEntity> selectHeadListBySearch(${data.moduleName}HeadSearch search);

	/**
	 * 根据查询条件获取分页信息总数
	 * @param search 查询条件
	 * @return
	 */
	int selectHeadListCountBySearch(${data.moduleName}HeadSearch search);
	
	/**
	 * 根据查询条件获取导出信息
	 * @param search 查询条件
	 * @return
	 */
	ArrayList<${data.moduleName}HeadEntity> selectHeadListForExport(${data.moduleName}HeadSearch search);
}
