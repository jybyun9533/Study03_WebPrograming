package servlet.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.User;

@WebServlet(urlPatterns = { "/MainServlet" }, initParams = {
		@WebInitParam(name = "path", value = "C:\\filestore\\userinfo\\member.txt") }, loadOnStartup = 1)

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String path;
	private ArrayList<User> user = new ArrayList<User>();

	@Override
	public void init() throws ServletException {

		path = getInitParameter("path");

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = null;

			while ((line = br.readLine()) != null) {
				String[] s = line.split(" ");
				user.add(new User(s[0], s[1], s[2], s[3]));
			}
			br.close();

		} catch (Exception e) {

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
		String pw = request.getParameter("password");

		User temp = null;
		for (User u : user) {
			if (u.getId().equals(id)) {
				temp = u;
			}
		}

		if (temp != null) {
			if (temp.getPassword().equals(pw)) {
				out.println("<a href=success.jsp> 로그인 성공!</a>");
			} else {
				out.println("<a href=error.jsp>비밀번호가 틀렸습니다.</a>");
			}
		} else {
			out.println("<a href=error.jsp>아이디가 존재하지 않습니다.</a>");
		}

		out.close();
	}
}
