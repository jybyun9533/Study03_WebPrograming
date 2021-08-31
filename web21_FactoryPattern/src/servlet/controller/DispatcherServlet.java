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
		/*
		 * 1. Command 값 받기
		 * 2. Factory에 Command값 전달 
		 * 3. Controller 타입 반환받음
		 * 
		 * 4. Controller의 메소드 호출, Componenet 메소드 수행-> path리턴
		 * 5. path를 가지고 페이지 이동
		 */
		
		String command = request.getParameter("command");
		String path = "index.jsp";
		
		Controller controller = ControllerFactory.getInstance().createController(command);
		
		try {
			path = controller.execute(request, response);
		}catch (Exception e) {
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
}

/*
 * 로그인, 정보수정은 로직은 반드시 세션에 바인딩.....
 */
