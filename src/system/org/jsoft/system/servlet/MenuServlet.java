package org.jsoft.system.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Menu;
import org.jsoft.comm.vo.Operater;
import org.jsoft.system.dao.impl.MenuDAO;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.MenuService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

/**
 * Servlet implementation class MenuServlet
 */
public class MenuServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private OperateLogService operateLogService = new OperateLogService();
	private IOperaterService operaterService = new OperaterService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public String allmenu(HttpServletRequest req, HttpServletResponse resp) {
		MenuDAO menudao = new MenuDAO();
		List<Menu> menus = menudao.findAllMenu();
		List<Menu> menusons = menudao.findSonMenu();
		req.setAttribute("menus", menus);
		req.setAttribute("menusons", menusons);
		return "jsps/comm/login/left.jsp";
	}

	public String managemenu(HttpServletRequest req, HttpServletResponse resp) {
		MenuDAO menudao = new MenuDAO();
		List<Menu> menus = menudao.findAllMenu();
		List<Menu> menusons = menudao.findSonMenu();
		req.setAttribute("menus", menus);
		req.setAttribute("menusons", menusons);
		/*
		 * 日志 String info = "查看了系统管理";
		 * operateLogService.add(operaterService.getById(((Operater) req
		 * .getSession().getAttribute("operater")).getOpId()), info); 日志
		 */
		return "jsps/system/menu/managemenu.jsp";
	}

	public String delmenus(HttpServletRequest req, HttpServletResponse resp) {
		String[] menuIds = req.getParameterValues("checkbox");
		MenuService menuService = new MenuService();
		MenuDAO menudao = new MenuDAO();
		System.out.println(menuIds[0]);
		/* 日志 */
		String info = "删除了菜单：";
		for (int i = 0; i < menuIds.length; i++) {
			info = info + menudao.findMenu("menuId", menuIds[i]).getMenuName();
		}
		operateLogService.add(operaterService.getById(((Operater) req
				.getSession().getAttribute("operater")).getOpId()), info);
		/* 日志 */
		menuService.deleteMenus(menuIds);

		return redirPath + "menu.sys?method=managemenu";
	}

	public String jumpAddMenu(HttpServletRequest req, HttpServletResponse resp) {
		MenuDAO menudao = new MenuDAO();
		List<Menu> menus = menudao.findAllMenu();
		MenuService menuService = new MenuService();
		String menuRels = "";
		String mainmenus = "";
		if (menus.size() != 0) {
			menuRels = menus.get(0).getMenuName();
			mainmenus = menus.get(0).getMenuName();
			for (Iterator iterator = menus.get(0).getMenus().iterator(); iterator
					.hasNext();) {
				Menu menu = (Menu) iterator.next();
				menuRels = menuRels + "," + menu.getMenuName();
			}
			if (menus.size() > 1) {
				for (int i = 1; i < menus.size(); i++) {
					menuRels = menuRels + "." + menus.get(i).getMenuName();
					mainmenus = mainmenus + "," + menus.get(i).getMenuName();
					for (Iterator iterator = menus.get(i).getMenus().iterator(); iterator
							.hasNext();) {
						Menu menu = (Menu) iterator.next();
						menuRels = menuRels + "," + menu.getMenuName();
					}
				}
			}
		}
		req.setAttribute("menuRels", menuRels);
		req.setAttribute("mainmenus", mainmenus);
		req.setAttribute("menus", menus);
		return "jsps/system/menu/addmenu.jsp";

	}

	public String addMenu(HttpServletRequest req, HttpServletResponse resp) {
		String men_menuId = req.getParameter("men_menuId");
		String menuName = req.getParameter("menuName");
		String menuUrl = req.getParameter("menuUrl");
		String remark = req.getParameter("remark");
		MenuService menuService = new MenuService();
		menuService.addMenu(men_menuId, menuName, menuUrl, remark);
		/* 日志 */
		String info = "添加了菜单：" + menuName;
		operateLogService.add(operaterService.getById(((Operater) req
				.getSession().getAttribute("operater")).getOpId()), info);
		/* 日志 */
		return redirPath + "menu.sys?method=managemenu";

	}
	public String menuUrl404(HttpServletRequest req, HttpServletResponse resp) {
		
		return "jsps/system/menu/menuerror.jsp";
		
	}
}
