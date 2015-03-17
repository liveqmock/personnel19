package org.jsoft.person.dao.impl;

import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelappraise;
import org.jsoft.person.dao.IPersonAppraiseDAO;

public class PersonAppraiseDAO extends BaseDAO<Personnelappraise> implements IPersonAppraiseDAO {
	private Personnelappraise pa1=new Personnelappraise();
	
	public List<Personnelappraise> findAllNoPage() {
		String hql = "from Personnelappraise where isDelete=0";
		System.out.println(hql);
		List<Personnelappraise> list = this.find(hql);
		return list;
	}
	public List<Personnelappraise> findAll(PageDivid pageDivid) {
		String hql = "from Personnelappraise pa order by pa.personnelAppraiseDate desc where isDelete=0";
		System.out.println("进入DAO的findAll了");
		System.out.println(hql);
		List<Personnelappraise> list = this.find(hql,pageDivid);
		return list;
	}
	
	public Personnelappraise findSingle(String personnelAppraiseId) {
		String hql = "from Personnelappraise where personnelAppraiseId='"+personnelAppraiseId+"'";
		System.out.println(hql);
		pa1=this.get(hql);
		return pa1;
	}
	
	public List<Personnelappraise> findByDepartment(String departmentName,PageDivid pageDivid){
		String hql="from Personnelappraise pa where isDelete=0 and pa.personnelinfo in (from Personnelinfo pi where isDelete=0 and pi.deptJobRel in (from DeptJobRel djr where isDelete=0 and djr.department in (from Department d where isDelete=0 and d.departmentName='"+departmentName+"'))) order by pa.personnelAppraiseDate desc";
		System.err.println(hql);
		List<Personnelappraise> list =this.find(hql, pageDivid);
		return list;
	}
	public List<Personnelappraise> findByDeptNoPage(String departmentName){
		String hql="from Personnelappraise pa where isDelete=0 and pa.personnelinfo in (from Personnelinfo pi where isDelete=0 and pi.deptJobRel in (from DeptJobRel djr where isDelete=0 and djr.department in (from Department d where isDelete=0 and d.departmentName='"+departmentName+"'))) order by pa.personnelAppraiseDate desc";
		System.err.println(hql);
		List<Personnelappraise> list =this.find(hql);
		return list;
	}
	public List<Personnelappraise> findByJobNoPage(String jobName){
		String hql="from Personnelappraise pa where isDelete=0 and pa.personnelinfo in (from Personnelinfo pi where isDelete=0 and pi.deptJobRel in (from DeptJobRel djr where isDelete=0 and djr.job in (from Job d where isDelete=0 and d.jobName='"+jobName+"'))) order by pa.personnelAppraiseDate desc";
		System.err.println(hql);
		List<Personnelappraise> list =this.find(hql);
		return list;
	}
	
	public List<Personnelappraise> findByJob(String jobName,PageDivid pageDivid){
		String hql="from Personnelappraise pa where isDelete=0 and pa.personnelinfo in (from Personnelinfo pi where isDelete=0 and pi.deptJobRel in (from DeptJobRel djr where isDelete=0 and djr.job in (from Job d where isDelete=0 and d.jobName='"+jobName+"'))) order by pa.personnelAppraiseDate desc";
		//查出来的如果是很多条记录的话，需要用in判断是否在后面子查询中
		System.err.println(hql);
		List<Personnelappraise> list =this.find(hql, pageDivid);
		return list;
	}


	public void add(Personnelappraise pa){
		this.save(pa);
		System.out.println("执行了DAO的add");
	}
	
	public void personAppraiseUpdate(Personnelappraise pa) {//这里起名不能叫update
		this.update(pa);
		System.out.println("执行了DAO里的update");

	}

	

}
