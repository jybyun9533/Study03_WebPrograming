package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpFormServlet
 */
@WebServlet("/FormServlet")
public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String addr = request.getParameter("address");

		PrintWriter out = response.getWriter();
		out.println("<html><body><h3>");
		out.println("Your Name Information...</h3><br>");
		out.println("<li> Your Name :: " + name + "</li>");
		out.println("<li> Your Address :: " + addr);
		out.println("</li></body></html>");
	}

}
