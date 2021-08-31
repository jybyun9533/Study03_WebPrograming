package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class IdCheckController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		try {
			boolean flag = MemberDAOImpl.getInstance().isExist(id);
			out.print(flag); // 넘어갈땐 String으로 넘어감
			
		} catch (SQLException e) {
		}
		
		return null;
	}
}
