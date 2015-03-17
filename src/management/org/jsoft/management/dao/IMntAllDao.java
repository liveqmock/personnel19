package org.jsoft.management.dao;

import java.util.List;

import org.jsoft.comm.vo.Personnelinfo;

public interface IMntAllDao {
	public abstract List<Personnelinfo> query(String hql);

}
