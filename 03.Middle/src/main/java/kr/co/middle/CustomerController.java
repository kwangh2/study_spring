package kr.co.middle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import kr.co.middle.customer.CustomerService;
import kr.co.middle.customer.CustomerVO;

@RestController //@Controller + @ResponseBody
@RequestMapping(value="/customer", produces ="text/plain; charset=utf-8")
public class CustomerController {
	@Autowired
	private CustomerService service;
//	@ResponseBody
	@RequestMapping("/list")
	public String list(String query) {
		List<CustomerVO> list = service.customer_list(query);
		
		return new Gson().toJson(list);
	}
}
