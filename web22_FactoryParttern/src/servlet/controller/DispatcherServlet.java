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

@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
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

		// String command = request.getParameter("command");
		// hidden값으로 들어온 요청을 받지않고 들어온 요청의 전체주소를 직접 받아온다. -> 앞부분만 자름

		String requestURI = request.getRequestURI(); // web22_FactoryPattern/find.do
		//System.out.println("리퀘스트유알아이 :: " + requestURI);

		String contextPath = request.getContextPath();
		//System.out.println("컨텍패 :: " + contextPath); // web22_FactoryPattern

		String command = requestURI.substring(contextPath.length() + 1); // /find.do or (find.do)
		//System.out.println("커맨드 :: " + command);

		String path = "index.jsp";
		ModelAndView mv = null;

		Controller controller = HandlerMapping.getInstance().createController(command);

		try {
			mv = controller.execute(request, response);
			path = mv.getPath();
		} catch (Exception e) {
		}

		if (mv != null) {
			if (mv.isRedirect()) {
				response.sendRedirect(path);
			} else {
				request.getRequestDispatcher(path).forward(request, response);
			}
		}

	}
}

/*
 * 로그인, 정보수정은 로직은 반드시 세션에 바인딩.....
 */
