package org.jsoft.information.dao;

import java.util.List;

import org.jsoft.information.vo.Page;

public interface IPageDAO {
	public void setPage(Page page, List artical);
	public void getShowPage(Page page, List showArticals,
			List artical, int curPage,String way);
}
