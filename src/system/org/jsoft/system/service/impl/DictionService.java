package org.jsoft.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.vo.DictionLog;
import org.jsoft.system.dao.impl.DictionDAO;
import org.jsoft.system.service.IDictionService;

public class DictionService implements IDictionService{

	
	
	public List<DictionLog> getAllFathers() {
		List<DictionLog> fathers=new ArrayList<DictionLog>();
		DictionDAO dd=new DictionDAO();
		fathers=dd.getAllFathers();
		return fathers;
	}
	public List<DictionLog> getAllSons() {
		DictionDAO dd=new DictionDAO();
		List<DictionLog> sons=new ArrayList<DictionLog>();
		sons=dd.getAllSons();
		return sons;
	}
	public void addAFather(DictionLog dl) {
		DictionDAO dd=new DictionDAO();
			dd.add(dl);
		
	}
	public void updateAFather(String sid,String name,String remark) {
		DictionDAO dd=new DictionDAO();
		DictionLog dl=new DictionLog();
		dl=dd.queryBySid(sid);
		dl.setName(name);
		dl.setDictionLogRemark(remark);
		dd.update(dl);
		
	}
	public void addsons(List<DictionLog> sons,String fatherName) {
		DictionDAO dd=new DictionDAO();
		DictionLog d=new DictionLog();
		d=dd.queryByName(fatherName);
		List<DictionLog> ss=new ArrayList<DictionLog>();
		for(DictionLog dl:sons){
			if("".equals(dl.getName())){
				
			}else{
				dl.setPid(d.getSid());
				ss.add(dl);
			}
		}
		dd.addSons(ss);
	}
	public void fatherDelete(String sid) {
		DictionDAO dd=new DictionDAO();
		dd.deleteBySid(sid);
	}
	public void delSon(String sid){
		DictionDAO dd=new DictionDAO();
		dd.deleteBySid(sid);
	}

	
	public void modSon(String sid,String name,String remark) {
		DictionDAO dd=new DictionDAO();
		DictionLog dl=new DictionLog();
		dl=dd.queryBySid(sid);
		dl.setName(name);
		dl.setDictionLogRemark(remark);
		dd.update(dl);
	}

	

	
	public DictionLog getOneItem(String sid) {
		DictionDAO dd=new DictionDAO();
		DictionLog dl=new DictionLog();
		dl=dd.queryBySid(sid);
		return dl;
	}
}










