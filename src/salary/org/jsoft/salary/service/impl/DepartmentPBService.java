package org.jsoft.salary.service.impl;

import java.sql.Date;
import java.util.List;

import org.jsoft.salary.dao.impl.DepartmentDAO;
import org.jsoft.salary.dao.impl.DeptJobRelDAO;
import org.jsoft.salary.dao.impl.EncorchastDAO;
import org.jsoft.salary.dao.impl.PEOCDAO;
import org.jsoft.salary.dao.impl.PersonnelInfoDAO;
import org.jsoft.salary.service.IDepartmentPBService;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.Encorchast;
import org.jsoft.comm.vo.Peoc;
import org.jsoft.comm.vo.Personnelinfo;

public class DepartmentPBService implements IDepartmentPBService {

	public List<Department> queryDept() {
		DepartmentDAO dd = new DepartmentDAO();
		return dd.queryAllDept();
	}

	public String checkMethod(String method) {
		String result = "get";
		if (method.equals("POST")) {
			result = "post";
		}
		return result;
	}

	public String dopb(String method, String pbtype, String pbpoint,
			String pbmoney, String pblevel, String pbreason, String pbremark,
			String[] deptid) {
		String result = "";
		if (method.equals("post")) {
			int point = 0;
			int money = 0;
			if (deptid == null) {
				result = "请选择需要修改的部门！" + result;
			}
			if (pblevel.equals("一等") == false && pblevel.equals("二等") == false
					&& pblevel.equals("三等") == false
					&& pblevel.equals("四等") == false) {
				result = "请选择奖罚等级！\\n" + result;
			}

			if (pbmoney.matches("[0-9]+")) {
				money = Integer.parseInt(pbmoney);
			} else {
				result = "奖罚钱数必须是正整数！\\n" + result;
			}

			if (pbpoint.matches("[0-9]+")) {
				point = Integer.parseInt(pbpoint);
			} else {
				result = "奖罚点数必须是正整数！\\n" + result;
			}

			if (pbtype.equals("罚款")) {
				money = 0 - money;
				point = 0 - point;
			} else if (pbtype.equals("奖励") == false) {
				result = "请选择奖罚类型！\\n" + result;
			}
			if (result.isEmpty()) {
				System.out.println("条件判断通过。");
				Encorchast encorchast = new Encorchast();
				encorchast.setIsDelete(0);
				encorchast.setMoney((double) money);
				encorchast.setPersonnelEncOrChastPoint((double) point);
				encorchast.setPersonnelEncOrChastSort(pblevel);
				EncorchastDAO encorchastdao = new EncorchastDAO();
				encorchastdao.updateEncorchast(encorchast);

				for (String departmentid : deptid) {
					Peoc peoc = new Peoc();
					peoc.setEncorchast(encorchast);
					peoc.setIsDelete(0);
					peoc.setPeocReason(pbreason);
					peoc.setPersonnelTrainRemark(pbremark);
					PEOCDAO peocdao = new PEOCDAO();
					System.out.println("部门号：" + departmentid);
					DepartmentDAO dd = new DepartmentDAO();
					Department dept = dd.queryDeptById(departmentid);
					if (dept == null) {
						result = "部门号" + departmentid + "有误!请重试\\n" + result;
						break;
					}
					System.out.println("部门名称：" + dept.getDepartmentName());
					DeptJobRelDAO djrd = new DeptJobRelDAO();
					List<DeptJobRel> djr = djrd.queryDeptJobRelFromDepartmentId(dept
							.getDepartmentId());
					if (djr == null) {
						result = "部门号" + departmentid + "有误!请重试\\n" + result;
						break;
					}
					for (DeptJobRel deptJobRel : djr) {
						System.out.println("部门职位人员关系表id："
								+ deptJobRel.getDeptJobRelId());
						PersonnelInfoDAO pid = new PersonnelInfoDAO();
						Personnelinfo pi = pid.queryPersonnelInfoFromDeptJobRelId(deptJobRel
								.getDeptJobRelId());

						if (pi == null) {
							result = "部门号" + departmentid + "有误!请重试\\n"
									+ result;
							break;
						}
						System.out.println("人员名字：" + pi.getPersonnelName());
						peoc.setPersonnelinfo(pi);
						java.util.Date ud = new java.util.Date();
						java.sql.Timestamp st;
						st=new java.sql.Timestamp(ud.getTime());
						peoc.setPeocDate(st);
						peocdao.updatePEOC(peoc);
						result ="操作成功！";
					}
				}
			}
		}
		System.out.println(result);
		return result;
	}
}
