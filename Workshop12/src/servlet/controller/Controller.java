package servlet.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
