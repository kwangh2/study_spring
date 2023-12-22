package kr.co.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping("/first")
	public String first(Model model) {
		//메소드를 String return하는 메소드로 만듬
		//return에 열 jsp파일 이름 return
		//메소드 어노테이션 추가하고 응답할 url적기
		
		
		String today = new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date()); 
		model.addAttribute("today",today);
		model.addAttribute("type","model");
		
		return "index";
	}	
	
	@RequestMapping("/second")
	public ModelAndView second() {
		ModelAndView model = new ModelAndView();
		String now =new SimpleDateFormat("hh시 mm분 ss초 ").format(new Date());
		model.addObject("now", now);
		model.addObject("type", "ModelAndView");
		model.setViewName("index");
		return model;
	}
	
	
}
