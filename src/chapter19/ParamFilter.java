package chapter19;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * フィルターの初期値パラメータを読み込むファイル
 * @author c3user
 *
 */
public class ParamFilter implements Filter {
	
	/** initメソッドで取得した初期化パラメータを保存するためのprivateフィールド */
	private String message;
	
	/** initメソッドはサーブレットの起動時に1回だけ実行される */
	public void init(FilterConfig config) throws ServletException {
		
		message = config.getInitParameter("message");
	}
	
	/** doFilterメソッドでmassageの内容を出力 */
	public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println(message);
		chain.doFilter(request, response);
	}
	
	/** destroyメソッド */
	public void destroy() {
		
	}

}
