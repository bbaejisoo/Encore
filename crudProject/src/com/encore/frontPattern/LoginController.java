package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EmpService;
import com.encore.model.EmpVO;

public class LoginController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		String method = (String)data.get("method");
		if(method.equals("get")) return;
		String userid = (String)data.get("userid");
		String userpass = (String)data.get("userpass");
		EmpService service = new EmpService();
		EmpVO emp = service.loginChk(userid, userpass);
		data.put("loginResult", emp==null?"no":"yes");
		data.put("emp", emp);
		
		
	}

}
