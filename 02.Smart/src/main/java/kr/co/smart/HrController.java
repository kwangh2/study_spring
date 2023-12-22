package kr.co.smart;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.smart.hr.HrService;

@Controller @RequestMapping("/hr")
public class HrController {
	@Autowired private HrService service;
	//사원목록 요청
	@RequestMapping("/list")
	public String list(HttpSession session, Model model) {
		session.setAttribute("category", "hr"); //사이드바
		model.addAttribute("list",null);
		return "hr/list";
	}
}
