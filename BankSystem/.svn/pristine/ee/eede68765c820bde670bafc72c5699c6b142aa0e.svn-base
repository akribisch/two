package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.FinalKind;

public interface FinalKindDao {
	/**
	 * 修改理财类型
	 * @return
	 */
	public int updateFinalKind(FinalKind finalKind);
	
	/**
	 * 添加理财类型
	 * @param finalKind
	 * @return
	 */
	public int insertFinalKind(FinalKind finalKind);
	
	/**
	 * 删除理财类型
	 * @return
	 */
	public int deleteFinalKind(int fkId);
	
	/**
	 * 查询全部理财类型
	 * @return
	 */
	public List<FinalKind> findAllKind(Map<String, Object> map);
	/**
	 * 查询全部理财记录总数
	 * @param map
	 * @return
	 */
	public int getFinalKindTotalCount(Map<String, Object> map);
	/**
	 * 通过编号查询
	 * @param fkId
	 * @return
	 */
	public FinalKind queryFinalKindById(Integer fkId);
	/**
	 * 无条件查询全部
	 * @return
	 */
	public List<FinalKind> getAllFinalKind();
	
}
