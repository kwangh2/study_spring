package kr.co.smart;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.smart.member.MemberService;
import kr.co.smart.member.MemberVO;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberService member;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {
		//임시로 로그인 처리
		String user_id = "admin", user_pw = "admin";
		MemberVO vo = member.member_info(user_id);
		if(pwEncoder.matches(user_pw, vo.getUser_pw())) {
			session.setAttribute("loginInfo", vo);
		}
		
		session.removeAttribute("category");
		
		return "home";
	}
	
}
