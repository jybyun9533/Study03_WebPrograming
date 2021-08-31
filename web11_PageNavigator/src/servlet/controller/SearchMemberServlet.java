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
		 * 기능작성 1. 폼 값 받기 2. DAO 리턴 3. 비지니스 로직 호출한 결과로 vo객체 리턴받음 4. 리턴받은 값을 Attribute에
		 * 바인딩 -- 어떤 Attribute를 사용할것인가? 5. 네비게이션 -- 서버내에 있는 jsp로 바로이동
		 */

		PrintWriter out = response.getWriter();

		// 1. 폼값 받기
		String id = request.getParameter("id");

		// 2. DAO 비지니스 로직 호출(미구현)

		request.setAttribute("id", id); // request에 바인딩

		//request.getRequestDispatcher("result_view.jsp").forward(request, response);
		request.getRequestDispatcher("includetest1.jsp").include(request, response);
		out.print("이부분이 보일까요");
		
		

	}
}

/*
 * RequestDispatcher가 가지고 있는 forward(req,res), include(req, res) 방식의 페이지 이동방법
 * 1. forward
 * forward 하려는 페이지로 현재 서블릿의 모든 권한을 가지고 서버내의 다른페이지로 직접 이동
 * 제어권이 완전히 이동하는 페이지로 가버리기 때문에 다시 이전 서블릿으로 되돌아오지 않는다.
 * -> 응답객체인 Printwriter를 사용할 일이 없음. 철저한 로직중심.
 * 결과페이지의 url 주소를 보면, 결과페이지인 jsp주소가 아니라 이전 서블릿 주소로 출력되어짐.
 * =>모든 권한을 가지고 이동했기 때문에 서블릿 이름으로 주소가 명시되어 진다.
 * 
 * 2. include  
 * 만약에 서블릿의 Printwriter객체를 이용하려 한다면 include방식으로 페이지를 이동할 수 있음.
 * include에 담겨져 있는 모든 내용을 가지고 서블릿에 포함되어 including 한 다음엔 다시 서블릿 이후과정을 마무리 짓고 서블릿이 직접 응답.
 * 하지만 이렇게 사용되는 부분은 거의 없고, 1번처럼 주로 forwarding방식을 훨씬 더 많이사용
 */




















