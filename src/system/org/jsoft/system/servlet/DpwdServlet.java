package org.jsoft.system.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.vo.Operater;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.OperaterService;

/**
 * Servlet implementation class DpwdServlet
 */
public class DpwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DpwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			System.out.println("ddjjdd");
			String password = request.getParameter("pwd");
			IOperaterService operaterService = new OperaterService();
			String opId = ((Operater)request.getSession().getAttribute("operater")).getOpId();
			boolean flag = operaterService.dpassword(opId, password);
			System.out.println(opId);
			System.out.println(password);
			PrintWriter out =response.getWriter();
			System.out.println(flag);
			out.print(flag);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
