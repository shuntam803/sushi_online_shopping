package chapter12;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * レスポンスを使ったサーブレット
 * ①"http://localhost:8080/book/chapter12/response"を開く
 * ②"http://localhost:8080/book/index.html"に飛ぶ
 * @author c3user
 */
@WebServlet("/chapter12/response")
public class Response extends HttpServlet {
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ステータスコードの302を指定(301を表す"SC_MOVED_PRIMANENTLY"を使っても動作は同じ)
		response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		// ページを自動で再読み込みするまでの秒数
		response.setHeader("Refresh", "1");
		// Locationヘッダフィールドに対しリダイレクト先のURLを指定
		response.setHeader("Location", "http://localhost:8080/book/index.html");
				
		
	}
	

}
