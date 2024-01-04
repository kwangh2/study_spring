package kr.co.smart;

import java.util.UUID;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.co.smart.common.CommonUtility;
import kr.co.smart.member.MemberService;
import kr.co.smart.member.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private CommonUtility common;

	@Autowired
	private BCryptPasswordEncoder pwEncoder;

	@Autowired
	private MemberService service;
	
	@Value("{naver_secret}")private String naver_secret;
	@Value("{naver_client_id}")private String naver_client_id;
	
	
	
	//네이버로그인 요청
	@RequestMapping("/naverLogin")
	public String naverlogin(HttpSession session , HttpServletRequest request) {
		//https://nid.naver.com/oauth2.0/authorize?response_type=code&
//		client_id=AMulK_4xOI04TXlMzU1k
//		&state=STATE_STRING&
//		redirect_uri=CALLBACK_URL
		String state = UUID.randomUUID().toString();
		session.setAttribute("state", state);
		
		StringBuffer url= new StringBuffer("https://nid.naver.com/oauth2.0/authorize?response_type=code");
		url.append("&client_id=").append("naver_client_id");
		url.append("&state=").append(state);
		url.append("&redirect_uri=").append(common.appURL(request)).append("/member/naverCallback"); //http://192.168.0.49/smart/member/naverCallback
		
		
		return "redirect:" +url.toString();
	}
	
	@RequestMapping("/naverCallback")
	public String naverCallback(String state, String code) {
		//https://nid.naver.com/oauth2.0/token?
//		grant_type=authorization_code
//		&client_id=jyvqXeaVOVmV
//		&client_secret=527300A0_COq1_XV33cf
//		&code=EIc5bFrl4RibFls1
//		&state=9kgsGTfH4j7IyAkg  
		StringBuffer url = new StringBuffer("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code");
		url.append("&client_id=").append(naver_client_id);
		url.append("&client_secret=").append(naver_secret);
		url.append("&code=").append(code);
		url.append("&state=").append(state);
		return "redirect:/";
	}
	
	
	@RequestMapping(value= "/resetPassword", produces = "text/html; charset=utf-8") @ResponseBody
	public String resetPassword(MemberVO vo , HttpServletRequest request) {
		vo = service.member_userid_email(vo);

		StringBuffer msg = new StringBuffer("<script>");

		if (vo == null) {
			msg.append("alert('아이디나 이메일이 맞지 않습니다. \\n확인하세요!'); ");
			msg.append("location='findPassword'");			
		}else {
		// 화면에서 입력한 아이디와 이메일이 일치하는 회원에게
		// 임시비밀번호를 발급해 이메일로 보내기
		String pw = UUID.randomUUID().toString();
		pw = pw.substring(pw.lastIndexOf("-")+1);	
		vo.setUser_pw(pwEncoder.encode(pw));
		if(service.member_resetPassword(vo)==1 && common.sendPassword(vo, pw)) {
			msg.append("alert('임시 비밀번호가 발급되었습니다. \\n이메일을 확인하세요.');");
			msg.append("location='login'");
		}else {
			msg.append("alert('임시비밀번호 발급 실패');");
			msg.append("history.go(-1)");
		}
		
		}
		msg.append("</script>");
		return msg.toString();
	}

	@RequestMapping("/findPassword")
	public String findPassword(HttpSession session) {
		session.setAttribute("category", "find");
		return "default/member/find";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginInfo");
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping(value = "/smartLogin", produces = "text/html; charset=utf-8")
	public String login(HttpServletRequest request, String user_id, String user_pw, HttpSession session) {
		MemberVO vo = service.member_info(user_id);
		StringBuffer msg = new StringBuffer("<script>");
		boolean match = false;
		if (vo != null) {
			match = pwEncoder.matches(user_pw, vo.getUser_pw());
		}
		if (match) {
			session.setAttribute("loginInfo", vo);
			msg.append("location='").append(common.appURL(request)).append("'");
		}
		else {
			msg.append("alert('아이디나 비밀번호가 일치하지 않습니다.'); history.go(-1)");

		}
		msg.append("</script>");
		return msg.toString();
	}

	// 로그인 화면 요청

	@RequestMapping("/login")
	public String login(HttpSession session) {
		session.setAttribute("category", "login");
		return "default/member/login";
	}
	
	@RequestMapping("/changePassword")
	public String changePassword() {
		
		
		return "member/password";
	}
	
	@ResponseBody
	@RequestMapping("confirmPassword")
	public int confirmPassword(String user_pw , HttpSession session) {
		MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
		if(vo==null) {
			return -1;
		}else {
			return pwEncoder.matches(user_pw, vo.getUser_pw()) ? 0 : 1;
		}
		
//		service.mem
	}
	
	@RequestMapping("/updatePassword")
	public boolean updatePassword(String user_pw, HttpSession session) {
		MemberVO vo =(MemberVO)session.getAttribute("loginInfo");
		vo.setUser_pw(pwEncoder.encode(user_pw));
		return service.member_resetPassword(vo) == 1 ? true : false;
	}
}
