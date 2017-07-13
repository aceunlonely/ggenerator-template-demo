package com.dcjet.javaBackendDemo.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcjet.javaBackendDemo.base.BackendService;
import com.dcjet.javaBackendDemo.dao.ZtythHbHeadMapper;
import com.dcjet.javaBackendDemo.entity.BodyEntity;
import com.dcjet.javaBackendDemo.entity.HeadEntity;
import com.dcjet.javaBackendDemo.search.BodySearch;
import com.dcjet.javaBackendDemo.search.DemoSearch;
import com.dcjet.javaBackendDemo.service.IDemoService;

@Service("demoSerivce")
public class DemoService extends BackendService<HeadEntity> implements IDemoService {
	@Autowired
	ZtythHbHeadMapper ztythHbHeadMapper;
	
	private static ArrayList<HeadEntity> _list = new ArrayList<HeadEntity>();
	
	private static int oidIndex = 75;
	
	private static HashMap<String,ArrayList<BodyEntity>> _bodyMap = new HashMap<String, ArrayList<BodyEntity>>();
	
	public DemoService(){
		//初始化表头表体数据
		if(_list.size() == 0) {
			for(int i=0;i < 75; i++) {
				HeadEntity he = this.getById(i + "");
				_list.add(this.getById(i+""));
				ArrayList<BodyEntity> blist = new ArrayList<BodyEntity>();
				for(int j =0;j<5;j++)
				{
					blist.add(getBody(i+"_" + j, i+""));
				}
				_bodyMap.put(i+"", blist);
			}
		}
	}
	
	public ArrayList<HeadEntity> selectHeadListBySearch(DemoSearch search) {
		return this.getEntities(search);
	}
		
	public ArrayList<BodyEntity> selectBodyListBySearch(BodySearch search) {
		int pageIndex = Integer.parseInt(search.getPage()) -1;
		int pageSize =Integer.parseInt(search.getRows());
		
		ArrayList<BodyEntity> blist = _bodyMap.get(search.getHeadOid());
		
		//筛选过程
		ArrayList<BodyEntity> list = new ArrayList<BodyEntity>();
		
		for(int i=pageIndex*pageSize ;i<pageIndex*pageSize + pageSize;i++) {
			if( i>=0 && i<blist.size()) {
				list.add(blist.get(i));
			}
		}
		
		search.setRows(blist.size() + "");
		return list;
	}
	
	/**
	 * 临时
	 * @return
	 */
	private ArrayList<HeadEntity> getEntities(DemoSearch search){
		int pageIndex = Integer.parseInt(search.getPage()) -1;
		int pageSize =Integer.parseInt(search.getRows());
		
		ArrayList<HeadEntity> list = new ArrayList<HeadEntity>();
		for(int i=pageIndex*pageSize ;i<pageIndex*pageSize + pageSize;i++) {
			if( i>=0 && i<_list.size())
			{
				list.add(_list.get(i));
			}
		}
		
		search.setRows( _list.size() + "");
		return list;
	}
	
	@Override
	public boolean deleteById(Serializable id) {
		HashSet<String> hs = new HashSet<String>(Arrays.asList(id.toString().split(",")));	
		for(int i=0;i<_list.size();i++) {
			if(hs.contains(_list.get(i).getOid())) {
				_list.remove(i);
			}
		}
		return true;
	}
	
