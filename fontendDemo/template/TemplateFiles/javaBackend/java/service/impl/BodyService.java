package com.dcjet.javaBackendDemo.service.impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dcjet.javaBackendDemo.base.BackendService;
import com.dcjet.javaBackendDemo.dao.ZtythHbImgMapper;
import com.dcjet.javaBackendDemo.entity.ZtythHbImgEntity;
import com.dcjet.javaBackendDemo.search.ZtythHbImgSearch;
import com.dcjet.javaBackendDemo.service.IZtythHbImgService;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>手册设立料件服务实现接口</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
@Service("ZtythHbImgService")
public class ZtythHbImgService extends BackendService<ZtythHbImgEntity> implements IZtythHbImgService {
	@Autowired
	ZtythHbImgMapper ztythHbImgMapper;
		
	@Override
	public ArrayList<ZtythHbImgEntity> selectBodyListBySearch(ZtythHbImgSearch search) {
		return ztythHbImgMapper.selectBodyListBySearch(search);
	}

	@Override
	public int selectBodyListCountBySearch(ZtythHbImgSearch search) {
		return ztythHbImgMapper.selectBodyListCountBySearch(search);
	}
	
	@Override
	public ArrayList<ZtythHbImgEntity> selectBodyListForExport(ZtythHbImgSearch search) {
		return ztythHbImgMapper.selectBodyListForExport(search);
	}
}
