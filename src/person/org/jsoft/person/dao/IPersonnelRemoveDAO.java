package org.jsoft.person.dao;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.Personnelremove;

/**  
 * <对于Personnelremove操作接口> 
 * @author xfd   
 * @version 创建时间：2014-10-8 下午6:43:37  
 */
public interface IPersonnelRemoveDAO extends IBaseDAO<Personnelremove> {
	
	/**
	 * 保存员工调动
	 * @param personnelRemove
	 */
	public void saveRemove(Personnelremove personnelRemove);
}
