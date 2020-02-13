package space.user.login;

import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import space.common.common.CommandMap;
import space.user.join.JoinService;

//why all broken again?
//한글 주석 추가
@Controller
public class loginController {

	Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "joinService")
	private JoinService joinService;
	@Resource(name = "loginService")
	private LoginService loginService;
	
//	濡쒓렇�씤 �뤌

	@RequestMapping(value = "/login/loginForm", method = RequestMethod.GET)

	public ModelAndView Login(CommandMap commandMap) throws Exception {
		// 濡쒓렇�씤酉고솕硫�
		ModelAndView mv = new ModelAndView("loginForm");

		return mv;

	}

	// 濡쒓렇�씤 �꽦怨� or �떎�뙣�떆
	@Resource
	private LoginDAO LoginDAO;

	@RequestMapping(value = "/login/login", method = RequestMethod.POST)
	public ModelAndView LoginProc(CommandMap commandMap, HttpSession session) throws Exception {
		// 濡쒓렇�씤�뻽�쓣�븣 �쟾�떖諛쏆쓣 二쇱냼媛�
		ModelAndView mv = new ModelAndView();
		String id = (String) commandMap.get("USER_ID");
		String db = LoginDAO.findMember(commandMap.getMap());
		// 濡쒓렇�씤 �떎�뙣
		if (db == null) {

			String alert = "濡쒓렇�씤�뿉 �떎�뙣�븯���뒿�땲�떎.";
			mv.addObject("alert", alert);
			mv.setViewName("loginForm");

			// 濡쒓렇�씤 �꽦怨�
		} else {
			String alert = "濡쒓렇�씤�뿉 �꽦怨듯븯���뒿�땲�떎.";
			mv.addObject("alert", alert);
			mv.setViewName("redirect:/main");
			session.setAttribute("USER_ID", id);

		}

		log.debug(commandMap);

		return mv;

	}

	// 濡쒓렇�븘�썐
	@RequestMapping(value = "/login/logout")

	public ModelAndView Logout(HttpSession session) throws Exception {
		// 濡쒓렇�씤酉고솕硫�
		ModelAndView mv = new ModelAndView("redirect:/main");

		// 濡쒓렇�씤�꽭�뀡�궘�젣

		session.invalidate();

		return mv;

	}

  // �븘�씠�뵒 鍮꾨쾲李얘린 �럹�씠吏�
	@RequestMapping(value = "/login/findIdPwd")
	public ModelAndView findIdPwd(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("login/findIdPwd");
		
		if(commandMap.get("resultMsg")!=null) {
			mav.addObject("resultMsg",commandMap.get("resultMsg"));
		}
		
		
		return mav;
	}	
	
	
 
 // �븘�씠�뵒 李얘린  
  @RequestMapping(value = "/login/findId", method = RequestMethod.POST)
  public String sendMailId(HttpSession session, CommandMap map, RedirectAttributes ra) {
	  String user = loginService.findAccount(map.getMap()); 
	  String email = (String)map.get("user_email");
	  if (user != null) {
		  String subject = "�븘�씠�뵒 李얘린 �븞�궡 �엯�땲�떎."; 
		  StringBuilder sb = new  StringBuilder(); 
		  sb.append("洹��븯�쓽 �븘�씠�뵒�뒗 " + user + " �엯�땲�떎.");
	  	  joinService.send(subject, sb.toString(), "webProjectTeam2@gmail.com", email, null); 
	  	  ra.addFlashAttribute("resultMsg", "�씠硫붿씪濡� 媛��엯�븯�떊 �븘�씠�뵒瑜� 諛쒖넚�뻽�뒿�땲�떎."); 
	  } else {
		  ra.addFlashAttribute("resultMsg", "�빐�떦 �씠硫붿씪濡� 媛��엯�맂 �븘�씠�뵒媛� 議댁옱�븯吏� �븡�뒿�땲�떎."); 
	  } 
	  return "redirect:/login/findIdPwd"; //硫붿씤�럹�씠吏�濡� 異뷀썑 �닔�젙 
   }  
  
  
  // 鍮꾨�踰덊샇 李얘린
  @RequestMapping(value = "/login/findPwd", method = RequestMethod.POST)
  public String sendMailPassword(HttpSession session, CommandMap map, RedirectAttributes ra) {
	  String email = (String)map.get("user_email");
	  String user = loginService.findPwd(map.getMap()); 
      if (user == null) {
			  ra.addFlashAttribute("resultMsg", "�엯�젰�븯�떊 �븘�씠�뵒�� �씠硫붿씪�씠 �씪移섑븯吏� �븡�뒿�땲�떎."); 
			  return  "redirect:/login/findIdPwd"; //硫붿씤�럹�씠吏�濡� 異뷀썑 �닔�젙 
		  } 
          int ran = new Random().nextInt(100000) + 10000;
          String password = String.valueOf(ran);
          
          map.put("password", password);
          loginService.updateInfo(map.getMap()); 

          String subject = "<怨듦컙>�엫�떆 鍮꾨�踰덊샇�엯�땲�떎."; 
		  StringBuilder sb = new  StringBuilder();
		  sb.append("洹��븯�쓽 �엫�떆 鍮꾨�踰덊샇�뒗 " + password + " �엯�땲�떎. 濡쒓렇�씤 �썑 �뙣�뒪�썙�뱶瑜� 蹂�寃쏀빐 二쇱꽭�슂.");
		  joinService.send(subject, sb.toString(), "webProjectTeam2@gmail.com",  email, null); 
		  ra.addFlashAttribute("resultMsg", "�씠硫붿씪濡� �엫�떆 鍮꾨�踰덊샇瑜� 諛쒖넚�뻽�뒿�땲�떎.");  
	   
	  return "redirect:/login/findIdPwd"; 

  }   
  
  
  
}
 


