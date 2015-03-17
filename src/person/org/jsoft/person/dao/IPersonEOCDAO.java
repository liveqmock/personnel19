package org.jsoft.person.dao;

import java.util.List;

import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DictionLog;
import org.jsoft.comm.vo.Duty;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Peoc;
import org.jsoft.comm.vo.Personnelinfo;

public interface IPersonEOCDAO {
	
	public List<Peoc> queryPeocsAll();   // 查询所有员工奖惩信息
	public List<Peoc> queryPeocsAll(PageDivid pg);   // 查询所有员工奖惩信息
	public Peoc queryPeocSingle(String peocId);    //  查询单独的员工奖惩信息
	
	public void updatePeoc(Peoc peoc);  // 修改员工奖惩信息
	
	public void insertPeoc(Peoc peoc); // 新增员工奖惩信息

	


}
