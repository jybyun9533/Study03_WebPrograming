package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.UserDAOImpl;
import servlet.model.UserVO;

public class LoginController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");

		String path = "error.jsp";

		try {
			UserVO rvo = UserDAOImpl.getInstance().login(userId, userPass);

			// 세션에 저장해야지만 로그인동안 계속 인증을 유지할수 있다.
			HttpSession session = request.getSession();
			if (rvo != null) {
				session.setAttribute("vo", rvo);
				path = "loginSuccess.jsp";
			}
		} catch (Exception e) {

		}

		return new ModelAndView(path);
	}

}
