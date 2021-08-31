package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Ŭ���̾�Ʈ�� ��û�� ó���� ����� �ʵ忡 ������ COUNT���� ������ ������� �ʰ�
 * ������ JSP���� �ѱ�� ��������� ó���� JSP�� �ϵ��� ������ ����
 * ������ �������� �ܼ��ϰ� a�±׸� �̿�.
 */

@WebServlet(urlPatterns = {"/LIFE2"}, loadOnStartup = 1)
public class LifeCycleServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;

	public LifeCycleServlet2() {
		System.out.println("1. LifeCycleServlet1 ������ ȣ��.. by Container..");
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
		System.out.println("3. service() --> doGet() or doPost() ȣ��.. by Container..");
		
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
		
		out.println("<a href=life2.jsp?cnt="+count+">���⸦ Ŭ���ϸ� jsp �������� �̵�</a>"); // count���� ������ jsp�� ������?
		out.close();
		
	}

	@Override
	public void init() throws ServletException {
		System.out.println("2. init() ȣ��.. by Container..");
	}

	@Override
	public void destroy() {
		System.out.println("4. destroy() ȣ��.. by Container..");
	}

}
