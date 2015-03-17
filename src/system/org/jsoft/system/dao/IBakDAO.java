package org.jsoft.system.dao;



import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.Bak;
import org.jsoft.comm.vo.PageDivid;



public interface IBakDAO extends IBaseDAO<Bak>{
	/**
	 * 查询所有的备份信息
	 * @return
	 */
	public List<Bak> queryAll();
	
	/**
	 * 根据分页信息查询所有的备份信息
	 */
	public List<Bak> queryAll(PageDivid pageDivid);
	
	/**
	 * 查询总数据数
	 */
	
	public int AllCount();
	/**
	 * 查询总数据数
	 */
	
	public int AllCountByElement(String hql,List<Object> paraments);
	
	/**
	 * 添加一条信息
	 */
	public void add(Bak bak);
	
	/**
	 * 根据  id 修改数据
	 * 
	 */
	
	public void updateBak(Bak bak);
	/**
	 * 根据可变参数查询
	 * @param paraments
	 * @return
	 */
	public List<Bak> getBakByParaments(String operaterName,Timestamp upDate,Timestamp downDate,PageDivid pageDivid);
}
