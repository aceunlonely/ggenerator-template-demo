package com.dcjet.${ddata.solution.solutionName}.base;

import com.dcjet.apollo.framework.web.base.BaseSearch;
import com.dcjet.${ddata.solution.solutionName}.common.IFrontendSearch;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>项目的BaseSearch</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
public class BackendBaseSearch extends BaseSearch implements IFrontendSearch {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 当前页
	 */
	private String page = "1";
	/**
	 * 每页行数
	 */
	private String rows = "20";
	/**
	 * 排序（升序或降序）
	 */
	private String sort;
	/**
	 * 排序字段
	 */
	private String order;
	
	/**
	 * 回调方法
	 */
	private String callback;

	public String getPage() {
		if(page==null || page.equals(""))
			return "1";
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		if(rows==null || rows.equals(""))
			return "20";
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}
}
