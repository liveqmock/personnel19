package org.jsoft.salary.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;

public class OtherServlet extends BaseServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String looking(HttpServletRequest req, HttpServletResponse resp)
	{
		System.out.println("就是和你一起慢慢变老，慢慢摇，我能想到最浪漫的是 就是和你一起慢慢变老 知道我们老的那里也去不了 你还把我当成 手心里的宝");
		return "jsps/salary/other/other.jsp";
	}
}
