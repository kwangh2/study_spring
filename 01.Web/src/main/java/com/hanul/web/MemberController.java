package com.hanul.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.MemberVO;

@Controller
public class MemberController {
	
	@RequestMapping("joinData")
	public String join(Model model, MemberVO vo) {
		model.addAttribute("vo",vo);
		model.addAttribute("method", "데이터객체방식");
		
		return "member/info";
	}
	
	@RequestMapping("joinParam")
	public String join(Model model , @RequestParam String name , String gender ,@RequestParam("email") String mail, int age) {
		model.addAttribute("name",name); //req.getParam없이 정보 받아서 보내기↑												↑ int쓰면 자동으로 Integer해줌
		model.addAttribute("gender",gender); 
		model.addAttribute("email",mail); 
		model.addAttribute("age",age); 
		model.addAttribute("method", "@RequestParam 방식");
		return "member/info";
	}
	
	@RequestMapping("/joinRequest")
	public String join(HttpServletRequest req,Model model) {
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String age = req.getParameter("age");
		model.addAttribute("name" , name);
		model.addAttribute("gender" , gender);
		model.addAttribute("email" , email);
		model.addAttribute("age" , Integer.parseInt(age));
		model.addAttribute("method" , "HttpServletRequest 방식");
		return "member/info";
	}

	@RequestMapping("/member")
	public String member() {
		return "member/join";
	}
	

}
