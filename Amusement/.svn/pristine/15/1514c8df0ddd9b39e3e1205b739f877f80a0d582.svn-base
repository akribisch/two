package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.PlayGameBiz;
import com.web.dao.PlayGameDao;
import com.web.entity.PlayGame;
import com.web.util.Page;
@Service
public class PlayGameBizImpl extends CommonBizImpl<PlayGame> implements PlayGameBiz {

	PlayGameDao pd;
	@Resource(name="playGameDaoImpl")
	public void setPd(PlayGameDao pd) {
		this.pd = pd;
		super.setCommonDao(pd);
	}


	@Override
	public void queryPaging(Page<PlayGame> paging, Map<String, Object> map) {
		String hql=null;
		String hql2=null;
		pd.queryPaging(paging, map, hql, hql2);

	}


}
