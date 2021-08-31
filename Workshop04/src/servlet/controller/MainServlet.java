
package servlet.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Member;

@WebServlet(urlPatterns = { "/MainServlet" }, loadOnStartup = 1)

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Member member;
	private ServletContext cont;
	private String path;
	private ArrayList<String> ids;

	@Override
	public void init() throws ServletException {
		cont = getServletContext();

		path = cont.getInitParameter("path");
		ids = new ArrayList<String>();

		try {
			InputStream is = cont.getResourceAsStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;

			while ((line = br.readLine()) != null) {
				String[] s = line.split("\\|");
				ids.add(s[0]);
			}
			br.close();

		} catch (Exception e) {
			System.out.println("실패");
		}
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

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String address = request.getParameter("address");

		member = new Member(id, pw, name, address);

		boolean idFlag = false;

		for (String s : ids) {
			if (s.equals(id)) {
				idFlag = true;
				break;
			}
		}

		if (!idFlag) {
			cont.setAttribute("member", member);
			out.println("<html><body>");
			out.println("<b>===== 회원가입 성공 =====<br>");
			out.println("회원가입 성공하셨습니다.</b><br><br>");
			out.println("<a href = 'Success.jsp'>확인</a>");
			out.println("</body></html>");
		} else {
			out.println("<html><body bgcolor = 'red'>");
			out.println("<b>===== 회원가입 실패 =====<br>");
			out.println("이미 존재하는 회원입니다.</b><br><br>");
			out.println("<a href = 'Error.jsp'>확인</a>");
			out.println("</body></html>");
		}

		out.close();
	}
}
