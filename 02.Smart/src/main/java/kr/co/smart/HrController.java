package kr.co.smart;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/hr")
public class HrController {
	
	//사원목록 요청
	@RequestMapping("/list")
	public String list(HttpSession session, Model model) {
		session.setAttribute("category", "hr"); //사이드바
		model.addAttribute("list",null);
		return "hr/list";
	}
}
