package com.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.TouristBiz;
import com.web.entity.Device;
import com.web.entity.Repair;
import com.web.entity.Tourist;
import com.web.util.Page;

@Controller
@RequestMapping(value="tourist/")
public class TouristController {

	@Resource(name="touristBizImpl")
	TouristBiz tb;
	
	@RequestMapping(value="queryTourist")
	public ModelAndView queryAll(ModelAndView mv,Integer page,String tourCount,String tourName,Integer tourSex){
		Page<Tourist> paging=new Page<>();
		Map<String, Object> map=new HashMap<>();
		if(page!=null){
			paging.setCurrentPage(page);
		}
		if(tourCount!=null){
			map.put("tourCount",tourCount );
		}
		if(tourName!=null){
			map.put("tourName",tourCount );
		}
		if(tourSex!=null){
			map.put("tourSex",tourSex );
		}
		tb.queryPaging(paging, map);
		mv.addObject("paging", paging);
		mv.setViewName("queryTourist");
		return mv;
	}
	
	@RequestMapping(value="addTourist")
	public ModelAndView addRepair(ModelAndView mv,Tourist tourist){
		boolean flag=tb.add(tourist);
		mv.setViewName(flag?"redirect:/tourist/queryTourist.do":"addTourist");
		return mv;
	}
	@RequestMapping(value="changeTourist")
	public ModelAndView changeTourist(ModelAndView mv,Integer touId){
		Tourist tourist=tb.findById(Tourist.class, touId);
		mv.addObject("tourist",tourist );
		mv.setViewName("changeTourist");
		return mv;
	}
	@RequestMapping(value="updateTourist")
	public ModelAndView updateRepair(ModelAndView mv,Tourist tourist){
		boolean flag=tb.update(tourist);
		mv.setViewName(flag?"redirect:/tourist/queryTourist.do":"redirect:/tourist/changeTourist.do");
		return mv;
	}
	@RequestMapping(value="deleteTourist")
	public ModelAndView deleteTourist(ModelAndView mv,Integer touId){
		Tourist tourist=tb.findById(Tourist.class, touId);
		tb.delete(tourist);
		mv.setViewName("redirect:/tourist/queryTourist.do");
		return mv;
	}
	
	/**
	 * 导出excel
	 * url:student/excelStudent.do
	 */
	@RequestMapping(path="excelTourist")
	public void downloadExcel(HttpServletResponse resp){
		Page<Tourist> paging = new Page<>();
		paging.setPageSize(2000);
		Map<String, Object> map=new HashMap<>();
		tb.queryPaging(paging, map);
		//分页查询
		
		//导出excel表中的数据
		 List<Tourist> data = paging.getList();
		 
		 //excel表的导出
		 createExcel(data,resp);
	}
	
	/**
	 * 创建excel表
	 */
	public void createExcel(List<Tourist> data,HttpServletResponse resp){
		// 第一步，创建一个webbook，对应一个Excel文件    
        HSSFWorkbook wb = new HSSFWorkbook();
        
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet    
        HSSFSheet sheet = wb.createSheet("游客表"); 
        
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short    
        HSSFRow row1 = sheet.createRow((int) 0);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        HSSFCell cellheader = row1.createCell(0);
        cellheader.setCellValue("游客信息");
        
        HSSFRow row = sheet.createRow((int) 1); 
        
        // 第四步，创建单元格，并设置值表头 设置表头居中    
        HSSFCellStyle style = wb.createCellStyle();    
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        
        HSSFCell cell = row.createCell(0);    
        cell.setCellValue("游客主键");    
        cell.setCellStyle(style);    
        cell = row.createCell(1);    
        cell.setCellValue("游客账户"); 
        cell = row.createCell(2);    
        cell.setCellValue("游客名称"); 
        cell = row.createCell(3);    
        cell.setCellValue("游客性别"); 
        cell = row.createCell(4);    
        cell.setCellValue("游客电话"); 
        cell = row.createCell(5);    
        cell.setCellValue("游客电子邮箱"); 
        
        for (int i = 0; i < data.size(); i++)    
        {    
            row = sheet.createRow((int) i + 2); //有多少条数据就应该创建多少行   
            Tourist t = data.get(i);
            
            // 第四步，创建单元格，并设置值    
            row.createCell(0).setCellValue(t.getTouId());    
            row.createCell(1).setCellValue(t.getTourCount());    
            row.createCell(2).setCellValue(t.getTourName());  
            row.createCell(3).setCellValue(t.getTourSex()); 
            row.createCell(4).setCellValue(t.getTourPhone()); 
            row.createCell(5).setCellValue(t.getTourEmail()); 
        }
        
        
       // 第六步，下载excel  
        OutputStream out = null;    
        try {        
            out = resp.getOutputStream();//获取输出流   
            String fileName = "tourist.xls";// 文件名    
            resp.setContentType("application/x-msdownload");    
            resp.setHeader("Content-Disposition", "attachment; filename="    
                                                    + URLEncoder.encode(fileName, "UTF-8"));    
            wb.write(out);    
        } catch (Exception e) {    
            e.printStackTrace();    
        } finally {      
            try {       
                out.close();      
            } catch (IOException e) {      
                e.printStackTrace();    
            }      
        }     

	}
}
