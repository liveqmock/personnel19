package org.jsoft.management.service.impl;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.management.dao.impl.MntAllDao;
import org.jsoft.management.service.IMntAllService;


public class MntAllService implements IMntAllService {
	
	private List<Personnelinfo> persons=new ArrayList();
	private MntAllDao gdao=new MntAllDao();
	
	public List<Personnelinfo> packAll() {
		String hql="FROM Personnelinfo";
		persons=gdao.query(hql);
		return persons;
	}
	public List<Personnelinfo> packSome(Map<String,String> m1,Map<String,String> m2) {
		String hql="FROM Personnelinfo";
		if(m1.size()>0||m2.size()>0){
			hql=hql+" "+"WHERE";
		String[] name1=m1.keySet().toArray(new String[0]),
				 name2=m2.keySet().toArray(new String[0]),
		         value1=m1.values().toArray(new String[0]),
		         value2=m2.values().toArray(new String[0]);
		if(m1.size()>0)
		    for(int i=0;i<m1.size();i++)
		    	hql=hql+" "+name1[i]+"="+"'"+value1[i]+"'"+" "+"and";
		if(m2.size()>0)
			for(int i=0;i<m2.size();i=i+2)
				hql=hql+" "+name2[i].substring(0,name2[i].length()-1)+">"+"'"+value2[i]+"'"+" "+"and"+" "+name2[i].substring(0,name2[i].length()-1)+"<"+"'"+value2[i+1]+"'"+" "+"and";
		hql=hql.substring(0,hql.length()-4);
		}
		System.out.println("拼装的"+hql);
		persons=gdao.query(hql);
		return persons;
	}
}
