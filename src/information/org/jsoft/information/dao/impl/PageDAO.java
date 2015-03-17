package org.jsoft.information.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.information.dao.IPageDAO;
import org.jsoft.information.vo.Page;

public class PageDAO extends BaseDAO<Page> implements IPageDAO {

	@Override
	public void setPage(Page page, List personInfo) {
		Session session = getSession();
		session.beginTransaction();
		page.setRowNum(new Integer(personInfo.size()));
		if (page.getRowNum() % page.getRowOfEachPage() == 0) {
			page.setPageNum(page.getRowNum() / page.getRowOfEachPage());
		} else {
			page.setPageNum(page.getRowNum() / page.getRowOfEachPage() + 1);
		}
		session.getTransaction().commit();
		session.close();		
	}

	@Override
	public void getShowPage(Page page, List showPersonInfo,
			List personInfo, int curPage, String way) {
		Session session = getSession();
		session.beginTransaction();
		showPersonInfo.clear();
		// 防越界限制
		if (curPage <= 0) {
			curPage = 1;
		}
		if (curPage > page.getPageNum()) {
			curPage = page.getPageNum();
		}
		page.setCurPage(curPage);
		int beginPage = page.getBeginPage();
		// 首页
		if (curPage == 1) {
			beginPage = 1;
		}
		// 末页
		if (curPage == page.getPageNum()) {
			if (curPage > page.getBlocksOfEachPage()) {
				beginPage = page.getPageNum() % page.getBlocksOfEachPage() == 0 ? (page
						.getPageNum() / page.getBlocksOfEachPage() - 1)
						* page.getBlocksOfEachPage()+1
						: page.getPageNum() / page.getBlocksOfEachPage()
								* page.getBlocksOfEachPage() + 1;
			} else {
				beginPage = 1;
			}
		}

		// 上下页翻动
		if (way != null) {
			if (way.equals("up")) {
				if (curPage % page.getBlocksOfEachPage() == 0) {
					if (curPage > page.getBlocksOfEachPage()) {
						beginPage -= page.getBlocksOfEachPage();
					} else {
						beginPage = 1;
					}
				}
			} else if (way.equals("down")) {
				if ((curPage - 1) % page.getBlocksOfEachPage() == 0) {
					beginPage += page.getBlocksOfEachPage();
				}
			}
		}
		page.setBeginPage(beginPage);
		int totalrow = page.getRowNum();
		int num = 0;
		if (curPage * page.getRowOfEachPage() < totalrow) {
			num = curPage * page.getRowOfEachPage();
		} else {
			num = totalrow;
		}
		for (int i = ((curPage - 1<=0)?0:(curPage - 1)) * page.getRowOfEachPage(); i < num; i++) {
			Object info = personInfo.get(i);
			showPersonInfo.add(info);
		}
		session.getTransaction().commit();
		session.close();		
	}

}
