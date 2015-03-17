package org.jsoft.salary.dao;

import java.sql.Timestamp;
import java.util.List;

import org.jsoft.comm.vo.Peoc;

public interface IPEOCDAO {
	public void updatePEOC(Peoc peoc);
	//查询个人 某月的 奖罚情况
	public List<Peoc> queryPeocByDate(String workid,Timestamp end,Timestamp start);
}
