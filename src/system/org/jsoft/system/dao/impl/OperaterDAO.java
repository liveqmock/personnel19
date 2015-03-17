package org.jsoft.system.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Menu;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.system.dao.IOperaterDAO;

public class OperaterDAO extends BaseDAO<Operater> implements IOperaterDAO {

	@Override
	public Operater getOperater(String username, String password) {
		// TODO Auto-generated method stub
		String hql = "From Operater where opName=? and opPassword=? and isDelete=?";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(username);
		paraments.add(password);
		paraments.add(0);

		Operater operater = new Operater();
		operater = get(hql, paraments);
		return operater;
	}

	@Override
	public Operater geOperaterByName(String opName) {
		// TODO Auto-generated method stub
		String hql = "From Operater where opName=? and isDelete=?";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(opName);
		paraments.add(0);
		Operater operater = new Operater();
		operater = get(hql, paraments);
		return operater;
	}

	
	
	
	
	@Override
	public List<Operater> getAllOperater() {
		// TODO Auto-generated method stub
		String hql = "From Operater where isDelete=?";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		return find(hql, paraments);
	}
	@Override
	public Operater getOperaterByMessage(String name, String value) {
		String hql = "From Operater where isDelete=? and "+name+"='"+value+"'";
		List<Object> paraments = new  ArrayList<Object>();
		paraments.add(0);
		Operater operater=new Operater();
		List<Operater> operaters=find(hql, paraments);
		if(operaters.size()!=0){
			operater = operaters.get(0)	;
		}else{
			operater=null;
		}
		return operater;
	}
	
	@Override
	public void updateOperater(Operater operater) {
		update(operater);
		
	}
	@Override
	public Operater getById(String opId) {
		// TODO Auto-generated method stub
		
		return get(Operater.class, opId);
	}
	@Override
	public void addOperater(Operater operater) {
		// TODO Auto-generated method stub
		save(operater);
	}
	public static void main(String[] args) {
		OperaterDAO operaterdao=new OperaterDAO();
		/*List<Operater> operaters=operaterdao.getAllOperater();
		for (Iterator iterator = operaters.iterator(); iterator.hasNext();) {
			Operater operater = (Operater) iterator.next();
			System.out.println(operater.getOpName());
			Personnelinfo personnelinfo =operater.getPersonnelinfo();
			System.out.println(personnelinfo.getPersonnelName());
		}*/
		/*Operater operater=operaterdao.getOperaterByMessage("opId", "1");
		System.out.println(operater.getOpName()+operater.getOpPassword());*/
		System.out.println(operaterdao.getOperaterByMessage("opId", "6"));
	}



		
}
