package org.jsoft.management.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personneladjustsalary;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.management.dao.IPersonnelRecordsDAO;

public class PersonnelRecordsDAO extends BaseDAO implements  IPersonnelRecordsDAO{

	@Override
	public String findAllRecords(String searchTableName) {	  
	  return "from "+searchTableName +" where isDelete = 0 ";	
	}

	@Override
	public String findRecordsByStartDate(String searchTableName,
			String startDate) {
		System.out.println("from "+searchTableName+" where "+getDateNameByTableName(searchTableName)+"> '"+startDate+"'");
      return "from "+searchTableName+" where "+getDateNameByTableName(searchTableName)+"> '"+startDate+"' and isDelete = 0";
		
	}
	
	@Override
	public String getDateNameByTableName(String searchTableName) {
		String dateName="";
		if("Personneladjustsalary".equals(searchTableName))
		{
			dateName="adjustSalaryDate";
		}
		if("Personnelremove".equals(searchTableName))
		{
			dateName="removeDate";
		}
		if("Personneltrain".equals(searchTableName))
		{
			dateName="personnelTrainDate";
		}
		if("Personnelappraise".equals(searchTableName))
		{
			dateName="personnelAppraiseDate";
		}
		if("Peoc".equals(searchTableName))
		{
			dateName="peocDate";
		}
		return dateName;
	}

	@Override
	public void setPage(PageDivid pg, int num) {
		 pg.setNum(num);
	      if((num%pg.getEachPageNum())!=0)
	      	pg.setAllPage((num/pg.getEachPageNum())+1);
	      else
	      	pg.setAllPage(num/pg.getEachPageNum());

	}

	@Override
	public List findRecords(String hql, PageDivid pg) {
		List result=new ArrayList();
		int num=find(hql).size();
		setPage(pg, num);
		System.out.println("pages"+pg.getAllPage());
		return find(hql, pg);
	}

	@Override
	public String findRecordsByEndDate(String searchTableName, String endDate) {
		System.out.println("from "+searchTableName+"where "+getDateNameByTableName(searchTableName)+" < '"+endDate+"' and isDelete =0 ");
		return "from "+searchTableName+" where "+getDateNameByTableName(searchTableName)+" < '"+endDate+"' and isDelete =0 ";
	}
	@Override
	public String findRecordsByStartDateAndEndDate(String searchTableName,
			String startDate, String endDate) {
		System.out.println("from "+searchTableName+" where "+getDateNameByTableName(searchTableName)+" >'"+startDate+"' and "+getDateNameByTableName(searchTableName)+" < '"+endDate+"' and isDelete = 0 ");
		return "from "+searchTableName+" where "+getDateNameByTableName(searchTableName)+" >'"+startDate+"' and "+getDateNameByTableName(searchTableName)+" < '"+endDate+"' and isDelete = 0 ";
	}

	@Override
	public String findRecordsByDepartment(String searchTableName,
			String department) {
	String hql="from "+searchTableName+" where   isDelete = 0 and "+getDepartmentHql(searchTableName, department);
	System.out.println("department"+hql);
		return hql;
	}

	@Override
	public String findRecordsByDepartmentAndStartDate(String searchTableName,
			String department, String startDate) {
	String hql="from "+searchTableName+" where "+getDepartmentHql(searchTableName, department)+" and "+getDateNameByTableName(searchTableName)+" >'"+startDate+"' and isDelete = 0 ";
	System.out.println(hql);
		return hql;
	}

	@Override
	public String findRecordsByDepartmentAndEndDate(String searchTableName,
			String department, String endDate) {
	String hql="from "+searchTableName+" where "+getDepartmentHql(searchTableName, department)+" and "+getDateNameByTableName(searchTableName)+" <'"+endDate+"' and isDelete = 0 ";
	System.out.println(hql);
		return hql;
	}

	@Override
	public String findRecordsByDepartmentAndStartDateAndEndDate(
			String searchTableName, String department, String startDate,
			String endDate) {
		
		String hql="from "+searchTableName+" where "+getDepartmentHql(searchTableName, department)+" and "+getDateNameByTableName(searchTableName)+" >'"+startDate+"' and "+getDateNameByTableName(searchTableName)+" <'"+endDate+"' and isDelete= 0 ";
		System.out.println(hql);
			return hql;
	}

	@Override
	public String getDepartmentHql(String searchTableName,String department) {
	
	if("Personneladjustsalary".equals(searchTableName))
	{
		return "deptJobRel in  (from DeptJobRel where isDelete = 0 and  department in ( from Department where departmentName = '"+department+"' and isDelete = 0 ))";
	}
	else

		return "personnelinfo in  (from Personnelinfo where deptJobRel in ( from DeptJobRel where isDelete = 0 and department in ( from Department where departmentName = '"+department+"' and isDelete = 0 )))";
	}
/*	@Override
	public List findAllPersonnelRecords(PageDivid pg) {
		String hql="from ";
		System.out.println(hql);
		int num=find(hql).size();
		setPage(pg, num);
		System.out.println("pages"+pg.getAllPage());
		return find(hql, pg);		
	}*/

	@Override
	public List findPersonAllRecordsById(String personId,
			String searchTableName) {
		List result=new ArrayList();
		String hql="";
		System.out.println(searchTableName);
		if(!"Personneladjustsalary".equals(searchTableName))
		{
			hql="from "+searchTableName+" where isDelete = 0 and personnelinfo in (from Personnelinfo where personnelId ='"+personId+"' and isDelete = 0 ) order by "+getDateNameByTableName(searchTableName)+" desc";
		}
		else
		{
			hql="from "+searchTableName+" where isDelete = 0  and deptJobRel in ( select deptJobRel from Personnelinfo where isDelete = 0 and personnelId ='"+personId+"') order by "+getDateNameByTableName(searchTableName)+" desc";
		}
		System.out.println(hql);
		result=find(hql);
		return result;
	}
	public List findAllPerson(PageDivid pg)
	{
		String hql="from Personnelinfo where isDelete = 0 order by personnelId ";
		int num=find(hql).size();
        pg.setNum(num);
        if((num%pg.getEachPageNum())!=0)
        	pg.setAllPage((num/pg.getEachPageNum())+1);
        else
        	pg.setAllPage(num/pg.getEachPageNum());
		return find("from Personnelinfo where isDelete = 0 order by personnelId ",pg);
	}
	public Personnelinfo getPersoninfoByAdjustSalaryRecord(Personneladjustsalary pas)
	{
		Personnelinfo p=new Personnelinfo();
		String hql="from Personnelinfo where isDelete = 0 and deptJobRel in ( from DeptJobRel where deptJobRelId = '"+pas.getDeptJobRel().getDeptJobRelId()+"' )";
		System.out.println("person geshu"+find(hql).size());
		if(find(hql).size()!=0)
		p=(Personnelinfo) find(hql).get(0);
		return p;
	}

}
