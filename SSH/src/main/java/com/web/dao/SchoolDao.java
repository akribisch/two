package com.web.dao;

import java.util.List;

import com.web.entity.School;

public interface SchoolDao extends CommonDao<School> {

	public List<School> query();
}
