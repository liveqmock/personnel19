package org.jsoft.system.dao.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Bak;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.system.dao.IBakDAO;
import org.jsoft.system.dao.IOperaterDAO;

public class BakDAO extends BaseDAO<Bak> implements IBakDAO{

	@Override
	public List<Bak> queryAll() {
		// TODO Auto-generated method stub
		String hql = "From Bak where isDelete=? order by bakDate desc";
		List<Object> paraments = new  ArrayList<Object>();
		paraments.add(0);
		List<Bak> baks = find(hql, paraments);
		return baks;
	}

	@Override
	public List<Bak> queryAll(PageDivid pageDivid) {
		// TODO Auto-generated method stub
		String hql = "From Bak where isDelete=? order by bakDate desc";
		List<Object> paraments = new  ArrayList<Object>();
		paraments.add(0);
		List<Bak> baks =find(hql, paraments, pageDivid);
		return baks;
		
	}

	@Override
	public int AllCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*)  From Bak where isDelete=?";
		List<Object> paraments = new  ArrayList<Object>();
		paraments.add(0);
		int a =   Integer.parseInt(count(hql, paraments)+"");
		return a;
	}
	@Override
	public int AllCountByElement(String hql,List<Object> paraments){
		int a =   Integer.parseInt(count(hql, paraments)+"");
		return a;
	}
	@Override
	public void add(Bak bak) {
		// TODO Auto-generated method stub
		save(bak);
	}

	@Override
	public void updateBak(Bak bak) {
		// TODO Auto-generated method stub
		update(bak);
	}

	@Override
	public List<Bak> getBakByParaments(String operaterName, Timestamp upDate,
			Timestamp downDate,PageDivid pageDivid) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Bak.class);
		criteria.add(Restrictions.eq("isDelete", 0));
		if(operaterName!=null){
			IOperaterDAO operaterDAO = new OperaterDAO();
			Operater operater = operaterDAO.geOperaterByName(operaterName);
			criteria.add(Restrictions.eq("operater", operater));
		}
		if(upDate!=null){
			System.err.println("dkjfdsk");
			criteria.add(Restrictions.gt("bakDate", upDate));
		}
		if(downDate!=null){
			criteria.add(Restrictions.le("bakDate", downDate));
		}
		pageDivid.setNum(criteria.list().size());
		pageDivid.setAllPage(criteria.list().size()/pageDivid.getEachPageNum()+1);
		List<Bak> baks = criteria.setFirstResult((pageDivid.getCurrentPage()-1)*pageDivid.getEachPageNum()).setMaxResults(pageDivid.getEachPageNum()).list();
		return baks;
	}
	
	public void bak(){
		String hql = "select * from bak into outfile 'D:\\a.txt'";
		
		System.out.println(getSession().createSQLQuery(hql));
	}
	
	public static void main(String[] args) {
		BakDAO bakDAO = new BakDAO();
		/*String update1 = "2011-05-09 11:49:45";
		String downDate1="2014-10-09 11:49:45";
		Timestamp upTimest = Timestamp.valueOf(update1);
		Timestamp upTimest2 = Timestamp.valueOf(downDate1);
		List<Bak> baks=bakDAO.getBakByParaments("lc", upTimest, upTimest2);
		System.out.println(baks.size());
		//String hql = "from Salary where basicSalary = 3000";  //多个salary
		String hql = "from Personnelinfo where deptJobRel in (from DeptJobRel where salary in (from Salary where basicSalary = 3000))"; //多个DeptJobRel.java
		
*/	
		bakDAO.bak();
		System.out.println(bakDAO.queryAll());
		}

}
