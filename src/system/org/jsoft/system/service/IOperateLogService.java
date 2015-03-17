package org.jsoft.system.service;

import java.util.List;

import org.jsoft.comm.vo.OperateLog;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;



public interface IOperateLogService {
	/**
	 * 得到pagedivid
	 * @param page
	 * @return
	 */
	public PageDivid getPageDivid(String page);
/**
 * 查询所有的  并分页
 * @param pageDivid
 * @return
 */
	public List<OperateLog> queryAll(PageDivid pageDivid);
	/**
	 * 根据条件选择查询
	 * @param operaterName
	 * @param upDAte
	 * @param DownDate
	 * @param pageDivid
	 * @return
	 */
	public List<OperateLog> queryByElements(String operaterName,String upDAte,String DownDate,PageDivid pageDivid);
	/**
	 * 根据id查询
	 * @param operateLogId
	 * @return
	 */
	public OperateLog getById(String operateLogId);
	
	/**
	 * 插入一条记录
	 */
	public void add(Operater operater, String info);
}
