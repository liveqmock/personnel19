package org.jsoft.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.Encorchast;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.system.dao.IEncorchastDAO;

public class EncorchastDAO extends BaseDAO<Encorchast> implements IEncorchastDAO {

	@Override
	public List<Encorchast> query(PageDivid pageDivid) {
		// TODO Auto-generated method stub
		String hql = "from Encorchast where isDelete=?";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		List<Encorchast> encorchasts = find(hql, paraments, pageDivid);
		return encorchasts;
	}

	@Override
	public int Allcount() {
		// TODO Auto-generated method stub
		String hql = "select count(*)  From Encorchast where isDelete=?";
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
	public void add(Encorchast encorchast) {
		// TODO Auto-generated method stub
		save(encorchast);
	}

	@Override
	public void updateencorchast(Encorchast encorchast) {
		// TODO Auto-generated method stub
		update(encorchast);
		
	}

	@Override
	public void dele(Encorchast encorchast) {
		// TODO Auto-generated method stub
		delete(encorchast);
	}

	@Override
	public Encorchast getencorchast(String encorchastId) {
		// TODO Auto-generated method stub
		return get(Encorchast.class, encorchastId);
	}

}
