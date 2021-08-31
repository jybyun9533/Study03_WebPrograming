package listener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*
 * WAS에 의해서 호출되는 모든 라이프사이클 메소드 정리
 * --------------------
 * 
 * 1. contextInitialized()
 * 
 * ------Ready On------
 * 
 * 2. 서블릿 생성자 호출
 * 3. init()
 * 
 * ------- Repeat -------
 * 
 * 4. service() --> doGet() | doPost()
 * 
 * --------------------
 *
 * 5. destroy()
 * 6. contextDestroyed()
 */

@WebListener
public class MyServletListener implements ServletContextListener {
	private ServletContext cont;

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized...");

		// 1. ServletContext 리턴받음.. 이때 sce로 받아야함.
		cont = sce.getServletContext();

		// 2. DD파일의 경로를 읽어들인다.
		String filename = cont.getInitParameter("path");
		System.out.println("User File Path" + filename);

		// 3. getResourceAsStream()..
		InputStream is = null;
		BufferedReader br = null;
		try {

			System.out.println("getResourceAsStream()...");
			is = cont.getResourceAsStream(filename);

			System.out.println("BufferedReader생성..");
			br = new BufferedReader(new InputStreamReader(is));

			String line = null;
			System.out.println("내용을 읽어들입니다.");

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {

		}

	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

}
