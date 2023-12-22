package kr.co.smart.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceimpl implements CustomerService {
	@Autowired private CustomerDAO dao;

	@Override
	public int customer_register(CustomerVO vo) {
		return dao.customer_register(vo);
	}

	@Override
	public List<CustomerVO> customer_list() {
		// TODO Auto-generated method stub
		return dao.customer_list();
	}

	@Override
	public CustomerVO customer_info(int id) {
		return dao.customer_info(id);
	}

	@Override
	public int customer_update(CustomerVO vo) {
		dao.customer_update(vo);
		return 0;
	}

	@Override
	public int customer_delete(int id) {
		return dao.customer_delete(id);
	}

	@Override
	public List<CustomerVO> customer_list(String name) {
		dao.customer_list(name);
		return null;
	}

}
