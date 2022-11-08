package chapter11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * 同時操作の問題があるプログラム
 * Servlet implementation class CountTread
 */
@WebServlet("/chapter11/count-thread")
public class CountThread extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// カウンタを保持する変数count
	int count;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);

		int i = count;

		try {
			// sleepメソッドを使った時間待ち。待ち時間は3000ミリ秒(3秒)
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			// 何もしない
		}

		// カウンタの値を更新
		count = i + 1;
		out.println(count);

		Page.footer(out);
	}
}