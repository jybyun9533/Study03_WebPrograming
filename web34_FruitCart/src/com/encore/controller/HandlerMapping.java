package com.encore.controller;
import com.encore.controller.ItemListController;

/*
 * Controller를 생성하는 공장...
 */
public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();

	private HandlerMapping() {
	}

	public static HandlerMapping getInstance() {
		return factory;
	}

	// Component를 생성....command 하는 기능....factory본연의 역할
	public Controller createController(String command) {
		Controller controller = null;
		if (command.equals("itemList.do")) {
			controller = new ItemListController();
		} else if (command.equals("itemView.do")) {
			controller = new ItemViewController();
		}

		return controller;
	}

}
