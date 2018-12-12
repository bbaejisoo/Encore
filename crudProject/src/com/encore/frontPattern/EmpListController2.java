package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EmpService;

public class EmpListController2 implements CommonController{

	@Override
	public void execute(Map<String, Object> data) {
		
		EmpService service = new EmpService();
		
		String deptid = (String)data.get("deptid");
		String jobid = (String)data.get("jobid");
		String salary = (String)data.get("salary");
		if(salary.equals("")) salary = "0";
		data.put("emps", service.selectByDeptJob(Integer.parseInt(deptid), jobid, Integer.parseInt(salary)));
		
		
	}

	
	
	
}
