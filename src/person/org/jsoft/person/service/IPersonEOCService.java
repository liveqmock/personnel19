package org.jsoft.person.service;

import java.util.List;

import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.DictionLog;
import org.jsoft.comm.vo.Duty;
import org.jsoft.comm.vo.Encorchast;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Peoc;
import org.jsoft.comm.vo.Personnelinfo;



public interface IPersonEOCService {
	
	public List<Peoc> queryPeocsAll(); // 查询所有员工奖惩信息
	public List<Peoc> queryPeocsAll(PageDivid pg); // 查询所有员工奖惩信息
	public Peoc queryPeocSingle(String peocId);     // 查询单独的奖惩记录
	
	public List<Encorchast> queryEncorchastAll(); // 查询所有的奖惩规则
	public Encorchast queryEncorchastSingle(String encOrChastId);  // 查询单独的奖惩规则
	
	// 修改员工奖惩信息
	public void updatePeoc(String peocRemark , String peocId , String personnelNo ,String personnelName ,String peocDate ,String peocReason ,String  encOrChastId);  
	
	// 新增员工奖惩信息
	public void insertPeoc(String personnelId , String peocReason , String encOrChastId , String peocRemark);

	public void deletePeoc(String peocId);  // 删除员工奖惩信息


}
