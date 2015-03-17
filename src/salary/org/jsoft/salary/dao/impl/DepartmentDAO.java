package org.jsoft.salary.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.Job;
import org.jsoft.salary.dao.IDepartmentDAO;

public class DepartmentDAO extends BaseDAO<Department> implements
		IDepartmentDAO
{
	@Override
	public Department queryDeptByDeptName(String DeptName)
	{
		Session session = getSession();
		// session.beginTransaction();查询不需要开事务
		Query query = session
				.createQuery("FROM Department where departmentName ="
						+ DeptName);
		List<Department> deptlist = query.list();
		return deptlist.get(0);

	}

	@Override
	public List<Department> queryAllDept()
	{
		// TODO Auto-generated method stub
		String hql = "from Department where isDelete = 0";
		return find(hql);
	}

	@Override
	public Department queryDeptById(String deptid)
	{

		String hql = "from Department where departmentId =" + deptid;
		List<Department> list = find(hql);
		Department department = list.get(0);
		return department;

	}

	public List<DeptJobRel> queryDeptJobRelbyDept(Department department)
	{
		BaseDAO<DeptJobRel> base = new BaseDAO<DeptJobRel>();
		String deptid = department.getDepartmentId();
		String hql = "from DeptJobRel where department.departmentId=" + deptid+"and salary is not null";
		List<DeptJobRel> list = base.find(hql);
		return list;

	}

	public static void main(String[] args)
	{

		Department department=new Department();
		department.setDepartmentId("1");
		DepartmentDAO de=new DepartmentDAO();
		List<DeptJobRel> list=de.queryDeptJobRelbyDept(department);
		for (DeptJobRel job : list)
		{
			System.out.println(job.getJob().getJobName());
			
		}
	}
}
