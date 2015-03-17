package org.jsoft.salary.dao.impl;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Encorchast;
import org.jsoft.salary.dao.IEncorchastDAO;

public class EncorchastDAO extends BaseDAO<Object> implements IEncorchastDAO{
	public void updateEncorchast(Encorchast encorchast){
		saveOrUpdate(encorchast);
	}
}
