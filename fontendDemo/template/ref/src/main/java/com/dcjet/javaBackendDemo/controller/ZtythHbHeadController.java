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
import com.dcjet.javaBackendDemo.entity.ZtythHbHeadEntity;
import com.dcjet.javaBackendDemo.search.ZtythHbHeadSearch;
import com.dcjet.javaBackendDemo.service.IZtythHbHeadService;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>手册设立表头控制器</h3>
 * @version 1.0
 * @author Administrator
 */
@Controller
@RequestMapping("/ZtythHbHead")
public class ZtythHbHeadController extends BackendBaseController {
	@Resource
	private IZtythHbHeadService ztythHbService; 

	/**
	 * 获取数据分页列表
	 * @param searchEntity 查询实体
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/getList")
	public FrontendGridResult<ZtythHbHeadEntity> getList(ZtythHbHeadSearch searchEntity) throws IOException {			
		ArrayList<ZtythHbHeadEntity> lst = ztythHbService.selectHeadListBySearch(searchEntity);
		int total = ztythHbService.selectHeadListCountBySearch(searchEntity);
		FrontendGridResult<ZtythHbHeadEntity> result = new FrontendGridResult<ZtythHbHeadEntity>(total,lst);
		return result;
	}
	
	/**
	 * 获取单条数据
	 * @param oid 主键
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/get")
	public ResponseResult get(String oid) {
		ZtythHbHeadEntity head = ztythHbService.selectById(oid);
		ResponseResult responseResult = new ResponseResult();
		responseResult.addData(head);
		return responseResult;
	}
	
	/**
	 * 数据删除
	 * @param oid 主键
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/delete")
	public ResponseResult delete(String oid) {
		ResponseResult responseResult = new ResponseResult();
		ActionResult result = ztythHbService.deleteBatchIdsFor(Arrays.asList(oid.split(",")));
		responseResult.setSuccess(result.getSuccess());
		return responseResult;
	}
	
	/**
	 * 数据修改
	 * @param oid 主键
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit")
	public ResponseResult edit(ZtythHbHeadEntity head) {
		ResponseResult responseResult = new ResponseResult();
		ActionResult result = new ActionResult();
		if (StringUtils.isNotBlank(head.getOid())) {
			result = ztythHbService.updateByIdFor(head);
		} else {
			head.setOid(PubUtil.generateUUID());
			result = ztythHbService.insertFor(head);
		}
		
		if(result.getSuccess()) {
			responseResult.setSuccess();
			responseResult.addData(head.getOid());
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
	public void exportExcel(HttpServletResponse response, ZtythHbHeadSearch searchEntity) throws IOException {
		//获取导出数据
		ArrayList<ZtythHbHeadEntity> lst = ztythHbService.selectHeadListForExport(searchEntity);
		//导出数据项
		LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
		fieldMap.put("compNo", "企业编码");
		fieldMap.put("tradeName", "经营单位名称");
		fieldMap.put("ownerName", "加工单位名称");
		fieldMap.put("masterCustoms", "主管海关");
        //Execl中sheet名称
		String sheetName = "手册设立表头";
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
