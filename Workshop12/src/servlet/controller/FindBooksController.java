package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

public class FindBooksController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {

		String path = "";
		
		try {
			ArrayList<Book> rvo = BookDAOImpl.getInstance().findBooks();
	
			if (rvo != null) {
				request.setAttribute("books", rvo);
				path = "book/bookList.jsp";
			}
		} catch (SQLException e) {

		}

		return new ModelAndView(path);
	}

}
