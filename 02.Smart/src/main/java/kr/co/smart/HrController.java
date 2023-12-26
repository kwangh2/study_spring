package kr.co.smart;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.smart.hr.EmployeeVO;
import kr.co.smart.hr.HrService;

@Controller @RequestMapping("/hr")
public class HrController {
	
	
	@Autowired private HrService service;
	
	@RequestMapping("/insert")
	public String insert(EmployeeVO vo) {
		service.employee_register(vo);
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/register")
	public String  register(Model model) {
		model.addAttribute("departments", service.hr_department_list());
		model.addAttribute("jobs", service.hr_job_list());
		model.addAttribute("managers", service.hr_manager_list());
		return "hr/register";
	}
	
	
	@RequestMapping("update")
	public String update(EmployeeVO vo) {
		service.employee_update(vo);
		return "redirect:info?id="+vo.getEmployee_id();
	}
	
	
	@RequestMapping("modify")
	public String modify(Model model, int id) {
		model.addAttribute("vo",service.employee_info(id));
		
		model.addAttribute("departments",service.hr_department_list());
		model.addAttribute("jobs", service.hr_job_list());
		
		
		
		return "hr/modify";
	}
	
	@RequestMapping("delete")
	public String delete(int id) {
		service.employee_delete(id);
		return "redirect:list";
	}
	
	@RequestMapping("/info")
	public String info(int id, Model model) {
		model.addAttribute("vo",service.employee_info(id));

		
		return "hr/info";
	}
	
	//사원목록 요청
	@RequestMapping("/list")
	public String list(HttpSession session, Model model) {
		session.setAttribute("category", "hr"); //사이드바
		
		
		model.addAttribute("list",service.employee_list());
		return "hr/list";
	}
}
