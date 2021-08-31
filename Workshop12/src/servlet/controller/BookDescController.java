package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

public class BookDescController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String isbn = (String) request.getParameter("isbn");
		
		try{
			PrintWriter out = response.getWriter();
			Book book = BookDAOImpl.getInstance().bookDesc(isbn);
			out.print(book.getTitle()+","+book.getPublisher()+","+book.getAuthor());		
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
