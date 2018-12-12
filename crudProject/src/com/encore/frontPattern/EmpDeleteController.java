package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EmpService;
import com.encore.model.EmpVO;

public class EmpDeleteController implements CommonController{

	@Override
	public void execute(Map<String, Object> data) {
		
		EmpService service = new EmpService();
		int empid = (Integer)data.get("empid");
		data.put("message", service.deleteEmp(empid)>0?"삭제성공":"삭제실패");	//DB에  한건 입력

	}

}
