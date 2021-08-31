package parrtern.client;

import pattern.action.Controller;
import pattern.factory.ControllerFactory;

public class DispatcherMainTest {

	public static void main(String[] args) {
		String command = "INSERT";

		// 1.
		ControllerFactory factory = ControllerFactory.getInstance();
		Controller controller = factory.createController(command);
		
		// 2.
		String path = controller.requestHandle();
		System.out.println(path);

	}

}
