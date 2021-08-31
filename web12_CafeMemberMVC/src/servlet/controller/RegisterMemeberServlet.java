package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/RMS")
public class RegisterMemeberServlet extends HttpServlet {
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
		 * 1. 폼값 받아서 2. pvo 생성 3. DAO리턴받아서 4. 비지니스로직 호출 5 결과값..바인딩(Attrinbute) 6. 네비게이션
		 * --> controller 역할
		 */
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");

		MemberVO pvo = new MemberVO(id, password, name, address);

		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			// request.getRequestDispatcher("AllMember").forward(request, response);
			response.sendRedirect("AllMember");
		} catch (SQLException e) {
		}

	}
}
