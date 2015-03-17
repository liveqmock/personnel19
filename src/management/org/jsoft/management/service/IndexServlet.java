package org.jsoft.management.service;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



public class IndexServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String login(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("list");
	//	List users=userDAO.queryList();
	//	req.setAttribute("users", users);
		return "jsps/login/login.jsp";
	}

}
