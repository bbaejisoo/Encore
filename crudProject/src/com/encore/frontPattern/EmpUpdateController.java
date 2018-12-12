package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EmpService;
import com.encore.model.EmpVO;

public class EmpUpdateController implements CommonController{

	@Override
	public void execute(Map<String, Object> data) {
		
		EmpService service = new EmpService();
		String method = (String)data.get("method");
		if(method.equals("get")) {	//post방식일때 DB에 입력을 하고 Get방식일때는 입력을 안하려고 한다.

			int empid = (Integer)data.get("empid");
			
			EmpVO empvo = service.selectById(empid);
			data.put("emp", empvo);
			data.put("deptlist", service.selectAllDept());
			data.put("joblist", service.selectAllJob());
			data.put("mgrlist", service.selectAllMgr());
			data.put("message", empvo.toString());
		}else {
			EmpVO emp = (EmpVO)data.get("emp");		//한건
			data.put("message", service.updateEmp(emp)>0?"수정성공":"수정실패");	//DB에  한건 입력

		}
		/*		EmpVO emp = (EmpVO)data.get("emp"); 		//한건
		EmpService service = new EmpService();
		data.put("result", service.insertEmp(emp));		//DB에  한건 입력
		 */		

	}

}
