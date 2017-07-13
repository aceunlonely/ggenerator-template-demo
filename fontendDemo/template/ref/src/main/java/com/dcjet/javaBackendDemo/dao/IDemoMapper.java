package com.dcjet.javaBackendDemo.dao;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dcjet.javaBackendDemo.entity.HeadEntity;
import com.dcjet.javaBackendDemo.search.DemoSearch;

public interface IDemoMapper extends BaseMapper<HeadEntity> {
	/**
	 * 根据查询条件获取表头信息
	 * @param search 查询条件
	 * @return
	 */
	List<HeadEntity> selectHeadListBySearch(DemoSearch search);
}
