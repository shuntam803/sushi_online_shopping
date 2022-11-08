package chapter11;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycle
 */
@WebServlet("/chapter11/life-Cycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * サーブレットの起動時に呼び出されるメソッド
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("init");
	}

	/**
	 * サーブレットがリクエスト処理にする際に呼び出されるメソッド
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service");
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}
	/**
	 * サーブレットの終了時に呼び出されるメソッド
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy");
	}


}
