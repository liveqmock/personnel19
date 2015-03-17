package org.jsoft.person.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.vo.DictionLog;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelappraise;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.person.dao.impl.PersonAppraiseDAO;
import org.jsoft.person.dao.impl.PersonAppraiseDictionDAO;
import org.jsoft.person.dao.impl.PersonInfoDAO;
import org.jsoft.person.service.IPersonAppraiseService;
import org.jsoft.system.dao.impl.DictionDAO;

public class PersonAppraiseService implements IPersonAppraiseService {
	private PersonAppraiseDAO pa = new PersonAppraiseDAO();
	private Personnelappraise pa1 = new Personnelappraise();
	private DictionDAO dcDAO = new DictionDAO();
	private PersonAppraiseDictionDAO padDAO = new PersonAppraiseDictionDAO();
	private PersonInfoDAO piDAO = new PersonInfoDAO();

	private static PageDivid pageDivid = new PageDivid();
	private static PageDivid pageDivid1 = new PageDivid();
	private static PageDivid pageDivid2 = new PageDivid();

	public List<Personnelappraise> findAll(String tempCurrentPage) {
		int currentPage = Integer.parseInt(tempCurrentPage);
		System.out.println("service中findAll里currentPage为" + currentPage);
		pageDivid.setEachPageNum(3);
		pageDivid.setCurrentPage(currentPage);

		List<Personnelappraise> setAllPageLs = pa.findAllNoPage();// 只是用来设置allPage的
		pageDivid.setNum(setAllPageLs.size());
		System.out.println("Service里数据总共" + pageDivid.getNum());
		List<Personnelappraise> ls = pa.findAll(pageDivid); // 查出来的东西永远不能改，如果要改，就要从新new一个专门用来显示的，set显示的=get查出来的
		// 用来显示的东西如果和数据库有不同，一定不能直接改原来的，要new新的再set，set的时候要精确到“单元格”
		// 这样才能保证和数据库是没有关系的，不造成意外的修改
		List<Personnelappraise> ls2 = new ArrayList<Personnelappraise>();// ls2专门用来设置显示的，比如考评结果需要，但是在培训里不需要，但是不能作为全局量，应该每次调用方法的时候都要new

		for (Personnelappraise pa1 : ls) {// 用来避免出现类似游离态与持久化的问题
			Personnelappraise p = new Personnelappraise();
			p.setIsDelete(pa1.getIsDelete());
			p.setPersonnelAppraiseContent(pa1.getPersonnelAppraiseContent());
			p.setPersonnelAppraiseDate(pa1.getPersonnelAppraiseDate());
			p.setPersonnelAppraiseId(pa1.getPersonnelAppraiseId());
			p.setPersonnelAppraiseRemark(pa1.getPersonnelAppraiseRemark());

			String sid = pa1.getPersonnelAppraiseResult();
			String name = padDAO.findAppraiseResult(sid).getName();
			p.setPersonnelAppraiseResult(name); // 设置字典

			String pId = pa1.getPersonnelinfo().getPersonnelId();
			Personnelinfo pInfo = piDAO.queryPersonSingle(pId);

			p.setPersonnelinfo(pInfo);

			ls2.add(p);

		}

		if (pageDivid.getNum() % pageDivid.getEachPageNum() == 0) {
			int allPage = pageDivid.getNum() / pageDivid.getEachPageNum();
			pageDivid.setAllPage(allPage);
		} else {
			int allPage = pageDivid.getNum() / pageDivid.getEachPageNum() + 1;
			pageDivid.setAllPage(allPage);
		}
		System.out.println("Service里allPage为" + pageDivid.getAllPage());
		System.err.println(ls2.size());
		return ls2;// 返回要显示的list
	}

