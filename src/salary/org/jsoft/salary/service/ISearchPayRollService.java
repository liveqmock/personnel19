package org.jsoft.salary.service;

import java.sql.Timestamp;
import java.util.List;

import org.jsoft.comm.vo.Peoc;
import org.jsoft.comm.vo.Salary;
import org.jsoft.salary.vo.PayRollResult;

public interface ISearchPayRollService {
	//按员工号 年 月查询工资表
	public PayRollResult searchPayRoll(String workid,String year,String month);
	//按员工号 年查询工资表
	public List<PayRollResult> searchPayRoll(String workid,String year);
	//按员工号查询 所有工资表
	public List<PayRollResult> searchPayRoll(String workid);
	//得到某员工 某月基本工资
	public Salary searchSalary(String personnelid,Timestamp endtime);
	//得到某员工 某月 奖罚信息
	public List<Peoc> searchPeoc(String personnelid,Timestamp endtime);
	//获取当前月薪金结算日期
	public Timestamp getEndTime();
	//获取任意与当前月相差month月的薪金结算日期
	public Timestamp getEndTime(int month);
	//获取员工入职时间
	public Timestamp getStartTime(String workid);
	public int getYear(Timestamp time);
	public int getMonth(Timestamp time);
	public String result();
}
