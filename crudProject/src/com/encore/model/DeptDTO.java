package com.encore.model;

//부서 정보를 담아서 transfer하기 위한 틀
public class DeptDTO {

	int department_id;
	String department_name;

	public DeptDTO() {
		super();
	}

	public DeptDTO(int department_id, String department_name) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeptDTO [department_id=").append(department_id).append(", department_name=")
				.append(department_name).append("]");
		return builder.toString();
	}

}
