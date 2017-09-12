package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.AccessBiz;
import com.web.dao.AccessDao;
import com.web.entity.Access;
import com.web.util.Page;

/**
 * 存取款表实体类的业务逻辑层实现类
 * @author java201
 *
 */
@Service
public class AccessBizImpl implements AccessBiz {
	
	@Resource
	AccessDao asdao;
	
	@Override
	public List<Access> selectAll() {
		return asdao.selectAll();
	}

	@Override
	public List<Access> select(Page<Access> page) {
		return asdao.select(page);
	}

	@Override
	public int selectCount(Page<Access> page) {
		return asdao.selectCount(page);
	}
	
	@Override
	public int insert(Access access) {
		return asdao.insert(access);
	}

	@Override
	public int deleteById(int accessId) {
		return asdao.deleteById(accessId);
	}

	@Override
	public int updateById(Access access) {
		return asdao.updateById(access);
	}


}
