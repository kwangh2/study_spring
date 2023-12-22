package com.hanul.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.MemberVO;

@Controller
public class MemberController {
	
	@RequestMapping("/login_result")
	public String login(String userid , String userpw) {
		//아이디&&비번 일치해서 로그인 성공하면 home 화면으로 연결
		//			일치하지 않으면 로그인 화면으로 연결 
		//아이디 : admin 비번 : 0000
		if(userid.equals("admin")  && userpw.equals("0000")) {
//			return "home";  //forward방식
			//redirect방식
			return "redirect:/";
		}else {
//			return "member/login"; forward방식
			return "redirect:/login";
		}
		
	}
	
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("/joinPath/{name}/{gender}/{e}/{age}")
	public String join(Model model , @PathVariable String name , @PathVariable String gender , @PathVariable("e") String email , @PathVariable String age) {
		model.addAttribute("name" , name);
		model.addAttribute("gender" , gender);
		model.addAttribute("email" , email);
		model.addAttribute("age" , age);
		model.addAttribute("method" , "@@PathVariable 방식");
		return "member/info";
	}
	
	
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
