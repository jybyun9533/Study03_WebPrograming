package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LoginController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String id=  request.getParameter("id");
		String password = request.getParameter("password");
		String path = "";
		try {
			MemberVO rvo=MemberDAOImpl.getInstance().login(id, password);
			
			//세션에 저장해야지만 로그인 동안 인증을 계속 유지할 수 있다.
			HttpSession session = request.getSession();
			if(rvo!=null) {
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID :: "+session.getId());				
				path = "login_result.jsp";
			}
		}catch(Exception e) {
			
		}
		return new ModelAndView(path);
	}
}
