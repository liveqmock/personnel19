package org.jsoft.system.service;


import java.util.List;

import org.jsoft.comm.vo.Menu;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;

public interface IOperaterService {
	/**
	 * 得到operater
	 * @param username
	 * @param password
	 * @return
	 */
	public Operater getOperaterByUP(String username,String password);

	/**
	 * 删除一条操作人员信息
	 * @param name(删除依据) value(依据的值)
	 */
	public void deleteOperater(String name,String value);
	/**
	 * 增加一条操作人员信息
	 * @param name(删除依据) value(依据的值)
	 */
	public void addOperater(String personnelNo,String opName,String opPassword,String operatertype);
	/**
	 * 删除一些操作人员信息
	 * @param String[] opIds 操作人员id
	 */
	public void deleteOperaters(String[] opIds);
	/**
	 * 根据用户id 得到用户
	 */
	public Operater getById(String opId);
	/**
	 * 跟新操作员密码
	 */
	public void updatePassword(String opId,String newPassword);
	/**
	 * 判断密码是否正确
	 */
	public boolean dpassword(String opId,String newPassword);
	/**
	 * 得到当前页的operaters
	 * @param PageDivid 
	 * @return List<Operater>
	 */
	public List<Operater> getOperatersByPageDivid(PageDivid pageDivid);
	/**
	 * 根据当前页得到PageDivid
	 * @param page 
	 * @return PageDivid
	 */
	public PageDivid getPageDividByPage(int page);
	/**
	 * 得到所有操作员的名字
	 * @return List<String>
	 */
	public List<String> getAllopNames();
}
