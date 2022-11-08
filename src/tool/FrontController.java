package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * フロントコントローラのクラス
 * Servlet implementation class Greeting
 */
@WebServlet("*.action")
public class FrontController extends HttpServlet {

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		try {
			// パスの取得
			String path = request.getServletPath().substring(1);
			// パスの加工(package名.class名という形式)
			 String name = path.replace(".a", "A").replace("/", ".");
			/*
			 *  アクションの生成(アクションのクラス名を使ってインスタンスを生成
			 *  ClassクラスのforNameメソッドとgetDeclaredメソッド、
			 *  ConstructorクラスのnewInstanceメソッドを次のように使う
			 *  Class.forName(クラス名).getDeclaredConstructor().newInstance()
			 */
			Action action = (Action)Class.forName(name).getDeclaredConstructor().newInstance();
			// アクションの実行(戻り値はurl)
			String url = action.execute(request, response);
			// フォワードの実行
			request.getRequestDispatcher(url).forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	
	}
	/**
	 * GETリクエストを処理するdoGetメソッドはdoPostメソッドを呼び出す
	 * したがってPOSTリクエストの場合も同じ処理を行う
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
	}
}
