package org.jsoft.management.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;

public class managementJumpServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	public String jumpScore(HttpServletRequest req,HttpServletResponse resp) {
		
		return "jsps/management/mntScore.jsp";
	}
    public String jumpAll(HttpServletRequest req,HttpServletResponse resp) {
		
		return "jsps/management/mntAll.jsp";
	}
    public String lookAll(HttpServletRequest req,HttpServletResponse resp) {
		String n=req.getParameter("n");
		req.getSession().setAttribute("index",n);
		return "jsps/management/showAll.jsp";
	}
       
    
}
