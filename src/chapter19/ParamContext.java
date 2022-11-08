package chapter19;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * コンテキストの初期値パラメータを読み込むファイル
 * @author c3user
 *
 */

@WebServlet("/chapter19/param-context")
public class ParamContext extends HttpServlet {
	
	/** doGetメソッドでmassageの内容を出力 */
	public void doGet (HttpServletRequest requst, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		// オブジェクト取得
		ServletContext context = getServletContext();
		// getInitParameterメソッドで初期値パラメータを取得して出力
		out.println(context.getInitParameter("message"));
	}

}
