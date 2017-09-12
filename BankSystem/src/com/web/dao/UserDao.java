package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.User;

public interface UserDao {
	/**
	 * 查询
	 * @return
	 */
public List<User> query();
	/**
	 * 分页查询用户信息
	 * @param map
	 * @return
	 */
public List<User> queryPageUser(Map<String, Object> map);
	/**
	 * 查询用户信息总的条数
	 * @param map
	 * @return
	 */
public int queryPageUserCount(Map<String, Object> map);
	/**
	 * 添加
	 * @return
	 */
public int addUser(User user);
	/**
	 * 修改
	 * @return
	 */
public int updateUser(User user);
	/**
	 * 删除
	 * @param id
	 */
public int delectUser(int id);
	/**
	 * 通过主键查找用户
	 * @return
	 */
public User queryById(int id);

}
