package com.dcjet.javaBackendDemo.base;

import org.springframework.stereotype.Service;

import com.dcjet.apollo.framework.core.AppContext;
import com.dcjet.apollo.framework.jdbc.AbstractDataSourceProvider;
import com.dcjet.apollo.framework.jdbc.model.DataSourceConsumerInfo;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>数据源选择器</h3>
 * @version 1.0
 * @author Administrator
 * 
 */
@Service
public class DataSourceProvider extends AbstractDataSourceProvider {
	@Override
	protected DataSourceConsumerInfo getDataSourceConsumerInfo() {
		DataSourceConsumerInfo dataSourceConsumerInfo = new DataSourceConsumerInfo();
		dataSourceConsumerInfo.setCorpCode(AppContext.current.getCorporation().getId());
		dataSourceConsumerInfo.setOperationSystem("SJGJZ");
		dataSourceConsumerInfo.setExtendField1("");
		return dataSourceConsumerInfo;
	}
}
