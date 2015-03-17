package org.jsoft.information.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Encorchast;
import org.jsoft.comm.vo.Peoc;
import org.jsoft.comm.vo.Personneladjustsalary;
import org.jsoft.comm.vo.Personnelappraise;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.comm.vo.Personnelremove;
import org.jsoft.comm.vo.Personneltrain;
import org.jsoft.comm.vo.Salary;
import org.jsoft.information.dao.IUserDAO;

public class UserDAO extends BaseDAO implements IUserDAO

{
	@SuppressWarnings("unchecked")
	@Override
	public List<Personnelinfo> queryAll() {
		Session session = getSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Personnelinfo where isDelete = 0");
		List<Personnelinfo> personInfo = query.list();
		session.getTransaction().commit();
		session.close();
		return personInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personnelinfo> queryByPersonnelId(String id) {
		Session session = getSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Personnelinfo WHERE isDelete = 0 and id="+id);
		List<Personnelinfo> personInfo = query.list();
		session.getTransaction().commit();
		session.close();
		return personInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personneltrain> queryTrain() {
		Session session = getSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Personneltrain where isDelete = 0");
		List<Personneltrain> personTrain = query.list();
		session.getTransaction().commit();
		session.close();
		return personTrain;
	}
	
	@SuppressWarnings("unchecked")
	public List<Personnelappraise> queryAppraise(){
		Session session = getSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Personnelappraise where isDelete = 0");
		List<Personnelappraise> personAppraise = query.list();
		session.getTransaction().commit();
		session.close();
		return personAppraise;
	}
	
	@SuppressWarnings("unchecked")
	public List<Personneladjustsalary> querySalary(){
		Session session = getSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Personneladjustsalary where isDelete = 0");
		List<Personneladjustsalary> personSalary = query.list();
		session.getTransaction().commit();
		session.close();
		return personSalary;
	}
	
	@SuppressWarnings("unchecked")
	public List<Personnelremove> queryRemove(){
		Session session = getSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Personnelremove where isDelete = 0");
		List<Personnelremove> personRemove = query.list();
		session.getTransaction().commit();
		session.close();
		return personRemove;
	}

	@Override
	public List<Salary> querySal() {
		Session session = getSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Salary where isDelete = 0");
		List<Salary> personSal = query.list();
		session.getTransaction().commit();
		session.close();
		return personSal;
	}
	
	@Override
	public List<Peoc> queryEn(){
		Session session = getSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Peoc where isDelete = 0");
		List<Peoc> personEn = query.list();
		session.getTransaction().commit();
		session.close();
		return personEn;
	}

}
