package com.dcjet.javaBackendDemo.service;


import java.util.ArrayList;

import com.dcjet.javaBackendDemo.base.IBackendService;
import com.dcjet.javaBackendDemo.entity.ZtythHbHeadEntity;
import com.dcjet.javaBackendDemo.search.ZtythHbHeadSearch;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>手册设立表头服务接口</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
public interface IZtythHbHeadService extends IBackendService<ZtythHbHeadEntity> {


	ArrayList<ZtythHbHeadEntity>  selectHeadListBySearch(ZtythHbHeadSearch search);
	
	int selectHeadListCountBySearch(ZtythHbHeadSearch search);
			
	ArrayList<ZtythHbHeadEntity> selectHeadListForExport(ZtythHbHeadSearch search);

	
}
