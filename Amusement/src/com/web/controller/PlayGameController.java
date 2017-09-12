package com.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.PlayGameBiz;
import com.web.biz.RecreationBiz;
import com.web.biz.TouristBiz;
import com.web.entity.Device;
import com.web.entity.PlayGame;
import com.web.entity.Recreation;
import com.web.entity.Repair;
import com.web.entity.Tourist;
import com.web.entity.Type;
import com.web.util.Page;
import com.web.util.StringUtil;

@Controller
@RequestMapping(value="game/")
public class PlayGameController {

	@Resource(name="playGameBizImpl")
	PlayGameBiz pb;
	
	@Resource(name="recreationBizImpl")
	RecreationBiz rb;
	
	@Resource(name="touristBizImpl")
	TouristBiz tb;
	
	@RequestMapping(value="queryPlayGame")
	public ModelAndView queryAll(ModelAndView mv,Integer page,
			Integer minPrice,Integer maxPrice,String tourCount,String rname){
		Page<PlayGame> paging=new Page<>();
		Map<String, Object> map=new HashMap<>();
		if(page!=null){
			paging.setCurrentPage(page);
		}
		if(minPrice!=null){
			map.put("minPrice", minPrice);
		}
		if(maxPrice!=null){
			map.put("maxPrice", maxPrice);
		}
		if(tourCount!=null){
			map.put("tourCount", tourCount);
		}
		if(rname!=null){
			map.put("rname", rname);
		}
		pb.queryPaging(paging, map);
		mv.addObject("paging", paging);
		mv.setViewName("queryPlayGame");
		return mv;
	}
	@RequestMapping(value="sendAddPlayGame")
	public ModelAndView sendAddPlayGame(ModelAndView mv){
		List<Recreation> list=rb.queryAll();
		mv.addObject("list", list);
		mv.setViewName("addPlayGame");
		return mv;
	}
	@RequestMapping(value="addPlayGame")
	public ModelAndView addPlayGame(ModelAndView mv,PlayGame playGame,String tourCount,Integer rno){
		playGame.setPlayDate(new Date());
		Recreation r=rb.findById(Recreation.class, rno);
		Tourist tour=tb.findByTourCount(tourCount);
		playGame.setTourist(tour);
		playGame.setRecreation(r);
		boolean flag=pb.add(playGame);
		mv.setViewName(flag?"redirect:/game/queryPlayGame.do":"redirect:/game/sendAddPlayGame.do");
		return mv;
	}
	@RequestMapping(value="changePlayGame")
	public ModelAndView changeDevice(ModelAndView mv,Integer playGameId){
		PlayGame playGame= pb.findById(PlayGame.class, playGameId);
		mv.addObject("playGame", playGame);
		List<Recreation> list=rb.queryAll();
		mv.addObject("list", list);
		mv.setViewName("changePlayGame");
		return mv;
	}
	@RequestMapping(value="updatePlayGame")
	public ModelAndView updatePlayGame(ModelAndView mv,PlayGame playGame,String tourCount,Integer rno,String playDates){
		Date playDate= StringUtil.StringToDateYMD(playDates);
		playGame.setPlayDate(playDate);
		Recreation r=rb.findById(Recreation.class, rno);
		Tourist tour=tb.findByTourCount(tourCount);
		playGame.setTourist(tour);
		playGame.setRecreation(r);
		boolean flag=pb.update(playGame);
		mv.setViewName(flag?"redirect:/game/queryPlayGame.do":"redirect:/game/changePlayGame.do");
		return mv;
	}
	@RequestMapping(value="deletePlayGame")
	public ModelAndView deletePlayGame(ModelAndView mv,Integer playGameId){
		PlayGame playGame= pb.findById(PlayGame.class, playGameId);
		pb.delete(playGame);
		mv.setViewName("redirect:/game/queryPlayGame.do");
		return mv;
	}
}
