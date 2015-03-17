package org.jsoft.person.dao.impl;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.DictionLog;
import org.jsoft.person.dao.IPersonAppraiseDictionDAO;

public class PersonAppraiseDictionDAO extends BaseDAO<DictionLog> implements IPersonAppraiseDictionDAO{
	private DictionLog dl=new DictionLog();
	public DictionLog findAppraiseResult(String sid){
		String hql="from DictionLog where sid='"+sid+"'";
		dl=this.get(hql);
		return dl;
	}
}
