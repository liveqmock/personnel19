package org.jsoft.information.servlet;

import java.util.ArrayList;
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
import org.jsoft.information.service.UserService;
import org.jsoft.information.vo.Page;

public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	public String queryAll(HttpServletRequest req, HttpServletResponse resp) {
		UserService userService = new UserService();
		PageService pageService = new PageService();
		Page page = new Page();
		String way = req.getParameter("way");
		List<Personnelinfo> personInfo = null;
		List<Personnelinfo> showPersonInfo = new ArrayList<Personnelinfo>();
		req.getSession().setAttribute("showPersonInfo", showPersonInfo);
		try {
			personInfo = userService.queryAll();
			pageService.setPage(page,personInfo);
			pageService.getShowPage(page, showPersonInfo, personInfo, page.getCurPage(), way);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			return "jsps/information/inc/error.jsp";
		}
		req.getSession().setAttribute("flag","Yes");
		req.getSession().setAttribute("page", page);
		req.getSession().setAttribute("personInfo", personInfo);
		return "jsps/information/personInfo.jsp";
	}
	public String queryByPersonnelId(HttpServletRequest req, HttpServletResponse resp) {
		UserService userService = new UserService();
		String personId = req.getParameter("personnelId"); 
		List<Personnelinfo> personDetail = null;
		try {
			personDetail = userService.queryByPersonnelId(personId);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			return "jsps/information/inc/error.jsp";
		}
		req.getSession().setAttribute("personDetail", personDetail);
		return "jsps/information/InfoDetail.jsp";
	}
	
	public String queryRemove(HttpServletRequest req, HttpServletResponse resp) {
		UserService userService = new UserService();
		PageService pageService = new PageService();
		Page page = new Page();
		String way = req.getParameter("way");
		List<Personnelremove> personRemove = null;
		List<Personnelremove> showPersonRemove  = new ArrayList<Personnelremove>();
		req.getSession().setAttribute("showPersonRemove", showPersonRemove);
		try {
			personRemove = userService.queryRemove();
			pageService.setPage(page,personRemove);
			pageService.getShowPage(page, showPersonRemove, personRemove, page.getCurPage(), way);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			return "jsps/information/inc/error.jsp";
		}
				req.getSession().setAttribute("flagRemove","Yes");
		req.getSession().setAttribute("page", page);
		req.getSession().setAttribute("personRemove", personRemove);
		return "jsps/information/personRemove.jsp";
	}
	
	public String queryTrain(HttpServletRequest req, HttpServletResponse resp) {
		UserService userService = new UserService();
		PageService pageService = new PageService();
		Page page = new Page();
		String way = req.getParameter("way");
		List<Personneltrain> personTrain = null;
		List<Personneltrain> showPersonTrain  = new ArrayList<Personneltrain>();
		req.getSession().setAttribute("showPersonTrain", showPersonTrain);
		try {
			personTrain = userService.queryTrain();
			pageService.setPage(page,personTrain);
			pageService.getShowPage(page, showPersonTrain, personTrain, page.getCurPage(), way);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			return "jsps/information/inc/error.jsp";
		}
				req.getSession().setAttribute("flagTrain","Yes");
		req.getSession().setAttribute("page", page);
		req.getSession().setAttribute("personTrain", personTrain);
		return "jsps/information/personTrain.jsp";
	}
	
	public String queryAppraise(HttpServletRequest req, HttpServletResponse resp) {
		UserService userService = new UserService();
		PageService pageService = new PageService();
		Page page = new Page();
		String way = req.getParameter("way");
		List<Personnelappraise> personAppraise = null;
		List<Personnelappraise> showPersonAppraise  = new ArrayList<Personnelappraise>();
		req.getSession().setAttribute("showPersonAppraise", showPersonAppraise);
		try {
			personAppraise = userService.queryAppraise();
			pageService.setPage(page,personAppraise);
			pageService.getShowPage(page, showPersonAppraise, personAppraise, page.getCurPage(), way);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			return "jsps/information/inc/error.jsp";
		}
				req.getSession().setAttribute("flagAppraise","Yes");
		req.getSession().setAttribute("page", page);
		req.getSession().setAttribute("personAppraise", personAppraise);
		return "jsps/information/personAppraise.jsp";
	}
	
	public String querySalary(HttpServletRequest req, HttpServletResponse resp) {
		UserService userService = new UserService();
		PageService pageService = new PageService();
		Page page = new Page();
		String way = req.getParameter("way");
		List<Personneladjustsalary> personSalary = null;
		List<Personneladjustsalary> showPersonSalary  = new ArrayList<Personneladjustsalary>();
		req.getSession().setAttribute("showPersonSalary", showPersonSalary);
		try {
			personSalary = userService.querySalary();
			pageService.setPage(page,personSalary);
			pageService.getShowPage(page, showPersonSalary, personSalary, page.getCurPage(), way);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			return "jsps/information/inc/error.jsp";
		}
				req.getSession().setAttribute("flagSalary","Yes");
		req.getSession().setAttribute("page", page);
		req.getSession().setAttribute("personSalary", personSalary);
		return "jsps/information/personSalary.jsp";
	}
	
	
	public String querySal(HttpServletRequest req, HttpServletResponse resp) {
		UserService userService = new UserService();
		PageService pageService = new PageService();
		Page page = new Page();
		String way = req.getParameter("way");
		List<Salary> personSal = null;
		List<Salary> showPersonSal  = new ArrayList<Salary>();
		req.getSession().setAttribute("showPersonSal", showPersonSal);
		try {
			personSal = userService.querySal();
			pageService.setPage(page,personSal);
			pageService.getShowPage(page, showPersonSal, personSal, page.getCurPage(), way);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			return "jsps/information/inc/error.jsp";
		}
				req.getSession().setAttribute("flagSal","Yes");
		req.getSession().setAttribute("page", page);
		req.getSession().setAttribute("personSal", personSal);
		return "jsps/information/personSal.jsp";
	}
	
	public String queryEn(HttpServletRequest req, HttpServletResponse resp) {
		UserService userService = new UserService();
		PageService pageService = new PageService();
		Page page = new Page();
		String way = req.getParameter("way");
		List<Peoc> personEn = null;
		List<Peoc> showPersonEn  = new ArrayList<Peoc>();
		req.getSession().setAttribute("showPersonEn", showPersonEn);
		try {
			personEn = userService.queryEn();
			pageService.setPage(page,personEn);
			pageService.getShowPage(page, showPersonEn, personEn, page.getCurPage(), way);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			return "jsps/information/inc/error.jsp";
		}
				req.getSession().setAttribute("flagEn","Yes");
		req.getSession().setAttribute("page", page);
		req.getSession().setAttribute("personEn", personEn);
		return "jsps/information/personEn.jsp";
	}
	
	public String jump(HttpServletRequest req, HttpServletResponse resp) {
		return "jsps/information/personInfo.jsp";
	}
	
	public String jumpAdvanceInfo(HttpServletRequest req, HttpServletResponse resp) {
		return "jsps/information/advanceInfo.jsp";
	}
}

