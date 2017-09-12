package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.web.dao.DeviceDao;
import com.web.entity.Device;
import com.web.util.Page;

@Repository
public class DeviceDaoImpl extends CommonDaoImpl<Device> implements DeviceDao {

	@Override
	public void queryPaging(Page<Device> paging, Map<String, Object> map,String hql,String hql2) {
		StringBuffer hqls=new StringBuffer("from Device where 1=1 ");
		
		if(map != null){
			for (String key : map.keySet()) {
				if("typeId".equals(key)){
					hqls.append(" and typeId ="+map.get(key)+"");
				}
				if("deviceTypeId".equals(key)){
					hqls.append(" and deviceTypeId like '%"+map.get(key)+"%'");
				}
				if("deviceName".equals(key)){
					hqls.append(" and deviceName like '%"+map.get(key)+"%'");
				}
			}
		}
		hql=hqls.toString();
		StringBuffer hqls2=new StringBuffer("select count(*) from Device where 1=1 ");
		
		if(map != null){
			for (String key : map.keySet()) {
				if("typeId".equals(key)){
					hqls.append(" and typeId ="+map.get(key)+"");
				}
				if("deviceTypeId".equals(key)){
					hqls.append(" and deviceTypeId like '%"+map.get(key)+"%'");
				}
				if("deviceName".equals(key)){
					hqls.append(" and deviceName like '%"+map.get(key)+"%'");
				}
			}
		}
		hql2=hqls2.toString();
		super.queryPaging(paging, map, hql,hql2);
	}

	@Override
	public List<Device> queryAll(String hql) {
		hql="from Device ";
		return super.queryAll(hql);
	}

	
}
