package org.jsoft.person.dao.impl;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Personnelremove;
import org.jsoft.person.dao.IPersonnelRemoveDAO;

/**  
 * <对于Personnelremove操作实现类> 
 * @author xfd   
 * @version 创建时间：2014-10-8 下午6:51:19  
 */
public class PersonnelRemoveDAO extends BaseDAO<Personnelremove> implements IPersonnelRemoveDAO {

	@Override
	public void saveRemove(Personnelremove personnelRemove) {
		// TODO Auto-generated method stub
		save(personnelRemove);
	}

	

}
