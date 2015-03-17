package org.jsoft.system.service.impl;

import org.jsoft.system.service.IBakService;
import org.jsoft.system.service.IInitDataBaseService;

public class InitDataBaseService implements IInitDataBaseService{

	@Override
	public void initDateBase(String path) {
		// TODO Auto-generated method stub
		IBakService bakService = new BakService();
		bakService.restore(path, "personnel.sql");
	}
	
}
