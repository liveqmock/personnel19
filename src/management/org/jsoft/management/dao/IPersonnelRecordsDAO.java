package org.jsoft.management.dao;

import java.util.List;

import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelinfo;

public interface IPersonnelRecordsDAO {
	//根据hql和PageDivid来查询
	public List findRecords(String hql,PageDivid pg);
   //查询某张表的所有记录所需要的hql语句
	public String findAllRecords(String searchTableName);
	//查询有起始时间的某表的记录所需要的hql语句
	public String findRecordsByStartDate(String searchTableName,String startDarte);
	//查询有最终时间的某表的记录所需要的hql语句
	public String findRecordsByEndDate(String searchTableName,String endDate);
	//查询某一段时间内的某表的记录所需要的hql语句
	public String findRecordsByStartDateAndEndDate(String searchTableName,String startDate,String endDate);
	//查询某表中某部门的所有记录所需要的hql语句
	public String findRecordsByDepartment(String searchTableName,String department);
   //查询某部门从起始时间开始的某项纪录所需要的hql语句
	public String findRecordsByDepartmentAndStartDate(String searchTableName,String department,String startDate);
   //查询某部门到最终时间为止的某项纪录所需要的hql语句
	public String findRecordsByDepartmentAndEndDate(String searchTableName,String department,String endDate);
   //查询某部门某段时间内的某项纪录所需要的hql语句
	public String findRecordsByDepartmentAndStartDateAndEndDate(String searchTableName,String department,String startDate,String endDate);
 //根据表明返回相应的date类型的字段名
	public String getDateNameByTableName(String searchTableName);
//根据总记录的条数来设置相关的page
	public void  setPage(PageDivid pg,int num);
	//根据具体的表名返回相应的有关部门的查询语句
	public String getDepartmentHql(String searchTableName,String department);
	/*//查询所有的记录
	public List findAllPersonnelRecords(PageDivid pg);*/
	//查询某个人的记录
	public List  findPersonAllRecordsById(String personId,String searchTableName);
	
}
