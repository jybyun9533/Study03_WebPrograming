package servlet.controller;

public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();

	private HandlerMapping() {
	}

	public static HandlerMapping getInstance() {
		return factory;
	}
	// Component를 생성.. command 하는 기능.. factory본연의 역할

	public Controller createController(String command) {

		Controller controller = null;
		if (command.equals("login.do")) {
			controller = new LoginController();
		} else if (command.equals("registerBook.do")) {
			controller = new RegisterBookController();
		} else if (command.equals("logout.do")) {
			controller = new LogoutController();
		} else if (command.equals("findbooks.do")) {
			controller = new FindBooksController();
		}else if (command.equals("bookDesc.do")) {
			controller = new BookDescController();
		}

		return controller;
	}
}
