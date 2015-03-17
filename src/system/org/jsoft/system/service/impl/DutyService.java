package org.jsoft.system.service.impl;

import java.util.List;

import org.jsoft.comm.vo.Duty;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.system.dao.IDutyDAO;
import org.jsoft.system.dao.impl.DutyDAO;
import org.jsoft.system.service.IDutyService;

public class DutyService implements IDutyService {
private IDutyDAO dutyDAO = new DutyDAO();
	@Override
	public List<Duty> queryNpage(String page) {
		// TODO Auto-generated method stub
		PageDivid pageDivid = new PageDivid();
		pageDivid =getPageDivid(page);
		List<Duty> dutys =dutyDAO.query(pageDivid);
		return dutys;
	}

	@Override
	public PageDivid getPageDivid(String page) {
		// TODO Auto-generated method stub
		PageDivid pageDivid = new PageDivid();
		int all =  dutyDAO.Allcount();
		pageDivid.setNum(all);
		pageDivid.setAllPage((all-1)/pageDivid.getEachPageNum()+1);
		int currentpage = 1;
		System.err.println(page);
		if(page!=null&&page!=""&&!("null".equals(page))){
			System.err.println(page);
			currentpage=Integer.parseInt(page);
		}
		pageDivid.setCurrentPage(currentpage);
		return pageDivid;
	}

	@Override
	public void updateDept(String dutytId, String dutyName) {
		// TODO Auto-generated method stub
		Duty duty =dutyDAO.getDuty(dutytId);
		duty.setDutyName(dutyName);
		dutyDAO.updateDuty(duty);
	}

	@Override
	public void add(String dutyName) {
		// TODO Auto-generated method stub
		Duty duty = new Duty();
		duty.setDutyName(dutyName);
		duty.setIsDelete(0);
		dutyDAO.add(duty);
	}

	@Override
	public void delLie(String dutyId) {
		// TODO Auto-generated method stub
		Duty duty =dutyDAO.getDuty(dutyId);
		duty.setIsDelete(1);
		dutyDAO.updateDuty(duty);
	}

	@Override
	public Duty getduty(String dutyId) {
		// TODO Auto-generated method stub
		return dutyDAO.getDuty(dutyId);
	}

	@Override
	public void delLie(String[] checkbox) {
		for (int i = 0; i < checkbox.length; i++) {
			delLie(checkbox[i]);
		}
	}

}
