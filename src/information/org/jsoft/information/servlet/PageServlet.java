package org.jsoft.information.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Peoc;
import org.jsoft.comm.vo.Personneladjustsalary;
import org.jsoft.comm.vo.Personnelappraise;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.comm.vo.Personnelremove;
import org.jsoft.comm.vo.Personneltrain;
import org.jsoft.comm.vo.Salary;
import org.jsoft.information.service.PageService;
import org.jsoft.information.vo.Page;
public class PageServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	public String paging(HttpServletRequest req, HttpServletResponse resp) {
		PageService pageService = new PageService();
		String way = req.getParameter("way");
		Page page = (Page) req.getSession().getAttribute("page");
		int curPage = Integer.valueOf(req.getParameter("curPage"));
		List<Personnelinfo> showPersonInfo= (List<Personnelinfo>) req.getSession()
				.getAttribute("showPersonInfo");
		List<Personnelinfo> personInfo = (List<Personnelinfo>) req.getSession().getAttribute(
				"personInfo");
		try {
			pageService.getShowPage(page, showPersonInfo, personInfo, curPage,way);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			return "jsps/information/inc/error.jsp";
		}
		req.getSession().setAttribute("page", page);
		req.getSession().setAttribute("personInfo", personInfo);
		return "jsps/information/personInfo.jsp";
	}
	@SuppressWarnings("unchecked")
	public String pagingTrain(HttpServletRequest req, HttpServletResponse resp) {
		PageService pageService = new PageService();
		String way = req.getParameter("way");
		Page page = (Page) req.getSession().getAttribute("page");
		int curPage = Integer.valueOf(req.getParameter("curPage"));
		List<Personneltrain> showPersonTrain= (List<Personneltrain>) req.getSession()
				.getAttribute("showPersonTrain");
		List<Personneltrain> personTrain = (List<Personneltrain>) req.getSession().getAttribute(
				"personTrain");
		try {
			pageService.getShowPage(page, showPersonTrain, personTrain, curPage,way);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			return "jsps/information/inc/error.jsp";
		}
		req.getSession().setAttribute("page", page);
		req.getSession().setAttribute("personTrain", personTrain);
		return "jsps/information/personTrain.jsp";
	}
	
	@SuppressWarnings("unchecked")
	public String pagingAppraise(HttpServletRequest req, HttpServletResponse resp) {
		PageService pageService = new PageService();
		String way = req.getParameter("way");
		Page page = (Page) req.getSession().getAttribute("page");
		int curPage = Integer.valueOf(req.getParameter("curPage"));
		List<Personnelappraise> showPersonAppraise= (List<Personnelappraise>) req.getSession()
				.getAttribute("showPersonAppraise");
		List<Personnelappraise> personAppraise = (List<Personnelappraise>) req.getSession().getAttribute(
				"personAppraise");
		try {
			pageService.getShowPage(page, showPersonAppraise, personAppraise, curPage,way);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			return "jsps/information/inc/error.jsp";
		}
		req.getSession().setAttribute("page", page);
		req.getSession().setAttribute("personAppraise", personAppraise);
		return "jsps/information/personAppraise.jsp";
	}
	
	@SuppressWarnings("unchecked")
	public String pagingSalary(HttpServletRequest req, HttpServletResponse resp) {
		PageService pageService = new PageService();
		String way = req.getParameter("way");
		Page page = (Page) req.getSession().getAttribute("page");
		int curPage = Integer.valueOf(req.getParameter("curPage"));
		List<Personneladjustsalary> showPersonSalary= (List<Personneladjustsalary>) req.getSession()
				.getAttribute("showPersonSalary");
		List<Personneladjustsalary> personSalary = (List<Personneladjustsalary>) req.getSession().getAttribute(
				"personSalary");
		try {
			pageService.getShowPage(page, showPersonSalary, personSalary, curPage,way);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			return "jsps/information/inc/error.jsp";
		}
		req.getSession().setAttribute("page", page);
		req.getSession().setAttribute("personSalary", personSalary);
		return "jsps/information/personSalary.jsp";
	}
	
	@SuppressWarnings("unchecked")
	public String pagingRemove(HttpServletRequest req, HttpServletResponse resp) {
		PageService pageService = new PageService();
		String way = req.getParameter("way");
		Page page = (Page) req.getSession().getAttribute("page");
		int curPage = Integer.valueOf(req.getParameter("curPage"));
		List<Personnelremove> showPersonRemove= (List<Personnelremove>) req.getSession()
				.getAttribute("showPersonRemove");
		List<Personnelremove> personRemove = (List<Personnelremove>) req.getSession().getAttribute(
				"personRemove");
		try {
			pageService.getShowPage(page, showPersonRemove, personRemove, curPage,way);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			return "jsps/information/inc/error.jsp";
		}
		req.getSession().setAttribute("page", page);
		req.getSession().setAttribute("personRemove", personRemove);
		return "jsps/information/personRemove.jsp";
	}
	
	@SuppressWarnings("unchecked")
	public String pagingSal(HttpServletRequest req, HttpServletResponse resp) {
		PageService pageService = new PageService();
		String way = req.getParameter("way");
		Page page = (Page) req.getSession().getAttribute("page");
		int curPage = Integer.valueOf(req.getParameter("curPage"));
		List<Salary> showPersonSal= (List<Salary>) req.getSession()
				.getAttribute("showPersonSal");
		List<Salary> personSal = (List<Salary>) req.getSession().getAttribute(
				"personSal");
		try {
			pageService.getShowPage(page, showPersonSal, personSal, curPage,way);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			return "jsps/information/inc/error.jsp";
		}
		req.getSession().setAttribute("page", page);
		req.getSession().setAttribute("personSal", personSal);
		return "jsps/information/personSal.jsp";
	}
	
	@SuppressWarnings("unchecked")
	public String pagingEn(HttpServletRequest req, HttpServletResponse resp) {
		PageService pageService = new PageService();
		String way = req.getParameter("way");
		Page page = (Page) req.getSession().getAttribute("page");
		int curPage = Integer.valueOf(req.getParameter("curPage"));
		List<Peoc> showPersonEn= (List<Peoc>) req.getSession()
				.getAttribute("showPersonEn");
		List<Peoc> personEn = (List<Peoc>) req.getSession().getAttribute(
				"personEn");
		try {
			pageService.getShowPage(page, showPersonEn, personEn, curPage,way);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			return "jsps/information/inc/error.jsp";
		}
		req.getSession().setAttribute("page", page);
		req.getSession().setAttribute("personEn", personEn);
		return "jsps/information/personEn.jsp";
	}
	
}
