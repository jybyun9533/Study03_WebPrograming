package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class IdListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		try {
			/*
			 * ArrayList list = DAO의 모든 ID값의 리스트를 받아온다. -- getIdList(); Attrubute에 list라는
			 * 이름으로 바인딩 path = show_idList.jsp
			 */

			request.setAttribute("list", MemberDAOImpl.getInstance().getIdList());
			path = "show_idList.jsp";

		} catch (SQLException e) {

		}
		return new ModelAndView(path);
	}
}
