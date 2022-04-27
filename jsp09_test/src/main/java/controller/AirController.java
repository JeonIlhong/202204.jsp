package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;

import service.AirconditionService;


@WebServlet("*.air")
public class AirController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       AirconditionService as = new AirconditionService();
      

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String path = request.getContextPath();
		
		if(uri.contains("pasing")) {
			
			String year = request.getParameter("year");
			
			
			int cnt = as.airconditionParsing(year);
			
			String msg = URLEncoder.encode(cnt+"건 저장", "utf-8") ;
			response.sendRedirect(path + "/view/main.jsp?msg="+msg);

			
			
			
			
		}else if(uri.contains("list")) {
			
			//조회
			String districtname = request.getParameter("districtname");
			List<Map<String, String>> alist = as.selectList(districtname);
			
			//foward 이동
			
			request.setAttribute("alist", alist);
			request.getRequestDispatcher("/view/main.jsp")
			.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
