package org.jsoft.person.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.comm.vo.Salary;
import org.jsoft.person.dao.IPersonAdjustSalaryDAO;

/**  
 * <关于员工调薪的查询DAO的实现> 
 * @author xfd   
 * @version 创建时间：2014-9-22 下午7:31:07  
 */
public class PersonAdjustSalaryDAO<T> extends BaseDAO<T> implements IPersonAdjustSalaryDAO<T> {

	@Override
	public DeptJobRel getDeptJobRelByPersonnelId(String personnelId) {
		// TODO Auto-generated method stub
		String hql="FROM Personnelinfo WHERE personnelId='"+personnelId+"'";
		DeptJobRel deptJobRel=null;
		List<Personnelinfo> persons=(List<Personnelinfo>) find(hql);
		for(Personnelinfo personsitem:persons){
			deptJobRel=personsitem.getDeptJobRel();
		}
		return deptJobRel;
	}

	@Override
	public List<Salary> getSalaryByDeptJobRel(DeptJobRel deptJobRel) {
		// TODO Auto-generated method stub
		String deptJobRelId=deptJobRel.getDeptJobRelId();
		String hql="FROM DeptJobRel WHERE deptJobRelId='"+deptJobRelId+"'";
		List<DeptJobRel> deptJobRelList=(List<DeptJobRel>) find(hql);
		List<Salary> salaryList=new ArrayList<Salary>();
		for(DeptJobRel deptJobRelItem:deptJobRelList){
			salaryList.add(deptJobRelItem.getSalary());
		}
		return salaryList;
	}





}
