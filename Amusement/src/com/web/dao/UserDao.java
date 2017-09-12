package com.web.dao;

import com.web.entity.User;

public interface UserDao extends CommonDao<User>{
	/**
	 * 登陆
	 * @param u
	 * @return
	 */
	public User login(User u);
	/**
	 * 根据用户姓名查询
	 * @param userName
	 * @return
	 */
	public User findByName(String userName);
}
