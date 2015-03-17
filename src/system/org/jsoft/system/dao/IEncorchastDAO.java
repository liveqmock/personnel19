package org.jsoft.system.dao;

import java.util.List;

import org.jsoft.comm.dao.IBaseDAO;

import org.jsoft.comm.vo.Encorchast;
import org.jsoft.comm.vo.PageDivid;

public interface IEncorchastDAO extends IBaseDAO<Encorchast> {
	/**
	 * 根据分页查询职称
	 * @param pageDivid
	 * @return
	 */
	public List<Encorchast> query(PageDivid pageDivid);
	/**
	 * 查询所有信息的条数
	 * @return
	 */
	public int Allcount();
	/**
	 * 根据条件查询所有条数
	 * @param hql
	 * @param paraments
	 * @return
	 */
	public int Allcount(String hql,List<Object> paraments);
	/**
	 * 增加一个奖惩规则
	 * @param encorchast
	 */
	public void add(Encorchast encorchast);
	/**
	 * 修改一个奖惩规则的信息
	 * @param encorchast
	 */
	public void updateencorchast(Encorchast encorchast);
	/**
	 * 删除一个奖惩规则的信息
	 * @param encorchast
	 */
	public void dele(Encorchast encorchast);
	/**
	 * 根据id 得到一个奖惩规则的信息
	 * @param encorchastId
	 */
	public Encorchast getencorchast(String encorchastId);
}
