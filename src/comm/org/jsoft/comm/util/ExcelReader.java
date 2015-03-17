package org.jsoft.comm.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Query;
import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.util.HibernateSessionFactory;
import org.jsoft.comm.vo.*;

import jxl.Sheet;
import jxl.WorkbookSettings;

import jxl.Workbook;

public class ExcelReader {

	/**
	 * ExcelJXL类 为对Excel相关的读取操作类 包括方法
	 * 
	 * 1. readExcel 方法 为读取excel文件的方法 返回List<List<String>>类型的VOsFromExcel
	 * 2.saveExcelToDB 方法 为把读取的excel存到数据库的方法
	 * 
	 * 
	 * 3.BeginLoadExcel 方法 为用户从外部调用的方法 使用的时候用户只用使用这个方法就行
	 * 
	 * @author 李智 Lychee
	 */

	public List<List<String>> readExcel(String ExcelPath) {

		/**
		 * readExcel 方法 为读取excel文件的方法 并显示到控制台 参数： 1. ExcelPath
		 * 为待读取的Excel文件的路径，例如 "D:/testXLS.xls"
		 * 
		 * 方法返回List<List<String>>类型的VOsFromExcel
		 * excel中每一行被封装为一个List，所有的List被封装为最后的VOsFromExcel返回
		 * 
		 * @author 李智 Lychee
		 */

		System.out.println("Excel读取开始");
		List<List<String>> VOsFromExcel = new ArrayList<List<String>>(); // 用于返回的list
		try {
			WorkbookSettings workbookSettings = new WorkbookSettings();
			workbookSettings.setEncoding("GBK"); // 解决乱码问题所采用的编码 utf-8无法解决
													// 暂时采用GBK
			Workbook book = Workbook.getWorkbook(new File(ExcelPath),
					workbookSettings);
			Sheet sheet = book.getSheet(0); // 0代表第一个工作表对象

			int excelRows = sheet.getRows(); // excel总行数
			int excelCols = sheet.getColumns(); // excel总列数
			System.out.println("文件总行数：" + excelRows + "      总列数：" + excelCols);

			for (int i = 1; i < excelRows; i++) { // 从第二行开始，检索每一行
				List<String> VOSingle = new ArrayList<String>(); // 用于返回的单个List
																	// 一个VOSingle为Excel的一行
																	// 从表的第一个字段开始
																	// 取出每个单元格的信息
				for (int j = 0; j < excelCols; j++) {
					String perUnit = sheet.getCell(j, i).getContents().trim(); // 取出每一行的信息
					VOSingle.add(perUnit);
				}
				VOsFromExcel.add(VOSingle); // 将每一行的VOSingle放到最终返回的list中
			}

		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println("没有找到文件！请检察路径和文件名是否正确");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Excel读取完成");
		return VOsFromExcel;
	}

	public void saveExcelToDB(List<List<String>> VOsFromExcel, String tableName) {

		/**
		 * SaveExcelToDB 方法 为将查询好的list存入数据库中的方法 其中参数： VOsFromExcel
		 * 为待存储的excel中提取的数据 tableName 为待插入的表名称
		 * 
		 * 这种方法写起来略麻烦，可能不是最终的解决方案
		 */
		
		System.out.println("Excel存储开始");
		for (List<String> vos : VOsFromExcel) {

			if ("bak".equals(tableName)) {

				BaseDAO<Bak> bDAO = new BaseDAO<Bak>();
				Bak b = new Bak();

				Operater o = new Operater();
				o.setOpId(vos.get(1));
				b.setOperater(o);

				b.setBakRemark(vos.get(2));

				try {
					Timestamp ts = new Timestamp(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").parse(vos.get(3)).getTime());
					// ↑ 将String转换成TimeStamp的方法
					b.setBakDate(ts);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				b.setPath(vos.get(4));
				b.setIsDelete(Integer.parseInt(vos.get(5)));

				bDAO.save(b);

			} else if ("department".equals(tableName)) {

				BaseDAO<Department> bDAO = new BaseDAO<Department>();
				Department d = new Department();
				d.setDepartmentName(vos.get(1));
				d.setIsDelete(Integer.parseInt(vos.get(2)));
				bDAO.save(d);

			} else if ("dept_job_rel".equals(tableName)) {

				BaseDAO<DeptJobRel> bDAO = new BaseDAO<DeptJobRel>();
				DeptJobRel d = new DeptJobRel();

				Salary s = new Salary();
				s.setSalaryId(vos.get(1));
				d.setSalary(s);

				Department dept = new Department();
				dept.setDepartmentId(vos.get(2));
				d.setDepartment(dept);

				Job j = new Job();
				j.setJobId(vos.get(3));
				d.setJob(j);

				d.setIsDelete(Integer.parseInt(vos.get(4)));

				bDAO.save(d);

			} else if ("diction_log".equals(tableName)) {

				BaseDAO<DictionLog> bDAO = new BaseDAO<DictionLog>();
				DictionLog d = new DictionLog();

				d.setPid(vos.get(1));
				d.setName(vos.get(2));

				try {
					Timestamp ts = new Timestamp(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").parse(vos.get(3)).getTime());
					// ↑ 将String转换成TimeStamp的方法
					d.setDictionLogDate(ts);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				d.setDictionLogRemark(vos.get(4));
				d.setIsDelete(Integer.parseInt(vos.get(5)));

				bDAO.save(d);

			} else if ("duty".equals(tableName)) {

				BaseDAO<Duty> bDAO = new BaseDAO<Duty>();
				Duty d = new Duty();

				d.setDutyName(vos.get(1));
				d.setIsDelete(Integer.parseInt(vos.get(2)));

				bDAO.save(d);

			} else if ("encorchast".equals(tableName)) {

				BaseDAO<Encorchast> bDAO = new BaseDAO<Encorchast>();
				Encorchast e = new Encorchast();
				e.setPersonnelEncOrChastPoint(Double.parseDouble(vos.get(1)));
				e.setMoney(Double.parseDouble(vos.get(2)));
				e.setPersonnelEncOrChastSort(vos.get(3));
				e.setIsDelete(Integer.parseInt(vos.get(4)));
				bDAO.save(e);

			} else if ("job".equals(tableName)) {

				BaseDAO<Job> bDAO = new BaseDAO<Job>();
				Job j = new Job();
				j.setJobName(vos.get(1));
				j.setIsDelete(Integer.parseInt(vos.get(2)));
				bDAO.save(j);

			} else if ("menu".equals(tableName)) {

				BaseDAO<Menu> bDAO = new BaseDAO<Menu>();
				Menu m = new Menu();

				Menu mm = new Menu();
				mm.setMenuId(vos.get(1));
				m.setMenu(mm);

				m.setMenuName(vos.get(2));
				m.setMenuUrl(vos.get(3));
				m.setRemark(vos.get(4));
				m.setMenuDate(vos.get(5));
				m.setIsDelete(Integer.parseInt(vos.get(6)));

				bDAO.save(m);

			} else if ("operate_log".equals(tableName)) {

				BaseDAO<OperateLog> bDAO = new BaseDAO<OperateLog>();
				OperateLog o = new OperateLog();

				Operater operater = new Operater();
				operater.setOpId(vos.get(1));
				o.setOperater(operater);

				try {
					Timestamp ts = new Timestamp(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").parse(vos.get(2)).getTime());
					// ↑ 将String转换成TimeStamp的方法
					o.setBakDate(ts);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				o.setEvent(vos.get(3));
				o.setIsDelete(Integer.parseInt(vos.get(4)));

				bDAO.save(o);

			} else if ("operater".equals(tableName)) {

				BaseDAO<Operater> bDAO = new BaseDAO<Operater>();
				Operater o = new Operater();

				Personnelinfo p = new Personnelinfo();
				p.setPersonnelId(vos.get(1));
				o.setPersonnelinfo(p);

				o.setPopedom(vos.get(2));
				o.setOpName(vos.get(3));
				o.setOpPassword(vos.get(4));
				o.setIsDelete(Integer.parseInt(vos.get(5)));

				bDAO.save(o);

			} else if ("peoc".equals(tableName)) {

				BaseDAO<Peoc> bDAO = new BaseDAO<Peoc>();
				Peoc p = new Peoc();

				Encorchast e = new Encorchast();
				e.setEncOrChastId(vos.get(1));
				p.setEncorchast(e);

				Personnelinfo pp = new Personnelinfo();
				pp.setPersonnelId(vos.get(2));
				p.setPersonnelinfo(pp);

				try {
					Timestamp ts = new Timestamp(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").parse(vos.get(3)).getTime());
					// ↑ 将String转换成TimeStamp的方法
					p.setPeocDate(ts);
				} catch (ParseException ee) {
					ee.printStackTrace();
				}
				p.setPeocReason(vos.get(4));
				p.setPersonnelTrainRemark(vos.get(5));
				p.setIsDelete(Integer.parseInt(vos.get(6)));

				bDAO.save(p);

			} else if ("personneladjustsalary".equals(tableName)) {

				BaseDAO<Personneladjustsalary> bDAO = new BaseDAO<Personneladjustsalary>();
				Personneladjustsalary p = new Personneladjustsalary();

				DeptJobRel d = new DeptJobRel();
				d.setDeptJobRelId(vos.get(1));

				try {
					Timestamp ts = new Timestamp(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").parse(vos.get(2)).getTime());
					// ↑ 将String转换成TimeStamp的方法
					p.setAdjustSalaryDate(ts);
				} catch (ParseException ee) {
					ee.printStackTrace();
				}
				p.setAdjustSalaryReason(vos.get(3));
				p.setPersonnelAdjustSalaryRemark(vos.get(4));
				p.setIsDelete(Integer.parseInt(vos.get(5)));

				bDAO.save(p);

			} else if ("personnelappraise".equals(tableName)) {

				BaseDAO<Personnelappraise> bDAO = new BaseDAO<Personnelappraise>();
				Personnelappraise p = new Personnelappraise();

				Personnelinfo pi = new Personnelinfo();
				pi.setPersonnelId(vos.get(1));
				p.setPersonnelinfo(pi);

				try {
					Timestamp ts = new Timestamp(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").parse(vos.get(2)).getTime());
					// ↑ 将String转换成TimeStamp的方法
					p.setPersonnelAppraiseDate(ts);
				} catch (ParseException ee) {
					ee.printStackTrace();
				}
				p.setPersonnelAppraiseResult(vos.get(3));
				p.setPersonnelAppraiseContent(vos.get(4));
				p.setPersonnelAppraiseRemark(vos.get(5));
				p.setIsDelete(Integer.parseInt(vos.get(6)));

				bDAO.save(p);

			} else if ("personnelinfo".equals(tableName)) {

				BaseDAO<Personnelinfo> bDAO = new BaseDAO<Personnelinfo>();
				Personnelinfo p = new Personnelinfo();

				Duty d = new Duty();
				d.setDutyId(vos.get(1));
				p.setDuty(d);

				DeptJobRel djr = new DeptJobRel();
				djr.setDeptJobRelId(vos.get(2));
				p.setDeptJobRel(djr);

				p.setPersonnelNo(vos.get(3));
				p.setPersonnelName(vos.get(4));
				p.setPersonnelSex(vos.get(5));

				try {
					Timestamp ts = new Timestamp(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").parse(vos.get(6)).getTime());
					// ↑ 将String转换成TimeStamp的方法
					p.setBirthday(ts);
				} catch (ParseException ee) {
					ee.printStackTrace();
				}
				p.setAge(Integer.parseInt(vos.get(7)));
				p.setIdentityId(vos.get(8));
				p.setWedLock(vos.get(9));
				p.setRace(vos.get(10));
				p.setNativePlace(vos.get(11));
				p.setPolitic(vos.get(12));
				p.setEMail(vos.get(13));
				p.setPhone(vos.get(14));
				p.setAddress(vos.get(15));
				p.setEngageForm(vos.get(16));
				p.setTipTopDegree(vos.get(17));
				p.setSpacialty(vos.get(18));
				p.setSchool(vos.get(19));

				try {
					Timestamp ts = new Timestamp(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").parse(vos.get(20)).getTime());
					// ↑ 将String转换成TimeStamp的方法
					p.setBeginWorkDate(ts);
				} catch (ParseException ee) {
					ee.printStackTrace();
				}
				p.setWorkState(vos.get(21));
				p.setWorkId(vos.get(22));
				p.setContractTerm(Integer.parseInt(vos.get(23)));

				try {
					Timestamp ts24 = new Timestamp(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").parse(vos.get(24)).getTime());
					p.setBeFormDate(ts24);
					Timestamp ts25 = new Timestamp(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").parse(vos.get(24)).getTime());
					p.setNotWorkState(ts25);
					Timestamp ts26 = new Timestamp(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").parse(vos.get(24)).getTime());
					p.setBeginContract(ts26);
					Timestamp ts27 = new Timestamp(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").parse(vos.get(24)).getTime());
					p.setEndContract(ts27);
				} catch (ParseException ee) {
					ee.printStackTrace();
				}
				p.setWorkAge(Integer.parseInt(vos.get(28)));
				p.setScore(Integer.parseInt(vos.get(29)));
				p.setIsDelete(Integer.parseInt(vos.get(30)));

				bDAO.save(p);

			} else if ("personnelremove".equals(tableName)) {

				BaseDAO<Personnelremove> bDAO = new BaseDAO<Personnelremove>();
				Personnelremove p = new Personnelremove();

				Personnelinfo pi = new Personnelinfo();
				pi.setPersonnelId(vos.get(1));
				p.setPersonnelinfo(pi);

				p.setAfterRemoveDepartment(vos.get(2));
				p.setBeforeRemoveDepartment(vos.get(3));
				p.setAfterRemoveJob(vos.get(4));
				p.setBeforeRemoveJob(vos.get(5));

				try {
					Timestamp ts = new Timestamp(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").parse(vos.get(6)).getTime());
					p.setRemoveDate(ts);
				} catch (ParseException ee) {
					ee.printStackTrace();
				}
				p.setRemoveReason(vos.get(7));
				p.setPersonnelRemoveRemark(vos.get(8));
				p.setIsDelete(Integer.parseInt(vos.get(9)));

				bDAO.save(p);

			} else if ("personneltrain".equals(tableName)) {

				BaseDAO<Personneltrain> bDAO = new BaseDAO<Personneltrain>();
				Personneltrain p = new Personneltrain();

				Personnelinfo pi = new Personnelinfo();
				pi.setPersonnelId(vos.get(1));
				p.setPersonnelinfo(pi);

				try {
					Timestamp ts = new Timestamp(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").parse(vos.get(2)).getTime());
					p.setPersonnelTrainDate(ts);
				} catch (ParseException ee) {
					ee.printStackTrace();
				}
				p.setPersonnelTrainConten(vos.get(3));
				p.setPersonnelTrainRemark(vos.get(4));
				p.setIsDelete(Integer.parseInt(vos.get(5)));

				bDAO.save(p);

			} else if ("salary".equals(tableName)) {

				BaseDAO<Salary> bDAO = new BaseDAO<Salary>();
				Salary s = new Salary();
				s.setBonus(Double.parseDouble(vos.get(1)));
				s.setLunchSalary(Double.parseDouble(vos.get(2)));
				s.setTrafficSalary(Double.parseDouble(vos.get(3)));
				s.setBasicSalary(Double.parseDouble(vos.get(4)));
				s.setAllSalary(Double.parseDouble(vos.get(5)));

				try {
					Timestamp ts = new Timestamp(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").parse(vos.get(6)).getTime());
					s.setUseredDate(ts);
				} catch (ParseException ee) {
					ee.printStackTrace();
				}
				s.setIsDelete(Integer.parseInt(vos.get(7)));

				bDAO.save(s);

			} else {
				System.out.println("未找到表 " + tableName + " 请检查表名和数据库连接");
			}

		}
		System.out.println("Excel存储完成");

	}

	public void BeginLoadExcel(String path, String tableName) { // 最终的调用方法

		/**
		 * 3.BeginLoadExcel 方法 为用户从外部调用的方法 使用的时候用户只用使用这个方法就行
		 * 
		 */
		
		System.out.println("Excel总操作开始");
		this.saveExcelToDB(this.readExcel(path), tableName);
		System.out.println("Excel总操作结束");
		
	}

	public static void main(String[] args) {  // 测试方法

		/**
		 * 测试一下 读取excel后存储到diction.log中
		 * 
		 * 注意！！！自己的vo构建的顺序要和从list中取出的顺序一致！！！
		 * 
		 * @author 李智Lychee
		 */

		ExcelReader er = new ExcelReader();

		String path = "D:/test2.xls";
		String tableName = "personneltrain";

		er.BeginLoadExcel(path, tableName);

	}
}