	public Personnelappraise findSingle(String personnelAppraiseId) {
		pa1 = pa.findSingle(personnelAppraiseId);// pa1为查出来的
		String sid = pa1.getPersonnelAppraiseResult();
		String name = padDAO.findAppraiseResult(sid).getName();
		Personnelappraise pa2 = new Personnelappraise();// pa2为要用来显示的
		pa2.setPersonnelAppraiseResult(name);
		pa2.setIsDelete(pa1.getIsDelete());
		pa2.setPersonnelAppraiseContent(pa1.getPersonnelAppraiseContent());
		pa2.setPersonnelAppraiseDate(pa1.getPersonnelAppraiseDate());
		pa2.setPersonnelAppraiseId(pa1.getPersonnelAppraiseId());
		pa2.setPersonnelAppraiseRemark(pa1.getPersonnelAppraiseRemark());

		String pId = pa1.getPersonnelinfo().getPersonnelId();
		Personnelinfo pInfo = piDAO.queryPersonSingle(pId);
		pa2.setPersonnelinfo(pInfo);

		return pa2;
	}

	public List<Personnelappraise> findByDepartment(String departmentName,
			String tempCurrentPage) {
		int currentPage = Integer.parseInt(tempCurrentPage);
		pageDivid1.setCurrentPage(currentPage);
		pageDivid1.setEachPageNum(3);
		List<Personnelappraise> ls = pa.findByDepartment(departmentName, pageDivid1);
		List<Personnelappraise> ls1 = pa.findByDeptNoPage(departmentName);		
		pageDivid1.setNum(ls1.size());
		List<Personnelappraise> ls2 = new ArrayList<Personnelappraise>();// ls2专门用来设置显示的，比如考评结果需要，但是在培训里不需要，但是不能作为全局量，应该每次调用方法的时候都要new
		for (Personnelappraise pa1 : ls) {// 用来避免出现类似游离态与持久化的问题

			Personnelappraise p = new Personnelappraise();
			p.setIsDelete(pa1.getIsDelete());
			p.setPersonnelAppraiseContent(pa1.getPersonnelAppraiseContent());
			p.setPersonnelAppraiseDate(pa1.getPersonnelAppraiseDate());
			p.setPersonnelAppraiseId(pa1.getPersonnelAppraiseId());
			p.setPersonnelAppraiseRemark(pa1.getPersonnelAppraiseRemark());

			String sid = pa1.getPersonnelAppraiseResult();
			String name = padDAO.findAppraiseResult(sid).getName();
			p.setPersonnelAppraiseResult(name); // 设置字典

			String pId = pa1.getPersonnelinfo().getPersonnelId();
			Personnelinfo pInfo = piDAO.queryPersonSingle(pId);

			p.setPersonnelinfo(pInfo);

			ls2.add(p);

		}
		if (pageDivid1.getNum() % pageDivid1.getEachPageNum() == 0) {
			int allPage = pageDivid1.getNum() / pageDivid1.getEachPageNum();
			pageDivid1.setAllPage(allPage);
		} else {
			int allPage = pageDivid1.getNum() / pageDivid1.getEachPageNum() + 1;
			pageDivid1.setAllPage(allPage);
		}

		return ls2;
	}
	
