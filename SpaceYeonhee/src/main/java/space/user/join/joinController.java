package space.user.join;

import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import space.common.common.CommandMap;

@Controller
public class joinController {

	private static final String sendEmailId = null;

	Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "joinService")
	private JoinService joinService;
	
	
//�쉶�썝媛��엯�럹�씠吏�
	@RequestMapping(value="/join/joinForm",method=RequestMethod.GET)
	public ModelAndView joinForm(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("joinForm");
		return mav;
	}
	
	//媛��엯
	@RequestMapping(value="/join/signUp")
	 public ModelAndView signUp(CommandMap commandMap) throws Exception {
	  joinService.insertUserData(commandMap.getMap());	  
	 
	  ModelAndView mav = new ModelAndView("/join/signUpComplete"); //  硫붿씤 �깮湲곕㈃ 硫붿씤 寃쎈줈濡� 蹂�寃쏀븷寃�
	  mav.addObject("msg", "�젙�긽�쟻�쑝濡� �쉶�썝媛��엯�씠 �릺�뿀�뒿�땲�떎.");
	  
	  return mav;
	}
	//�븘�씠�뵒 以묐났泥댄겕
	@RequestMapping(value="/join/idCheck")
	@ResponseBody
	 public int checkUserID(CommandMap commandMap) throws Exception {
	 
	  int checkResult = joinService.selectUserID(commandMap.getMap());
	 
	  return checkResult;
	 }
	
    //�씠硫붿씪 �씤利�-�쉶�썝媛��엯
    @RequestMapping(value = "/join/auth", produces = "application/json")
    @ResponseBody
    public boolean sendMailAuth(HttpSession session, @RequestParam String user_email) {
        int ran = new Random().nextInt(100000) + 10000; // 10000 ~ 99999
        String joinCode = String.valueOf(ran);
        session.setAttribute("joinCode", joinCode);
 
        String subject = "<怨듦컙> �쉶�썝媛��엯 �씤利� 肄붾뱶�엯�땲�떎.";
        StringBuilder sb = new StringBuilder();
        sb.append("洹��븯�쓽 �씤利� 肄붾뱶�뒗 " + joinCode + " �엯�땲�떎.");
        return joinService.send(subject, sb.toString(), "webProjectTeam2@gmail.com", user_email, null);
    }
    
    @RequestMapping(value = "/join/authCheck", produces = "application/json")
    @ResponseBody
    public ModelAndView emailAuth(HttpSession session, @RequestParam String joinCode) {
    	ModelAndView mav = new ModelAndView("jsonView");
    	String originalJoinCode = (String)session.getAttribute("joinCode");
    	log.debug("originalJoinCode >>>>"+originalJoinCode +" & "+joinCode);
    	if(originalJoinCode.equals(joinCode)) mav.addObject("result","complete");
    	else mav.addObject("result","fail");
    	
    	return mav;
    }
	
	

}