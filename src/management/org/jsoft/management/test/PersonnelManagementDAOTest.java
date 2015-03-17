package org.jsoft.management.test;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.management.dao.impl.PersonnelManagementDAO;

import junit.framework.TestCase;

public class PersonnelManagementDAOTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testFindALL() {
		Map PersonnelTemp =new HashMap();
		Map SalaryTemp =new HashMap();
		Map DepartmentTemp =new HashMap();
		Map JobTemp =new HashMap();
		Map PramsOrder=new HashMap();
		PersonnelTemp.put("personnelName", "lusy");
		SalaryTemp.put("basicSalary", 3000);
		DepartmentTemp.put("departmentName", "develop");
		JobTemp.put("jobName", "助理");
		/*PramsOrder.put("salary", "ASC");*/
	
		PersonnelManagementDAO pmDAO=new PersonnelManagementDAO();
		/*assertNotSame(0, pmDAO.findALL(PersonnelTemp, SalaryTemp, DepartmentTemp, JobTemp,PramsOrder));
	
		List result=pmDAO.findALL(PersonnelTemp, SalaryTemp, DepartmentTemp, JobTemp,PramsOrder);*/
		
		/*for (int i = 0; i < result.size(); i++) {
			Personnelinfo p=(Personnelinfo) result.get(i);
			System.out.println(p.getPersonnelName());
		}*/
    
	
	}
	
		
		
		
	
	public void testGetHql() {
		
	}

}
