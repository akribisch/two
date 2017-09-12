package com.web.biz;

import java.util.List;

import com.web.entity.Transfer;
import com.web.util.Page;

/**
 * 转账记录表实体类的业务逻辑层
 * @author java201
 *
 */
public interface TransferBiz {
	
	/**
	 * 动态分页查询
	 * @param page
	 * @return
	 */
	public List<Transfer> select(Page<Transfer> page);
	
	/**
	 * 动态分页查询的总条目数
	 * @param page
	 * @return
	 */
	public int selectCount(Page<Transfer> page);
	
	/**
	 * 根据主键查询
	 * @param transferId
	 * @return
	 */
	public Transfer selectById(int transferId);
	
	/**
	 * 添加
	 * @param transfer
	 * @return
	 */
	public int insert(Transfer transfer);
	
	/**
	 * 删除
	 * @param transferId
	 * @return
	 */
	public int deleteById(int transferId);
	
	/**
	 * 修改
	 * @param transfer
	 * @return
	 */
	public int updateById(Transfer transfer);
	
}
