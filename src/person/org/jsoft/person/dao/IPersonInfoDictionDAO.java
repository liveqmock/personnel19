package org.jsoft.person.dao;

import java.util.List;

import org.jsoft.comm.vo.DictionLog;
import org.jsoft.comm.vo.Personnelinfo;

public interface IPersonInfoDictionDAO {
	public List<Personnelinfo> buildPersonByDiction(List<Personnelinfo> persons); 
	// 把查出来的东西修改为字典值的方法 

	public List<DictionLog> queryDictionInfos(String pId);    // 查询字典值

}
