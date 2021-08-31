package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 1. �� ���� �Է� �޴´�. -> getParameter()
 * 2. ���� ������ ��ü�� �����Ѵ�.
 * 3. Servletcontext�� ��ȯ �޴´�. ServletConfig�� getServletContext()
 *    Servletcontext�� ���ε�. setAttribute()
 * 4. ���ε��� ������ ���� ������ ������ ���� �ֵ��� ������ ���� 
 */

@WebServlet("/Writing")
public class WriteContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//�ʵ� �߰�
	private HashMap userList;// VO ��� ����� Collection ��� :: Map
	private ServletContext cont;
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() Call..");
		cont = getServletContext();
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

		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");
		String userName = request.getParameter("userName");

		// userList�� �߰�
		userList.put("userId", userId);
		userList.put("userPass", userPass);
		userList.put("userName", userName);
		
		// ���ε�
		cont.setAttribute("userList", userList);

		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor = 'pink'>");
		out.println("<b>===== Data Writing ServletContext =====<br>");
		out.println("������� ������ ��ϵǾ����ϴ�.</b><br><br>");
		
		// ���� ���� ����
		out.println("<a href = 'Reading'>������ ��� ����</a>");
		out.println("</body></html>");
		out.close();
	}
}
