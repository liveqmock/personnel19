package org.jsoft.management.test;

import java.util.List;

import org.jsoft.management.dao.impl.PersonnelRecordsDAO;

import junit.framework.TestCase;

public class PersonnelRecordsDAOTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testFindAllRecords() {
		fail("Not yet implemented");
	}

	public void testFindRecordsByStartDate() {
		fail("Not yet implemented");
	}

	public void testGetDateNameByTableName() {
		fail("Not yet implemented");
	}

	public void testSetPage() {
		fail("Not yet implemented");
	}

	public void testFindRecords() {
		fail("Not yet implemented");
	}

	public void testFindRecordsByEndDate() {
		fail("Not yet implemented");
	}

	public void testFindRecordsByStartDateAndEndDate() {
		fail("Not yet implemented");
	}

	public void testFindRecordsByDepartment() {
		fail("Not yet implemented");
	}

	public void testFindRecordsByDepartmentAndStartDate() {
		fail("Not yet implemented");
	}

	public void testFindRecordsByDepartmentAndEndDate() {
		fail("Not yet implemented");
	}

	public void testFindRecordsByDepartmentAndStartDateAndEndDate() {
		fail("Not yet implemented");
	}

	public void testGetDepartmentHql() {
		fail("Not yet implemented");
	}

	public void testFindAllPersonnelRecords() {
		fail("Not yet implemented");
	}

	public void testFindPersonAllRecordsById() {
		PersonnelRecordsDAO prdao=new PersonnelRecordsDAO();
		List temp1=prdao.findPersonAllRecordsById("1", "Personneladjustsalary");
	  List temp2=prdao.findPersonAllRecordsById("1", "Personneltrain");
	  for (int i = 0; i < temp1.size(); i++) {
		System.out.println("temp1**"+temp1.get(i).toString());		  
	}
	  for (int i = 0; i < temp2.size(); i++) {
			System.out.println("temp2**"+temp2.get(i).toString());		  
		}
	}

	public void testGetSession() {
		fail("Not yet implemented");
	}

	public void testCloseSession() {
		fail("Not yet implemented");
	}

	public void testSave() {
		fail("Not yet implemented");
	}

	public void testUpdate() {
		fail("Not yet implemented");
	}

	public void testDelete() {
		fail("Not yet implemented");
	}

	public void testSaveOrUpdate() {
		fail("Not yet implemented");
	}

	public void testFindString() {
		fail("Not yet implemented");
	}

	public void testFindStringListOfObject() {
		fail("Not yet implemented");
	}

	public void testFindStringPageDivid() {
		fail("Not yet implemented");
	}

	public void testFindStringListOfObjectPageDivid() {
		fail("Not yet implemented");
	}

	public void testGetClassOfTSerializable() {
		fail("Not yet implemented");
	}

	public void testGetString() {
		fail("Not yet implemented");
	}

	public void testGetStringListOfObject() {
		fail("Not yet implemented");
	}

	public void testCountString() {
		fail("Not yet implemented");
	}

	public void testCountStringListOfObject() {
		fail("Not yet implemented");
	}

	public void testObject() {
		fail("Not yet implemented");
	}

	public void testGetClass() {
		fail("Not yet implemented");
	}

	public void testHashCode() {
		fail("Not yet implemented");
	}

	public void testEquals() {
		fail("Not yet implemented");
	}

	public void testClone() {
		fail("Not yet implemented");
	}

	public void testToString() {
		fail("Not yet implemented");
	}

	public void testNotify() {
		fail("Not yet implemented");
	}

	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	public void testWaitLong() {
		fail("Not yet implemented");
	}

	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	public void testWait() {
		fail("Not yet implemented");
	}

	public void testFinalize() {
		fail("Not yet implemented");
	}

}
