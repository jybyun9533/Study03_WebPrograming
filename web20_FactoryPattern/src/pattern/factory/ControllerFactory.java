package pattern.factory;

import pattern.action.AddController;
import pattern.action.Controller;
import pattern.action.DeleteController;
import pattern.action.UpdateController;

public class ControllerFactory {
	// 싱글톤
	private static ControllerFactory factory = new ControllerFactory();

	private ControllerFactory() {
		System.out.println("controllerFactory Creating");
	}

	public static ControllerFactory getInstance() {
		return factory;
	}

	// Controller를 생성하는 기능
	public Controller createController(String command) {
		Controller controller = null;
		if (command.equals("INSERT")) {
			controller = new AddController();
			System.out.println("ADDController 생성");
		} else if (command.equals("UPDATE")) {
			controller = new UpdateController();
			System.out.println("UpdateController 생성");
		} else if (command.equals("DELETE")) {
			controller = new DeleteController();
			System.out.println("DELEEController 생성");
		}
		return controller;
	}

}
