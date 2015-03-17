package org.jsoft.salary.dao.impl;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.salary.dao.IPersonnelInfoDAO;

public class PersonnelInfoDAO extends BaseDAO<Personnelinfo> implements IPersonnelInfoDAO {
	
	public Personnelinfo queryPersonnelInfoFromDeptJobRelId(String deptjobrelid){
		String hql="from Personnelinfo where deptJobRel = '"+deptjobrelid+"' ";
		Personnelinfo person=this.get(hql);
		return person;
	}
	public Personnelinfo queryPersonnelInfoFromWorkId(String workid){
		String hql="from Personnelinfo where workId = '"+workid+"' ";
		Personnelinfo person=this.get(hql);
		return person;
	}
}
