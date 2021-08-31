package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");

		try {
			MemberVO vo = MemberDAOImpl.getInstance().findByIdMember(id);
		
			out.print(vo.getName() + ", " + vo.getAddress());

		} catch (SQLException e) {

		}
		return null;
	}
}
