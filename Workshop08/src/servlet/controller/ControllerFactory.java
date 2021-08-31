package servlet.controller;

public class ControllerFactory {
	private static ControllerFactory factory = new ControllerFactory();

	private ControllerFactory() {
	}

	public static ControllerFactory getInstance() {
		return factory;
	}
	// Component를 생성.. command 하는 기능.. factory본연의 역할

	public Controller createController(String command) {

		Controller controller = null;
		if (command.equals("login")) {
			controller = new LoginController();
		} else if (command.equals("registerBook")) {
			controller = new RegisterBookController();
		} else if (command.equals("logout")) {
			controller = new LogoutController();
		} else if (command.equals("findbooks")) {
			controller = new FindBooksController();
		}

		return controller;
	}
}
