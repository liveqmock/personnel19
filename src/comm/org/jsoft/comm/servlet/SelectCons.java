package org.jsoft.comm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectCons
 */
public class SelectCons extends BaseServlet {
	private static final long serialVersionUID = 1L;
       

    public String selectcons(HttpServletRequest req,HttpServletResponse resp) {
        System.out.println("cons");
    	return "jsps/comm/loadexcel/selectCons.jsp";
    
    }

	
	

}
