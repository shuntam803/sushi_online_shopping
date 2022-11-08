package chapter4;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello3 extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Servlet/JSP Samples</title>");
		out.println("<p>Hello!</p>");
		out.println("<p>こんにちは！</p>");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年 MM月 dd日 hh時 mm分 ss秒");
		out.println("<p>" + sdf.format(new Date()) + "</p>");
		out.println("</head>");
		out.println("</html>");
	
	}
}
