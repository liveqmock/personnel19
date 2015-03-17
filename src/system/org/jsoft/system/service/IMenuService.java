package org.jsoft.system.service;
import java.util.List;

import org.jsoft.comm.vo.Menu;
public interface IMenuService{
	/**
	 * 得到所有的主菜单（其menus-子菜单已赋值）
	 * @return List<Menu>
	 *//*
	public List<Menu> getAllMenu();*/
	/**
	 * 删除一条菜单信息
	 * @param name(删除依据) value(依据的值)
	 */
	public void deleteMenu(String name,String value);
	/**
	 * 删除一些菜单信息
	 * @param String[] menuIds 
	 */
	public void deleteMenus(String[] menuIds);
	/**
	 * 增加一些菜单信息
	 * @param String men_menuId 
	 */
	public void addMenu(String men_menuId,String menuName,String menuUrl,String remark);
	
}
