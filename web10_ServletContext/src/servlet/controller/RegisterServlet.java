package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Member;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Member member;
	private ServletContext cont;

	@Override
	public void init() throws ServletException {
		cont = getServletContext();
	}

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
		// UTF-8 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 1. form 값 받기
		String name = request.getParameter("name");
		int age = Integer.valueOf(request.getParameter("age"));
		String address = request.getParameter("address");

		// 2. 받은 값으로 VO 객체 생성
		member = new Member(name, age, address);

		// 3. ServletContext 리턴 받아 vo 객체 바인딩
		cont.setAttribute("member", member);

		// 4. <a href>를 이용하여 result.jsp로 이동
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor = 'pink'>");
		out.println("<b>===== RegisterServlet =====<br>");
		out.println("사용자의 정보가 등록되었습니다.</b><br><br>");
		out.println("<a href = 'result.jsp'>가입 정보 확인</a>");
		out.println("</body></html>");
		out.close();
		

	}

}
