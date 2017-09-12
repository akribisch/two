package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.BankMenuBiz;
import com.web.entity.BankMenu;
import com.web.entity.Staff;

@Controller
@RequestMapping(value="menu")
public class BankMenuController {
	

	@Resource(name="bankMenuBizImpl")
	BankMenuBiz bmb;
	
	@RequestMapping(value="sendAdd")
	public ModelAndView sendAdd(ModelAndView mv){
		
		 List<BankMenu> list = bmb.findParent(null);
		 
		 mv.addObject("menuList", list);//传数据
		 mv.setViewName("addMenu");
		 
		 return mv;
	}
	
	@RequestMapping(value="saveMenu")
	public ModelAndView saveMenu(ModelAndView mv,BankMenu bm){
		Integer id=null;
		bm.setMenuLevel(1);
		if(bm.getParentId()==0){
			bm.setParentId(id);
			bm.setMenuLevel(2);
		}
		int res=bmb.insertBankMenu(bm);
		mv.setViewName(res > 0 ? "redirect:/menu/queryMenu.do" : "redirect:/menu/sendAdd.do");
		return mv;
	}
	
	@RequestMapping(value="queryMenu")
	public ModelAndView queryMenu(ModelAndView mv,Integer statId){
		List<BankMenu> list=bmb.findParent(null);
		List<Integer> checklist=bmb.findMenu(statId);
		checkMenu(list, checklist);
		mv.addObject("statId", statId);
		mv.addObject("list", list);
		mv.setViewName("menu");
		return mv;
	}
	@RequestMapping(value="allMenu")
	public ModelAndView allMenu(ModelAndView mv){
		List<BankMenu> list=bmb.findParent(null);
		mv.addObject("list", list);
		mv.setViewName("menulist");
		return mv;
	}
	
	@RequestMapping(value="changeMenu")
	public ModelAndView changeMenu(ModelAndView mv,Integer parentId){
		List<BankMenu> list=bmb.findParent(null);
		mv.addObject("list", list);
		mv.setViewName("menulist");
		return mv;
	}
	
	@RequestMapping(value="showMenu")
	public ModelAndView showMenu(ModelAndView mv,Integer statId,HttpServletRequest req){
		List<BankMenu> list=bmb.findParent(null);
		HttpSession session =  req.getSession();
		Staff staff= (Staff) session.getAttribute("Staff");
		if(statId==null&&staff!=null){
			statId=staff.getStation().getStatId();
		}
		List<Integer> checklist=bmb.findMenu(statId);
		checkMenu(list, checklist);
		mv.addObject("list", list);
		mv.setViewName("../admin/main");
		return mv;
	}
	
	@RequestMapping(value="saveAuthority")
	public ModelAndView saveAuthority(ModelAndView mv,Integer statId,Integer[] check){
		if(statId!=null){
			bmb.deleteMenu(statId);
		}
		
		if(statId!=null&&check!=null){
			for (Integer item : check) {
				Map<String, Object> map=new HashMap<>();
				map.put("statId", statId);
				map.put("menuId", item);
				bmb.insertMenu(map);
			}
		}
		mv.setViewName("redirect:/station/findStation.do");
		return mv;
	}
	
	/**
	 * 将list集合中的主键与第二个相比对
	 * @param list 所有的菜单
	 * @param checklist 比对的菜单
	 */
	public void checkMenu(List<BankMenu> list,List<Integer> checklist){
		if(list!=null){
			for (BankMenu bankMenu : list) {
				bankMenu.setHasAuthority(0);
				if(checklist!=null){
					for (Integer item : checklist) {
						if(item.intValue()==bankMenu.getMenuId()){
							bankMenu.setHasAuthority(1);
						}
					}
				}
				checkMenu(bankMenu.getChildMenu(), checklist);
			}
		}
	}

}
