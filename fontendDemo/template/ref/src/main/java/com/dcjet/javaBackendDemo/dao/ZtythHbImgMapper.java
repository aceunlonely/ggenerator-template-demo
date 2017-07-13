package com.dcjet.javaBackendDemo.dao;

import java.util.ArrayList;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dcjet.javaBackendDemo.entity.ZtythHbImgEntity;
import com.dcjet.javaBackendDemo.search.ZtythHbImgSearch;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>手册设立料件数据接口</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
public interface ZtythHbImgMapper extends BaseMapper<ZtythHbImgEntity> {
	/**
	 * 根据查询条件获取手册设立料件分页信息
	 * @param search 查询条件
	 * @return
	 */
	ArrayList<ZtythHbImgEntity> selectBodyListBySearch(ZtythHbImgSearch search);

	/**
	 * 根据查询条件获取手册设立料件分页信息记录总数
	 * @param search 查询条件
	 * @return
	 */
	int selectBodyListCountBySearch(ZtythHbImgSearch search);
	
	/**
	 * 根据查询条件获取手册设立料件导出信息
	 * @param search 查询条件
	 * @return
	 */
	ArrayList<ZtythHbImgEntity> selectBodyListForExport(ZtythHbImgSearch search);
}
