package chapter21;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;

/**
 * リクエスト属性を使った商品検索サーブレット
 * @author c3user
 */
@WebServlet("/chapter21/el")
public class EL extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// オブジェクト生成して検索する値をセット
		Product prod = new Product();
		prod.setId(1);
		prod.setName("まぐろ");
		prod.setPrice(100);
		
		/*
		 * setAttributeメソッド
		 * 第1引数で指定した名前の属性に第2引数のデータを設定する
		 * リクエスト属性にBeanを設定する属性名は"product"とする
		 */
		request.setAttribute("product", prod);
		
		// "attribute.jsp"にフォワードする
		request.getRequestDispatcher("/chapter21/el.jsp").forward(request, response);
	}

}