	public boolean delBodyById(String headOid, String oid) {
		ArrayList<BodyEntity> blist = _bodyMap.get(headOid);
		
		for (int i = 0; i < blist.size(); i++) {
			if(blist.get(i).getOid().equals(oid)) {
				blist.remove(i);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public HeadEntity selectById(Serializable id) {
		for(int i = 0; i < _list.size(); i ++) {
			if(_list.get(i).getOid().equals(id.toString())) {
				return _list.get(i);
			}
		}
		return this.getById(id.toString());
	}
	
	public BodyEntity getBodyById(String headOid, String oid) {
		ArrayList<BodyEntity> blist = _bodyMap.get(headOid);
		if(blist == null) return null;
		for (int i = 0; i < blist.size(); i++) {
			if(blist.get(i).getOid().equals(oid)) {
				return blist.get(i);
			}
		}
		return new BodyEntity();
	}
	
	@Override
	public boolean updateById(HeadEntity entity) {
		String oid = entity.getOid();
		if(oid == null || oid.equals("")) {
			entity.setOid("" + oidIndex++);
			_list.add(0, entity);
			
			_bodyMap.put(entity.getOid(),  new ArrayList<BodyEntity>());
			return true;
		} else {
			for(int i=0;i<_list.size();i ++) {
				if(_list.get(i).getOid().equals(entity.getOid())) {
					_list.set(i, entity);
					return true;
				}
			}
			return true;
		}
	}
	
	public boolean editBodyById(BodyEntity entity) {
		if(entity.getHeadOid() == null 
				|| entity.getHeadOid().equals("") 
				|| _bodyMap.containsKey(entity.getHeadOid()) == false) {
			return false;
		}
		ArrayList<BodyEntity> blist = _bodyMap.get(entity.getHeadOid());
		
		String oid = entity.getOid();
		if(oid == null || oid.equals("")) {
			entity.setOid("" + oidIndex++);
			blist.add(0,entity);
		} else {
			for(int i=0;i<blist.size();i ++) {
				if(blist.get(i).getOid().equals(oid)) {
					blist.set(i, entity);
					return true;
				}
			}
		}
		return true;
	}
	
	private HeadEntity getById(String id){
		int i = Integer.parseInt(id);
		HeadEntity entity = new HeadEntity();
		entity.setAccountBank("bank" + id);
		entity.setAgreeNo("no" + id);
		entity.setOid(i + "");
		entity.setSerialNo("12345" + (i + 1));
		entity.setInsertTime(new Date(2015, 11, 3));
		entity.setExpiryDate(new Date(2017, 11, 1));
		entity.setSendTime(new Date(2016, 4, 4));
		entity.setEndTime(new Date(2017, 1, 30));
		entity.setCompNo("9999999999");
		entity.setCopEmsNo("99999988" + id);
		entity.setHbNo("C23270903020");
		entity.setHbBaseNo("HS2326400888");
		entity.setMasterCustoms("2303");
		entity.setTradeCode("9999999999");
		entity.setTradeName("苏州友隆电子科技有限公司");
		entity.setTradeAeotype("1");
		entity.setOwnerCode("9999999999");
		entity.setOwnerName("神州数码捷通科技有限公司");
		entity.setOwnerAeotype("2");
		entity.setContactPerson("捷通科技" + id);
		entity.setPhone("15262430153");
		entity.setPlantConditio("1,2");
		entity.setModifyMark("1");
		entity.setIsFirst("1");
		entity.setTradeAddress("捷通科技有限公司");
		entity.setOwnerAddress("捷通科技有限公司");
		entity.setMasterFtc("1100");
		entity.setAccountBank("1");
		entity.setManageObject("0");
		entity.setReceiveArea("11019");
		entity.setOperator("许" + id + "刚");
		entity.setContactPhone("911");
		entity.setForeignCoName("天价公司");
		entity.setUseHbCount(new BigDecimal(0));
		entity.setHbType("1");
		entity.setTradeMode("3");
		entity.setCutMode("101");
		entity.setTradeCountry("102");
		entity.setProduceType("01");
		entity.setInRatio(new BigDecimal(id));
		entity.setEmsApprNo("1234" + id);
		entity.setApproveOrg("国务院");
		entity.setAgreeNo(id);
		entity.setContrIn("210" + id);
		entity.setApprImgAmt(new BigDecimal("20000000"));
		entity.setImCurr("110");
		entity.setContrOut("100" + id);
		entity.setApprExgAmt(new BigDecimal("33000000"));
		entity.setExCurr("111");
		entity.setNote("自动生成" + id);
		entity.setState("1");
		entity.setRiskState("3");
		return entity;
	}
	
	private BodyEntity getBody(String oid,String headOid){
		BodyEntity entity = new BodyEntity();
		entity.setOid(oid);
		entity.setHeadOid(headOid);
		entity.setgNo(new BigDecimal("1"));
		entity.setUseType(new BigDecimal("1"));
		entity.setCodeT("8471701000");
		entity.setgName("固态硬盘(SSD)");
		entity.setgModel("型号" + oid);
		entity.setUnit("007");
		entity.setUnit1("001");
		entity.setQty(new BigDecimal(headOid));
		entity.setDecPrice("100");
		entity.setApprAmt(new BigDecimal("3000" + headOid));
		entity.setCurr("110");
		entity.setCountryCode("102");
		entity.setDutyMode("2");
		entity.setModifyMark("1");
		entity.setApplyState("2");
		entity.setNote("自动生成" + headOid + oid);
		return entity;
	}
}
