package chapter19;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * サーブレットの初期値パラメータを読み込むファイル
 * @author c3user
 *
 */
public class ParamServlet extends HttpServlet {
	
	/** initメソッドで取得した初期化パラメータを保存するためのprivateフィールド */
	private String message;
	
	/** initメソッドはサーブレットの起動時に1回だけ実行される */
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		message = config.getInitParameter("message");
		
	}
	/** doGetメソッドでmessageの内容を出力 */
	public void doGet (HttpServletRequest requst, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println(message);
	}

}
