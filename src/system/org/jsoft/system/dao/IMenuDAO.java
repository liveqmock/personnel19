package org.jsoft.system.dao;
import java.util.List;
import java.util.Set;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.Menu;
public interface IMenuDAO extends IBaseDAO<Menu>{
	/**
	 * 增加一条菜单信息
	 * @param Menu
	 */
	public void saveMenu(Menu menu);
	/**
	 * 修改一条菜单信息
	 * @param Menu
	 */
	public void updateMenu(Menu menu);
	/**
	 * 查找一条菜单信息
	 * @param name(查找依据) value(依据的值)
	 * @return　Menu(若为空返回null)
	 */
	public Menu findMenu(String name,String value);
	/**
	 * 查找所有子菜单
	 * @param Menu
	 */
	public List<Menu> findSonMenu();
	/**
	 * 查询所有主菜单
	 * @return List<Menu>
	 */
	public List<Menu> findAllMenu();
}
