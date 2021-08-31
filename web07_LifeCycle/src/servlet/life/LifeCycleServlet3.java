package servlet.life;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

@WebServlet(urlPatterns = { "/LIFE3" }, loadOnStartup = 1)
public class LifeCycleServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String path = "C:\\encore_bjy\\util\\web_util\\life\\count.txt";

	public LifeCycleServlet3() {
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
		out.println("<html><body bgcolor=yellow>");
		out.println("<h3>LifeCycle CallBack Method..</h3>");
		out.println("<b>Count :: " + ++count + "</b>");
		out.println("</body></html>");

		out.close();

	}

	@Override
	public void init() throws ServletException {
		System.out.println("2. init() ȣ��.. by Container..");
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str = br.readLine();
			count = Integer.parseInt(str);
			
			System.out.println("count.txt�� ���� �о �ʵ� count�� �ٽ� �Ҵ�.");
		} catch(Exception e) {
			System.out.println("������ �о���̴µ� ������ �߻��߽��ϴ�. fail.");
		}
	}

	@Override
	public void destroy() {
		System.out.println("4. destroy() ȣ��.. by Container..");
		// �ν��Ͻ��� �޸𸮿��� ���ŵǱ� ���� �ʵ尪�� ���������� ����.. ���Ͽ� ����
		// ��¿� ��Ʈ���� ����..�̰��� �ʵ尪�� ���
		
		File f = new File(path);
		f.getParentFile().mkdirs();
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(f));
			pw.println(count);
			pw.close();
			
			System.out.println(path+"COUNT �� :: " + count + "���Ͽ� �� ���������� ����");
		} catch(Exception e) {
			System.out.println("��¿� ��Ʈ�� ���� ����...");
		}
	}

}
