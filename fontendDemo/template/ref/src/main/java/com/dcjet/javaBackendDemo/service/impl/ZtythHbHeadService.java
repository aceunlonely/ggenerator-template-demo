package com.dcjet.javaBackendDemo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcjet.javaBackendDemo.base.BackendService;
import com.dcjet.javaBackendDemo.dao.ZtythHbHeadMapper;
import com.dcjet.javaBackendDemo.entity.ZtythHbHeadEntity;
import com.dcjet.javaBackendDemo.search.ZtythHbHeadSearch;
import com.dcjet.javaBackendDemo.service.IZtythHbHeadService;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>手册设立表头服务实现接口</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
@Service("ZtythHbHeadService")
public class ZtythHbHeadService extends BackendService<ZtythHbHeadEntity> implements IZtythHbHeadService {
	@Autowired
	ZtythHbHeadMapper ztythHbHeadMapper;
		
	@Override
	public ArrayList<ZtythHbHeadEntity> selectHeadListBySearch(ZtythHbHeadSearch search) {
		return ztythHbHeadMapper.selectHeadListBySearch(search);
	}

	@Override
	public int selectHeadListCountBySearch(ZtythHbHeadSearch search) {
		return ztythHbHeadMapper.selectHeadListCountBySearch(search);
	}

	@Override
	public ArrayList<ZtythHbHeadEntity> selectHeadListForExport(ZtythHbHeadSearch search) {
		return ztythHbHeadMapper.selectHeadListForExport(search);
	}
}
