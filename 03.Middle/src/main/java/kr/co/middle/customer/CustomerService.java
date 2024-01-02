package kr.co.middle.customer;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	private SqlSession sql;
	
	public List<CustomerVO> customer_list(String query) {
		return sql.selectList("cu.list", query);
	}
	public CustomerVO customer_info() {
		return null;
	}
}
