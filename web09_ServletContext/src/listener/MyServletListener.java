package listener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*
 * WAS�� ���ؼ� ȣ��Ǵ� ��� ����������Ŭ �޼ҵ� ����
 * --------------------
 * 
 * 1. contextInitialized()
 * 
 * ------Ready On------
 * 
 * 2. ���� ������ ȣ��
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

		// 1. ServletContext ���Ϲ���.. �̶� sce�� �޾ƾ���.
		cont = sce.getServletContext();

		// 2. DD������ ��θ� �о���δ�.
		String filename = cont.getInitParameter("path");
		System.out.println("User File Path" + filename);

		// 3. getResourceAsStream()..
		InputStream is = null;
		BufferedReader br = null;
		try {

			System.out.println("getResourceAsStream()...");
			is = cont.getResourceAsStream(filename);

			System.out.println("BufferedReader����..");
			br = new BufferedReader(new InputStreamReader(is));

			String line = null;
			System.out.println("������ �о���Դϴ�.");

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {

		}

	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

}
