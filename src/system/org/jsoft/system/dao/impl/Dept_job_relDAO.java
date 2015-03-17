package org.jsoft.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;

import org.jsoft.comm.vo.PageDivid;
import org.jsoft.system.dao.IDept_job_relDAO;

public class Dept_job_relDAO extends BaseDAO<DeptJobRel> implements IDept_job_relDAO {

	@Override
	public List<DeptJobRel> query(PageDivid pageDivid) {
		String hql = "from DeptJobRel where isDelete=?";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		List<DeptJobRel> deptJobRels = find(hql, paraments, pageDivid);
		return deptJobRels;
	}

	@Override
	public int Allcount() {
		// TODO Auto-generated method stub
		String hql = "select count(*)  From DeptJobRel where isDelete=?";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		int a = Integer.parseInt(count(hql, paraments) + "");
		return a;
	}

	@Override
	public int Allcount(String hql, List<Object> paraments) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				int a =   Integer.parseInt(count(hql, paraments)+"");
				return a;
	}

	@Override
	public void add(DeptJobRel deptJobRel) {
		// TODO Auto-generated method stub
		save(deptJobRel);
	}

	@Override
	public void updateDeptJobRel(DeptJobRel deptJobRel) {
		// TODO Auto-generated method stub
		update(deptJobRel);
	}

	@Override
	public void dele(DeptJobRel deptJobRel) {
		// TODO Auto-generated method stub
		delete(deptJobRel);
	}

	@Override
	public DeptJobRel getDeptJobRel(String deptJobRelId) {
		// TODO Auto-generated method stub
		return get(DeptJobRel.class, deptJobRelId);
	}

	@Override
	public List<DeptJobRel> queryBydeptName(PageDivid pageDivid,Department department) {
		// TODO Auto-generated method stub
		String hql = "from DeptJobRel where isDelete=? and department=?";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		paraments.add(department);
		List<DeptJobRel> deptJobRels = find(hql, paraments, pageDivid);
		pageDivid.setNum(deptJobRels.size());
		pageDivid.setAllPage((deptJobRels.size()-1)/10+1);
		return deptJobRels;
	}

}
