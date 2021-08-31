package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SMS")
public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		/*
		 * ����ۼ� 1. �� �� �ޱ� 2. DAO ���� 3. �����Ͻ� ���� ȣ���� ����� vo��ü ���Ϲ��� 4. ���Ϲ��� ���� Attribute��
		 * ���ε� -- � Attribute�� ����Ұ��ΰ�? 5. �׺���̼� -- �������� �ִ� jsp�� �ٷ��̵�
		 */

		PrintWriter out = response.getWriter();

		// 1. ���� �ޱ�
		String id = request.getParameter("id");

		// 2. DAO �����Ͻ� ���� ȣ��(�̱���)

		request.setAttribute("id", id); // request�� ���ε�

		//request.getRequestDispatcher("result_view.jsp").forward(request, response);
		request.getRequestDispatcher("includetest1.jsp").include(request, response);
		out.print("�̺κ��� ���ϱ��");
		
		

	}
}

/*
 * RequestDispatcher�� ������ �ִ� forward(req,res), include(req, res) ����� ������ �̵����
 * 1. forward
 * forward �Ϸ��� �������� ���� ������ ��� ������ ������ �������� �ٸ��������� ���� �̵�
 * ������� ������ �̵��ϴ� �������� �������� ������ �ٽ� ���� �������� �ǵ��ƿ��� �ʴ´�.
 * -> ���䰴ü�� Printwriter�� ����� ���� ����. ö���� �����߽�.
 * ����������� url �ּҸ� ����, ����������� jsp�ּҰ� �ƴ϶� ���� ���� �ּҷ� ��µǾ���.
 * =>��� ������ ������ �̵��߱� ������ ���� �̸����� �ּҰ� ��õǾ� ����.
 * 
 * 2. include  
 * ���࿡ ������ Printwriter��ü�� �̿��Ϸ� �Ѵٸ� include������� �������� �̵��� �� ����.
 * include�� ����� �ִ� ��� ������ ������ ������ ���ԵǾ� including �� ������ �ٽ� ���� ���İ����� ������ ���� ������ ���� ����.
 * ������ �̷��� ���Ǵ� �κ��� ���� ����, 1��ó�� �ַ� forwarding����� �ξ� �� ���̻��
 */




















