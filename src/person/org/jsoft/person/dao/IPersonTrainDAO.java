package org.jsoft.person.dao;


import java.util.List;

import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personneltrain;

public interface IPersonTrainDAO {
	public List<Personneltrain> findAll(PageDivid pageDivid);// 查找所有
	public Personneltrain findSingle(String personnelTrainId);// 查找一个
	public List<Personneltrain> findAllNoPage();
	public void add(Personneltrain pt);// 增加培训员工
	public void update(Personneltrain personneltrain);// 修改员工培训的相关信息
	public List<Personneltrain> findByDepartment(String departmentName,PageDivid pageDivid);
	public List<Personneltrain> findByDeptNoPage(String departmentName);
	public List<Personneltrain> findByJobNoPage(String jobName);
	public List<Personneltrain> findByJob(String jobName,PageDivid pageDivid);
	public void personTrainUpdate(Personneltrain personneltrain);
   
}
