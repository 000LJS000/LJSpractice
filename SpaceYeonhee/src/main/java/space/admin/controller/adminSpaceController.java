package space.admin.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import space.admin.service.AdminSpaceService;
import space.common.common.CommandMap;

@Controller
public class adminSpaceController {
	
	Logger log = Logger.getLogger(this.getClass());
 
	@Resource(name="AdminSpaceService")
	private AdminSpaceService adminSpaceService;
	
	@RequestMapping(value="admin/spaceList")
    public ModelAndView spaceList(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("admin/spaceList");
    	
    	return mv;
    }
	
	@RequestMapping(value="admin/selectspaceList")
	public ModelAndView AdminSelectSpaceList(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		List<Map<String,Object>> list = adminSpaceService.selectSpaceList(commandMap.getMap());
		
    	mv.addObject("list", list);
    	
    	if(list.size()>0) {
    		mv.addObject("TOTAL", list.get(0).get("TOTAL_COUNT"));
    	}else {
    		mv.addObject("TOTAL", 0);
    	}
    	
    	return mv;
	}
	
	
}