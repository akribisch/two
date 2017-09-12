package com.web.dao.impl;




import java.util.List;



import org.springframework.stereotype.Repository;

import com.web.dao.VipLevelDao;
import com.web.entity.VipLevel;

@Repository
public class VipLevelDaoImpl extends CommonDaoImpl<VipLevel> implements VipLevelDao {

	public List<VipLevel> queryAll(String hql){
		
		hql="from VipLevel";
		
	   
	    return super.queryAll(hql);
		
		
	}
	

	

}
