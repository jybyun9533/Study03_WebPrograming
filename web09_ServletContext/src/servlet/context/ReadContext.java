package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 1. ServletContext �ϳ� �޾ƿ´�.
 * 2. getAttirbute()�� ����ؼ� ���ε� �� �����͸� �����´�.
 * 3. ������ ������ ���������� ����Ѵ�.
 */

@WebServlet("/Reading")
public class ReadContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// �ʵ� �߰�
	private HashMap<String, String> userList;// VO ��� ����� Collection ��� :: Map
	private ServletContext cont;

	@Override
	public void init() throws ServletException {
		System.out.println("init() Call..");
		cont = getServletContext();
		System.out.println("Reading ServletContext...return.." + cont.getContextPath());
		System.out.println("Reading ServletContext...return.." + cont);
		userList = new HashMap<String, String>();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		userList = (HashMap) cont.getAttribute("userList");

		// ȭ�� ���
		out.println("<h2>������ Attribute�ȿ� ���ε� �� �����͸� ã�ƿ� ��� �Դϴ�.</h2><p>");

		Set<String> set = userList.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = userList.get(key);
			out.println(key + " : " + value + "<br>");
		}
		out.println("</body></html>");
	}
}
