package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/*
 * Ŭ���̾�Ʈ�κ��� ������ ��û�� ����ä�
 * ���ڵ��۾��� ���͸����� �����Ѵ�.
 * ���� ���� �޺κп� ������ ��� ������Ʈ���� ���⼭ �۾��� ���͸� �۾� ȿ���� ��´�
 */
@WebFilter(value= {"/*"})
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
