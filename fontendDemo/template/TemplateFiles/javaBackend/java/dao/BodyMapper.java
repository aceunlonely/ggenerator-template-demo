package com.dcjet.${ddata.solution.solutionName}.dao;

import java.util.ArrayList;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dcjet.${ddata.solution.solutionName}.entity.${data.moduleName}BodyEntity;
import com.dcjet.${ddata.solution.solutionName}.search.${data.moduleName}BodySearch;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>数据接口</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
public interface ${data.moduleName}BodyMapper extends BaseMapper<${data.moduleName}BodyEntity> {
	/**
	 * 根据查询条件分页信息
	 * @param search 查询条件
	 * @return
	 */
	ArrayList<${data.moduleName}BodyEntity> selectBodyListBySearch(${data.moduleName}BodySearch search);

	/**
	 * 根据查询条件获取分页信息记录总数
	 * @param search 查询条件
	 * @return
	 */
	int selectBodyListCountBySearch(${data.moduleName}BodySearch search);
	
	/**
	 * 根据查询条件获取导出信息
	 * @param search 查询条件
	 * @return
	 */
	ArrayList<${data.moduleName}BodyEntity> selectBodyListForExport(${data.moduleName}BodySearch search);
}
