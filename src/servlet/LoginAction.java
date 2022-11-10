package servlet;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;
import dao.CustomerDAO;
import tool.Action;

/**
 * ・ログインアクションの作成 <br>
 * (1)セッション開始 <br>
 * (2)リクエストパラメーターからログイン名とパスワードを取得 <br>
 * (3)顧客テーブルから指定されたログイン名とパスワードの顧客を検索 <br>
 * (4)顧客が取得できたらログイン成功。顧客Beanをセッションに設定し
 *    ログイン成功ページにフォワード <br>
 * (5)顧客が取得できなかったらログイン失敗。ログイン失敗ページにフォワード <br>
 * @author shuntam
 *
 */

public class LoginAction extends Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// return先のJSPを指定するための文字列
		String url;

		// (1)セッション開始
		HttpSession session = request.getSession();

		// (2)リクエストパラメーターからログイン名とパスワードを取得
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		// (3)顧客テーブルから指定されたログイン名とパスワードの顧客を検索
		CustomerDAO dao = new CustomerDAO();
		Connection conn = dao.getConnection();
		Customer customer = dao.search(conn, login, password);

		conn.close();

		// (4)顧客が取得できたらログイン成功。顧客Beanをセッションに設定しログイン成功ページにフォワード
		if (customer != null) {
			session.setAttribute("customer", customer);
			url = "../views/login-out.jsp";
		} else {
			url = "../views/login-error.jsp";
		}
		// (5)顧客が取得できなかったらログイン失敗。ログイン失敗ページにフォワード
		return url;
	}
}
