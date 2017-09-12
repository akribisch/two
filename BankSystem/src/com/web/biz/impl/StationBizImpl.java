package com.web.biz.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.StationBiz;
import com.web.dao.StationDao;
import com.web.entity.Station;
import com.web.util.Page;

/**
 * 岗位表实体类的业务逻辑层
 * @author java2stationDao.1
 *
 */
@Service
public class StationBizImpl implements StationBiz {
	@Resource
	StationDao stationDao;

	@Override
	public Page<Station> select(Page<Station> page,Map<String, Object> map) {
		map.put("startIndex", page.getStartIndex());
		map.put("pageSize", page.getPageSize());
		page.setTotalRecord(stationDao.selectCount(map));
		page.setList(stationDao.select(map));
		return page;
	}

	@Override
	public Station selectById(int statId) {
		return stationDao.selectById(statId);
	}

	@Override
	public int insert(Station station) {
		return stationDao.insert(station);
	}

	@Override
	public int deleteById(int statId) {
		return stationDao.deleteById(statId);
	}

	@Override
	public int updateById(Station station) {
		return stationDao.updateById(station);
	}

	@Override
	public List<Station> selectAll() {
		return stationDao.selectAll();
	}
	
}
