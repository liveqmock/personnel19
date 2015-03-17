package org.jsoft.management.dao;

import java.util.List;
import java.util.Map;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelinfo;

public interface IPersonnelManagementDAO  {
     //根据参数查询员工相关的人事信息
	public List  findALL(String form,Map Params,PageDivid pg);
	//根据各种参数map得到查询的hql语句
	 public  String getAllHql(String form,Map Params);
	 //查询某个人的具体信息
	 public Personnelinfo findPersonAllInfo(String  personId);
	 //查询所有的数据
	 public List findAllInfo(PageDivid pg);
}
