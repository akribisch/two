package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.TransferBiz;
import com.web.dao.TransferDao;
import com.web.entity.Transfer;
import com.web.util.Page;

/**
 * 转账记录表实体类的业务逻辑层
 * @author java2transferDao.1
 *
 */
@Service
public class TransferBizImpl implements TransferBiz {
	@Resource
	TransferDao transferDao;

	@Override
	public List<Transfer> select(Page<Transfer> page) {
		return transferDao.select(page);
	}

	@Override
	public int selectCount(Page<Transfer> page) {
		return transferDao.selectCount(page);
	}

	@Override
	public Transfer selectById(int transferId) {
		return transferDao.selectById(transferId);
	}

	@Override
	public int insert(Transfer transfer) {
		return transferDao.insert(transfer);
	}

	@Override
	public int deleteById(int transferId) {
		return transferDao.deleteById(transferId);
	}

	@Override
	public int updateById(Transfer transfer) {
		return transferDao.updateById(transfer);
	}
	
}
