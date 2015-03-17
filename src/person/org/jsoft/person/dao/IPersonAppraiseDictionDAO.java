package org.jsoft.person.dao;

import org.jsoft.comm.vo.DictionLog;

public interface IPersonAppraiseDictionDAO {
	public DictionLog findAppraiseResult(String sid);
}
