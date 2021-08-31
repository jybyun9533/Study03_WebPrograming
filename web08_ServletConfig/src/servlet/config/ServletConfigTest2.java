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
		System.out.println("생성자 호출.. 인스턴스 이때 생성 됩니다.");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() call...");
		// 서블릿의 필드 초기화.. 이 정보는 절대로 화면으로 부터 받아온 정보가아니다.
		// 그 이전에 훨씬 이전에 컨테이너에 keeping된 값을 끌어당겨 왔다.
		path = getInitParameter("path");

		System.out.println("init().. configTest2...");
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			custid = br.readLine();
			System.out.println("고객정보.. credit no..." + custid);
			
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
		
		// 폼으로부터 받아온 값 읽어온다.. getParameter();..getInitParameter()와 시점이 완전히 다르고 값을 받아오는 통로도 다르다.

		String custname = request.getParameter("cust");
		
		out.println("<html><body bgcolor=yellow>");
		out.println("<h2> A Servlet Configuration </h2>");
		
		out.println("<h3>"+custname + ", " + custid+"로 인증되었습니다.");
		
		out.println("</body></html>");
		out.close();
	}

}
