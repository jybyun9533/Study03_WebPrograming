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

@WebServlet("/front.do")
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

		String command = request.getParameter("command");
		String path = "login.html"; // error page나 home

		if (command.equals("login")) { // 로그인
			path = login(request, response);
		} else if (command.equals("registerBook")) { // 책 등록
			path = registerBook(request, response);
		}

		response.sendRedirect(path);

	} // doProcess

	protected String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");

		String path = "error.jsp";

		try {
			UserVO rvo = UserDAOImpl.getInstance().login(userId, userPass);

			// 세션에 저장해야지만 로그인동안 계속 인증을 유지할수 있다.
			HttpSession session = request.getSession();
			if (rvo != null) {
				session.setAttribute("vo", rvo);
				path = "loginSuccess.jsp";
			}
		} catch (Exception e) {

		}

		return path;

	}

	protected String registerBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] bookNoList = request.getParameterValues("bookNo");
		String isbn = "";

		String path = "book/book.html";

		for (int i = 0; i < bookNoList.length; i++) {
			if (i == bookNoList.length - 1) {
				isbn += bookNoList[i];
			} else {
				isbn += bookNoList[i] + "-";
			}
		}

		String title = request.getParameter("bookTitle");
		String catalogue = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String publish_date = request.getParameter("bookDate");
		String publisher = request.getParameter("bookPublisher");
		String author = request.getParameter("bookAuthor");
		int price = Integer.parseInt(request.getParameter("bookPrice"));
		String description = request.getParameter("bookSummary");

		Book bo = new Book(isbn, title, catalogue, nation, publish_date, publisher, author, price, description);
		try {
			BookDAOImpl.getInstance().registerBook(bo);
			request.setAttribute("bo", bo);
			path = "book/bookSuccess.jsp";
		} catch (SQLException e) {
			System.out.println(e);
		}

		return path;
	}

}
