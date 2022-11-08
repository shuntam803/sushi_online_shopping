package chapter10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter2 implements Filter {

	public void doFilter(
		ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out= response.getWriter();
		out.println("<p>フィルター②実行前");
		out.println("[HelloFilter2(pre)]</p>");
		
		chain.doFilter(request, response);
		out.println("<p>フィルター②実行後");
		out.println("[HelloFilter2(post)]</p>");
	}
	/** initとdestroはyメソッドは使用しない */
	public void init(FilterConfig config) {}
	public void destroy() {}
}
