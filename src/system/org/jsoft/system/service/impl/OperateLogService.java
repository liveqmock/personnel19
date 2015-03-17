package org.jsoft.system.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.jsoft.comm.vo.Bak;
import org.jsoft.comm.vo.OperateLog;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.system.dao.IOperateLogDAO;
import org.jsoft.system.dao.impl.OperateLogDAO;
import org.jsoft.system.service.IOperateLogService;

public class OperateLogService implements IOperateLogService {
private IOperateLogDAO operateLogDAO = new OperateLogDAO();

@Override
public PageDivid getPageDivid(String page) {
	// TODO Auto-generated method stub
	PageDivid pageDivid = new PageDivid();
	int all = operateLogDAO.account();
	pageDivid.setNum(all);
	pageDivid.setAllPage((all-1)/pageDivid.getEachPageNum()+1);
	int currentpage = 1;
	System.err.println(page);
	if(page!=null&&page!=""&&!("null".equals(page))){
		System.err.println(page);
		currentpage=Integer.parseInt(page);
	}
	pageDivid.setCurrentPage(currentpage);
	return pageDivid;
}

@Override
public List<OperateLog> queryAll(PageDivid pageDivid) {
	// TODO Auto-generated method stub
	List<OperateLog> operateLogs = operateLogDAO.queryALL(pageDivid);
	
	return operateLogs;
}

@Override
public List<OperateLog> queryByElements(String operaterName, String upDAte,
		String DownDate, PageDivid pageDivid) {
	String last = " 00:00:00";
	Timestamp upDate=null;
	Timestamp downDate=null;
	if(operaterName==""){
		operaterName=null;
	}
	if(upDAte!=""&&upDAte!=null){
		upDAte=upDAte+last;
		 upDate =Timestamp.valueOf(upDAte);
	}
	if(DownDate!=""&&DownDate!=null){
		DownDate=DownDate+last;
		 downDate =Timestamp.valueOf(DownDate);
	}
	
	
	List<OperateLog> operateLogs =operateLogDAO.queryByElement(operaterName, upDate, downDate, pageDivid);
	
	return operateLogs;
}

@Override
public OperateLog getById(String operateLogId) {
	// TODO Auto-generated method stub
	return operateLogDAO.getById(operateLogId);
}

@Override
public void add(Operater operater, String info) {
	// TODO Auto-generated method stub
	operateLogDAO.add(operater, info);
}


}
