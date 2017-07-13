package com.dcjet.javaBackendDemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dcjet.apollo.framework.publicCode.PublicCodeProvider;
import com.dcjet.apollo.framework.publicCode.model.PublicCodeItem;
import com.dcjet.apollo.framework.web.shiro.ShiroHelper;
import com.dcjet.apollo.framework.web.shiro.authority.model.entity.FunctionEntity;
import com.dcjet.javaBackendDemo.base.BackendBaseController;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>权限控制器</h3>
 * @version 1.0
 * @author Administrator
 */
@Controller
@RequestMapping("/Permission")
public class PermissionController extends BackendBaseController {
	@Resource
	private ShiroHelper shiroHelper; 


	/**
	 * 获取公共代码参数列表
	 * @param catalogCode 参数编码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/getList")
	public JSONObject getList(String pageCode) throws Exception {		
		List<FunctionEntity> lst = null;
		lst = shiroHelper.getFunctionsByCode(pageCode);
		StringBuilder messageBuilder = new StringBuilder();
		List<String> funList = new ArrayList<String>();
		
		boolean pageShow = true;
		for(FunctionEntity fun : lst){
			if("1".equals(fun.getType()))
				pageShow = "1".equals(fun.getIsVisible())?true:false;
			boolean show = "1".equals(fun.getIsVisible())?true:false;
			boolean eable = "1".equals(fun.getIsActivated())?true:false;
			funList.add((String) ("{\"funCode\":\"" + fun.getCode()
			+ "\",\"show\":" + show
			+ ",\"eable\":" + eable + "}"));
		}
		messageBuilder.append("{pms:{\"page\":{\"pageCode\":\""+pageCode+"\",\"show\":"+pageShow+"},\"fun\":[");
		messageBuilder.append(StringUtils.join(funList.toArray(), ","));
		messageBuilder.append("]}}");		
	    JSONObject object = JSONObject.parseObject(messageBuilder.toString()) ;
		return object;
	}
}
