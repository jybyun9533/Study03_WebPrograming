package servlet.header.PrintHeaderServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PHP")
public class PrintHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrintHeaderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String info = "";
		
		Enumeration<String> em = request.getHeaderNames();	 
	    


		
		
		out.println("<html><body>");
		out.println("<h1>==== Header Information Printed ====</h1><br>");
		while(em.hasMoreElements()){
	        String headerName = em.nextElement() ;
	        String val = request.getHeader(headerName) ;
	        out.println(headerName +" : " + val + "<br>");
		}
		out.print("<hr><br>");
		out.println("<li> ID : " + id + "</li>");
		out.println("<li> PW : " + pw + "</li>");
		out.println("<li> NAME : " + name + "</li>");
		out.println("<li> ADDR : " + address + "</li>");
		out.println("</body></html>");
		out.close();
	}
}
