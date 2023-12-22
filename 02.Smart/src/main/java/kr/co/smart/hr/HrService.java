package kr.co.smart.hr;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HrService {
	@Autowired @Qualifier("hr") private SqlSession sql;
	//CRUD
	//사원등록
	public int employee_register(EmployeeVO vo) {
		return 0;
	}
	
	//사원목록조회
	public List<EmployeeVO> employee_list() {
		return null;
	}
	
	public EmployeeVO employee_info(int id) {
		return null;
	}
	
	public int employee_update(EmployeeVO ve) {
		return 0;
	}
	
	public int employee_delete() {
		return 0;
	}
	
}
