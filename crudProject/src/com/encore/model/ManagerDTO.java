package com.encore.model;

public class ManagerDTO {
	int employee_id;
	String emp_name;

	public ManagerDTO() {
		super();
	}

	public ManagerDTO(int employee_id, String emp_name) {
		super();
		this.employee_id = employee_id;
		this.emp_name = emp_name;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ManagerDTO [employee_id=").append(employee_id).append(", emp_name=").append(emp_name)
				.append("]");
		return builder.toString();
	}

}
