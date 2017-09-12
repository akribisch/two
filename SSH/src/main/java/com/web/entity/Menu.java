package com.web.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="rw_menu")
public class Menu implements Serializable {

	private int menuId;//菜单id
	private String menuName;//菜单名称
	private Menu parentMenu;// 多对一     多个菜单对应一个父级菜单
	private int menuLevel;//节点的层级  
    private String menuImage;//节点图标
    private int menuSort;//节点排序
    private String menuUrl;//菜单访问地址
    private int isDisplay;//是否显示     1：显示   0：不显示
    
    private List<Menu> childMenu = new ArrayList<Menu>();//子菜单   一对多    一个菜单下面有多个子菜单
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@ManyToOne
	@JoinColumn(name="parentId")
	public Menu getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}

	public int getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getMenuImage() {
		return menuImage;
	}

	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}

	public int getMenuSort() {
		return menuSort;
	}

	public void setMenuSort(int menuSort) {
		this.menuSort = menuSort;
	}

	public int getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	}

	@OneToMany(mappedBy="parentMenu")  //mappedBy:该对象在关联的对象中的属性名称
	public List<Menu> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<Menu> childMenu) {
		this.childMenu = childMenu;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	
}
