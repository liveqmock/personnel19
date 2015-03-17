package org.jsoft.person.dao.impl;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Personneladjustsalary;
import org.jsoft.person.dao.IPersonneladjustsalaryDAO;

/**  
 * <关于员工调薪表的DAO的实现> 
 * @author xfd   
 * @version 创建时间：2014-9-27 下午3:42:56  
 */
public class PersonneladjustsalaryDAO extends BaseDAO<Personneladjustsalary> implements IPersonneladjustsalaryDAO {

	@Override
	public void addPersonAdjustSalary(Personneladjustsalary personAdjustSalary) {
		// TODO Auto-generated method stub
		save(personAdjustSalary);
	}

}
