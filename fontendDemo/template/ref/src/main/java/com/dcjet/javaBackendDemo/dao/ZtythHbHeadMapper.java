package com.dcjet.javaBackendDemo.dao;

import java.util.ArrayList;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dcjet.javaBackendDemo.entity.ZtythHbHeadEntity;
import com.dcjet.javaBackendDemo.search.ZtythHbHeadSearch;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>手册设立表头数据接口</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
public interface ZtythHbHeadMapper extends BaseMapper<ZtythHbHeadEntity> {
	/**
	 * 根据查询条件获取手册设立表头分页信息
	 * @param search 查询条件
	 * @return
	 */
	ArrayList<ZtythHbHeadEntity> selectHeadListBySearch(ZtythHbHeadSearch search);

	/**
	 * 根据查询条件获取手册设立表头分页信息总数
	 * @param search 查询条件
	 * @return
	 */
	int selectHeadListCountBySearch(ZtythHbHeadSearch search);
	
	/**
	 * 根据查询条件获取手册设立表头导出信息
	 * @param search 查询条件
	 * @return
	 */
	ArrayList<ZtythHbHeadEntity> selectHeadListForExport(ZtythHbHeadSearch search);
}
