package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
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
		
		String[] bookNoList = request.getParameterValues("bookNo");
		String isbn = "";
		
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
			request.getRequestDispatcher("book/bookSuccess.jsp").forward(request, response);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
