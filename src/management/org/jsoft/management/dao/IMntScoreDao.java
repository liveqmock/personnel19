package org.jsoft.management.dao;

import java.util.List;

import org.jsoft.comm.vo.Personnelinfo;

public interface IMntScoreDao {
	public abstract List<Personnelinfo> query(String hql);

}
