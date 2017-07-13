package com.dcjet.javaBackendDemo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dcjet.apollo.framework.web.common.ResponseResult;
import com.dcjet.javaBackendDemo.base.BackendBaseController;
import com.dcjet.javaBackendDemo.common.FrontendGridResult;
import com.dcjet.javaBackendDemo.entity.BodyEntity;
import com.dcjet.javaBackendDemo.entity.HeadEntity;
import com.dcjet.javaBackendDemo.search.BodySearch;
import com.dcjet.javaBackendDemo.search.DemoSearch;
import com.dcjet.javaBackendDemo.service.IDemoService;

@Controller
@RequestMapping("/Demo")
public class DemoController extends BackendBaseController {
	@Resource
	private IDemoService demoSerivce; 
	
	@ResponseBody
	@RequestMapping(value ="/index", method=RequestMethod.GET)
	public ResponseResult Index() {
		ResponseResult responseResult = new ResponseResult();
		responseResult.setSuccess(true);
		responseResult.addData("nihao");
		return responseResult;
	}
	
	@ResponseBody
	@RequestMapping("/getGridData")
	public FrontendGridResult<HeadEntity> getGridData(HttpServletResponse response, DemoSearch searchEntity) throws IOException {
		ArrayList<HeadEntity> lst = demoSerivce.selectHeadListBySearch(searchEntity);
		FrontendGridResult<HeadEntity> result = new FrontendGridResult<HeadEntity>(Integer.parseInt(searchEntity.getRows()),lst);
		return result;
	}
	
	/**
	 * 导出Excel
	 * @param response
	 */
	@RequestMapping("/export")
	public void exportExcel(HttpServletResponse response, DemoSearch searchEntity) throws IOException {
		String data = "中国sdfsf中国";
		OutputStream outputStream = response.getOutputStream();//获取OutputStream输出流
		response.setHeader("content-type", "text/html;charset=UTF-8");//通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码

		byte[] dataByteArr = data.getBytes("UTF-8");//将字符转换成字节数组，指定以UTF-8编码进行转换
		outputStream.write(dataByteArr);//使用OutputStream流向客户端输出字节数组
	}
	
	@ResponseBody
	@RequestMapping("/getBodyList")
	public FrontendGridResult<BodyEntity> getBodyList(HttpServletResponse response, 
		BodySearch searchEntity, String headOid)  {
		ArrayList<BodyEntity> list = demoSerivce.selectBodyListBySearch(searchEntity);
		FrontendGridResult<BodyEntity> result = new FrontendGridResult<BodyEntity>(Integer.parseInt(searchEntity.getRows()),list);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/getHead")
	public ResponseResult getHead(String oid) {
		HeadEntity head = demoSerivce.selectById(oid); 
		ResponseResult responseResult = new ResponseResult();
		responseResult.addData(head);
		return responseResult;
	}
	
	@ResponseBody
	@RequestMapping("/getBody")
	public ResponseResult getBody(String oid, String headOid) {
		BodyEntity body = demoSerivce.getBodyById(headOid, oid);
		ResponseResult responseResult = new ResponseResult();
		responseResult.addData(body);
		return responseResult;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public ResponseResult del(String oid) {
		ResponseResult responseResult = new ResponseResult();
		if(demoSerivce.deleteById(oid)) {
			responseResult.setSuccess();
		} else {
			responseResult.setError();
			responseResult.addData("test");
		}
		return responseResult;
	}
	
	@ResponseBody
	@RequestMapping("/delBody")
	public ResponseResult delBody(String oid, String headOid) {
		ResponseResult responseResult = new ResponseResult();
		if(demoSerivce.delBodyById(headOid, oid)) {
			responseResult.setSuccess();
		} else {
			responseResult.setError();
			responseResult.addData("test");
		}
		return responseResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit" , method = {RequestMethod.POST})
	public ResponseResult edit(HttpServletResponse response, HeadEntity head) {
		ResponseResult responseResult = new ResponseResult();
		demoSerivce.updateById(head);
		responseResult.setSuccess();
		responseResult.addData("保存成功");
		return responseResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/editBody" )
	public ResponseResult editBody(HttpServletResponse response, BodyEntity body) {
		ResponseResult responseResult = new ResponseResult();
		if(demoSerivce.editBodyById(body)) {
			responseResult.setSuccess();
			responseResult.addData("保存成功");
		} else {
			responseResult.setError();
			responseResult.addData("test");
		}
		return responseResult;
	}
}
