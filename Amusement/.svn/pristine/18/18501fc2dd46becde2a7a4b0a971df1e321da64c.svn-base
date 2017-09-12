package com.web.biz.impl;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.web.biz.UserBiz;
import com.web.dao.UserDao;
import com.web.entity.User;

@Service
public class UserBizImpl extends CommonBizImpl<User> implements UserBiz {
	
	UserDao userDao;
	
	@Resource(name="userDaoImpl")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		super.setCommonDao(userDao);
	}

	@Override
	public User login(User u) {
		return userDao.login(u);
	}

	@Override
	public User findByName(String userName) {
		return userDao.findByName(userName);
	}
	
}
