package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 클라이언트의 요청을 처리한 결과를 필드에 지정된 COUNT값을 서블릿이 출력하지 않고
 * 정보를 JSP에게 넘기고 결과페이지 처리를 JSP가 하도록 로직을 수정
 * 페이지 연결방법은 단순하게 a태그를 이용.
 */

@WebServlet(urlPatterns = {"/LIFE2"}, loadOnStartup = 1)
public class LifeCycleServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;

	public LifeCycleServlet2() {
		System.out.println("1. LifeCycleServlet1 생성자 호출.. by Container..");
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
		
		// TestPrint
		System.out.println("3. service() --> doGet() or doPost() 호출.. by Container..");
		
		// Logic
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		count++;
	
		/*
		 * out.println("<html><body bgcolor='yellow'>");
		 * out.println("<h3>LifeCycle CallBack Method..</h3>");
		 * out.println("<b>count :: " + ++count + "</b>");
		 * out.println("</body></html>");
		 */
		
		out.println("<a href=life2.jsp?cnt="+count+">여기를 클릭하면 jsp 페이지로 이동</a>"); // count갑을 가지고 jsp를 가려면?
		out.close();
		
	}

	@Override
	public void init() throws ServletException {
		System.out.println("2. init() 호출.. by Container..");
	}

	@Override
	public void destroy() {
		System.out.println("4. destroy() 호출.. by Container..");
	}

}
