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
 * 1. 폼 값을 입력 받는다. -> getParameter()
 * 2. 받은 값으로 객체를 생성한다.
 * 3. Servletcontext를 반환 받는다. ServletConfig의 getServletContext()
 *    Servletcontext에 바인딩. setAttribute()
 * 4. 바인딩된 정보를 다음 서블릿이 가져다 쓸수 있도록 페이지 연결 
 */

@WebServlet("/Writing")
public class WriteContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//필드 추가
	private HashMap userList;// VO 대신 사용할 Collection 사용 :: Map
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

		// userList에 추가
		userList.put("userId", userId);
		userList.put("userPass", userPass);
		userList.put("userName", userName);
		
		// 바인딩
		cont.setAttribute("userList", userList);

		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor = 'pink'>");
		out.println("<b>===== Data Writing ServletContext =====<br>");
		out.println("사용자의 정보가 등록되었습니다.</b><br><br>");
		
		// 다음 서블릿 연결
		out.println("<a href = 'Reading'>접속자 명단 보기</a>");
		out.println("</body></html>");
		out.close();
	}
}
