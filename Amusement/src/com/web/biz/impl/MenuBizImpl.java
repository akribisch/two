package com.web.biz.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.web.biz.MenuBiz;
import com.web.dao.MenuDao;
import com.web.entity.Menu;

@Service
public class MenuBizImpl extends CommonBizImpl<Menu> implements MenuBiz {
	
	MenuDao menuDao;
	
	@Resource(name="menuDaoImpl")
	public void setUserDao(MenuDao menuDao) {
		this.menuDao = menuDao;
		super.setCommonDao(menuDao);
	}
	
	
}
