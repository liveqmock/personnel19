package org.jsoft.salary.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.Peoc;
import org.jsoft.comm.vo.Personneladjustsalary;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.comm.vo.Salary;
import org.jsoft.salary.dao.impl.PEOCDAO;
import org.jsoft.salary.dao.impl.PersonnelAdjustSalaryDAO;
import org.jsoft.salary.dao.impl.PersonnelInfoDAO;
import org.jsoft.salary.service.ISearchPayRollService;
import org.jsoft.salary.vo.PayRollResult;

public class SearchPayRollService implements ISearchPayRollService {
	private List<PayRollResult> result;

	public PayRollResult searchPayRoll(String workid, String year, String month) {
		List<PayRollResult> all = searchPayRoll(workid);
		try {
			for (PayRollResult payRollResult : all) {
				if (payRollResult.getMonth() == (Integer.parseInt(month))
						&& payRollResult.getYear() == (Integer.parseInt(year))) {
					PayRollResult result = payRollResult;
					return result;
				}
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	public List<PayRollResult> searchPayRoll(String workid,String year){
			List<PayRollResult> all = searchPayRoll(workid);
			List<PayRollResult> result = new ArrayList<PayRollResult>();
				for (PayRollResult payRollResult : all) {
					System.out.println("YYYYY"+payRollResult.getYear());
					if (payRollResult.getYear() == (Integer.parseInt(year))) {
						result.add(payRollResult);
					}
				}
		return result;
	}
	
	public List<PayRollResult> searchPayRoll(String workid) {
		List<PayRollResult> result = new ArrayList<PayRollResult>();
		Timestamp start = getStartTime(workid);
		Timestamp end = getEndTime();
		int month = 0;
		while (start.before(end)) {
			System.out.println("start=" + start + ";end=" + end);
			Salary s = searchSalary(workid, end);
			List<Peoc> l = searchPeoc(workid, end);
			double total = 0;
			int times = 0;
			if (s != null) {
				total += s.getAllSalary();
			}
			if (l != null) {
				for (Peoc peoc : l) {
					if (peoc.getEncorchast() != null) {
						total += peoc.getEncorchast().getMoney();
						times++;
					}
				}
			}
			System.out.println(total);
			PayRollResult prr = new PayRollResult(s, l, getYear(end),
					getMonth(end), total, times);
			result.add(prr);
			month = month + 1;
			end = getEndTime(-month);
		}
		return result;
	}

	// 获取当前月薪金结算日期
	public Timestamp getEndTime() {
		Calendar now = Calendar.getInstance();// 当前时间
		Calendar paysalary = now;
		paysalary.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 14, 23,
				59, 59);// 设置当月薪金结算日期
		Timestamp end = new Timestamp(paysalary.getTime().getTime());
		return end;
	}

	// 获取任意月薪金结算日期
	public Timestamp getEndTime(int month) {
		Calendar now = Calendar.getInstance();// 当前时间
		Calendar paysalary = now;
		paysalary.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH) + month,
				14, 23, 59, 59);// 设置当月薪金结算日期
		Timestamp end = new Timestamp(paysalary.getTime().getTime());
		return end;
	}

	// 获取员工入职所在月 结薪时间
	public Timestamp getStartTime(String workid) {
		PersonnelInfoDAO pid = new PersonnelInfoDAO();
		Personnelinfo person = pid.queryPersonnelInfoFromWorkId(workid);
		Timestamp st = person.getBeginWorkDate();// 入职日期
		System.out.println("入职日期:" + st);
		Calendar c = Calendar.getInstance();
		c.setTime(st);
		System.out.println(c);
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 15, 0, 0, 0);
		Timestamp st2 = new Timestamp(c.getTime().getTime());// 当月结薪日期
		System.out.println("当月结薪日期:" + st2);
		if (st.before(st2)) {
			c.add(Calendar.MONTH, -1);
			st2 = new Timestamp(c.getTime().getTime());
		}
		System.out.println("当月结薪日期:" + st2);
		return st2;
	}

	// 得到某员工 某月 奖罚信息
	public List<Peoc> searchPeoc(String workid, Timestamp endtime) {
		System.out.println("当月结薪日：" + endtime);
		Timestamp premonth = endtime;
		Calendar c = Calendar.getInstance();
		c.setTime(premonth);
		c.add(Calendar.MONTH, -1);
		c.add(Calendar.SECOND, +1);// 前一个月结薪日期之后
		premonth = new Timestamp(c.getTime().getTime());
		System.out.println("前一个月结薪日期:" + premonth);
		PEOCDAO pd = new PEOCDAO();
		List<Peoc> peoc = pd.queryPeocByDate(workid, endtime, premonth);
		for (Peoc peoc2 : peoc) {
			System.out.println(peoc2.getEncorchast().getMoney());
		}
		return peoc;
	}

	// 得到某员工某月Salary
	public Salary searchSalary(String Workid, Timestamp endtime) {
		PersonnelInfoDAO pid = new PersonnelInfoDAO();
		Personnelinfo person = pid.queryPersonnelInfoFromWorkId(Workid);
		DeptJobRel djr = person.getDeptJobRel();
		String djrid = djr.getDeptJobRelId();
		PersonnelAdjustSalaryDAO pasd = new PersonnelAdjustSalaryDAO();
		Personneladjustsalary pjs = pasd.queryByDate(djrid, endtime);
		if (pjs != null) {
			Salary s = pjs.getSalary();
			return s;
		} else {
			return null;
		}
	}

	public int getYear(Timestamp time) {
		Date d = new Date(time.getTime());
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int year = c.get(Calendar.YEAR);
		return year;
	}

	public int getMonth(Timestamp time) {
		Date d = new Date(time.getTime());
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int month = c.get(Calendar.MONTH);
		return month + 1;
	}

	public String result() {
		return null;
	}
}
