package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		// 로그인과 정부수정은 세션에 저장!!

		String command = request.getParameter("command");
		String path = "index.jsp"; // error page나 home

		if (command.equals("register")) { // 회원가입
			path = register(request, response);
		} else if (command.equals("find")) { // 회원검색
			path = find(request, response);
		} else if (command.equals("login")) { // 로그인
			path = login(request, response);
		} else if (command.equals("allmember")) { // 모든회원출력
			path = allmember(request, response);
		}

		System.out.println("메인으로 왔음 경로::" + path);
		request.getRequestDispatcher(path).forward(request, response);
		
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
		System.out.println("끝 경로 리턴" + path);
		return path;
	}

	protected String allmember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = "index.jsp";

		try {
			ArrayList<MemberVO> list = MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);

			path = "allView.jsp";
		} catch (SQLException e) {
		}
		return path;
	}

}
