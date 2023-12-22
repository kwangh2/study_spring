package kr.co.smart;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.smart.customer.CustomerServiceimpl;
import kr.co.smart.customer.CustomerVO;

@Controller
public class CustomerController {
//	org.mybatis.spring.SqlSessionTemplate
	@Autowired private CustomerServiceimpl service;
	
	@RequestMapping("insert.cu")
	public String insert(CustomerVO vo) {
		service.customer_register(vo);
		return "redirect:list.cu";
	}
	
	@RequestMapping("register.cu")
	public String register() {
		return "customer/register";
	}
	
	@RequestMapping("delete.cu")
	public String delete(int id) {
		service.customer_delete(id);
		return "redirect:list.cu";
	}
	
	
	@RequestMapping("update.cu")
	public String update(CustomerVO vo) {
		service.customer_update(vo);
		return "redirect:info.cu?id="+vo.getCustomer_id();
		//info.cu url로 이동! (해당 url로가면 데이터 조회까지 다 되니까!)
		//DML처리 한후 화면연결은 redirect (화면만 보내고 url이 그대로면 새로고침했을떄 계속 CRUD됨)
	}
	
	@RequestMapping("/modify.cu")
	public String modify(int id , Model model) {
		model.addAttribute("vo" , service.customer_info(id));
		return "customer/modify";
	}
	
	@RequestMapping("/info.cu")
	public String name(Model model, int id) {
		// 선택한 고객 정보 DB에서 조회해서 출력하기
		//출력할려면 모델에 담아서 보내야함~
		CustomerVO vo = service.customer_info(id);
		model.addAttribute("vo",vo);
		return "customer/info";
	}
	
	@RequestMapping("/list.cu" )
	public String list(Model model  , HttpSession session) {
		session.setAttribute("category", "cu");
		//DB에서 고객목록을 조회해와 화면에 출력
		List<CustomerVO> list = service.customer_list();
		model.addAttribute("list",list);
		//조회한 정보를 화면에 출력할 수 있도록 Model객체에 담기
		return "customer/list";
	}
	
	@RequestMapping("/search.cu" )
	public String search(Model model  , HttpSession session ,@RequestParam(defaultValue = "") String name) {
		session.setAttribute("category", "cu");
		//DB에서 고객목록을 조회해와 화면에 출력
		List<CustomerVO> list = service.customer_list(name);
		model.addAttribute("list",list);
		model.addAttribute("name",name);
		//조회한 정보를 화면에 출력할 수 있도록 Model객체에 담기
		return "customer/list";
	}
}
