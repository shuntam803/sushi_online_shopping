package chapter12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * リクエスト情報を取得するサーブレット
 * ①～⑥まではリクエストラインの情報を取得するメソッド
 * ⑦～⑩まではURLの情報を取得するメソッド
 * @author c3user
 */
@WebServlet("/chapter12/request2")
public class Request2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		Page.header(out);
		// ①HTTPのメソッドを表示
		out.println("<p>Method<br>" + request.getMethod() + "</p>");
		// ②リクエストされたURIを表示
		out.println("<p>Request URI<br>" + request.getRequestURI() + "</p>");
		// ③コンテキストパスを表示
		out.println("<p>Context Path<br>" + request.getContextPath() + "</p>");
		// ④サーブレットのパスを表示
		out.println("<p>Servlet Path<br>" + request.getServletPath() + "</p>");
		// ⑤リクエストパラメーターを表示(URLに"?p1=v2&p1=v2"につけると表示される
		out.println("<p>Query String<br>" + request.getQueryString() + "</p>");
		// ⑥プロトコル(HTTPのバージョン)を表示
		out.println("<p>Protocol<br>" + request.getProtocol() + "</p>");
		// ⑦リクエストされたURLを表示
		out.println("<p>Request URL<br>" + request.getRequestURL() + "</p>");
		// ⑧スキームを表示
		out.println("<p>Scheme<br>" + request.getScheme() + "</p>");
		// ⑨ホスト名を表示
		out.println("<p>Server Name<br>" + request.getServerName() + "</p>");
		// ⑩ポート番号を表示
		out.println("<p>Server Port<br>" + request.getServerPort() + "</p>");
		Page.footer(out);

	}

}
