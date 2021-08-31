package servlet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.ProductVO;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// �ʵ��߰�
	List<ProductVO> list = Collections.synchronizedList(new ArrayList<ProductVO>());

	@Override
	public void init() throws ServletException {
	System.out.println("1. ServletContext Address :: " + getServletContext());
	getServletContext().setAttribute("list", list);
	System.out.println("ServletContext 상품정보들을 하나씩 저장할 것입니다..");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		double price = Double.valueOf(request.getParameter("price"));
		String desc = request.getParameter("desc");

		ProductVO pvo = new ProductVO(name, price, desc);
		list.add(pvo);
		request.setAttribute("product", pvo);

		request.getRequestDispatcher("register.jsp").forward(request, response);

	}
}
