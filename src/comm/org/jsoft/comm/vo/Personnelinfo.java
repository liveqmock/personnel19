package org.jsoft.comm.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Personnelinfo  implements java.io.Serializable {

    // Fields    

     private String personnelId;
     private DeptJobRel deptJobRel;
     private Duty duty;
     private String personnelNo;
     private String personnelName;
     private String personnelSex;
     private Timestamp birthday;
     private Integer age;
     private String identityId;
     private String wedLock;
     private String race;
     private String nativePlace;
     private String politic;
     private String EMail;
     private String phone;
     private String address;
     private String engageForm;
     private String tipTopDegree;
     private String spacialty;
     private String school;
     private Timestamp beginWorkDate;
     private String workState;
     private String workId;
     private Integer contractTerm;
     private Timestamp beFormDate;
     private Timestamp notWorkState;
     private Timestamp beginContract;
     private Timestamp endContract;
     private Integer workAge;
     private Integer score;
     private Integer isDelete;
     private Set operaters = new HashSet(0);
     private Set personnelremoves = new HashSet(0);
     private Set personnelappraises = new HashSet(0);
     private Set personneltrains = new HashSet(0);
     private Set peocs = new HashSet(0);


    // Constructors

    /** default constructor */
    public Personnelinfo() {
    }

	/** minimal constructor */
    public Personnelinfo(String personnelId) {
        this.personnelId = personnelId;
    }
    
    /** full constructor */
    public Personnelinfo(String personnelId, DeptJobRel deptJobRel, Duty duty, String personnelNo, String personnelName, String personnelSex, Timestamp birthday, Integer age, String identityId, String wedLock, String race, String nativePlace, String politic, String EMail, String phone, String address, String engageForm, String tipTopDegree, String spacialty, String school, Timestamp beginWorkDate, String workState, String workId, Integer contractTerm, Timestamp beFormDate, Timestamp notWorkState, Timestamp beginContract, Timestamp endContract, Integer workAge, Integer score, Integer isDelete, Set operaters, Set personnelremoves, Set personnelappraises, Set personneltrains, Set peocs) {
        this.personnelId = personnelId;
        this.deptJobRel = deptJobRel;
        this.duty = duty;
        this.personnelNo = personnelNo;
        this.personnelName = personnelName;
        this.personnelSex = personnelSex;
        this.birthday = birthday;
        this.age = age;
        this.identityId = identityId;
        this.wedLock = wedLock;
        this.race = race;
        this.nativePlace = nativePlace;
        this.politic = politic;
        this.EMail = EMail;
        this.phone = phone;
        this.address = address;
        this.engageForm = engageForm;
        this.tipTopDegree = tipTopDegree;
        this.spacialty = spacialty;
        this.school = school;
        this.beginWorkDate = beginWorkDate;
        this.workState = workState;
        this.workId = workId;
        this.contractTerm = contractTerm;
        this.beFormDate = beFormDate;
        this.notWorkState = notWorkState;
        this.beginContract = beginContract;
        this.endContract = endContract;
        this.workAge = workAge;
        this.score = score;
        this.isDelete = isDelete;
        this.operaters = operaters;
        this.personnelremoves = personnelremoves;
        this.personnelappraises = personnelappraises;
        this.personneltrains = personneltrains;
        this.peocs = peocs;
    }

   
    // Property accessors

    public String getPersonnelId() {
        return this.personnelId;
    }
    
    public void setPersonnelId(String personnelId) {
        this.personnelId = personnelId;
    }
    public Personnelinfo personnelId(String personnelId){
    	this.personnelId=personnelId;
    	return this;
    }
    public DeptJobRel getDeptJobRel() {
        return this.deptJobRel;
    }
    public void setDeptJobRel(DeptJobRel deptJobRel) {
        this.deptJobRel = deptJobRel;
    }
    public Personnelinfo DeptJobRel(DeptJobRel deptJobRel){
    	this.deptJobRel = deptJobRel;
    	return this;
    }
    
    public Duty getDuty() {
        return this.duty;
    }
    public void setDuty(Duty duty) {
        this.duty = duty;
    }
    public Personnelinfo Duty(Duty duty) {
        this.duty = duty;
        return this;
    }
    
    public String getPersonnelNo() {
        return this.personnelNo;
    }
    public void setPersonnelNo(String personnelNo) {
        this.personnelNo = personnelNo;
    }
    public Personnelinfo PersonnelNo(String personnelNo) {
        this.personnelNo = personnelNo;
        return this;
    }
    
    public String getPersonnelName() {
        return this.personnelName;
    }
    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
    }
    public Personnelinfo PersonnelName(String personnelName) {
        this.personnelName = personnelName;
        return this;
    }
    
    public String getPersonnelSex() {
        return this.personnelSex;
    }
    public void setPersonnelSex(String personnelSex) {
        this.personnelSex = personnelSex;
    }
    public Personnelinfo PersonnelSex(String personnelSex) {
        this.personnelSex = personnelSex;
        return this;
    }
    
    public Timestamp getBirthday() {
        return this.birthday;
    }
    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }
    public Personnelinfo Birthday(Timestamp birthday) {
        this.birthday = birthday;
        return this;
    }
    
    public Integer getAge() {
        return this.age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Personnelinfo Age(Integer age) {
        this.age = age;
        return this;
    }
    
    public String getIdentityId() {
        return this.identityId;
    }
    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }
    public Personnelinfo IdentityId(String identityId) {
        this.identityId = identityId;
        return this;
    }
    
    public String getWedLock() {
        return this.wedLock;
    }
    public void setWedLock(String wedLock) {
        this.wedLock = wedLock;
    }
    public Personnelinfo WedLock(String wedLock) {
        this.wedLock = wedLock;
        return this;
    }
    
    public String getRace() {
        return this.race;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public Personnelinfo Race(String race) {
        this.race = race;
        return this;
    }
    
    public String getNativePlace() {
        return this.nativePlace;
    }
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }
    public Personnelinfo NativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
        return this;
    }
    
    public String getPolitic() {
        return this.politic;
    }
    public void setPolitic(String politic) {
        this.politic = politic;
    }
    public Personnelinfo Politic(String politic) {
        this.politic = politic;
        return this;
    }
    
    public String getEMail() {
        return this.EMail;
    }
    public void setEMail(String EMail) {
        this.EMail = EMail;
    }
    public Personnelinfo EMail(String EMail) {
        this.EMail = EMail;
        return this;
    }
    
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Personnelinfo Phone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Personnelinfo Address(String address) {
        this.address = address;
        return this;
    }
    
    public String getEngageForm() {
        return this.engageForm;
    }
    public void setEngageForm(String engageForm) {
        this.engageForm = engageForm;
    }
    public Personnelinfo EngageForm(String engageForm) {
        this.engageForm = engageForm;
        return this;
    }

    public String getTipTopDegree() {
        return this.tipTopDegree;
    }
    public void setTipTopDegree(String tipTopDegree) {
        this.tipTopDegree = tipTopDegree;
    }
    public Personnelinfo TipTopDegree(String tipTopDegree) {
        this.tipTopDegree = tipTopDegree;
        return this;
    }
    public String getSpacialty() {
        return this.spacialty;
    }
    public void setSpacialty(String spacialty) {
        this.spacialty = spacialty;
    }
    public Personnelinfo Spacialty(String spacialty) {
        this.spacialty = spacialty;
        return this;
    }
    
    public String getSchool() {
        return this.school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public Personnelinfo School(String school) {
        this.school = school;
        return this;
    }

    public Timestamp getBeginWorkDate() {
        return this.beginWorkDate;
    }
    public void setBeginWorkDate(Timestamp beginWorkDate) {
        this.beginWorkDate = beginWorkDate;
    }
    public Personnelinfo BeginWorkDate(Timestamp beginWorkDate) {
        this.beginWorkDate = beginWorkDate;
        return this;
    }

    public String getWorkState() {
        return this.workState;
    }
    public void setWorkState(String workState) {
        this.workState = workState;
    }
    public Personnelinfo WorkState(String workState) {
        this.workState = workState;
        return this;
    }

    public String getWorkId() {
        return this.workId;
    }
    public void setWorkId(String workId) {
        this.workId = workId;
    }
    public Personnelinfo WorkId(String workId) {
        this.workId = workId;
        return this;
    }

    public Integer getContractTerm() {
        return this.contractTerm;
    }
    public void setContractTerm(Integer contractTerm) {
        this.contractTerm = contractTerm;
    }
    public Personnelinfo ContractTerm(Integer contractTerm) {
        this.contractTerm = contractTerm;
        return this;
    }

    public Timestamp getBeFormDate() {
        return this.beFormDate;
    }
    public void setBeFormDate(Timestamp beFormDate) {
        this.beFormDate = beFormDate;
    }
    public Personnelinfo BeFormDate(Timestamp beFormDate) {
        this.beFormDate = beFormDate;
        return this;
    }

    public Timestamp getNotWorkState() {
        return this.notWorkState;
    }
    public void setNotWorkState(Timestamp notWorkState) {
        this.notWorkState = notWorkState;
    }
    public Personnelinfo NotWorkState(Timestamp notWorkState) {
        this.notWorkState = notWorkState;
        return this;
    }

    public Timestamp getBeginContract() {
        return this.beginContract;
    }
    public void setBeginContract(Timestamp beginContract) {
        this.beginContract = beginContract;
    }
    public Personnelinfo BeginContract(Timestamp beginContract) {
        this.beginContract = beginContract;
        return this;
    }

    public Timestamp getEndContract() {
        return this.endContract;
    }
    public void setEndContract(Timestamp endContract) {
        this.endContract = endContract;
    }
    public Personnelinfo EndContract(Timestamp endContract) {
        this.endContract = endContract;
    return this;
    }

    public Integer getWorkAge() {
        return this.workAge;
    }
    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }
    public Personnelinfo WorkAge(Integer workAge) {
        this.workAge = workAge;
        return this;
    }

    public Integer getScore() {
        return this.score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
    public Personnelinfo Score(Integer score) {
        this.score = score;
        return this;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public Personnelinfo IsDelete(Integer isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public Set getOperaters() {
        return this.operaters;
    }
    public void setOperaters(Set operaters) {
        this.operaters = operaters;
    }
    public Personnelinfo Operaters(Set operaters) {
        this.operaters = operaters;
        return this;
    }

    public Set getPersonnelremoves() {
        return this.personnelremoves;
    }
    public void setPersonnelremoves(Set personnelremoves) {
        this.personnelremoves = personnelremoves;
    }
    public Personnelinfo Personnelremoves(Set personnelremoves) {
        this.personnelremoves = personnelremoves;
        return this;
    }

    public Set getPersonnelappraises() {
        return this.personnelappraises;
    }
    public void setPersonnelappraises(Set personnelappraises) {
        this.personnelappraises = personnelappraises;
    }
    public Personnelinfo Personnelappraises(Set personnelappraises) {
        this.personnelappraises = personnelappraises;
        return this;
    }

    public Set getPersonneltrains() {
        return this.personneltrains;
    }
    public void setPersonneltrains(Set personneltrains) {
        this.personneltrains = personneltrains;
    }
    public Personnelinfo Personneltrains(Set personneltrains) {
        this.personneltrains = personneltrains;
        return this;
    }

    public Set getPeocs() {
        return this.peocs;
    }
    public void setPeocs(Set peocs) {
        this.peocs = peocs;
    }
    public Personnelinfo Peocs(Set peocs) {
        this.peocs = peocs;
    return this;
    }
    
   








}