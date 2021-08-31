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
		System.out.println("������ ȣ��.. �ν��Ͻ� �̶� ���� �˴ϴ�.");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() call...");
		// ������ �ʵ� �ʱ�ȭ.. �� ������ ����� ȭ������ ���� �޾ƿ� �������ƴϴ�.
		// �� ������ �ξ� ������ �����̳ʿ� keeping�� ���� ������ �Դ�.
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
