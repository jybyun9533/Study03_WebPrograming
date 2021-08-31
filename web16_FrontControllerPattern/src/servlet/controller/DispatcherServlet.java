package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet(urlPatterns = "/front.do", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 가장먼저 해야하는 일은 클라이언트로부터 어떤 요청이 들어오는지를 알아야 한다. -- command값 받아온다.
		////////////////////////////////////////////////////////////////////////////////////////////////////
		// 1. RegisterServlet의 doProcess(){} 안에 있는 코드를 직접 여기에 작성(권장X)
		// 2. Method로 하나 뽑아내서 그 메소드 안에 코드를 넣는다(추천 :: 가독력 높아지고 코드를 구조적으로 볼수있음 -> 유지보수성
		// 높아짐)

		String command = request.getParameter("command");
		String path = "index.html"; // error page나 home

		if (command.equals("register")) { // 회원가입
			path = register(request, response);
		} else if (command.equals("find")) { // 회원검색
			path = find(request, response);
		} else if (command.equals("login")) { // 로그인
			path = login(request, response);
		} else if (command.equals("allmember")) { // 모든회원출력
			path = allmember(request, response);
		}

		request.getRequestDispatcher(path);
	}

	protected String register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");

		String path = "register_fail.jsp";

		MemberVO pvo = new MemberVO(id, password, name, address);

		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			path = "register_result.jsp";
		} catch (SQLException e) {
		}

		return path;
	}

	protected String find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "find_fail.jsp"; // 경로를 뽑아내면 간단
		try {
			MemberVO rvo = MemberDAOImpl.getInstance().findByIdMember(id);
			if (rvo != null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}
		} catch (SQLException e) {
		}

		return path;

	}

	protected String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		String path = "login_fail.jsp";

		try {
			MemberVO rvo = MemberDAOImpl.getInstance().login(id, password);

			// 세션에 저장해야지만 로그인동안 계속 인증을 유지할수 있다.
			HttpSession session = request.getSession();
			if (rvo != null) {
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID :: " + session.getId());

				path = "login_result.jsp";
			}

		} catch (Exception e) {

		}
		return path;
	}

	protected String allmember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = "index.html";

		try {
			ArrayList<MemberVO> list = MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);

			path = "allView.jsp";
		} catch (SQLException e) {
		}
		return path;
	}

}
