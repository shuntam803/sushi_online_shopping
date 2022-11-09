package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * サーブレット
 * Servlet implementation class Greeting
 */
@WebServlet("/chapter06/select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 文字エンコーディングをUTF-8に指定
		request.setCharacterEncoding("UTF-8");
		
		// name要素
		// セレクトボックス
		String count = request.getParameter("count");
		// ラジオボタン
		String payment = request.getParameter("payment");
		// テキストボックス
		String review = request.getParameter("review");
		// チェックボックス
		String mail = request.getParameter("mail");
		
		Page.header(out);
		// メッセージの出力
		out.println("<p>" + count + "個の商品をカートに入れました。<p>");
		out.println("<p>お支払方法を" + payment + "に設定しました。<p>");
		out.println("<p>ご感想ありがとうございます。<p>");
		out.println("<p>「" + review +"」<p>");
		
		if (mail != null) {
			// mailにチェックを入れた場合
			out.println("<p>メールをお送りします。<p>");
		} else {
			// mailにチェックを入れなかった場合
			out.println("<p>メールはお送りしません。<p>");
		}
		Page.footer(out);

	}
}
