package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubjectController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("SubjectComponent 진입");
		// 비지니스 로직.. 엔코아 주요과목, 이수과목을 DB에서 갖고옴 (생략)
		
		String result = "Bid Data | Machine Learning | DeepLearning | Python | Restful API Service | Vue.ls CLI";
		
		request.setAttribute("result", result);
		
		
	
		
		return new ModelAndView("Result.jsp");
	}

}
