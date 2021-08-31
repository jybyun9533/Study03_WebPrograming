package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Member;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Member member;
	private ServletContext cont;

	@Override
	public void init() throws ServletException {
		cont = getServletContext();
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
		// UTF-8 ���ڵ�
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 1. form �� �ޱ�
		String name = request.getParameter("name");
		int age = Integer.valueOf(request.getParameter("age"));
		String address = request.getParameter("address");

		// 2. ���� ������ VO ��ü ����
		member = new Member(name, age, address);

		// 3. ServletContext ���� �޾� vo ��ü ���ε�
		cont.setAttribute("member", member);

		// 4. <a href>�� �̿��Ͽ� result.jsp�� �̵�
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor = 'pink'>");
		out.println("<b>===== RegisterServlet =====<br>");
		out.println("������� ������ ��ϵǾ����ϴ�.</b><br><br>");
		out.println("<a href = 'result.jsp'>���� ���� Ȯ��</a>");
		out.println("</body></html>");
		out.close();
		

	}

}
