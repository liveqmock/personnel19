package org.jsoft.salary.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Personneladjustsalary;
import org.jsoft.salary.dao.IPersonnelAdjustSalaryDAO;

public class PersonnelAdjustSalaryDAO extends BaseDAO<Personneladjustsalary>
		implements IPersonnelAdjustSalaryDAO {
	public List<Personneladjustsalary> queryFromDJRId(String djrid) {
		String hql = "from Personneladjustsalary where deptJobRel.deptJobRelId ="
				+ djrid;
		List<Personneladjustsalary> list = find(hql);
		return list;
	}

	public Personneladjustsalary queryByDate(String djrid, Timestamp end) {
		String hql = "from Personneladjustsalary where deptJobRel.deptJobRelId ="
				+ djrid
				+ "and adjustSalaryDate < '"
				+ end
				+ "' order by adjustSalaryDate desc";
		List<Personneladjustsalary> list = find(hql);
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
