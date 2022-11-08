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
 * 同時操作の問題を対策したプログラム
 * Servlet implementation class CountTread
 */
@WebServlet("/chapter11/count-thread2")
public class CountThread2 extends HttpServlet {
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
		
		/*
		 * sychronizedブロックを使って、ブロック内の処理を
		 * 同時に進行できるスレッドを一つだけに制限する。
		 * sychronizedメソッドはメソッド宣言に付加すると
		 * そのメソッドを同時に実行できるスレッドを一つだけに制限できる。
		 * (1)カウンタから値を取得する
		 * (2)値を加算する
		 * (3)カウンタに値を設定する
		 * (4)カウンタの値を表示する
		 */
		synchronized (this) {
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
		}

		Page.footer(out);
	}
}