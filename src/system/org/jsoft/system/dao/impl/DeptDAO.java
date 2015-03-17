package org.jsoft.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.PageDivid;

import org.jsoft.system.dao.IDeptDAO;

public class DeptDAO extends BaseDAO<Department> implements IDeptDAO {

	@Override
	public List<Department> queryAll() {
		String hql = "from Department where isDelete=0";
		List<Department> departments = find(hql);
		return departments;
	}

	@Override
	public List<Department> query(PageDivid pageDivid) {
		String hql = "from Department where isDelete=?";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		List<Department> departments = find(hql, paraments, pageDivid);
		return departments;
	}

	@Override
	public int Allcount() {
		String hql = "select count(*)  From Department where isDelete=?";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		int a = Integer.parseInt(count(hql, paraments) + "");
		return a;
	}

	@Override
	public int Allcount(String hql, List<Object> paraments) {
		int a =   Integer.parseInt(count(hql, paraments)+"");
		return a;
	}

	@Override
	public void add(Department department) {
		save(department);

	}

	@Override
	public void dele(Department department) {
		delete(department);
	}

	@Override
	public void updateDepartment(Department department) {
		update(department);
		
	}

	@Override
	public Department getDept(String deptId) {
		return get(Department.class, deptId);
	}

	@Override
	public Department getDeptByName(String deptName) {
		// TODO Auto-generated method stub
		String hql = "from Department where isDelete=? and departmentName=?";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		paraments.add(deptName);
		return get(hql, paraments);
	}

}
