package com.web.dao;

import java.util.List;

import com.web.entity.Menu;

public interface MenuDao extends CommonDao<Menu> {

	public List<Menu> findByParentId(int parentId);
}
