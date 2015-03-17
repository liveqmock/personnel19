package org.jsoft.person.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.DictionLog;
import org.jsoft.comm.vo.Duty;
import org.jsoft.comm.vo.Encorchast;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Peoc;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.person.dao.impl.PersonEOCDAO;
import org.jsoft.person.dao.impl.PersonInfoDAO;
import org.jsoft.person.dao.impl.PersonInfoDictionDAO;
import org.jsoft.person.service.IPersonEOCService;
import org.jsoft.person.service.IPersonInfoService;

public class PersonEOCService implements IPersonEOCService {
	
	
	public PersonEOCService() {
	}

	@Override
	public List<Peoc> queryPeocsAll() {
		PersonEOCDAO peocDAO = new PersonEOCDAO();
		List<Peoc> peocs = peocDAO.queryPeocsAll();
		return peocs;
		
	}
	
	@Override
	public List<Peoc> queryPeocsAll(PageDivid pg) {
		PersonEOCDAO peocDAO = new PersonEOCDAO();
		List<Peoc> peocs = peocDAO.queryPeocsAll(pg);
		return peocs;
	}
	


	@Override
	public Peoc queryPeocSingle(String peocId) {
		PersonEOCDAO peocDAO = new PersonEOCDAO();
		Peoc peoc = peocDAO.queryPeocSingle(peocId);
		return peoc;
	}
	
	@Override
	public List<Encorchast> queryEncorchastAll() {
		BaseDAO<Encorchast> eocDAO = new BaseDAO<Encorchast>();
		String isDelete = "0";
		List<Encorchast> eocs = eocDAO.find("from Encorchast where isDelete='"+isDelete+"'   "); 
		return eocs;
	}

	@Override
	public void updatePeoc(String peocRemark , String peocId , String personnelNo, String personnelName,
			String peocDate, String peocReason, String encOrChastId) {
		
		PersonEOCDAO peocDAO = new PersonEOCDAO();
		Peoc peoc = peocDAO.queryPeocSingle(peocId);
		
		try {
			Timestamp ts = new Timestamp(new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").parse(peocDate).getTime());
			// ↑ 将String转换成TimeStamp的方法
			peoc.setPeocDate(ts);
		} catch (ParseException ee) {
			ee.printStackTrace();
		}
		peoc.setPeocReason(peocReason);
		
		BaseDAO<Encorchast> eocDAO = new BaseDAO<Encorchast>();
		Encorchast e = eocDAO.get("from Encorchast where encOrChastId = '"+encOrChastId+"'   ");
		
		peoc.setEncorchast(e);
		peoc.setPersonnelTrainRemark(peocRemark);
		
		peocDAO.updatePeoc(peoc);
	
		
	}



	@Override
	public void insertPeoc(String personnelId, String peocReason,
			String encOrChastId, String peocRemark) {
		
		PersonEOCDAO peocDAO = new PersonEOCDAO();
		Peoc peoc = new Peoc();
		
		Encorchast e = this.queryEncorchastSingle(encOrChastId);
		peoc.setEncorchast(e);
		
		peoc.setIsDelete(0);
		
		Timestamp t = new Timestamp(System.currentTimeMillis()); 
		peoc.setPeocDate(t);
		
		peoc.setPeocReason(peocReason);
		
		PersonInfoDAO piDAO = new PersonInfoDAO();
		Personnelinfo p = piDAO.queryPersonSingle(personnelId);
		peoc.setPersonnelinfo(p);
		
		peoc.setPersonnelTrainRemark(peocRemark);
		
		peocDAO.insertPeoc(peoc);
		
	}
	
	

	@Override
	public Encorchast queryEncorchastSingle(String encOrChastId) {
		BaseDAO<Encorchast> eocDAO = new BaseDAO<Encorchast>();
		String isDelete = "0";
		Encorchast e = eocDAO.get("from Encorchast where isDelete='"+isDelete+"' and encOrChastId='"+encOrChastId+"'  "); 
		return e;
	}


	@Override
	public void deletePeoc(String peocId) {
		
		PersonEOCDAO peocDAO = new PersonEOCDAO();
		Peoc peoc = this.queryPeocSingle(peocId);
		peoc.setIsDelete(1);
		peocDAO.updatePeoc(peoc);
		
	}
	
	public static void main(String[] args) {
		PersonEOCService peocService = new PersonEOCService();
		List<Encorchast> encorchasts = peocService.queryEncorchastAll();
		for(Encorchast e : encorchasts){
			System.out.println(e.getPersonnelEncOrChastPoint());
		}
	}

	
	
	
	
}
