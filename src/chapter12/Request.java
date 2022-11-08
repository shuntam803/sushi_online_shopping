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
 * @author c3user
 */
@WebServlet("/chapter12/request")
public class Request extends HttpServlet {
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		Page.header(out);
		// サーブレットのURLを表示
		out.println("<p>Request URL<br>" + request.getRequestURL() + "</p>");
		// Hostを指定してサーバーの情報を表示
		out.println("<p>Host<br>" + request.getHeader("Host") + "</p>");
		// Uset-Agentを指定してブラウザの種類を表示
		out.println("<p>User-Agent<br>" + request.getHeader("User-Agent") + "</p>");
		// リクエスト送信元のIPアドレスを表示
		out.println("<p>Remote Address<br>" + request.getRemoteAddr() + "</p>");
		Page.footer(out);
		
		
	}
	

}
