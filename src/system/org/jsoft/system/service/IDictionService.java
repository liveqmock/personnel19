package org.jsoft.system.service;

import java.util.List;

import org.jsoft.comm.vo.DictionLog;

public interface IDictionService {
public List<DictionLog> getAllFathers();
public List<DictionLog> getAllSons();
public void addAFather(DictionLog dl);
public void updateAFather(String sid,String name,String remark);
public void addsons(List<DictionLog> sons,String fatherName) ;
public void fatherDelete(String sid);
public void delSon(String sid);
public void modSon(String sid,String name,String remark);
public DictionLog getOneItem(String sid);
}
