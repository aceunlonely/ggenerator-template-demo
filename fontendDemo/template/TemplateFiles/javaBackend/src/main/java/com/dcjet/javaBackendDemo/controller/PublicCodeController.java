package com.dcjet.javaBackendDemo.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcjet.apollo.framework.publicCode.PublicCodeProvider;
import com.dcjet.apollo.framework.publicCode.model.PublicCodeItem;
import com.dcjet.javaBackendDemo.base.BackendBaseController;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>公共参数控制器</h3>
 * @version 1.0
 * @author Administrator
 */
@Controller
@RequestMapping("/PublicCode")
public class PublicCodeController extends BackendBaseController {
	@Resource
	private PublicCodeProvider publicCodeProvider; 

	/**
	 * 获取公共代码参数列表
	 * @param catalogCode 参数编码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/getList")
	public List<PublicCodeItem> getList(String catalogCode) throws Exception {		
		List<PublicCodeItem> getPublicItem = null;
		getPublicItem = publicCodeProvider.getPublicCodeList(catalogCode);
		return getPublicItem;
	}
}
