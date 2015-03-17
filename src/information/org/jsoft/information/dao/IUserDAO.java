package org.jsoft.information.dao;

import java.util.List;

import org.jsoft.comm.vo.Peoc;
import org.jsoft.comm.vo.Personneladjustsalary;
import org.jsoft.comm.vo.Personnelappraise;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.comm.vo.Personnelremove;
import org.jsoft.comm.vo.Personneltrain;
import org.jsoft.comm.vo.Salary;

public interface IUserDAO 
{
	public List<Personnelinfo> queryAll();
	
	public List<Personnelinfo> queryByPersonnelId(String id);
	
	public List<Personneltrain> queryTrain();
	
	public List<Personnelappraise> queryAppraise();
	
	public List<Personneladjustsalary> querySalary();
	
	public List<Personnelremove> queryRemove();
	
	public List<Salary> querySal();
	
	public List<Peoc> queryEn();

}
