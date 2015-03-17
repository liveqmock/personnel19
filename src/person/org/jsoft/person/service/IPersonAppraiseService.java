package org.jsoft.person.service;


import java.util.List;
import org.jsoft.comm.vo.Personnelappraise;

public interface IPersonAppraiseService {
	public List<Personnelappraise> findAll(String tempCurrentPage);
	public Personnelappraise findSingle(String personnelAppraiseId);
	public List<Personnelappraise> findByDepartment(String departmentName,
			String tempCurrentPage);
	public List<Personnelappraise> findByJob(String jobName,
			String tempCurrentPage);
	public void add(String personnelId, String personnelAppraiseContent,
			String ptdTemp, String personnelAppraiseResult,
			String personnelAppraiseRemark);
	public void update(String personnelAppraiseId,
			String personnelAppraiseContent, String ptdTemp,
			String personnelAppraiseResult, String personnelAppraiseRemark,
			int isDelete);

}
