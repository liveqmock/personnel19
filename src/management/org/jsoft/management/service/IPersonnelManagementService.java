package org.jsoft.management.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelinfo;

public interface IPersonnelManagementService {
	
 /**得到值并判断查询的条件有哪些，如 性别，工资，职务，姓名，部门然后将他们放在一个map里面
  * 
  * */
	//查询所有的数据
public List  findAllByParaments(Map Params,HttpServletRequest req);
//根据personnelId查询某个人的信息
public Personnelinfo findPersonAllInfo(String personId);


}
