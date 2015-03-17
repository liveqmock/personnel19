package org.jsoft.system.service.impl;

import java.util.List;
import org.jsoft.comm.vo.Encorchast;
import org.jsoft.comm.vo.PageDivid;

import org.jsoft.system.dao.IEncorchastDAO;
import org.jsoft.system.dao.impl.EncorchastDAO;
import org.jsoft.system.service.IEncorchastService;

public class EncorchastService implements IEncorchastService{
private IEncorchastDAO encorchastDAO = new EncorchastDAO();
	@Override
	public List<Encorchast> queryNpage(String page) {
		// TODO Auto-generated method stub
		PageDivid pageDivid = new PageDivid();
		pageDivid =getPageDivid(page);
		List<Encorchast> encorchasts =encorchastDAO.query(pageDivid);
		return encorchasts;
	}

	@Override
	public PageDivid getPageDivid(String page) {
		// TODO Auto-generated method stub
		PageDivid pageDivid = new PageDivid();
		int all =  encorchastDAO.Allcount();
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
	public void updateDept(String EncorchastId,
			double personnelEncorchastPoint, double money,
			String personnelEncorchastSort) {
		Encorchast encorchast= getEncorchast(EncorchastId);
		encorchast.setMoney(money);
		encorchast.setPersonnelEncOrChastPoint(personnelEncorchastPoint);
		encorchast.setPersonnelEncOrChastSort(personnelEncorchastSort);
		encorchastDAO.updateencorchast(encorchast);
		
	}

	@Override
	public void add(double personnelEncorchastPoint, double money,
			String personnelEncorchastSort) {
		Encorchast encorchast= new Encorchast();
		encorchast.setMoney(money);
		encorchast.setPersonnelEncOrChastPoint(personnelEncorchastPoint);
		encorchast.setPersonnelEncOrChastSort(personnelEncorchastSort);
		encorchast.setIsDelete(0);
		encorchastDAO.save(encorchast);
		
	}

	@Override
	public void delLie(String EncorchastId) {
		Encorchast encorchast= getEncorchast(EncorchastId);
		encorchast.setIsDelete(1);
		encorchastDAO.updateencorchast(encorchast);
	}

	@Override
	public Encorchast getEncorchast(String encorchastId) {
		// TODO Auto-generated method stub
		return encorchastDAO.getencorchast(encorchastId);
	}

	@Override
	public void delLie(String[] checkbox) {
		for (int i = 0; i < checkbox.length; i++) {
			delLie(checkbox[i]);
		}
		
	}

}
