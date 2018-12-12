package com.encore.frontPattern;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.encore.model.EmpVO;
import com.encore.util.EmpUtill;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.go")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getRequestURI()); /// education/emp/emplist.go 이렇게 온다.
		// System.out.println(request.getContextPath()); ///education 이렇게 온다.

		String path = request.getContextPath();
		String uri = request.getRequestURI();
		String requestURI = uri.substring(path.length(), uri.length() - 3); /// emp/emplist 이렇게 잘린다.
		// System.out.println(requestURI);
		RequestDispatcher rd = null;
		response.setCharacterEncoding("utf-8");

		CommonController controller = null; // 조회하러 갈지 어떤걸 하러 갈지 몰라서 null;
		Map<String, Object> data = new HashMap<>();
		String page = null;
		String method = request.getMethod().toLowerCase();
		data.put("method", method);

		HttpSession session = request.getSession();
		if (requestURI.equals("/login/signOut")) {
			session.invalidate(); // 다 지우고
			response.sendRedirect("../index.jsp"); // index.jsp로 가라
			return;
		}

		Object sessionObj = session.getAttribute("emp");
		if (!requestURI.equals("/login/sign") && sessionObj == null) {
			response.sendRedirect(path + "/login/sign.go");
			return;
		}

		switch (requestURI) {

		case "/emp/getEmpInfo":
			controller = new EmpUpdateController();
			int empid2 = Integer.parseInt(request.getParameter("empid"));
			data.put("empid", empid2);
			page = "result2.jsp";
			break;
		
		// 매니저조회
		case "/emp/managerlist": // .jsp 페이지랑 이름을 맞춰야한다.
			controller = new ManagerController();
			page = "managerlist.jsp";
			break;

		// 직책조회
		case "/emp/joblist": // .jsp 페이지랑 이름을 맞춰야한다.
			controller = new JobController();
			page = "joblist.jsp";
			break;

		// 부서조회
		case "/emp/deptlist": // .jsp 페이지랑 이름을 맞춰야한다.
			controller = new DeptController();
			page = "deptlist.jsp";
			break;

		case "/login/sign":
			controller = new LoginController();
			if (method.equals("get")) {
				page = "sign.jsp";
			} else {
				String userid = request.getParameter("userid"); // first_name 이라고 가정
				String userpass = request.getParameter("userpass"); // last_name 이라고 가정
				data.put("userid", userid);
				data.put("userpass", userpass);
			}
			break;
		case "/emp/emplist": // .jsp 페이지랑 이름을 맞춰야한다.
			// rd = request.getRequestDispatcher("/emp/emplist");
			// rd.include(request, response);
			controller = new EmpListController();
			page = "emplist.jsp";
			break;
			
		case "/emp/emplist2":
			controller = new EmpListController2();
			data.put("deptid", request.getParameter("deptid"));
			data.put("jobid", request.getParameter("jobid"));
			data.put("salary", request.getParameter("salary"));
			page = "emplist2.jsp";
			break;
			
		case "/emp/empById": // .jsp 페이지랑 이름을 맞춰야한다.
			controller = new EmpUpdateController();
			if (method.equals("get")) {
				String sid = request.getParameter("empid");
				int empid = Integer.parseInt(sid);
				data.put("empid", empid);
				page = "empDetail.jsp";
			} else {
				EmpVO emp = EmpUtill.makeEmp(request);
				data.put("emp", emp);
				page = "result.jsp";
			}

			break;

		case "/emp/empInsert": // .jsp 페이지랑 이름을 맞춰야한다.
			controller = new EmpInsertController();
			if (method.equals("get")) {
				page = "empInsert.jsp";
			} else {
				data.put("emp", EmpUtill.makeEmp(request));
				page = "result.jsp";
			}

			break;

		case "/emp/empDelete": // .jsp 페이지랑 이름을 맞춰야한다.
			controller = new EmpDeleteController();
			String sid = request.getParameter("empid");
			int empid = Integer.parseInt(sid);
			data.put("empid", empid);
			page = "result.jsp";
			break;

		default:
		}
		controller.execute(data);

		Object result = data.get("loginResult"); // 로그인인 경우, 기타인 경우
		if (result != null) {
			String yesNo = (String) result;

			if (yesNo.equals("yes")) {
				// 인증이 되면 index.jsp로 이동
				EmpVO emp = (EmpVO) data.get("emp");
				session.setAttribute("emp", emp);
				session.setAttribute("signMessage", "");
				response.sendRedirect("../index.jsp");
				return;
			} else {
				// 인증이 안되면 sign.jsp로 이동
				session.setAttribute("signMessage", "인증실패");
				response.sendRedirect("sign.go");
				return;
			}
		}

		for (String key : data.keySet()) {
			request.setAttribute(key, data.get(key));
		}
		rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
