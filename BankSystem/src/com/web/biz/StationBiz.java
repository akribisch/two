package com.web.biz;


import java.util.List;
import java.util.Map;

import com.web.entity.Station;
import com.web.util.Page;

/**
 * 岗位表实体类的业务逻辑层
 * @author java201
 *
 */
public interface StationBiz {

	/**
	 * 动态分页查询
	 * @param page
	 * @return
	 */
	public Page<Station> select(Page<Station> page,Map<String, Object> map);
	
	/**
	 * 根据主键查询
	 * @param statId
	 * @return
	 */
	public Station selectById(int statId);
	
	/**
	 * 添加
	 * @param Station
	 * @return
	 */
	public int insert(Station station);
	
	/**
	 * 删除
	 * @param statId
	 * @return
	 */
	public int deleteById(int statId);
	
	/**
	 * 修改
	 * @param Station
	 * @return
	 */
	public int updateById(Station station);
	
	/**
	 * 全查询
	 * @return
	 */
	public List<Station> selectAll();
}
