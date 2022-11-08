package tool;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/**
 * リクエストとレスポンスに関して
 * 文字エンコーディングやMIMEタイプの設定を行うクラス
 * chapter10で使う(実行はchapter3のHello.java)
 * WebFilterのURLで"/*"を指定すると全部にフィルターがかかる
 * @author c3user
 *
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

	public void doFilter (
		ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// サーブレットやJSPの呼び出し後に行う処理
		// System.out.println("フィルタの前処理");
		
		chain.doFilter(request, response);
		// サーブレットやJSPの呼び出し後に行う処理
		// System.out.println("フィルタの後処理");
	}
	
	/** initメソッドとdestroyメソッドでは、何も処理を行わない */
	public void init(FilterConfig filterConfig) {}
	@Override
	public void destroy() {}
}
