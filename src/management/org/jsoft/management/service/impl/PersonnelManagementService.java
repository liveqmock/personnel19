package org.jsoft.management.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.management.dao.impl.PersonnelManagementDAO;
import org.jsoft.management.service.IPersonnelManagementService;
import org.jsoft.management.util.PersonnelCommMethod;




public class PersonnelManagementService implements  IPersonnelManagementService{

	@Override
	public List findAllByParaments(Map Params,HttpServletRequest req)  {
		/**
		 * 得到页面传过来的参数
		 * 处理参数
		 * 将非空的参数与名称放入map中
		 * 
		 * */

		PersonnelManagementDAO pmdao=new PersonnelManagementDAO();
		PageDivid pg=new PageDivid();
		List temp=new ArrayList();
		Iterator i = Params.entrySet().iterator();	
    	String isAll="not";
    	String isSalaryLow="notLow";
    	String isSalaryUp="notUp";
		while(i.hasNext())
		{
			Entry  entry=(Entry)i.next();
		    Object key=entry.getKey();
		    Object value=entry.getValue();
           if("all".equals(key))
        	   isAll="is";
           if("salaryLow".equals(key))
        	   isSalaryLow="isLow";
           if("salaryUp".equals(key))
        	   isSalaryUp="isUp";
		}
		System.out.println("isAll"+isAll);
		if("is".equals(isAll))//查询所有
		{
			temp=pmdao.findALL("isAll",Params,pg);
		}
		else{
		
		if("isLow".equals(isSalaryLow)&&"notUp".equals(isSalaryUp))//工资只有low值
		{
			temp=pmdao.findALL("hasLow",Params,pg);
		}
		if("isLow".equals(isSalaryLow)&&"isUp".equals(isSalaryUp))//工资有low和up值
		{
			temp=pmdao.findALL("LowAndUp",Params,pg);
		}
		if("notLow".equals(isSalaryLow)&&"isUp".equals(isSalaryUp))//工资只有up值
		{
			temp=pmdao.findALL("hasUp",Params,pg);
		}
		if("notLow".equals(isSalaryLow)&&"notUp".equals(isSalaryUp))//无工资查询
		{
			temp=pmdao.findALL("notSalary",Params,pg);
		}
		}
		req.setAttribute("pg", pg);
         req.setAttribute("allHql", pmdao.getHql());
		return temp;
	}
    public List findPerPage(String hql,PageDivid pd)
    {
    	PersonnelManagementDAO pmdao=new PersonnelManagementDAO();
    	List temp=pmdao.find(hql, pd);
    	return temp;
    }
	public Personnelinfo findPersonAllInfo(String personId)
	{
		PersonnelManagementDAO pmdao=new PersonnelManagementDAO();
		return pmdao.findPersonAllInfo(personId);
	}

	
	

}
