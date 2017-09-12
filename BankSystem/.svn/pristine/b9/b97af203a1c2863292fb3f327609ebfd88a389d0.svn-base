package com.web.biz;

import java.util.List;

import com.web.entity.TransferState;
import com.web.util.Page;

/**
 * 转账状态表实体类的业务逻辑层
 * @author java201
 *
 */
public interface TransferStateBiz {

	/**
	 * 动态分页查询
	 * @param page
	 * @return
	 */
	public List<TransferState> select(Page<TransferState> page);
	
	/**
	 * 动态分页查询的总条目数
	 * @param page
	 * @return
	 */
	public int selectCount(Page<TransferState> page);
	
	/**
	 * 根据主键查询
	 * @param statId
	 * @return
	 */
	public TransferState selectById(int stateId);
	
	/**
	 * 添加
	 * @param transferState
	 * @return
	 */
	public int insert(TransferState transferState);
	
	/**
	 * 删除
	 * @param statId
	 * @return
	 */
	public int deleteById(int stateId);
	
	/**
	 * 修改
	 * @param transferState
	 * @return
	 */
	public int updateById(TransferState transferState);
	
}
