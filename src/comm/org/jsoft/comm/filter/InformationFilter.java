package org.jsoft.comm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.vo.Operater;

/**
 * Servlet Filter implementation class EncodeFilter
 */
public class InformationFilter implements Filter {
	
    /**
     * Default constructor. 
     */
    public InformationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		Operater operater = (Operater)req.getSession().getAttribute("operater");
		if(operater==null){
			res.sendRedirect("index.jsp");
			return;
		}else{
		if((!"员工资料".equals(operater.getPopedom()))&&(!"0".equals(operater.getPopedom()))){
			req.getRequestDispatcher("error.jsp").forward(req, res);
			return;
		}}
		// pass the request along the filter chain
		chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
