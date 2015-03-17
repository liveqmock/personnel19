package org.jsoft.person.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.comm.vo.Personneltrain;
import org.jsoft.person.dao.impl.PersonTrainDAO;
import org.jsoft.person.service.IPersonTrainService;

public class PersonTrainService implements IPersonTrainService {
	private PersonTrainDAO pt = new PersonTrainDAO();
	private Personneltrain pt1 = new Personneltrain();
	private static PageDivid pageDivid=new PageDivid();
	private static PageDivid pageDivid1 = new PageDivid();
	private static PageDivid pageDivid2 = new PageDivid();
	
	public List<Personneltrain> findAll(String tempCurrentPage) {
		int currentPage=Integer.parseInt(tempCurrentPage);
		
		pageDivid.setEachPageNum(3);
		pageDivid.setCurrentPage(currentPage);
		
		List<Personneltrain> setAllPageLs = pt.findAllNoPage();//只是用来设置allPage的
		pageDivid.setNum(setAllPageLs.size());
		System.out.println("Service里数据总共"+pageDivid.getNum());
		
		List<Personneltrain> ls =pt.findAll(pageDivid);
		
		if(pageDivid.getNum()%pageDivid.getEachPageNum()==0){
			int allPage=pageDivid.getNum()/pageDivid.getEachPageNum();
			pageDivid.setAllPage(allPage);
		}else {
			int allPage=pageDivid.getNum()/pageDivid.getEachPageNum()+1;
			pageDivid.setAllPage(allPage);
		}
		System.out.println("Service里allPage为"+pageDivid.getAllPage());
		return ls;
	}
	
	public Personneltrain findSingle(String personnelTrainId) {
		pt1=pt.findSingle(personnelTrainId);
		return pt1;
	}
	
	public List<Personneltrain> findByDepartment(String departmentName,
			String tempCurrentPage) {
		int currentPage = Integer.parseInt(tempCurrentPage);
		pageDivid1.setCurrentPage(currentPage);
		pageDivid1.setEachPageNum(3);
		List<Personneltrain> ls = pt.findByDepartment(departmentName, pageDivid1);
		List<Personneltrain> ls1 = pt.findByDeptNoPage(departmentName);		
		pageDivid1.setNum(ls1.size());
		
		if (pageDivid1.getNum() % pageDivid1.getEachPageNum() == 0) {
			int allPage = pageDivid1.getNum() / pageDivid1.getEachPageNum();
			pageDivid1.setAllPage(allPage);
		} else {
			int allPage = pageDivid1.getNum() / pageDivid1.getEachPageNum() + 1;
			pageDivid1.setAllPage(allPage);
		}

		return ls;
	}
	
	public List<Personneltrain> findByJob(String jobName,
			String tempCurrentPage) {
		int currentPage = Integer.parseInt(tempCurrentPage);
		pageDivid2.setCurrentPage(currentPage);
		pageDivid2.setEachPageNum(3);
		List<Personneltrain> ls = pt.findByJob(jobName, pageDivid2);
		List<Personneltrain> ls1 = pt.findByJobNoPage(jobName);		
		pageDivid2.setNum(ls1.size());
		
		if (pageDivid2.getNum() % pageDivid2.getEachPageNum() == 0) {
			int allPage = pageDivid2.getNum() / pageDivid2.getEachPageNum();
			pageDivid2.setAllPage(allPage);
		} else {
			int allPage = pageDivid2.getNum() / pageDivid2.getEachPageNum() + 1;
			pageDivid2.setAllPage(allPage);
		}
		
		return ls;
	}
	
	
	public void add(String personnelId, String personnelTrainConten,
			String ptdTemp, String personnelTrainRemark) {
		Personnelinfo p = new Personnelinfo();
		// 为了用这个类里的setPersonnelId方法,这里id是主键，非空，必须set
		p.setPersonnelId(personnelId);
		pt1.setPersonnelinfo(p);
		pt1.setPersonnelTrainConten(personnelTrainConten);

		Timestamp personnelTrainDate = null;
		try {
			personnelTrainDate = new Timestamp(new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").parse(ptdTemp).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pt1.setPersonnelTrainDate(personnelTrainDate);
		pt1.setPersonnelTrainRemark(personnelTrainRemark);
		pt1.setIsDelete(0);

		pt.add(pt1);
		System.out.println("执行了Service的add");

	}

	public void update(String personnelTrainId,String personnelTrainConten,String ptdTemp,String personnelTrainRemark,int isDelete ) {
		Timestamp personnelTrainDate = null;
		try {
			personnelTrainDate = new Timestamp(new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").parse(ptdTemp).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		Personneltrain personneltrain=new Personneltrain();//不能在这new出游离态的对象，这是与数据库无关的一个对象，这样做的话后果是只能改一次，多改几次会出现问题，报错
		pt1=pt.findSingle(personnelTrainId);
		pt1.setPersonnelTrainConten(personnelTrainConten);
		pt1.setPersonnelTrainDate(personnelTrainDate);
		pt1.setPersonnelTrainRemark(personnelTrainRemark);
		pt1.setIsDelete(isDelete);
		pt.personTrainUpdate(pt1);//这里要把给的参数封装成这个类
		System.out.println("执行了Service里的update");
	}

	
	public static PageDivid getPageDivid() {
		return pageDivid;
	}

	public static void setPageDivid(PageDivid pageDivid) {
		PersonTrainService.pageDivid = pageDivid;
	}

	public static PageDivid getPageDivid1() {
		return pageDivid1;
	}

	public static void setPageDivid1(PageDivid pageDivid1) {
		PersonTrainService.pageDivid1 = pageDivid1;
	}
	
	public static PageDivid getPageDivid2() {
		return pageDivid2;
	}
	
	public static void setPageDivid2(PageDivid pageDivid2) {
		PersonTrainService.pageDivid2 = pageDivid2;
	}



}
