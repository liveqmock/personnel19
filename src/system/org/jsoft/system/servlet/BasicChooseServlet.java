package org.jsoft.system.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Department;

public class BasicChooseServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String jumpDept(HttpServletRequest req,HttpServletResponse resp) {
		return "jsps/system/basic/dept/deptQuery.jsp";
	}
	public String jumpBasic(HttpServletRequest req,HttpServletResponse resp) {
		return "jsps/system/basic/basicChoose.jsp";
	}

}
