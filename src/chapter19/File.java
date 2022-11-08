package chapter19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * ファイルを読み込むサーブレット
 * @author c3user
 *
 */
@WebServlet("/chapter19/file")
public class File extends HttpServlet {
	
	
	public void doGet (HttpServletRequest requst, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		// getAServletContextメソッドによりServletContextオブジェクトを取得
		ServletContext context = getServletContext();
		
		// getRealPathメソッドにより設定ファイルのパスを取得
		String path = context.getRealPath("/WEB-INF/setting.txt");
		
		// ファイルを読み込むためのFileInputStreamクラス 
		FileInputStream file = new FileInputStream(path);
		
		// プロパティファイルを扱うPropertiesクラス
		Properties prop = new Properties();
	
		// ファイルの読み込み
		prop.load(file);
		file.close();
		
		// Propertiesオブジェクトに保存された名前の一覧を取得
		for (String key : prop.stringPropertyNames()) {
			// getPropertyメソッドで名前と値を出力
			out.println("<p>" + key + " : " + prop.getProperty(key) + "</p>");
			
		}
	
		
		Page.footer(out);
	}

}
