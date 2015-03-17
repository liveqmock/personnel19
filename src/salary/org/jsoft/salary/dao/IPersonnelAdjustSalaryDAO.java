package org.jsoft.salary.dao;

import java.sql.Timestamp;
import java.util.List;

import org.jsoft.comm.vo.Personneladjustsalary;

public interface IPersonnelAdjustSalaryDAO {
	//通过Dept_Job_Relid 得到List<Personneladjustsalary>
	public List<Personneladjustsalary> queryFromDJRId(String djrid);
	//通过Dept_Job_Relid 得到end时间之前的Personneladjustsalary 并以date降序排列
	public Personneladjustsalary queryByDate(String djrid,Timestamp end);
}
