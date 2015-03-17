package org.jsoft.salary.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Peoc;
import org.jsoft.salary.dao.IPEOCDAO;

public class PEOCDAO extends BaseDAO<Peoc> implements IPEOCDAO {
	public void updatePEOC(Peoc peoc) {
		saveOrUpdate(peoc);
	}

	public List<Peoc> queryPeocByDate(String workid, Timestamp end,
			Timestamp start) {
		String hql = "from Peoc where personnelinfo.workId ="
				+ workid + " and peocDate > '" + start
				+ "' and peocDate < '" + end + "'";
		List<Peoc> list = find(hql);
		return list;
	}
}
