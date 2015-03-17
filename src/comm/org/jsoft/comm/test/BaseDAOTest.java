package org.jsoft.comm.test;

import org.jsoft.comm.dao.impl.BaseDAO;

import junit.framework.TestCase;

public class BaseDAOTest extends TestCase {
	private BaseDAO baseDAO=new BaseDAO();
	public void testGetSession() {
		assertNotNull(baseDAO.getSession());
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

}
