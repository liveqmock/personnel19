package org.jsoft.system.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Bak;
import org.jsoft.comm.vo.OperateLog;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.system.dao.IOperateLogDAO;
import org.jsoft.system.dao.IOperaterDAO;

public class OperateLogDAO extends BaseDAO<OperateLog> implements IOperateLogDAO {

	@Override
	public void add(Operater operater, String info) {
		// TODO Auto-generated method stub
		OperateLog log = new OperateLog();
		log.setOperater(operater);
		log.setBakDate(new Timestamp(new Date().getTime()));
		log.setEvent(info);
		log.setIsDelete(0);
		save(log);
	}

	@Override
	public void del(String operateLogId) {
		// TODO Auto-generated method stub
		OperateLog log =get(OperateLog.class, operateLogId);
		System.out.println(log);
		log.setIsDelete(1);
		update(log);
	}

	@Override
	public List<OperateLog> queryAll() {
		String hql = "From OperateLog  where isDelete=? order by bakDate desc";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		List<OperateLog> operateLogs = find(hql, paraments);
		return operateLogs;
	}

	@Override
	public List<OperateLog> queryALL(PageDivid pageDivid) {
		String hql = "From OperateLog where isDelete=? order by bakDate desc";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		List<OperateLog> operateLogs = find(hql, paraments, pageDivid);
		return operateLogs;
	}
	public static void main(String[] args) {
		for (int i = 0; i < 23; i++) {
			OperateLogDAO operateLogDAO = new OperateLogDAO();
			OperaterDAO operaterDAO = new OperaterDAO();
			//Operater operater = operaterDAO.get(Operater.class, "1");
			operateLogDAO.add(null, "hahh");
		}
		
		//operateLogDAO.del("3e348d4d-9768-1032-8a46-4524e615b345");
		//List<OperateLog> ops=operateLogDAO.queryAll();
	//	System.out.println(ops.get(0).getEvent());
	}

	@Override
	public int account() {
		String hql = "select count(*)  From OperateLog where isDelete=?";
		List<Object> paraments = new  ArrayList<Object>();
		paraments.add(0);
		int a =   Integer.parseInt(count(hql, paraments)+"");
		return a;
	}

	@Override
	public int account(String hql, List<Object> paraments) {
		int a =   Integer.parseInt(count(hql, paraments)+"");
		return a;
	}

	@Override
	public List<OperateLog> queryByElement(String operaterName,
			Timestamp upDate, Timestamp downDate, PageDivid pageDivid) {
		Criteria criteria = getSession().createCriteria(OperateLog.class);
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
		List<OperateLog> operateLogs = criteria.setFirstResult((pageDivid.getCurrentPage()-1)*pageDivid.getEachPageNum()).setMaxResults(pageDivid.getEachPageNum()).list();
		return operateLogs;
	}

	@Override
	public OperateLog getById(String id) {
		OperateLog operateLog=get(OperateLog.class, id);
		return operateLog;
	}
}
