package org.jsoft.system.dao;

import java.sql.Timestamp;
import java.util.List;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.OperateLog;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;

public interface IOperateLogDAO extends IBaseDAO<OperateLog> {
	/**
	 * 增加一条新记录
	 * 
	 * @param operater
	 *            操作员对象
	 * @param info
	 *            日志信息
	 */
	void add(Operater operater, String info);

	/**
	 * 删除一条记录
	 * 
	 * @param log
	 */
	public void del(String operateLogId);

	/**
	 * 查看所有日志
	 * 
	 * @return
	 */
	public List<OperateLog> queryAll();

	/**
	 * 根据分页查询所有日志
	 * 
	 * @param pageDivid
	 * @return
	 */
	public List<OperateLog> queryALL(PageDivid pageDivid);
	/**
	 * 记录查询数据的树木
	 * @return
	 */
	public int account();
/**
 * 得到查询的树木
 * @param sql
 * @param paraments
 * @return
 */
	public int account(String sql,List<Object> paraments);
	/**
	 * 根据可变参数查询
	 * @param operaterName
	 * @param upDate
	 * @param downDate
	 * @param pageDivid
	 * @return
	 */
	public List<OperateLog> queryByElement(String operaterName,Timestamp upDate,Timestamp downDate,PageDivid pageDivid);
	
	public OperateLog getById(String id);
	// /**
	// * 根据时间查看所有日志
	// *
	// * @param date
	// * 查询日期
	// * @return
	// */
	// public List<OperateLog> queryByDate(Date date);
	//
	// /**
	// * 根据操作员ID查看所有操作记录
	// *
	// * @param operateLogId
	// * 操作员ID
	// * @param pageDivid
	// * 显示页码
	// * @return
	// */
	// public List<OperateLog> queryByOperater(String operateLogId, PageDivid
	// pageDivid);

}
