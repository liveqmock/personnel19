package org.jsoft.management.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.management.dao.IMntAllDao;

public class MntAllDao extends BaseDAO<Personnelinfo> implements IMntAllDao{

	public List<Personnelinfo> query(String hql) {
		return this.find(hql);
	}

}
