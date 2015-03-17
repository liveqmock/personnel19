package org.jsoft.person.dao.impl;

import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personneltrain;
import org.jsoft.person.dao.IPersonTrainDAO;

public class PersonTrainDAO extends BaseDAO<Personneltrain> implements
		IPersonTrainDAO {
	private Personneltrain pt1=new Personneltrain();
	
	public List<Personneltrain> findAll(PageDivid pageDivid) {
		String hql = "from Personneltrain pt where isDelete=0 order by pt.personnelTrainDate desc";
		System.out.println("进入DAO的findAll了");
		System.out.println(hql);
		List<Personneltrain> list = this.find(hql,pageDivid);
		return list;
	}
	public Personneltrain findSingle(String personnelTrainId) {
		String hql = "from Personneltrain where personnelTrainId='"+personnelTrainId+"'";
		System.out.println(hql);
		pt1=this.get(hql);
		return pt1;
	}

	public List<Personneltrain> findAllNoPage() {
		String hql = "from Personneltrain where isDelete=0";
		System.out.println(hql);
		List<Personneltrain> list = this.find(hql);
		return list;
	}

	public List<Personneltrain> findByDepartment(String departmentName,PageDivid pageDivid){
		String hql="from Personneltrain pt where isDelete=0 and pt.personnelinfo in (from Personnelinfo pi where isDelete=0 and pi.deptJobRel in (from DeptJobRel djr where isDelete=0 and djr.department in (from Department d where isDelete=0 and d.departmentName='"+departmentName+"'))) order by pt.personnelTrainDate desc";
		System.err.println(hql);
		List<Personneltrain> list =this.find(hql, pageDivid);
		return list;
	}
	public List<Personneltrain> findByDeptNoPage(String departmentName){
		String hql="from Personneltrain pt where isDelete=0 and pt.personnelinfo in (from Personnelinfo pi where isDelete=0 and pi.deptJobRel in (from DeptJobRel djr where isDelete=0 and djr.department in (from Department d where isDelete=0 and d.departmentName='"+departmentName+"'))) order by pt.personnelTrainDate desc";
		System.err.println(hql);
		List<Personneltrain> list =this.find(hql);
		return list;
	}
	public List<Personneltrain> findByJobNoPage(String jobName){
		String hql="from Personneltrain pt where isDelete=0 and pt.personnelinfo in (from Personnelinfo pi where isDelete=0 and pi.deptJobRel in (from DeptJobRel djr where isDelete=0 and djr.job in (from Job d where isDelete=0 and d.jobName='"+jobName+"'))) order by pt.personnelTrainDate desc";
		System.err.println(hql);
		List<Personneltrain> list =this.find(hql);
		return list;
	}
	
	public List<Personneltrain> findByJob(String jobName,PageDivid pageDivid){
		String hql="from Personneltrain pt where isDelete=0 and pt.personnelinfo in (from Personnelinfo pi where isDelete=0 and pi.deptJobRel in (from DeptJobRel djr where isDelete=0 and djr.job in (from Job d where isDelete=0 and d.jobName='"+jobName+"'))) order by pt.personnelTrainDate desc";
		//查出来的如果是很多条记录的话，需要用in判断是否在后面子查询中
		System.err.println(hql);
		List<Personneltrain> list =this.find(hql, pageDivid);
		return list;
	}
	
	public void add(Personneltrain pt) {				
		this.save(pt);
		System.out.println("执行了DAO的add");
	}

	public void personTrainUpdate(Personneltrain personneltrain) {
		this.update(personneltrain);
		System.out.println("执行了DAO里的update");

	}

	

}
