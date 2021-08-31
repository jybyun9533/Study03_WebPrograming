package com.encore.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.model.Item;
import com.encore.model.ItemDao;

public class ItemListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "";
		try {
			ArrayList<Item> list = ItemDao.getInstance().getAllItem();
			request.setAttribute("list", list);

			ArrayList<String> fruits = new ArrayList<String>();
			
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for(Cookie c : cookies) {
					if(c.getName().startsWith("fruitshop")) {
						fruits.add(c.getValue()); // 해당 사이트의 오늘봄 상품 이미지들 추가
					} 
				}
			}
			
			request.setAttribute("fruits", fruits);

			path = "itemList.jsp";
		} catch (SQLException e) {

		}

		/*
		 * 브라우저의 모든 쿠키정보를 받아오는 로직 작성 1. cookies[] = req.getCookies() 2. 그 중에서 내가 원하는 쿠키
		 * 정보를 뽑아서 바인딩
		 */

		return new ModelAndView(path);
	}

}
