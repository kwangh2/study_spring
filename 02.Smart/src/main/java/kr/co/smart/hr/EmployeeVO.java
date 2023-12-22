package kr.co.smart.hr;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeVO {
	private int employee_id;
	private String late_name, first_name, name, email, phone_number, job_id, salary, manager_id, department_id, department_name, job_title;
	private Date hire_date;
	private Double  commission_pct;
}
