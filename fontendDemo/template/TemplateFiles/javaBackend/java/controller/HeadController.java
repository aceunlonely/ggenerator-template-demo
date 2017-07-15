package com.dcjet.${data.solution.solutionName}.controller;

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
import com.dcjet.${data.solution.solutionName}.base.BackendBaseController;
import com.dcjet.${data.solution.solutionName}.common.FrontendGridResult;
import com.dcjet.${data.solution.solutionName}.entity.${data.moduleName}HeadEntity;
import com.dcjet.${data.solution.solutionName}.search.${data.moduleName}HeadSearch;
import com.dcjet.${data.solution.solutionName}.service.I${data.moduleName}HeadService;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>手册设立表头控制器</h3>
 * @version 1.0
 * @author Administrator
 */
@Controller
@RequestMapping("/${data.moduleName}Head")
public class ${data.moduleName}HeadController extends BackendBaseController {
	@Resource
	private I${data.moduleName}HeadService ${data.moduleName|firstLowerCase}HeadService; 

	/**
	 * 获取数据分页列表
	 * @param searchEntity 查询实体
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/getList")
	public FrontendGridResult<${data.moduleName}HeadEntity> getList(${data.moduleName}HeadSearch searchEntity) throws IOException {			
		ArrayList<${data.moduleName}HeadEntity> lst = ${data.moduleName|firstLowerCase}HeadService.selectHeadListBySearch(searchEntity);
		int total = ${data.moduleName|firstLowerCase}HeadService.selectHeadListCountBySearch(searchEntity);
		FrontendGridResult<${data.moduleName}HeadEntity> result = new FrontendGridResult<${data.moduleName}HeadEntity>(total,lst);
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
		${data.moduleName}HeadEntity head = ${data.moduleName|firstLowerCase}HeadService.selectById(oid);
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
		ActionResult result = ${data.moduleName|firstLowerCase}HeadService.deleteBatchIdsFor(Arrays.asList(oid.split(",")));
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
	public ResponseResult edit(${data.moduleName}HeadEntity head) {
		ResponseResult responseResult = new ResponseResult();
		ActionResult result = new ActionResult();
		if (StringUtils.isNotBlank(head.getOid())) {
			result = ${data.moduleName|firstLowerCase}HeadService.updateByIdFor(head);
		} else {
			head.setOid(PubUtil.generateUUID());
			result = ${data.moduleName|firstLowerCase}HeadService.insertFor(head);
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
	public void exportExcel(HttpServletResponse response, ${data.moduleName}HeadSearch searchEntity) throws IOException {
		//获取导出数据
		ArrayList<${data.moduleName}HeadEntity> lst = ${data.moduleName|firstLowerCase}HeadService.selectHeadListForExport(searchEntity);
		//导出数据项
		LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
		{@each data.fields.rows as di, index}
                        {@if di.isTableShow == "Y"}
		fieldMap.put("${di.FIELDNAME|getDcm}", "${di.FIELDDESC}");
                        {@/if}
        {@/each}
        //Execl中sheet名称
		String sheetName = "XXXX表";
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
