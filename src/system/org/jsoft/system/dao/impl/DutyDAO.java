package org.jsoft.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.Duty;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.system.dao.IDutyDAO;

public class DutyDAO extends BaseDAO<Duty> implements IDutyDAO{

	@Override
	public List<Duty> query(PageDivid pageDivid) {
		// TODO Auto-generated method stub
		String hql = "from Duty where isDelete=?";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		List<Duty> dutys = find(hql, paraments, pageDivid);
		return dutys;
	}

	@Override
	public int Allcount() {
		// TODO Auto-generated method stub
		String hql = "select count(*)  From Duty where isDelete=?";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		int a = Integer.parseInt(count(hql, paraments) + "");
		return a;
	}

	@Override
	public int Allcount(String hql, List<Object> paraments) {
		// TODO Auto-generated method stub
		int a =   Integer.parseInt(count(hql, paraments)+"");
		return a;
	}

	@Override
	public void add(Duty duty) {
		// TODO Auto-generated method stub
		save(duty);
	}

	@Override
	public void updateDuty(Duty duty) {
		// TODO Auto-generated method stub
		update(duty);
	}

	@Override
	public void dele(Duty duty) {
		// TODO Auto-generated method stub
		delete(duty);
	}

	@Override
	public Duty getDuty(String dutyId) {
		// TODO Auto-generated method stub
		return get(Duty.class, dutyId);
	}

}
