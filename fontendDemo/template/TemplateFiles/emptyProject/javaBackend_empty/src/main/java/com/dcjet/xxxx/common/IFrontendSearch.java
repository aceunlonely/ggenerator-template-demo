package com.dcjet.${ddata.solution.solutionName}.common;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>前端框架查询接口</h3>
 * @version 1.0
 * @author Administrator
 */
public interface IFrontendSearch {
	public String getPage() ;

	public void setPage(String page);
	
	public String getRows() ;

	public void setRows(String rows) ;
	
	public String getSort() ;

	public void setSort(String sort) ;
	
	public String getOrder() ;

	public void setOrder(String order) ;

	public String getCallback() ;

	public void setCallback(String callback) ;
}
