package org.jsoft.comm.vo;

import java.util.HashSet;
import java.util.Set;


/**
 * Job entity. @author MyEclipse Persistence Tools
 */

public class Job  implements java.io.Serializable {


    // Fields    

     private String jobId;
     private String jobName;
     private Integer isDelete;
     private Set deptJobRels = new HashSet(0);


    // Constructors

    /** default constructor */
    public Job() {
    }

	/** minimal constructor */
    public Job(String jobId) {
        this.jobId = jobId;
    }
    
    /** full constructor */
    public Job(String jobId, String jobName, Integer isDelete, Set deptJobRels) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.isDelete = isDelete;
        this.deptJobRels = deptJobRels;
    }

   
    // Property accessors

    public String getJobId() {
        return this.jobId;
    }
    
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return this.jobName;
    }
    
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Set getDeptJobRels() {
        return this.deptJobRels;
    }
    
    public void setDeptJobRels(Set deptJobRels) {
        this.deptJobRels = deptJobRels;
    }
   








}