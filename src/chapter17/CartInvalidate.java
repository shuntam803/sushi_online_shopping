package chapter17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Page;

/**
 * カウンタ属性の活用例
 * カートを削除にしたうえセッションも終了させるサーブレット
 * @author c3user
 */
@WebServlet("/chapter17/cart-invalidate")
public class CartInvalidate extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);
		
		// HttpSessionオブジェクトを取得
		HttpSession session = request.getSession();
		
		// invalidateメソッドを使ってセッション属性を無効化にしてセッションを終了
		session.invalidate();
	
		
		out.println("カートを削除しました。");
		
		Page.footer(out);

	}

}
