package org.jsoft.comm.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.vo.Menu;
import org.jsoft.system.dao.impl.MenuDAO;

public class JumpServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public String top(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("top");
		return "jsps/comm/login/top.jsp";
	}
	
	public String center(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("center");
		return "jsps/comm/login/center.html";
	}
	
	public String down(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("down");
		return "jsps/comm/login/down.jsp";
	}
	public String left(HttpServletRequest req,HttpServletResponse resp) {
		MenuDAO menudao = new MenuDAO();
		List<Menu> menus = menudao.findAllMenu();
		List<Menu> menusons = menudao.findSonMenu();
		req.setAttribute("menus", menus);
		req.setAttribute("menusons", menusons);
		
		return "jsps/comm/login/left.jsp";
	}
	public String right(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("right");
		return "jsps/comm/login/right.jsp";
	}
}
