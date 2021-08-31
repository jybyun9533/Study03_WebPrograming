package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompanyController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ComanyComponent 진입");
		
		// 비지니스 로직 생략
		
		String result ="<ul><li> Tomato System </li><br>"
				+ "<li> NCSoft </li><br>"
				+ "<li> EAST Engin </li><br>"
				+ "<li> Encore System </li><br>"
				+ "<li> KTDS </li><br>"
				+ "<li> LGCN </li><br></ul>";
		
		request.setAttribute("result", result);
		return new ModelAndView("Result.jsp");
	}

}
