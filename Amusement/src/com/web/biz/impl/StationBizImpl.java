package com.web.biz.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.web.biz.StationBiz;
import com.web.dao.StationDao;
import com.web.entity.Station;

@Service
public class StationBizImpl extends CommonBizImpl<Station> implements StationBiz {

	StationDao stationDao;
	
	@Resource(name="stationDaoImpl")
	public void setStationDao(StationDao stationDao) {
		this.stationDao = stationDao;
		super.setCommonDao(stationDao);
	}
	
}
