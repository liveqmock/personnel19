package org.jsoft.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Peoc;
import org.jsoft.comm.vo.Personneladjustsalary;
import org.jsoft.comm.vo.Personnelappraise;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.comm.vo.Personnelremove;
import org.jsoft.management.dao.impl.PersonnelManagementDAO;
import org.jsoft.management.dao.impl.PersonnelRecordsDAO;
import org.jsoft.management.service.IPersonnelRecordsService;

public class PersonnelRecordsService implements IPersonnelRecordsService{

	@Override
	public List findRecords(String department, String startDate,
			String endDate, String searchTableName,HttpServletRequest req) {
		 PersonnelRecordsDAO prdao=new PersonnelRecordsDAO();
		   String flag="";
		   String hql="";
		   System.out.println("service +department"+department);
		   List result=new ArrayList();
			PageDivid pg=new PageDivid();
		   System.out.println(searchTableName+"searchTabelName");
		if("Personneladjustsalary".equals(searchTableName))
		{
			flag="Personneladjustsalary";
		}
		if("Personnelremove".equals(searchTableName))
		{
			flag="Personnelremove";
		}
		if("Personneltrain".equals(searchTableName))
		{
			flag="Personneltrain";
		}
		if("Personnelappraise".equals(searchTableName))
		{
			flag="Personnelappraise";
		}
		if("Peoc".equals(searchTableName))
		{
			flag="Peoc";
		}
		req.setAttribute("flag", flag);
		if("".equals(department))//无部门
		{
			if("".equals(endDate))//无最终时间
			{
				if("".equals(startDate))//无起始时间
				{
					hql=prdao.findAllRecords(searchTableName);
					result=prdao.findRecords(hql, pg);
				}
				else//有起始时间
				{
					hql=prdao.findRecordsByStartDate(searchTableName, startDate);
					result=prdao.findRecords(hql, pg);
				}
			}
			else//有最终时间
			{
				if("".equals(startDate))//无起始时间
				{
					hql=prdao.findRecordsByEndDate(searchTableName, endDate);
					result=prdao.findRecords(hql, pg);
				}
				else//有起始时间
				{
					hql=prdao.findRecordsByStartDateAndEndDate(searchTableName, startDate, endDate);
					result=prdao.findRecords(hql, pg);
				}
			}			
		}
		else//有部门
		{
			if("".equals(endDate))//无最终时间
			{
				if("".equals(startDate))//无起始时间
				{
					hql=prdao.findRecordsByDepartment(searchTableName, department);
					result=prdao.findRecords(hql, pg);
				}
				else//有起始时间
				{
					hql=prdao.findRecordsByDepartmentAndStartDate(searchTableName, department, startDate);
					result=prdao.findRecords(hql, pg);
				}
			}
			else//有最终时间
			{
				if("".equals(startDate))//无起始时间
				{
					hql=prdao.findRecordsByDepartmentAndEndDate(searchTableName, department, endDate);
					result=prdao.findRecords(hql, pg);
				}
				else//有起始时间
				{
					hql=prdao.findRecordsByDepartmentAndStartDateAndEndDate(searchTableName, department, startDate, endDate);
					result=prdao.findRecords(hql, pg);
				}
			}		
		}
		req.setAttribute("pg", pg);
        req.setAttribute("allHql", hql);
        System.out.println(result.size());
		return result;
	}
	public List findPerPage(String hql,PageDivid pd)
	  {
		  PersonnelRecordsDAO prdao=new PersonnelRecordsDAO();
	     return prdao.find(hql, pd);
	  }
	public List findAllPerson(PageDivid pg)
	{
		PersonnelRecordsDAO prdao=new PersonnelRecordsDAO();
		return prdao.findAllPerson(pg);
	}
	@Override
	public List findAllPersonnelRecords(HttpServletRequest req,PageDivid pg) {
		/*返回记录表的list*/
		PersonnelRecordsDAO prdao=new PersonnelRecordsDAO();
		List personList=findAllPerson(pg);
		List result=new ArrayList();
		for (int i = 0; i < personList.size(); i++) {
			String personId=((Personnelinfo) personList.get(i)).getPersonnelId();
			List<Personneladjustsalary> adjustSalary=prdao.findPersonAllRecordsById(personId, "Personneladjustsalary");
			List<Peoc> peoc=prdao.findPersonAllRecordsById(personId, "Peoc");
			List<Personnelappraise> train=prdao.findPersonAllRecordsById(personId, "Personneltrain");
		    List<Personnelremove> remove=prdao.findPersonAllRecordsById(personId, "Personnelremove");
		    List<Personnelappraise> aparise=prdao.findPersonAllRecordsById(personId, "Personnelappraise");
		    System.out.println("adjustsalary"+adjustSalary.size());
		    System.out.println("peoc"+peoc.size());
		    System.out.println("train"+train.size());
		    System.out.println("remove"+remove.size());
		    System.out.println("aparise"+aparise.size());
		    List  eachPerson=new ArrayList();
		    eachPerson.add(remove.size());
		    eachPerson.add(adjustSalary.size());
		    eachPerson.add(train.size());
		    eachPerson.add(aparise.size());		  
		    eachPerson.add(peoc.size());
		   
		   result.add(i,eachPerson);
		}
		//这里的分页就是限制从数据库中去的个数
		/*PageDivid pg=new PageDivid();	
		result=prdao.findAllPersonnelRecords(pg);
		req.setAttribute("pg", pg);*/
        //req.setAttribute("allHql", "from Personnelinfo where isDelete =0 and personnelremoves in ( from Personnelremove where isDelete= 0 ) and personnelappraises in (from Personnelappraise where isDelete =0 ) and personneltrains in (from Personneltrain where isDelete =0 ) and peocs in (from Peoc where isDelete =0 )");
        System.out.println(result.size());
		return result;
	}
   public List findPersonAllRecords(String personId,String searchTableName)
   {
	   List p=new ArrayList();
	   PersonnelRecordsDAO prdao=new PersonnelRecordsDAO();
	   p=(List) prdao.findPersonAllRecordsById(personId,searchTableName);
	   return p;
   }
  public List findAdjustSalaryPerson(List result)
  {
	  List temp=new ArrayList();
	  PersonnelRecordsDAO prdao=new PersonnelRecordsDAO();
	  for (int i = 0; i < result.size(); i++) {
		  Personneladjustsalary pas=(Personneladjustsalary) result.get(i);
		  Personnelinfo p=prdao.getPersoninfoByAdjustSalaryRecord(pas);
		  if(p!=null)
		temp.add(i, p);
	}
	  return temp;
  }
 
}
