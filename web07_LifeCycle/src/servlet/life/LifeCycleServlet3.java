package servlet.life;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 클라이언트의 요청을 처리한 결과를 필드에 지정된 COUNT값을 서블릿이 출력하지 않고
 * 정보를 JSP에게 넘기고 결과페이지 처리를 JSP가 하도록 로직을 수정
 * 페이지 연결방법은 단순하게 a태그를 이용.
 */

@WebServlet(urlPatterns = { "/LIFE3" }, loadOnStartup = 1)
public class LifeCycleServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String path = "C:\\encore_bjy\\util\\web_util\\life\\count.txt";

	public LifeCycleServlet3() {
		System.out.println("1. LifeCycleServlet1 생성자 호출.. by Container..");
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

		// TestPrint
		System.out.println("3. service() --> doGet() or doPost() 호출.. by Container..");

		// Logic
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor=yellow>");
		out.println("<h3>LifeCycle CallBack Method..</h3>");
		out.println("<b>Count :: " + ++count + "</b>");
		out.println("</body></html>");

		out.close();

	}

	@Override
	public void init() throws ServletException {
		System.out.println("2. init() 호출.. by Container..");
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str = br.readLine();
			count = Integer.parseInt(str);
			
			System.out.println("count.txt의 값을 읽어서 필드 count에 다시 할당.");
		} catch(Exception e) {
			System.out.println("파일을 읽어들이는데 문제가 발생했습니다. fail.");
		}
	}

	@Override
	public void destroy() {
		System.out.println("4. destroy() 호출.. by Container..");
		// 인스턴스가 메모리에서 제거되기 전에 필드값을 영구적으로 보관.. 파일에 저장
		// 출력용 스트림을 생성..이곳에 필드값을 출력
		
		File f = new File(path);
		f.getParentFile().mkdirs();
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(f));
			pw.println(count);
			pw.close();
			
			System.out.println(path+"COUNT 값 :: " + count + "파일에 값 영구적으로 저장");
		} catch(Exception e) {
			System.out.println("출력용 스트림 생성 실패...");
		}
	}

}
