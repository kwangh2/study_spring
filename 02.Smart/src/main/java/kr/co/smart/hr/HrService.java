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
		return sql.insert("hr.insert",vo);
	}
	
	//사원목록조회
	public List<EmployeeVO> employee_list() {
		return sql.selectList("hr.list");
		
	}
	
	public EmployeeVO employee_info(int id) {
		return sql.selectOne("hr.info", id);
	}
	
	public int employee_update(EmployeeVO vo) {
		return sql.update("hr.update",vo);
	}
	
	public int employee_delete(int id) {
		return sql.delete("hr.delete",id);
	}
	
	//부서 조회
	public List<DepartmentVO> hr_department_list() {
		return sql.selectList("hr.departmentList");
	}
	//업무 조회
	public List<JobVO> hr_job_list() {
		return sql.selectList("hr.jobList");
	}
	//매니저 적용할 사원 목록 조회
	public List<EmployeeVO> hr_manager_list() {
		return sql.selectList("hr.managerList");
	}
}
