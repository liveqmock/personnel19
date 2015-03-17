package org.jsoft.person.dao;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.Personneladjustsalary;

/**  
 * <关于员工调薪表的DAO的接口> 
 * @author xfd   
 * @version 创建时间：2014-9-27 下午3:40:42  
 * @param <T>
 */
public interface IPersonneladjustsalaryDAO extends IBaseDAO<Personneladjustsalary> {
	/**
	 * @param personAdjustSalary
	 */
	public void addPersonAdjustSalary(Personneladjustsalary personAdjustSalary);

}
