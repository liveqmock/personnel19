package org.jsoft.management.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoft.comm.vo.PageDivid;
import org.jsoft.management.dao.impl.PersonnelManagementDAO;


public class PersonnelCommMethod {

	//得到jsp页面的参数
	public Object getParams( HttpServletRequest req, String Name) {
              Object  value=req.getParameter(Name);
               System.out.println(Name+":"+value);
               return value;
		
	}
	
	//若该参数不为空，则将其加入map中	
	public void addIntoMap(Object param, String Name,Map map) {
	     if((param!="")&&(param!=null))
	    	 map.put(Name, param);
	
	}
	

	
	
}
