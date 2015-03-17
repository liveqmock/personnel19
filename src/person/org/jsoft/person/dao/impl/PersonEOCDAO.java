package org.jsoft.person.dao.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DictionLog;
import org.jsoft.comm.vo.Duty;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Peoc;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.person.dao.IPersonEOCDAO;
import org.jsoft.person.dao.IPersonInfoDAO;

public class PersonEOCDAO extends BaseDAO<Peoc> implements IPersonEOCDAO {

	@Override
	public List<Peoc> queryPeocsAll() {
		List<Peoc> peocs = new ArrayList<Peoc>();
		String isDelete = "0";
		String hql = "from Peoc where isDelete = '"+isDelete+"'    ";
		peocs = this.find(hql);
	
		return peocs;
	}
	
	public List<Peoc> queryPeocsAll(PageDivid pg) {
		List<Peoc> peocs = new ArrayList<Peoc>();
		String isDelete = "0";
		String hql = "from Peoc where isDelete = '"+isDelete+"'    ";
		peocs = this.find(hql, pg);
	
		return peocs;
	}

	@Override
	public Peoc queryPeocSingle(String peocId) {
		String isDelete = "0";
		String hql = "from Peoc where peocId ='"+peocId+"' and isDelete = '"+isDelete+"'   ";
		Peoc peoc = this.get(hql);
		return peoc;
	}

	@Override
	public void updatePeoc(Peoc peoc) {
		this.update(peoc);
		
	}

	@Override
	public void insertPeoc(Peoc peoc) {
		this.save(peoc);
		
	}




}
