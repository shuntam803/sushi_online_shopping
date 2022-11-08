package chapter22;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * リストの要素を取り出すサンプル
 * @author c3user
 *
 */
@WebServlet("/chapter22/main")
public class Main extends HttpServlet {
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] hands = {"グー", "チョキ", "パー"};
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		System.out.println(now.format(dFormat));
		request.setCharacterEncoding("UTF-8");
		String handStr = request.getParameter("hand");
		int userHand = Integer.parseInt(handStr);
		int pcHand = new Random().nextInt(hands.length);
		String result;
		int diff = (userHand + 3 - pcHand) % 3;
		if (diff == 0) {
			result = "あいこです☝";
		}else if (diff == 2) {
			result = "あなたの勝ち🎊";
		}else {
			result = "あなたの負け😭";
		}
		request.setAttribute("userHand", hands[userHand]);
		request.setAttribute("pcHand", hands[pcHand]);
		request.setAttribute("result", result);
		
		doGet(request, response);
	}

}
