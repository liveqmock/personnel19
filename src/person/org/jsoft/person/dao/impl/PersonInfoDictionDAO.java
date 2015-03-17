package org.jsoft.person.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.DictionLog;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.person.dao.IPersonInfoDAO;
import org.jsoft.person.dao.IPersonInfoDictionDAO;

public class PersonInfoDictionDAO extends BaseDAO<DictionLog> implements IPersonInfoDictionDAO  {

	@Override
	public List<Personnelinfo> buildPersonByDiction(List<Personnelinfo> persons) {

		String hql = "";
			for(Personnelinfo p : persons){                                                     // 根据字典来改一些东西
				
				try {
				    hql = "from DictionLog where sid = '"+p.getPersonnelSex()+"'   ";

					DictionLog d = this.get(hql);					
					p.setPersonnelSex(d.getName());
				/*	getSession().beginTransaction().commit();*/
			
				    hql = "from DictionLog where sid = '"+p.getWedLock()+"'   ";
					d = this.get(hql);
					p.setWedLock(d.getName()); 
					 
					hql = "from DictionLog where sid = '"+p.getPolitic()+"'   ";
					d = this.get(hql);
					p.setPolitic(d.getName());  

					hql = "from DictionLog where sid = '"+p.getEngageForm()+"'   ";
					d = this.get(hql);
					p.setEngageForm(d.getName());  
				
					hql = "from DictionLog where sid = '"+p.getTipTopDegree()+"'   ";
					d = this.get(hql);
					p.setTipTopDegree(d.getName());  
					
					hql = "from DictionLog where sid = '"+p.getWorkState()+"'   ";
					d = this.get(hql);
					p.setWorkState(d.getName());  
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		
		
		return persons;
	}

	@Override
	public List<DictionLog> queryDictionInfos(String pId) {
		List<DictionLog> dictionLogs = new ArrayList<DictionLog>();
		dictionLogs = this.find("from DictionLog where pid = '"+pId+"'  ");
		return dictionLogs;
	}
	
	public static void main(String[] args) {
		PersonInfoDictionDAO pidDAO = new PersonInfoDictionDAO();
		List<DictionLog> dics = pidDAO.queryDictionInfos("1005");
		
		for(DictionLog d : dics){
			System.out.println(d.getName());
		}
	}

}
