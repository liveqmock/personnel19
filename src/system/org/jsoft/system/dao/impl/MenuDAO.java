package org.jsoft.system.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Bak;
import org.jsoft.comm.vo.Menu;
import org.jsoft.comm.vo.OperateLog;
import org.jsoft.system.dao.IMenuDAO;

public class MenuDAO extends BaseDAO<Menu> implements IMenuDAO{
    BaseDAO baseDao=new BaseDAO();
    @Override
	public void saveMenu(Menu menu) {
		// TODO Auto-generated method stub
    	baseDao.save(menu);
	}
	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		baseDao.update(menu);
	}
	@Override
	public Menu findMenu(String name,String value) {
		// TODO Auto-generated method stub
		String hql = "From Menu where isDelete=? and "+name+"='"+value+"'";
		List<Object> paraments = new  ArrayList<Object>();
		paraments.add(0);
		Menu menu=new Menu();
		List<Menu> menus=find(hql, paraments);
		if(menus.size()!=0){
			menu = menus.get(0)	;
		}else{
			menu=null;
		}
		return menu;
	}
	@Override
	public List<Menu> findSonMenu() {
		// TODO Auto-generated method stub
		String hql = "From Menu where isDelete=? and menu!=null";
		List<Object> paraments = new  ArrayList<Object>();
		paraments.add(0);
		List<Menu> menus = find(hql, paraments);
		return menus;
	}
	@Override
	public List<Menu> findAllMenu() {
		// TODO Auto-generated method stub
		String hql = "From Menu where isDelete=? and menu=null";
		List<Object> paraments = new  ArrayList<Object>();
		paraments.add(0);
		List<Menu> menus = find(hql, paraments);
		return menus;
	}
	public static void main(String[] args) {
		//updateMenu测试
		/*Menu menu=new Menu();
		menu.setMenuId("10001");
		menu.setMenuName("员工资料管理");
		menu.setIsDelete(1);
		menudao.update(menu);*/
		MenuDAO menudao=new MenuDAO();
		/*Menu menu=menudao.findMenu("1000"); //对findMenu的测试
		System.out.println(menu);
		List<Menu> menus=menudao.findAllMenu();//对findAllMenu的测试
		for (int i = 0; i < menus.size(); i++) {
			System.out.println(menus.get(i).getMenuName());
		}*/
		//对save的测试
		//Menu menu=new Menu();
		/*menu.setMenuId("1000000");
		menudao.save(menu);*/
		//对findMenu的测试
		/*menu=menudao.findMenu("menuId", "10001");
		System.out.println(menu.getMenuName());*/
		/*Menu menu=menudao.findMenu("menuId", "10001");
		System.out.println(menu.getMenuName());
		Set menus=menu.getMenus();
		for (Iterator iterator = menus.iterator(); iterator.hasNext();) {
			Menu menu1 = (Menu) iterator.next();
			System.out.println(menu1.getMenuName());		
		}*/
		List<Menu> menus=menudao.findAllMenu();
		for (int i = 0; i < menus.size(); i++) {
			System.out.println(menus.get(i).getMenuName());
			Set<Menu> menusset=menus.get(i).getMenus();
			for (Iterator iterator = menusset.iterator(); iterator.hasNext();) {
				Menu menu = (Menu) iterator.next();
				System.out.println(menu.getMenuName());
			}
		}
	}


}
