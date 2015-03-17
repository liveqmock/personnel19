package org.jsoft.comm.vo;
/**
 * 分页需要使用的bean类
 * @author 羽
 *
 */
public class PageDivid {
	/**
	 * @attribute 总页码
	 */
	private int allPage;
	/**
	 * @attribute 当前页码 默认为第一页
	 */
	private int currentPage=1;
	/**
	 * @attribute 每页显示的数据条数  默认为10条
	 */
	private int eachPageNum=10;
	/**
	 * @attribute 总条数
	 * 
	 */
	
	private int num;
	
	public int getAllPage() {
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getEachPageNum() {
		return eachPageNum;
	}
	public void setEachPageNum(int eachPageNum) {
		this.eachPageNum = eachPageNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
