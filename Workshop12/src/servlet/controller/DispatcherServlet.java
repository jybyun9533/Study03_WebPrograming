package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Book;
import servlet.model.BookDAOImpl;
import servlet.model.UserDAOImpl;
import servlet.model.UserVO;

@WebServlet("*.do")
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

		String requestURI = request.getRequestURI(); 
		
		String contextPath = request.getContextPath();
		
		String command = requestURI.substring(contextPath.length()+1);
		String path = "login.jsp";
		ModelAndView mv = null;
		
		Controller controller   = HandlerMapping.getInstance().createController(command);
		
		try {
			mv = controller.execute(request, response);
			path = mv.getPath();
			
		}catch(Exception e) {			
		}
		if(mv!=null) {
			if(mv.isRedirect()) response.sendRedirect(path);
			else request.getRequestDispatcher(path).forward(request, response);
		}		
	}

}
