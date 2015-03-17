package org.jsoft.system.service.impl;

import java.util.List;

import org.jsoft.comm.vo.Bak;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.system.dao.IDeptDAO;
import org.jsoft.system.dao.impl.BakDAO;
import org.jsoft.system.dao.impl.DeptDAO;

import org.jsoft.system.service.IDeptService;

public class DeptSevice implements IDeptService{
private IDeptDAO deptDAO = new DeptDAO();

@Override
public List<Department> queryAll() {
	
	return deptDAO.queryAll();
}

@Override
public List<Department> queryNpage(String page) {
	PageDivid pageDivid = new PageDivid();
	pageDivid =getPageDivid(page);
	List<Department> departments =deptDAO.query(pageDivid);
	return departments;
}

@Override
public PageDivid getPageDivid(String page) {
		PageDivid pageDivid = new PageDivid();
		int all =  deptDAO.Allcount();
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
public void updateDept(String departmentId, String deptName) {
	Department department =deptDAO.getDept(departmentId);
	department.setDepartmentName(deptName);
	deptDAO.updateDepartment(department);
}

@Override
public void add(String deptName) {
	Department department = new Department();
	department.setDepartmentName(deptName);
	department.setIsDelete(0);
	deptDAO.add(department);
}

@Override
public void delLie(String departmentId) {
	Department department =deptDAO.getDept(departmentId);
	department.setIsDelete(1);
	deptDAO.updateDepartment(department);
}

@Override
public Department getdept(String deptId) {
	
	return deptDAO.getDept(deptId);
}

@Override
public void delLie(String[] checkbox) {
	for (int i = 0; i < checkbox.length; i++) {
		delLie(checkbox[i]);
	}
	
}
}
