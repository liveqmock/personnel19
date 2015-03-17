package org.jsoft.salary.dao.impl;

import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.salary.dao.ISetofBookDAO;

public class SetofBookDAO extends BaseDAO<DeptJobRel> implements ISetofBookDAO
{

	@Override
	public List<DeptJobRel> queryDeptJobWithoutSalary(PageDivid pageDivid)
	{

		String hql = "from DeptJobRel where salary is null";
		List<DeptJobRel> list = find(hql,pageDivid);
		return list;
	}

	
		
	}

