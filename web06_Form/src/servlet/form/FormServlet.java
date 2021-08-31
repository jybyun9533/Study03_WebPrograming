package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.accessibility.AccessibleStateSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MFS")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormServlet() {
		super();
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
		// ������ ���⼭ �ۼ��Ѵ�..
		/*
		 * 1. �ѱ�ó��..����� ��� ��. 2. PrintWriter ��ü ���Ϲ��� 3. ���� ���� ������ �� �޾ƿ´�. 4. Ŭ���̾�Ʈ��
		 * �������� ���� ������ ����Ѵ�. 5. PrintWriter�� �ݾ��ش�
		 */

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String menus[] = request.getParameterValues("menu");
		String gender = request.getParameter("gender");
		String intro = request.getParameter("intro");

		String menu = "";
		for (int i = 0; i < menus.length; i++) {
			menu += menus[i] + " ";
		}

		out.println("<html><body>");
		out.println("<h2>���� �Էµ� ������ ����մϴ�.</h2>");
		out.println("<li> ����� ���̵� : " + id + "</li>");
		out.println("<li> ����� �н����� : " + pw + "</li>");
		out.println("<li> ����� ���� : " + gender + "</li>");
		out.println("<h4> ����� ������ �޴� </h4>");
		out.println(menu);
		out.println("<h4> ���� ���� </h4>");
		out.println(intro);
		out.println("</body></html>");
		out.close();

	}

}
