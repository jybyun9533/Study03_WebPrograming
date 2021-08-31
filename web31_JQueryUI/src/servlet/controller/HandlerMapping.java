package servlet.controller;
/*
 * Controller를 생성하는 공장...
 */
public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return factory;
	}
	
	//Component를 생성....command 하는 기능....factory본연의 역할
	public  Controller  createController(String command) {
		Controller controller = null;
		if(command.equals("subject.do")) {
			controller = new SubjectController();
			System.out.println("subjectController 생성");
		}else if(command.equals("company.do")) {
			controller = new CompanyController();
			System.out.println("companyController 생성");
		}
		return controller;
	}
	
}
