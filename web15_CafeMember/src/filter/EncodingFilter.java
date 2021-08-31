package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
/*
 * 클라이언트로부터 들어오는 요청을 가로채어서
 * 인코딩작업을 필터링으로 연결한다.
 * 이후 필터 뒷부분에 나오는 모든 컴포넌트들은 여기서 작업된 필터링 작업 효과를 얻는다
 */
@WebFilter(
			value= {"/*"},
			initParams = @WebInitParam(name="encoding", value="utf-8")

		)
public class EncodingFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
