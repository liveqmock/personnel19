package org.jsoft.information.vo;

public class Page {
    // 当前是第几页
    private Integer curPage = 1;
    //每页显示几个
    private Integer rowOfEachPage = 7;
    //底部翻页的的数字是从第几个开始
    private Integer beginPage = 1;
    //底部翻页的数字在每页显示多少个
    private Integer blocksOfEachPage = 4;
    //一共有多少页
    private Integer pageNum;
    //一共有多少条数据
    private Integer rowNum;
    //这里忽略getter和setter方法
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getRowOfEachPage() {
		return rowOfEachPage;
	}
	public void setRowOfEachPage(Integer rowOfEachPage) {
		this.rowOfEachPage = rowOfEachPage;
	}
	public Integer getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(Integer beginPage) {
		this.beginPage = beginPage;
	}
	public Integer getBlocksOfEachPage() {
		return blocksOfEachPage;
	}
	public void setBlocksOfEachPage(Integer blocksOfEachPage) {
		this.blocksOfEachPage = blocksOfEachPage;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getRowNum() {
		return rowNum;
	}
	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}
    
}


