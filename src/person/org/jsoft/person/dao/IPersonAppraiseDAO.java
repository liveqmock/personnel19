package org.jsoft.person.dao;

import java.util.List;

import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelappraise;

public interface IPersonAppraiseDAO {
	public List<Personnelappraise> findAllNoPage();
	public List<Personnelappraise> findAll(PageDivid pageDivid);
	public Personnelappraise findSingle(String personnelAppraiseId);
	public void add(Personnelappraise pa);
	public void update(Personnelappraise pa);
	public List<Personnelappraise> findByDepartment(String departmentName,PageDivid pageDivid);
	public List<Personnelappraise> findByDeptNoPage(String departmentName);
	public List<Personnelappraise> findByJobNoPage(String jobName);
	public List<Personnelappraise> findByJob(String jobName,PageDivid pageDivid);
	public void personAppraiseUpdate(Personnelappraise pa);
	
}
