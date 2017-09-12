package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.BankMenuBiz;
import com.web.dao.BankMenuDao;
import com.web.entity.BankMenu;

@Service
public class BankMenuBizImpl implements BankMenuBiz {
	
	@Resource
	BankMenuDao bmd;

	@Override
	public List<BankMenu> findParent(Integer parentId) {
		List<BankMenu> parentlist=bmd.findParent(parentId);
		addChild(parentlist);
		return parentlist;
	}
	
	public void addChild(List<BankMenu> parentlist){
		if(parentlist!=null){
			for (BankMenu bankMenu : parentlist) {
				List<BankMenu> childlist=bmd.findParent(bankMenu.getMenuId());
				addChild(childlist);
				bankMenu.setChildMenu(childlist);
			}
		}
	}

	@Override
	public List<Integer> findMenu(Integer statid) {
		return bmd.findMenu(statid);
	}

	@Override
	public int insertMenu(Map<String, Object> map) {
		return bmd.insertMenu(map);
	}

	@Override
	public int deleteMenu(Integer statid) {
		return bmd.deleteMenu(statid);
	}

	@Override
	public int insertBankMenu(BankMenu bankMenu) {
		return bmd.insertBankMenu(bankMenu);
	}

}
