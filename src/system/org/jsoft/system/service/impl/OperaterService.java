package org.jsoft.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.service.impl.BaseService;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.person.dao.impl.PersonInfoDAO;
import org.jsoft.system.dao.IOperaterDAO;
import org.jsoft.system.dao.impl.OperaterDAO;
import org.jsoft.system.service.IOperaterService;

public class OperaterService extends BaseService implements IOperaterService {
	private IOperaterDAO operaterDAO = new OperaterDAO();

	@Override
	public Operater getOperaterByUP(String username, String password) {
		// TODO Auto-generated method stub

		Operater operater2 = operaterDAO.getOperater(username, password);
		Operater operater = new Operater();
		if (operater2 != null) {
			operater.setOpId(operater2.getOpId());
			operater.setOpName(operater2.getOpName());
			operater.setPopedom(operater2.getPopedom());
		} else {
			operater = null;
		}

		return operater;
	}

	@Override
	public void deleteOperater(String name, String value) {
		OperaterDAO operaterdao = new OperaterDAO();
		Operater operater = new Operater();
		operater = operaterdao.getOperaterByMessage(name, value);
		if (operater != null) {
			operater.setIsDelete(1);
			operaterdao.update(operater);
		}
	}

	@Override
	public Operater getById(String opId) {
		// TODO Auto-generated method stub

		return operaterDAO.getById(opId);
	}

	@Override
	public void updatePassword(String opId, String newPassword) {
		// TODO Auto-generated method stub
		Operater operater = operaterDAO.getById(opId);
		operater.setOpPassword(newPassword);
		operaterDAO.updateOperater(operater);
	}

	@Override
	public boolean dpassword(String opId, String newPassword) {
		// TODO Auto-generated method stub
		Operater operater = operaterDAO.getById(opId);
		System.out.println(operater);
		if (newPassword.equals(operater.getOpPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public void addOperater(String personnelNo, String opName,
			String opPassword, String operatertype) {
		// TODO Auto-generated method stub
		Operater operater = new Operater();
		OperaterDAO operaterdao = new OperaterDAO();
		Personnelinfo personnelinfo = new Personnelinfo();
		PersonInfoDAO personinfodao = new PersonInfoDAO();
		personnelinfo = personinfodao.queryNo(personnelNo);
		operater.setOpName(opName);
		operater.setOpPassword(opPassword);
		operater.setPopedom(operatertype);
		operater.setPersonnelinfo(personnelinfo);
		operater.setIsDelete(0);
		operaterdao.addOperater(operater);
	}

	@Override
	public void deleteOperaters(String[] opIds) {
		OperaterService operaterservice = new OperaterService();
		// TODO Auto-generated method stub
		if (opIds!=null) {
			for (int i = 0; i < opIds.length; i++) {
				operaterservice.deleteOperater("opId", opIds[i]);
			}
		}
	}

	@Override
	public PageDivid getPageDividByPage(int page) {
		// TODO Auto-generated method stub
		PageDivid pageDivid = new PageDivid();
		List<Operater> operaterall = new ArrayList<Operater>();
		operaterall = operaterDAO.getAllOperater();
		pageDivid.setNum(operaterall.size());
		if (operaterall.size() == 0) {
		} else {
			int totalRow = operaterall.size();
			if (totalRow % pageDivid.getEachPageNum() != 0) {
				pageDivid.setAllPage(totalRow / pageDivid.getEachPageNum() + 1);
			} else {
				pageDivid.setAllPage(totalRow / pageDivid.getEachPageNum());
			}
			if (page < 1) {
				page = 1;
			}
			if (page > pageDivid.getAllPage()) {
				page = pageDivid.getAllPage();
			}
			pageDivid.setCurrentPage(page);
		}
		return pageDivid;

	}

	@Override
	public List<Operater> getOperatersByPageDivid(PageDivid pageDivid) {

		// TODO Auto-generated method stub
		int startrow;
		List<Operater> operaters = new ArrayList<Operater>();
		if (pageDivid.getCurrentPage() == 1) {
			startrow = 0;
		} else {
			startrow = (pageDivid.getCurrentPage() - 1)
					* pageDivid.getEachPageNum();
		}
		int i = 1;
		while (startrow < pageDivid.getNum() && i <= pageDivid.getEachPageNum()) {
			Operater operater = operaterDAO.getAllOperater().get(startrow);
			operaters.add(operater);
			startrow++;
			i++;
		}

		return operaters;
	}

	public static void main(String[] args) {
		OperaterService operateroervice = new OperaterService();
		List<String> opNames =new ArrayList<String>();
		opNames=operateroervice.getAllopNames();
		for (int i = 0; i < opNames.size(); i++) {
			System.out.println(opNames.get(i));
		}
	}

	@Override
	public List<String> getAllopNames() {
		// TODO Auto-generated method stub
		List<String> opNames=new ArrayList<String>();
		List<Operater> operaters=new ArrayList<Operater>();
		operaters=operaterDAO.getAllOperater();
		for (int i = 0; i <operaters.size(); i++) {
			opNames.add(operaters.get(i).getOpName());
		}
		return opNames;
	}

}
