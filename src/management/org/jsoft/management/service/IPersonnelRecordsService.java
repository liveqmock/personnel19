package org.jsoft.management.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelinfo;

public interface IPersonnelRecordsService {
//根据jsp的参数查找相关的表，获得相关的记录
	public List findRecords(String department,String startDate,String endDate,String searchTableName,HttpServletRequest req);
//查询所有的人事记录
	public List findAllPersonnelRecords(HttpServletRequest req,PageDivid pg);
//查询某人的具体记录
	 public List findPersonAllRecords(String personId,String searchTableName);
	  
}

