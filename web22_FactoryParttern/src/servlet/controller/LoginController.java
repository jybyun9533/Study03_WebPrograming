package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		String path = "index.jsp";

		try {
			MemberVO vo = MemberDAOImpl.getInstance().login(id, password);

			System.out.println("DB갔다옴 " + vo);
			// 세션에 저장해야지만 로그인동안 계속 인증을 유지할수 있다.
			HttpSession session = request.getSession();
			if (vo != null) {
				session.setAttribute("vo", vo);
				System.out.println("JSESSIONID :: " + session.getId());

				path = "login_result.jsp";
			}

		} catch (Exception e) {
			
		}
		return new ModelAndView(path);
	}

}
