package space.user.modify;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import space.common.common.CommandMap;
import space.user.member.MemberDAO;
import space.user.member.MemberDeleteDAO;

@Controller
public class memberModifyController {
	// �������� ��

		@RequestMapping(value = "/member/MemberModifyForm", method = RequestMethod.GET)
		public ModelAndView pwdCheck(CommandMap commandMap) throws Exception {
			// �������� ȭ��;
			ModelAndView mv = new ModelAndView("pwdcheck");
			return mv;

		}

		// �������� ������ �н����尡 ������� or Ʋ�����
		@Resource
		private ModifyDAO modifyDAO;

		@RequestMapping(value = "/member/MemberModifyForm", method = RequestMethod.POST)
		public ModelAndView select(CommandMap commandMap,HttpSession session) throws Exception {
			
			//������������
			ModelAndView mv = new ModelAndView();
			String alert="";
			String id = (String) session.getAttribute("USER_ID");//���ǿ� ����� ID��
			commandMap.put("USER_ID", id);
			//�Է��� ����� ���ǿ� ���̵� �� �̿��ؼ� DB�� id��ã��
			String pw =(String)modifyDAO.pwdcheck(commandMap.getMap(),"USER_ID");
			Map<String, Object> MemberInfo;//�������ҷ�����
			
			//����� ��ġ�Ұ�� ->������������
			if(id.equals(pw)) {
				
				mv.setViewName("modify");
				MemberInfo=modifyDAO.selectInfo(id);
				mv.addObject("MemberInfo",MemberInfo);
						
				
				
				//��ġ�����������->����������
			}else{
				alert="�н����带 �߸��Է��Ͽ����ϴ�.";
				mv.addObject("alert",alert);
				mv.setViewName("pwdcheck");
			}
			return mv;
		}
			
		//��������
		@Resource
		private MemberDAO memberDAO;
		@RequestMapping(value = "/member/memberModify", method = RequestMethod.POST)
		public ModelAndView modify(CommandMap commandMap,HttpSession session) throws Exception {
			ModelAndView mv = new ModelAndView();
			//�н�����üũ ����
		commandMap.remove("pwdcheck");
		
		//ȸ�����̵����� ���
		commandMap.put("USER_ID",session.getAttribute("USER_ID"));
			/*
			 * System.out.println(commandMap.get("USER_PASSWORD"));
			 */
		
			//������ ��
			memberDAO.updateDB(commandMap.getMap());
			
			
			mv.setViewName("main");
			// �������� ȭ��;
			
			return mv;
					
			
				
			}

		
		//Ż���ϱ�
		@Resource
		private MemberDeleteDAO memberDeleteDAO;
		
		@RequestMapping(value = "/member/memberDelete")
		public ModelAndView delete(CommandMap commandMap,HttpSession session) throws Exception {
			commandMap.put("USER_ID", session.getAttribute("USER_ID"));

			memberDeleteDAO.memberDelete(commandMap.getMap());
			// �������� ȭ��;
			ModelAndView mv = new ModelAndView("main");
			//���� ���̵�� ��� ���� 
			session.invalidate();
			return mv;

		}

}
