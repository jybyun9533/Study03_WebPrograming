package servlet.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String path;
	private String custid;
	
	public ServletConfigTest2() {
		System.out.println("������ ȣ��.. �ν��Ͻ� �̶� ���� �˴ϴ�.");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() call...");
		// ������ �ʵ� �ʱ�ȭ.. �� ������ ����� ȭ������ ���� �޾ƿ� �������ƴϴ�.
		// �� ������ �ξ� ������ �����̳ʿ� keeping�� ���� ������ �Դ�.
		path = getInitParameter("path");

		System.out.println("init().. configTest2...");
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			custid = br.readLine();
			System.out.println("������.. credit no..." + custid);
			
			br.close();
		} catch (Exception e) {

		}
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
		
		// �����κ��� �޾ƿ� �� �о�´�.. getParameter();..getInitParameter()�� ������ ������ �ٸ��� ���� �޾ƿ��� ��ε� �ٸ���.

		String custname = request.getParameter("cust");
		
		out.println("<html><body bgcolor=yellow>");
		out.println("<h2> A Servlet Configuration </h2>");
		
		out.println("<h3>"+custname + ", " + custid+"�� �����Ǿ����ϴ�.");
		
		out.println("</body></html>");
		out.close();
	}

}
