package org.jsoft.system.dao;

import java.util.List;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.Duty;
import org.jsoft.comm.vo.PageDivid;

public interface IDutyDAO extends IBaseDAO<Duty>{
	/**
	 * 根据分页查询职称
	 * @param pageDivid
	 * @return
	 */
	public List<Duty> query(PageDivid pageDivid);
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
	 * 增加一个职称
	 * @param duty
	 */
	public void add(Duty duty);
	/**
	 * 修改一个职称的信息
	 * @param duty
	 */
	public void updateDuty(Duty duty);
	/**
	 * 删除一个职称的信息
	 * @param duty
	 */
	public void dele(Duty duty);
	/**
	 * 根据id 得到一个职称的信息
	 * @param dutyId
	 */
	public Duty getDuty(String dutyId);
}
