package kr.co.smart.hr;


import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeVO {
	private int employee_id , department_id , manager_id, salary;
	private String last_name, first_name, name, email, phone_number, job_id, department_name, job_title, manager_name;
	private Date hire_date;
	private Double  commission_pct;
}
