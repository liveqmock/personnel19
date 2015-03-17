package org.jsoft.comm.vo;

import java.util.HashSet;
import java.util.Set;


/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class Menu  implements java.io.Serializable {


    // Fields    

     private String menuId;
     private Menu menu;
     private String menuName;
     private String menuUrl;
     private String remark;
     private String menuDate;
     private Integer isDelete;
     private Set menus = new HashSet(0);


    // Constructors

    /** default constructor */
    public Menu() {
    }

	/** minimal constructor */
    public Menu(String menuId) {
        this.menuId = menuId;
    }
    
    /** full constructor */
    public Menu(String menuId, Menu menu, String menuName, String menuUrl, String remark, String menuDate, Integer isDelete, Set menus) {
        this.menuId = menuId;
        this.menu = menu;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.remark = remark;
        this.menuDate = menuDate;
        this.isDelete = isDelete;
        this.menus = menus;
    }

   
    // Property accessors

    public String getMenuId() {
        return this.menuId;
    }
    
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public Menu getMenu() {
        return this.menu;
    }
    
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getMenuName() {
        return this.menuName;
    }
    
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return this.menuUrl;
    }
    
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMenuDate() {
        return this.menuDate;
    }
    
    public void setMenuDate(String menuDate) {
        this.menuDate = menuDate;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Set getMenus() {
        return this.menus;
    }
    
    public void setMenus(Set menus) {
        this.menus = menus;
    }
   








}