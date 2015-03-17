package org.jsoft.management.dao.impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.management.dao.IPersonnelManagementDAO;

public class PersonnelManagementDAO extends BaseDAO implements IPersonnelManagementDAO {


	private String PERINFO="perInfo";
    private String hql;

	public List  findALL(String form,Map Params,PageDivid pg ){
		
		 //处理与数据库有关的操作，因此hql语句应该是在这里写的
		//查询员工基本资料表,工资表，工作表，部门表，	
		String hql=this.getAllHql(form, Params);	
       this.setHql(hql);
         int num=find(hql).size();
        pg.setNum(num);
        if((num%pg.getEachPageNum())!=0)
        	pg.setAllPage((num/pg.getEachPageNum())+1);
        else
        	pg.setAllPage(num/pg.getEachPageNum());
        System.out.println(pg.getAllPage()+"pages");
		 return this.find(hql, pg);
	}	
    public String getHql() {
		return hql;
	}
	public void setHql(String hql) {
		this.hql = hql;
	}
	public  String getAllHql(String form,Map Params)
    {   	
    	String hql="";
    	String temp="";  	
		String temp1="";
		System.out.println(form+"*********");
		
		if("isAll".equals(form)){
			return " from Personnelinfo where isDelete = 0 ORDER BY personnelNo ASC";
		}
		else
		{
			if("hasLow".equals(form))
			{
				temp1=" deptJobRel in (from DeptJobRel where isDelete = 0 and salary in (from Salary where isDelete = 0 and basicSalary >"+Params.get("salaryLow")+" )) ";
			}
			if("LowAndUp".equals(form))
			{
				temp1=" deptJobRel in (from DeptJobRel where isDelete = 0 and salary in (from Salary where isDelete = 0 and basicSalary >"+Params.get("salaryLow")+"and basicSalary < "+Params.get("salaryUp")+" )) ";
			}
			if("hasUp".equals(form))
			{
				temp1=" deptJobRel in (from DeptJobRel where  isDelete = 0 and salary in (from Salary where isDelete = 0 and basicSalary < "+Params.get("salaryUp")+")) ";
			}
    	  Iterator i = Params.entrySet().iterator();	
    	 while(i.hasNext())
    	{
    		Entry  entry=(Entry)i.next(); 		
		    Object key=entry.getKey();
		    Object value=entry.getValue();	   
		    if("username".equals(key))
		    {
		    	temp=" personnelName = '"+value+"' and isDelete= 0  and ";
		    }
		    if("sex".equals(key))
		    {
		    	temp=" personnelSex = '"+value+"' and isDelete= 0 and ";
		    }
		
		    if("department".equals(key))
		    {
		    	temp="deptJobRel in (from DeptJobRel where isDelete = 0 and  department in (from Department where departmentName='"+value+"' and isDelete =0 )) and ";
		    }
		    if("job".equals(key))
		    {
		    	temp="deptJobRel in (from DeptJobRel where  isDelete = 0 and  job in (from Job where jobName='"+value+"' and isDelete=0 )) and ";
		    }
	       hql=hql+temp;
		}
    	 if(hql.endsWith(" and "))
	      {
	    	  hql=hql.substring(0,hql.length()-5);
	      }
		if((!("".equals(temp1)))&&(!("".equals(hql))))
		{
			hql="from Personnelinfo where"+temp1+"and isDelete = 0 and "+hql;				
		}
		if("".equals(hql))
			hql="from Personnelinfo where isDelete = 0 and"+temp1;	
		if("".equals(temp1))
			hql="from Personnelinfo where isDelete = 0 and "+hql;		
		return hql;
	}
    }

   public Personnelinfo findPersonAllInfo(String  personId)
   {
	  String hql="from Personnelinfo where isDelete = 0 and personnelId = '"+personId+"' ";
	  Personnelinfo result=(Personnelinfo) get(hql);
	  return result;
   }
@Override
public List findAllInfo(PageDivid pg) {
	List result=new ArrayList();
	String hql=" from Personnelinfo where isDelete = 0 ORDER BY personnelNo ASC";
	setHql(hql);
	result=find(hql, pg);
	int num=find(hql).size();
	pg.setNum(num);
    if((num%pg.getEachPageNum())!=0)
    	pg.setAllPage((num/pg.getEachPageNum())+1);
    else
    	pg.setAllPage(num/pg.getEachPageNum());
    System.out.println(pg.getAllPage()+"pages");
	return result;
}




	

}
