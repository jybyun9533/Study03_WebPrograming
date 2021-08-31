package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(); // 새롭게 만들어진 세션이 아니라 기존 세션을 계속 사용한다. (로그아웃해서 세션을 죽이지 않는 이상.)

		if (session.getAttribute("vo") != null) { // 로그인 되었다면
			MemberVO vo = (MemberVO)session.getAttribute("vo");
			out.println("JSESSIONID :: " + session.getId()+"<br>"); // 앞페이지에서 출력된 값과 동일한 값이 출력
			out.print("VO :: " + vo);
			
			//지금 로그인한 사용자가 상품을 구매.. 상품정보(책)까지 다시 세션에 추가
			session.setAttribute("book", "Web개발에 대해서");
			out.println("<a href=CartServlet>CardServlet 이동.. 세번째 다시 요청하는 서블릿..</a>");
		} else { // 로그인 실패
			out.println("<a href = login.html>로그인 페이지 이동");
		}
	}

}
