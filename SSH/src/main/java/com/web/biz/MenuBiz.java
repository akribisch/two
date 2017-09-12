package com.web.biz;

import java.util.List;

import com.web.entity.Menu;

public interface MenuBiz extends CommonBiz<Menu> {

	public List<Menu> findByParentId(int parentId);
}
