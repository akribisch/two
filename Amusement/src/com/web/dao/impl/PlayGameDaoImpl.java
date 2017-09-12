package com.web.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.web.dao.PlayGameDao;
import com.web.entity.PlayGame;
import com.web.util.Page;

@Repository
public class PlayGameDaoImpl extends CommonDaoImpl<PlayGame> implements PlayGameDao {


	@Override
	public void queryPaging(Page<PlayGame> paging, Map<String, Object> map, String hql, String hql2) {
		StringBuffer hqls=new StringBuffer("from PlayGame where 1=1 ");
		StringBuffer hqls2=new StringBuffer("select count(*) from PlayGame where 1=1 ");
		if(map!=null){
			for (String item : map.keySet()) {
				if("tourName".equals(item)){
					hqls.append(" and tourist.tourCount='"+map.get(item)+"'");
					hqls2.append(" and tourist.tourCount='"+map.get(item)+"'");
				}
				if("rname".equals(item)){
					hqls.append(" and recreation.rname like '%"+map.get(item)+"%'");
					hqls2.append(" and recreation.rname like '%"+map.get(item)+"%'");
				}
				if("minPrice".equals(item)){
					hqls.append(" and playPrice>='"+map.get(item)+"'");
					hqls2.append(" and playPrice>='"+map.get(item)+"'");
				}
				if("maxPrice".equals(item)){
					hqls.append(" and playPrice<='"+map.get(item)+"'");
					hqls2.append(" and playPrice<='"+map.get(item)+"'");
				}
			}
		}
		hql=hqls.toString();
		hql2=hqls2.toString();
		super.queryPaging(paging, map, hql, hql2);
	}


}
