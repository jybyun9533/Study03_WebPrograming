package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); // 새롭게 만들어진 세션이 아니라 기존 세션을 계속 사용한다.

		out.println("JSESSIONID :: " + session.getId() + "<br>"); // 앞페이지에서 출력된 값과 동일한 값이 출력
		out.println("VO :: " + session.getAttribute("vo") + "<br>");
		out.println("Book Info :: " + session.getAttribute("book") + "<br>");

		// 해당하는 상품에 대한 결제로직
		if (session.getAttribute("vo") != null) {
			session.invalidate(); // 세션 죽이는 기능. 로그아웃 로직에 반드시 이 코드가 들어가야 한다.
			out.println("<script>");
			out.println("alert('로그아웃 하시겠습니까?')");
			out.println("location.href=login.html"); // 자바스크립트에서 다른 페이지로 연결
			out.println("</script>");
		} else {
			response.sendRedirect("login.html");
		}

	}
}
