package com.dcjet.javaBackendDemo.service;


import java.util.ArrayList;
import com.dcjet.javaBackendDemo.base.IBackendService;
import com.dcjet.javaBackendDemo.entity.ZtythHbImgEntity;
import com.dcjet.javaBackendDemo.search.ZtythHbImgSearch;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>手册设立料件服务接口</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
public interface IZtythHbImgService extends IBackendService<ZtythHbImgEntity> {

	
	ArrayList<ZtythHbImgEntity> selectBodyListBySearch(ZtythHbImgSearch search);
	
	
	int selectBodyListCountBySearch(ZtythHbImgSearch search);
	

	ArrayList<ZtythHbImgEntity> selectBodyListForExport(ZtythHbImgSearch search);

}
