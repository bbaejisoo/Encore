package com.encore.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

//business logic�ۼ�
public class EmpService {

	EmpDAO dao = new EmpDAO();

	public EmpVO loginChk(String userid, String userpass) {
		return dao.loginChk(userid, userpass);
	}

	public List<ManagerDTO> selectAllMgr() {
		return dao.selectAllMgr();
	}

	public List<JobDTO> selectAllJob() {
		return dao.selectAllJob();
	}

	public List<DeptDTO> selectAllDept() {
		return dao.selectAllDept();
	}

	public List<EmpVO> selectAll() {
		// ......
		return dao.selectAll();
	}

	public EmpVO selectById(int empid) {
		return dao.selectById(empid);
	}

	public List<EmpVO> selectByDept(int deptid) {
		//
		return dao.selectByDept(deptid);
	}

	public List<EmpVO> selectBySalary(int salary) {
		//
		return dao.selectBySalary(salary);
	}

	public List<EmpVO> selectByDeptJob(int deptid, String jobid, int salary) {
		//
		return dao.selectByDeptJob(deptid, jobid, salary);
	}

	public int insertEmp(EmpVO emp) {

		return dao.insertEmp(emp);
	}

	public int updateEmp(EmpVO emp) {

		return dao.updateEmp(emp);
	}

	public int updateEmpBySal(int salary) {

		return dao.updateEmpBySal(salary);
	}

	public int deleteEmp(int empid) {

		return dao.deleteEmp(empid);
	}

	public Map<String, Object> executeTest(int job) {
		// 1.��ȸ
		// 2.����
		String sql;
		if (job == 1) {
			sql = "select * from employees";
		} else if (job == 2) {
			sql = "update employees set commission_pct=0.5";
		} else {
			sql = "";
		}
		return dao.executeTest(sql);
	}

	public int[] addBatchTest(Map<Integer, String> data) {

		String[] jobs = new String[3];
		int i = 0;
		for (Integer key : data.keySet()) {
			jobs[i++] = "update employees set last_name='" + data.get(key) + "' where department_id=" + key;

		}

		return dao.addBatchTest(jobs);
	}

	public int plsqlTest(int sal, double rate) {
		// TODO Auto-generated method stub
		return dao.plsqlTest(sal, rate);
	}

}
