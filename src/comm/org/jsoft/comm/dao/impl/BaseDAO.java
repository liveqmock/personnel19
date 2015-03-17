package org.jsoft.comm.dao.impl;

import java.io.Serializable;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.util.HibernateSessionFactory;
import org.jsoft.comm.vo.PageDivid;
/**
 * 对数据库基本操作的实现类
 * @author 羽
 *
 * @param <T>
 */
public class BaseDAO<T> implements IBaseDAO<T> {

	@Override
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	@Override
	public void closeSession() {
		HibernateSessionFactory.closeSession();
	}
	@Override
	public Serializable save(T object) {
		
		Session session = null;
		Transaction ts=null;
		Serializable a=null;
		try {
			session=getSession();
			ts = session.beginTransaction();
			 a=session.save(object);
			session.beginTransaction().commit();
			
		} catch (HibernateException e) {
			
			if(ts!=null){
				ts.rollback();
			}
			e.printStackTrace();
		}finally{
			if(session.isOpen()||session!=null){
				/*closeSession();*/
			}
		}
		
		
		return a;
	}

	@Override
	public void update(T object) {
		
		Session session = null;
		Transaction ts=null;
		
		try {
			session=getSession();
			ts = session.beginTransaction();
			session.update(object);
			session.beginTransaction().commit();
			
		} catch (HibernateException e) {
		
			if(ts!=null){
				ts.rollback();
			}
			e.printStackTrace();
		}finally{
			if(session.isOpen()||session!=null){
				/*closeSession();*/
			}
		}
	}

	@Override
	public void delete(T object) {
		
		Session session = null;
		Transaction ts=null;
		
		try {
			session=getSession();
			ts = session.beginTransaction();
			session.delete(object);
			session.beginTransaction().commit();
			
		} catch (HibernateException e) {
			
			if(ts!=null){
				ts.rollback();
			}
			e.printStackTrace();
		}finally{
			if(session.isOpen()||session!=null){
				/*closeSession();*/
			}
		}
	}

	@Override
	public void saveOrUpdate(T object) {
		
		Session session =null;
		Transaction ts=null;
		
		try {
			session=getSession();
			ts = session.beginTransaction();
			session.saveOrUpdate(object);
			session.beginTransaction().commit();
			
		} catch (HibernateException e) {
			
			if(ts!=null){
				ts.rollback();
			}
			e.printStackTrace();
		}finally{
			if(session.isOpen()||session!=null){
				/*closeSession();*/
			}
		}
	}

	@Override
	public List<T> find(String hql) {
		Session session = null;
		List<T> list =null;
		try {
			session=getSession();
			list = session.createQuery(hql).list();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			if(session.isOpen()||session!=null){
				/*closeSession();*/
			}
		}
		return list;
	}

	@Override
	public List<T> find(String hql, List<Object> paraments) {
		Session session = null;
		List<T> list =null;
		try {
			session=getSession();
			Query query = session.createQuery(hql);
			for (int i = 0; i < paraments.size(); i++) {
				query.setParameter(i, paraments.get(i));
			}
			list = query.list();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			if(session.isOpen()||session!=null){
				/*closeSession();*/
			}
		}
		return list;
	}

	@Override
	public List<T> find(String hql, PageDivid pageDivid) {
		Session session = null;
		List<T> list =null;
		try {
			session=getSession();
			Query query = session.createQuery(hql);
			query.setFirstResult((pageDivid.getCurrentPage()-1)*pageDivid.getEachPageNum()).setMaxResults(pageDivid.getEachPageNum());
			list = query.list();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			if(session.isOpen()||session!=null){
				/*closeSession();*/
			}
		}
		return list;
	}

	@Override
	public List<T> find(String hql, List<Object> paraments, PageDivid pageDivid) {
		Session session = null;
		List<T> list =null;
		try {
			session=getSession();
			Query query = session.createQuery(hql);
			for (int i = 0; i < paraments.size(); i++) {
				query.setParameter(i, paraments.get(i));
			}
			query.setFirstResult((pageDivid.getCurrentPage()-1)*pageDivid.getEachPageNum()).setMaxResults(pageDivid.getEachPageNum());
			list = query.list();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			if(session.isOpen()||session!=null){
				/*closeSession();*/
			}
		}
		return list;
	}

	@Override
	public T get(Class<T> clazz, Serializable id) {
		Session session = null;
		T t =null;
		try {
			session=getSession();
			if(session.get(clazz, id)!=null){
				t = (T)session.get(clazz, id);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			if(session.isOpen()||session!=null){
				/*closeSession();*/
			}
		}
		return t;
	}

	@Override
	public T get(String hql) {
		Session session = null;
		T t =null;
		try {
			session=getSession();
			if(session.createQuery(hql).uniqueResult()!=null){
				t = (T)session.createQuery(hql).uniqueResult();
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			if(session.isOpen()||session!=null){
				/*closeSession();*/
			}
		}
		return t;
	}

	@Override
	public T get(String hql, List<Object> paraments) {
		Session session = null;
		T t =null;
		try {
			session=getSession();
			Query query = session.createQuery(hql);
			for (int i = 0; i < paraments.size(); i++) {
				query.setParameter(i, paraments.get(i));
			}
			
			if(query.uniqueResult()==null){
				t= null;
			}else{
				t = (T)query.uniqueResult();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session.isOpen()||session!=null){
				/*closeSession();*/
			}
		}
		return t;
	}
	@Override
	public Serializable count(String hql) {
		Session session = null;
		Serializable s =null;
		try {
			session=getSession();
			if(session.createQuery(hql).uniqueResult()!=null){
				 s= (Serializable)session.createQuery(hql).uniqueResult();
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			if(session.isOpen()||session!=null){
				/*closeSession();*/
			}
		}
		return s;
	}
	@Override
	public Serializable count(String hql, List<Object> paraments) {
		Session session = null;
		Serializable s =null;
		try {
			session=getSession();
			Query query =session.createQuery(hql);
			for (int i = 0; i < paraments.size(); i++) {
				query.setParameter(i, paraments.get(i));
			}
			if(query.uniqueResult()!=null){
				 s = (Serializable)query.uniqueResult();
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			if(session.isOpen()||session!=null){
				/*closeSession();*/
			}
		}
		return s;
	}
	@Override
	public void rebuildSessionFactory() {
		HibernateSessionFactory.rebuildSessionFactory();
		
	}
	
	
	



}
