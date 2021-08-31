package servlet.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String name, address;

	public ServletConfigTest1() {
		System.out.println("생성자 호출.. 인스턴스 이때 생성 됩니다.");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() call...");
		// 서블릿의 필드 초기화.. 이 정보는 절대로 화면으로 부터 받아온 정보가아니다.
		// 그 이전에 훨씬 이전에 컨테이너에 keeping된 갑을 끌어당겨 왔다.
		name = getInitParameter("custname");
		address = getInitParameter("address");
		System.out.println(name + ", " + address);
	}

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

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor=yellow>");
		out.println("<h2> A Servlet Configuration </h2>");
		out.println("Your Name : " + name + "<br>");
		out.println("Your Address : " + address + "<br>");
		out.println("</body></html>");
		out.close();
	}

}
