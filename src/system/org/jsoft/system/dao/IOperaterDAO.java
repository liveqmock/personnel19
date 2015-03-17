package org.jsoft.system.dao;

import java.util.List;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.Personnelinfo;

public interface IOperaterDAO extends IBaseDAO<Operater>{
	/**
	 * 根据username  和password  返回operater  如果没有则返回null
	 * @param username
	 * @param password
	 * @return
	 */
	public Operater getOperater(String username,String password);
	/**
	 * 根据username  和password  返回operater  如果没有则返回null
	 * @param opName
	 * @return
	 */
	public Operater geOperaterByName(String opName);
	
	
	
	//我
	/**
	 * 查出所有的操作员的信息
	 * @return List<Operater>
	 */
	public List<Operater> getAllOperater();
	/**
	 * 查找一个操作员信息
	 * @param name(查找依据) value(依据的值)
	 * @return　Operater(若为空返回null)
	 */
	public Operater getOperaterByMessage(String name,String value);
	/**
	 * 增加一个operater
	 * @param operater
	 */
	public void addOperater(Operater operater);
	/**
	 * 更新一个operater
	 * @param operater
	 */
	public void updateOperater(Operater operater);
	
	/**
	 * 根据用户id得到用户
	 */
	public Operater getById(String opId);
}
