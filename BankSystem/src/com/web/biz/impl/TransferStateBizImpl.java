package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.TransferStateBiz;
import com.web.dao.TransferStateDao;
import com.web.entity.TransferState;
import com.web.util.Page;

/**
 * 转账状态表实体类的业务逻辑层
 * @author java201
 *
 */
@Service
public class TransferStateBizImpl implements TransferStateBiz {
	@Resource
	TransferStateDao transferStateDao;

	@Override
	public List<TransferState> select(Page<TransferState> page) {
		return transferStateDao.select(page);
	}

	@Override
	public int selectCount(Page<TransferState> page) {
		return transferStateDao.selectCount(page);
	}

	@Override
	public TransferState selectById(int stateId) {
		return transferStateDao.selectById(stateId);
	}

	@Override
	public int insert(TransferState transferState) {
		return transferStateDao.insert(transferState);
	}

	@Override
	public int deleteById(int stateId) {
		return transferStateDao.deleteById(stateId);
	}

	@Override
	public int updateById(TransferState transferState) {
		return transferStateDao.updateById(transferState);
	}
	
	
	
}
