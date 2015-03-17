package org.jsoft.information.service;

import java.util.List;

import org.jsoft.information.dao.impl.PageDAO;
import org.jsoft.information.vo.Page;

public class PageService {

	PageDAO pageDAO = new PageDAO();

	public void setPage(Page page, List personInfo) {
		pageDAO.setPage(page, personInfo);
	}
	public void getShowPage(Page page, List showPersonInfo,
			List personInfo, int curPage, String way) {
		pageDAO.getShowPage(page, showPersonInfo, personInfo, curPage, way);
	}

}
