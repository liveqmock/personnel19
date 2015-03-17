package org.jsoft.system.dao;

import java.util.List;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.DictionLog;

public interface IDictionDAO<DictionLog> extends IBaseDAO<DictionLog>{
	
	public List<DictionLog> getAllFathers();//得到所有的父选项信息
	
	public List<DictionLog> getAllSons();//得到所有父類的子項
	
	public DictionLog queryBySid(String sid);//根据sid查询字典中的一项
	   
	public List<DictionLog> querySonsById(String sid);//根据父类的sid查找所有子类
	    
	public DictionLog queryByName(String name);//根据名字查询字典中的一项

	public List<DictionLog> querySonsByName(String name);//根据父类的名字查找所有子类
    
	public void add(DictionLog dictionlog);//在字典中增加一项
	
	public void addSons(List<DictionLog> sons);//为父项增加一批子项
     
	public void deleteSonsById(String sid);//根据父类的sid删除子类
	
	public void deleteBySid(String sid);//根据sid删除字典中的一项(如果是父id则级联删除)
	
	public void deleteByName(String name);//根据名字删除字典中的一项
	
	public void deleteByObject(DictionLog dictionlog);//根据DictionLog对象删除字典中的一项

	public void update(DictionLog dictionlog);//根据DictionLog对象修改字典中的一项

   }
