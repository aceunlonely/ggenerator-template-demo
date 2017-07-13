package com.dcjet.javaBackendDemo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcjet.apollo.framework.core.ActionResult;
import com.dcjet.apollo.framework.utils.DateTimeUtil;
import com.dcjet.apollo.framework.utils.PubUtil;
import com.dcjet.apollo.framework.utils.constant.ExcelPostfixEnum;
import com.dcjet.apollo.framework.web.common.ResponseResult;
import com.dcjet.apollo.framework.web.utils.ExcelExtendUtil;
import com.dcjet.javaBackendDemo.base.BackendBaseController;
import com.dcjet.javaBackendDemo.common.FrontendGridResult;
import com.dcjet.javaBackendDemo.entity.ZtythHbImgEntity;
import com.dcjet.javaBackendDemo.search.ZtythHbImgSearch;
import com.dcjet.javaBackendDemo.service.IZtythHbImgService;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>手册设立料件表控制器</h3>
 * @version 1.0
 * @author Administrator
 */
@Controller
@RequestMapping("/ZtythHbImg")
public class ZtythHbImgController extends BackendBaseController {
	@Resource
	private IZtythHbImgService ztythHbImgService; 
	
	/**
	 * 获取数据分页列表
	 * @param searchEntity 查询实体
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getList")
	public FrontendGridResult<ZtythHbImgEntity> getList(HttpServletResponse response, ZtythHbImgSearch searchEntity) {
		ArrayList<ZtythHbImgEntity> list = ztythHbImgService.selectBodyListBySearch(searchEntity); 
		int total = ztythHbImgService.selectBodyListCountBySearch(searchEntity);
		FrontendGridResult<ZtythHbImgEntity> result = new FrontendGridResult<ZtythHbImgEntity>(total,list);
		return result;
	}
		
	/**
	 * 获取单条数据
	 * @param oid 主键
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/get")
	public ResponseResult get(String oid) {
		ZtythHbImgEntity body = ztythHbImgService.selectById(oid);
		ResponseResult responseResult = new ResponseResult();
		responseResult.addData(body);
		return responseResult;
	}
		
	/**
	 * 数据删除
	 * @param oid 主键
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public ResponseResult delete(String oid) {
		ResponseResult responseResult = new ResponseResult();
		ActionResult result = ztythHbImgService.deleteBatchIdsFor(Arrays.asList(oid.split(",")));
		responseResult.setSuccess(result.getSuccess());
		return responseResult;
	}
		
	/**
	 * 数据修改
	 * @param oid 主键
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit" )
	public ResponseResult edit(HttpServletResponse response,ZtythHbImgEntity body) {
		ResponseResult responseResult = new ResponseResult();
		ActionResult result = new ActionResult();
		if (StringUtils.isNotBlank(body.getOid())) {
			result = ztythHbImgService.updateByIdFor(body);
		} else {
			body.setOid(PubUtil.generateUUID());
			result = ztythHbImgService.insertFor(body);
		}

		if(result.getSuccess()) {
			responseResult.setSuccess();
			responseResult.addData(body.getOid());
		} else {
			responseResult.setError(result.getMessage());
			responseResult.addData("");
		}
		return responseResult;
	}
	
	/**
	 * 导出Excel
	 * @param response
	 * @param searchEntity
	 * @return
	 */
	@RequestMapping("/export")
	public void exportExcel(HttpServletResponse response, ZtythHbImgSearch searchEntity) throws IOException {
		//获取导出数据
		ArrayList<ZtythHbImgEntity> lst = ztythHbImgService.selectBodyListForExport(searchEntity);
		//导出数据项
		LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
		fieldMap.put("hbNo", "手册编号");
		fieldMap.put("codeT", "商品编码");
		fieldMap.put("gName", "商品名称");
		fieldMap.put("gModel", "规格型号");
		//Execl中sheet名称
		String sheetName = "手册设立料件表";
		try{
			String fileName = DateTimeUtil.convertDateToString(
					DateTimeUtil.D17_DATETIME_PATTERN, new Date())
					+ PubUtil.getFixLengthRandomString(5) + ExcelPostfixEnum.Office2007Xlsx.getConstValue();
			//调用导出公用方法
			ExcelExtendUtil.listToExcel(lst, fieldMap, sheetName, 5000, fileName, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
