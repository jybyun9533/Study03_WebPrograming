package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

public class RegisterBookController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String[] bookNoList = request.getParameterValues("bookNo");
		String isbn = "";

		String path = "book/book.jsp";

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

		return new ModelAndView(path);
	}

}
