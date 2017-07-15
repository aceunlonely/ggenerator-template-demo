package com.dcjet.${ddata.solution.solutionName}.controller;

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
import com.dcjet.${ddata.solution.solutionName}.base.BackendBaseController;
import com.dcjet.${ddata.solution.solutionName}.common.FrontendGridResult;
import com.dcjet.${ddata.solution.solutionName}.entity.${data.moduleName}BodyEntity;
import com.dcjet.${ddata.solution.solutionName}.search.${data.moduleName}BodySearch;
import com.dcjet.${ddata.solution.solutionName}.service.I${data.moduleName}BodyService;

/**
 * Copyright (c) 2017, 苏州神州数码捷通科技有限公司
 * All rights reserved.
 * 
 * <h3>手册设立料件表控制器</h3>
 * @version 1.0
 * @author Administrator
 */
@Controller
@RequestMapping("/${data.moduleName}Body")
public class ${data.moduleName}BodyController extends BackendBaseController {
	@Resource
	private I${data.moduleName}BodyService ${data.moduleName|firstLowerCase}BodyService; 
	
	/**
	 * 获取数据分页列表
	 * @param searchEntity 查询实体
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getList")
	public FrontendGridResult<${data.moduleName}BodyEntity> getList(HttpServletResponse response, ${data.moduleName}BodySearch searchEntity) {
		ArrayList<${data.moduleName}BodyEntity> list = ${data.moduleName|firstLowerCase}BodyService.selectBodyListBySearch(searchEntity); 
		int total = ${data.moduleName|firstLowerCase}BodyService.selectBodyListCountBySearch(searchEntity);
		FrontendGridResult<${data.moduleName}BodyEntity> result = new FrontendGridResult<${data.moduleName}BodyEntity>(total,list);
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
		${data.moduleName}BodyEntity body = ${data.moduleName|firstLowerCase}BobyService.selectById(oid);
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
		ActionResult result = ${data.moduleName|firstLowerCase}BodyService.deleteBatchIdsFor(Arrays.asList(oid.split(",")));
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
	public ResponseResult edit(HttpServletResponse response,${data.moduleName}BodyEntity body) {
		ResponseResult responseResult = new ResponseResult();
		ActionResult result = new ActionResult();
		if (StringUtils.isNotBlank(body.getOid())) {
			result = ${data.moduleName|firstLowerCase}BodyService.updateByIdFor(body);
		} else {
			body.setOid(PubUtil.generateUUID());
			result = ${data.moduleName|firstLowerCase}BodyService.insertFor(body);
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
	public void exportExcel(HttpServletResponse response, ${data.moduleName}BodySearch searchEntity) throws IOException {
		//获取导出数据
		ArrayList<${data.moduleName}BodyEntity> lst = ${data.moduleName|firstLowerCase}BodyService.selectBodyListForExport(searchEntity);
		//导出数据项
		LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
        {@each data.fields.rows as di, index}
                        {@if di.isTableShow == "Y"}
		fieldMap.put("${di.FIELDNAME|getDcm}", "${di.FIELDDESC}");
                        {@/if}
        {@/each}
		//Execl中sheet名称
		String sheetName = "XXX表";
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
