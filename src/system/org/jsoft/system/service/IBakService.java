package org.jsoft.system.service;

import java.sql.Timestamp;
import java.util.List;

import org.jsoft.comm.vo.Bak;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;

public interface IBakService {
	/**
	 * 查询第一页的记录
	 */
	public List<Bak> queryFistPage();
	
	/**
	 * 查询第n页的信息
	 */
	public List<Bak> queryNPage(int page);
	
	/**
	 * 根据前台的page 进行封装或者查询
	 */
	public List<Bak> query(String page);
	
	/**
	 * 得到一个pagedivide
	 */
	public PageDivid getPageDivide(String page);
	
	/**
	 * 查询的信息  根据pagedivide
	 */
	public List<Bak> queryNPage(PageDivid pageDivid);
	
	/**
	 * 备份数据库数据
	 */
	public void bak(String path,String fileName);
	/**
	 * 备份改名
	 */
	public void rename(String path,String fileName,String oldName);
	
	/**
	 * 还原数据库数据  
	 *
	 */
	
	public void restore(String path,String filename);
	
	/**
	 * 插入备份信息
	 */
	public void add(Bak bak,Operater operater);
	/**
	 * 插入数据
	 * @param bakRemark
	 * @param fileName
	 * @param operater
	 */
	public void add(String bakRemark,String fileName,Operater operater);
	
	/**
	 * 修改数据
	 */
	public void updateBak(String bakId,Operater operater,String remark,Timestamp date,String path);
	
	/**
	 * 伪删除
	 */
	public String deleteLie(String bakId,String username);
	/**
	 * 删除
	 */
	public void deleteBak(String bakId);
	/**
	 * 备份并插入数据
	 */
	public void bakAndAdd(String path,String remark,String fileName,Operater operater);

	/**
	 * 根据时间  备份人员 查询 时间内的备份列表
	 */
	public List<Bak> queryByElements(String operaterName,String upDAte,String DownDate,PageDivid pageDivid);

	public Bak getBakById(String bakId);
	/**
	 * 更改
	 * @param bakId
	 */
	public void editBakById(String bakId,String path,String bakRemark,String fileName);
	/**
	 * 批量删除
	 * @param checkbox
	 * @param username
	 */
	public void delLieSome(String[] checkbox,String username);
	
	/*public void reStart();*/
}
