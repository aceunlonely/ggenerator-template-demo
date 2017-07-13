package com.dcjet.javaBackendDemo.service;

import java.util.ArrayList;

import com.dcjet.javaBackendDemo.base.IBackendService;
import com.dcjet.javaBackendDemo.entity.BodyEntity;
import com.dcjet.javaBackendDemo.entity.HeadEntity;
import com.dcjet.javaBackendDemo.search.BodySearch;
import com.dcjet.javaBackendDemo.search.DemoSearch;

public interface IDemoService extends IBackendService<HeadEntity> {
	/**
	 * 根据查询条件获取表头信息
	 * @param search 查询条件
	 * @return
	 */
	ArrayList<HeadEntity> selectHeadListBySearch(DemoSearch search);
	
	ArrayList<BodyEntity> selectBodyListBySearch(BodySearch search);
	
	BodyEntity getBodyById(String headOid,String oid);
	
	boolean delBodyById(String headOid,String oid);
	
	boolean editBodyById(BodyEntity entity);
}
