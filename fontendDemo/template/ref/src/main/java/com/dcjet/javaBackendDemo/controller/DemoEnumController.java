package com.dcjet.javaBackendDemo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcjet.apollo.framework.publicCode.model.SelectListItem;
import com.dcjet.javaBackendDemo.base.BackendBaseController;

@Controller
@RequestMapping("/Enum")
public class DemoEnumController extends BackendBaseController {
	@ResponseBody
	@RequestMapping("/getStates")
	public List<SelectListItem> getStates(HttpServletResponse response, String callback,String oid) throws IOException {
		List<SelectListItem> list = new ArrayList<SelectListItem>();
		SelectListItem item = new SelectListItem();
		item.setValue("0");
		item.setText("--请选择--");
		item.setSelected(true);
		list.add(item);
		item = new SelectListItem();
		item.setValue("1");
		item.setText("暂存");
		list.add(item);
		item = new SelectListItem();
		item.setValue("2");
		item.setText("待审核");
		item = new SelectListItem();
		item.setValue("3");
		item.setText("已审核");
		list.add(item);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/getRiskStates")
	public List<SelectListItem> getRiskStates(HttpServletResponse response, String callback,String oid) throws IOException {
		List<SelectListItem> list = new ArrayList<SelectListItem>();
		SelectListItem item = new SelectListItem();
		item.setValue("0");
		item.setText("--请选择--");
		item.setSelected(true);
		list.add(item);
		item = new SelectListItem();
		item.setValue("1");
		item.setText("待确认");
		list.add(item);
		item = new SelectListItem();
		item.setValue("2");
		item.setText("不同意");
		item = new SelectListItem();
		item.setValue("3");
		item.setText("已同意");
		list.add(item);
		return list;
	}
}
