package org.jsoft.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jsoft.comm.vo.Menu;
import org.jsoft.comm.vo.Operater;
import org.jsoft.system.dao.impl.MenuDAO;
import org.jsoft.system.service.IMenuService;

public class MenuService implements IMenuService{
	private MenuDAO menudao=new MenuDAO();
	/*@Override
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		List<Menu> menus=menudao.findAllMenu();
		for (int i = 0; i < menus.size(); i++) {
			String men_menuId=menus.get(i).getMenuId();
			Set<Menu> sonmenus=menudao.findSonMenu(men_menuId);
			menus.get(i).setMenus(sonmenus);
		}
		return menus;
	}*/
	@Override
	public void deleteMenu(String name,String value) {
		// TODO Auto-generated method stub
		Menu menu=new Menu();
		menu=menudao.findMenu(name,value);
		menu.setIsDelete(1);
		menudao.updateMenu(menu);
	}
	@Override
	public void deleteMenus(String[] menuIds) {
		// TODO Auto-generated method stub
		MenuService menuService=new MenuService();
		for (int i = 0; i < menuIds.length; i++) {
			menuService.deleteMenu("menuId", menuIds[i]);
		}
	}
	public static void main(String[] args) {
		MenuService menuser=new MenuService();
		/*List<Menu> menus=menuser.getAllMenu();
		for (int i = 0; i < menus.size(); i++) {
			System.out.println(menus.get(i).getMenuName());//得到主菜单
			Set<Menu> sonmenus=menus.get(i).getMenus();
			for (Iterator iterator = sonmenus.iterator(); iterator.hasNext();) {
				Menu menu = (Menu) iterator.next();
				System.out.println(menu.getMenuName());//得到子菜单
			}
			System.out.println("**************************");
		}*/
		
		menuser.deleteMenu("menuId","10001");
	}
	@Override
	public void addMenu(String men_menuId, String menuName, String menuUrl,
			String remark) {
		// TODO Auto-generated method stub
		MenuDAO menuDAO=new MenuDAO();
		Menu fmenu =new Menu();
		Menu menu =new Menu();
		fmenu=menuDAO.findMenu("menuId", men_menuId);
		menu.setIsDelete(0);
		menu.setMenuName(menuName);
		menu.setMenuUrl(menuUrl);
		menu.setRemark(remark);
		menu.setMenu(fmenu);
		menuDAO.saveMenu(menu);
	}	
	
}
