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
 * セッションを使ったカウンター
 * ブラウザを更新するたびにカウントアップする
 * @author c3user
 */
@WebServlet("/chapter17/count")
public class Count extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);
		
		// HttpSessionオブジェクトを取得
		HttpSession session = request.getSession();
		
		// session属性からカウンタの値を取得
		Integer count = (Integer)session.getAttribute("count");
		
		// countがnullの場合0を代入
		if (count == null) {
			count = 0;
		}
		count++;
		
		//setAttribureメソッドで再びセッション属性に保存する
		session.setAttribute("count", count);
		
		if (count == 10) {
			session.removeAttribute("count");
		}
		
		// countの値とセッションIDを取得し
		out.println("<p>" + count + "</p>");
		out.println("<p>" + session.getId() + "</p>");
		
		Page.footer(out);

	}

}
