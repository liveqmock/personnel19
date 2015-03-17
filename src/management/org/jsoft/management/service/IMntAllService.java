package org.jsoft.management.service;

import java.util.List;
import java.util.Map;

import org.jsoft.comm.vo.Personnelinfo;

public interface IMntAllService {
	public abstract List<Personnelinfo> packAll();
	public abstract List<Personnelinfo> packSome(Map<String,String> m1,Map<String,String> m2);

}
