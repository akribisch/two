package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.UserBiz;
import com.web.dao.UserDao;
import com.web.entity.User;
@Service
public class UserBizImpl implements UserBiz {
	@Resource
	UserDao userdao;
	@Override
	public List<User> query() {
		return userdao.query();
	}
	@Override
	public int addUser(User user) {
		return userdao.addUser(user);
		
	}
	@Override
	public int updateUser(User user) {
		return userdao.updateUser(user);
		
	}
	@Override
	public int delectUser(int id) {
		return userdao.delectUser(id);
		
	}
	@Override
	public User queryById(int id) {
		return userdao.queryById(id);
	}
	@Override
	public List<User> queryPageUser(Map<String, Object> map) {
		return userdao.queryPageUser(map);
	}
	@Override
	public int queryPageUserCount(Map<String, Object> map) {
		return userdao.queryPageUserCount(map);
	}

}