	public List<Personnelappraise> findByJob(String jobName,
			String tempCurrentPage) {
		int currentPage = Integer.parseInt(tempCurrentPage);
		pageDivid2.setCurrentPage(currentPage);
		pageDivid2.setEachPageNum(3);
		List<Personnelappraise> ls = pa.findByJob(jobName, pageDivid2);
		List<Personnelappraise> ls1 = pa.findByJobNoPage(jobName);		
		pageDivid2.setNum(ls1.size());
		List<Personnelappraise> ls2 = new ArrayList<Personnelappraise>();// ls2专门用来设置显示的，比如考评结果需要，但是在培训里不需要，但是不能作为全局量，应该每次调用方法的时候都要new
		for (Personnelappraise pa1 : ls) {// 用来避免出现类似游离态与持久化的问题
			
			Personnelappraise p = new Personnelappraise();
			p.setIsDelete(pa1.getIsDelete());
			p.setPersonnelAppraiseContent(pa1.getPersonnelAppraiseContent());
			p.setPersonnelAppraiseDate(pa1.getPersonnelAppraiseDate());
			p.setPersonnelAppraiseId(pa1.getPersonnelAppraiseId());
			p.setPersonnelAppraiseRemark(pa1.getPersonnelAppraiseRemark());
			
			String sid = pa1.getPersonnelAppraiseResult();
			String name = padDAO.findAppraiseResult(sid).getName();
			p.setPersonnelAppraiseResult(name); // 设置字典
			
			String pId = pa1.getPersonnelinfo().getPersonnelId();
			Personnelinfo pInfo = piDAO.queryPersonSingle(pId);
			
			p.setPersonnelinfo(pInfo);
			
			ls2.add(p);
			
		}
		if (pageDivid2.getNum() % pageDivid2.getEachPageNum() == 0) {
			int allPage = pageDivid2.getNum() / pageDivid2.getEachPageNum();
			pageDivid2.setAllPage(allPage);
		} else {
			int allPage = pageDivid2.getNum() / pageDivid2.getEachPageNum() + 1;
			pageDivid2.setAllPage(allPage);
		}
		
		return ls2;
	}

	public void add(String personnelId, String personnelAppraiseContent,
			String ptdTemp, String personnelAppraiseResult,
			String personnelAppraiseRemark) {
		Personnelinfo p = new Personnelinfo();
		// 为了用这个类里的setPersonnelId方法,这里id是主键，非空，必须set
		p.setPersonnelId(personnelId);
		pa1.setPersonnelinfo(p);
		pa1.setPersonnelAppraiseContent(personnelAppraiseContent);

		Timestamp personnelAppraiseDate = null;
		try {
			personnelAppraiseDate = new Timestamp(new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").parse(ptdTemp).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		DictionLog dl = dcDAO.queryByName(personnelAppraiseResult);
		String sid = dl.getSid();

		pa1.setPersonnelAppraiseDate(personnelAppraiseDate);
		pa1.setPersonnelAppraiseResult(sid);
		pa1.setPersonnelAppraiseRemark(personnelAppraiseRemark);
		pa1.setIsDelete(0);

		pa.add(pa1);
		System.out.println("执行了Service的add");
	}

	public void update(String personnelAppraiseId,
			String personnelAppraiseContent, String ptdTemp,
			String personnelAppraiseResult, String personnelAppraiseRemark,
			int isDelete) {
		Timestamp personnelAppraiseDate = null;
		try {
			personnelAppraiseDate = new Timestamp(new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").parse(ptdTemp).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Personnelappraise personnelappraise=new
		// Personnelappraise();//不能在这new出游离态的对象，这是与数据库无关的一个对象，这样做的话后果是只能改一次，多改几次会出现问题，报错
		pa1 = pa.findSingle(personnelAppraiseId);
		pa1.setPersonnelAppraiseContent(personnelAppraiseContent);
		pa1.setPersonnelAppraiseDate(personnelAppraiseDate);
		pa1.setPersonnelAppraiseResult(personnelAppraiseResult);
		pa1.setPersonnelAppraiseRemark(personnelAppraiseRemark);
		pa1.setIsDelete(isDelete);
		pa.personAppraiseUpdate(pa1);// 这里要把给的参数封装成这个类
		System.out.println("执行了Service里的update");
	}

	public static PageDivid getPageDivid() {
		return pageDivid;
	}

	public static void setPageDivid(PageDivid pageDivid) {
		PersonAppraiseService.pageDivid = pageDivid;
	}

	public static PageDivid getPageDivid1() {
		return pageDivid1;
	}

	public static void setPageDivid1(PageDivid pageDivid1) {
		PersonAppraiseService.pageDivid1 = pageDivid1;
	}
	
	public static PageDivid getPageDivid2() {
		return pageDivid2;
	}
	
	public static void setPageDivid2(PageDivid pageDivid2) {
		PersonAppraiseService.pageDivid2 = pageDivid2;
	}

}
