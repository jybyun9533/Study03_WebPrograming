package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h3>");
		out.println(id + " 님이 로그인 되었습니다!!</h3><br><br>");
		out.println("<a href="+"> 도서 등록 </a><br>");
		out.println("<a a href="+"> 로그아웃 </a>");
		out.println("</body></html>");

	}

}
