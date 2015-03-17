package org.jsoft.system.dao.impl;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.DictionLog;
import org.jsoft.system.dao.IDictionDAO;

public class DictionDAO extends BaseDAO<DictionLog> implements IDictionDAO<DictionLog>{
	
	public List<DictionLog> getAllFathers() {
		List<DictionLog> fathers=new ArrayList<DictionLog>();
		String hql="from DictionLog where pid=null and isDelete=0";
		fathers=find(hql);
		return fathers;
	}
	public List<DictionLog> getAllSons() {
		List<DictionLog> sons=new ArrayList<DictionLog>();
		String hql="from DictionLog where pid!=null and isDelete=0";
		sons=find(hql);
		return sons;
	}
	public DictionLog queryBySid(String sid) {
	       
        DictionLog dl=new DictionLog();
        String hql="From DictionLog where sid='"+sid+"'";//hql只认识类名不认识表名，
        dl=get(hql);
		return dl;
	}

	
	public List<DictionLog> querySonsById(String sid) {
		List<DictionLog> dictionLogs=new ArrayList<DictionLog>();
		String hql="From DictionLog where pid='"+sid+"'";
		dictionLogs=find(hql);
		return dictionLogs;
	}

	
	public DictionLog queryByName(String name) {
		DictionLog dl=new DictionLog();
        String hql="From DictionLog where name='"+name+"'";
        dl=get(hql);
		return dl;
	}

	
	public List<DictionLog> querySonsByName(String name) {
		DictionLog dl=new DictionLog();
		List<DictionLog> dictionLogs=new ArrayList<DictionLog>();
		String hql1="From DictionLog where name='"+name+"'";
		dl=get(hql1);
		String hql2="From DictionLog where pid="+dl.getSid();
		dictionLogs=find(hql2);
		return dictionLogs;
		
	}
	public void add(DictionLog dictionlog) {
		
		Timestamp ts = new Timestamp(new Date().getTime());
		dictionlog.setDictionLogDate(ts);
		dictionlog.setIsDelete(0);
		save(dictionlog);
		
	}
	
	public void addSons(List<DictionLog> sons) {
		for(DictionLog dl:sons){
			add(dl);
		}
		
	}

	
	public void deleteSonsById(String sid){
		List<DictionLog> sons=new ArrayList<DictionLog>();
		String hql="From DictionLog where pid='"+sid+"'";
		sons=find(hql);
		for (DictionLog son : sons) {
		 son.setIsDelete(1);
		 saveOrUpdate(son);
		}
	}
	
	public void deleteBySid(String sid) {
		DictionLog dl=new DictionLog();
		String hql="From DictionLog where sid='"+sid+"'";
		dl=get(hql);
		if(dl.getPid()==null){
			deleteSonsById(dl.getSid());
		}
		dl.setIsDelete(1);
		saveOrUpdate(dl);
		
	}

	public void deleteByName(String name) {
		DictionLog dl=new DictionLog();
		String hql1="From DictionLog where name='"+name+"'";
		dl=get(hql1);
		//String hql2="From DictionLog where sid='"+name+"'";
		if(dl.getPid()==null){
			deleteSonsById(dl.getSid());
		}
		dl.setIsDelete(1);
		saveOrUpdate(dl);
		
	}

	
	public void deleteByObject(DictionLog dictionlog) {
		
		if(dictionlog.getPid()==null){
			deleteSonsById(dictionlog.getSid());
		}
		dictionlog.setIsDelete(1);
		saveOrUpdate(dictionlog);
		
	}
	public void update(DictionLog dictionlog){
		Timestamp ts = new Timestamp(new Date().getTime());
		dictionlog.setDictionLogDate(ts);
		saveOrUpdate(dictionlog);
	}

	

	
	
	
  /*  public static void main(String[] args) {
   	String sid="03fcb447-a04e-1032-8177-4f052bc86abb";
//    	DictionLog dl1=new DictionLog();
//    	DictionLog dl2=new DictionLog();
//    	dl1.setName("dl1");
//    	dl2.setName("dl2");
//    	List<DictionLog> dictionLogs=new ArrayList<DictionLog>();
//    	dictionLogs.add(dl1);
//    	dictionLogs.add(dl2);
	//	DictionLog dl=new DictionLog();
//		dl.setDictionLogRemark("jjdj");
//		dl.setName("mm");
//		dl.setPid("100000");
//		dl.setSid("01011010013");
	//DictionDAO dao=new DictionDAO();
	//dao.deleteBySid("1001");
	//	dictionLogs=dao.getAllFathers();
		//System.out.println(dictionLogs.size());
	//	dl=dao.queryBySid("01011010013");
	//	dl.setDictionLogRemark("haahah");
	//	System.out.println("333333");
	//	dl=dao.queryByName("mm");
	//	System.out.println("4444");
	//	dictionLogs=dao.querySonsByName("政治面貌");
		//dao.update(dl);
		//	System.out.println(dictionLogs.size());
		//	System.out.println("2222");
	//	System.out.println(dictionLogs.size());
	}*/
}
