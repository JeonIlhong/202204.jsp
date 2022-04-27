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

import dto.Covid;
import service.CovidXMLService;

/**
 * Servlet implementation class CovidController
 */
@WebServlet("*.covid")
public class CovidController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CovidXMLService covidXMLService = new CovidXMLService();   
  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String path = request.getContextPath();
		
		if(uri.contains("list")) {
			String startDt = request.getParameter("startDt");
			String endDt = request.getParameter("endDt");
			startDt = startDt.replace("-", "");
			endDt = endDt.replace("-", "");
			System.out.println(startDt);
			System.out.println(endDt);
			
			List<Covid> clist = covidXMLService.selectList(startDt, endDt);
			System.out.println("controller clsit:"+clist);
			
			//forward 이동
			request.setAttribute("clist", clist);
			request.getRequestDispatcher("/view/covidlist/covidlist.jsp")
			.forward(request, response);
		}else if (uri.contains("dbsave")) {
			//파싱후 db저장 
			String startDt = request.getParameter("startDt");
			String endDt = request.getParameter("endDt");
			startDt = startDt.replace("-", "");
			endDt = endDt.replace("-", "");
			int cnt = CovidXMLService.covidParsing(startDt, endDt);
			System.out.println("패스:"+path);
			//redirect로 이동
			String msg = URLEncoder.encode(cnt +"건 db 저장 완료","utf-8");
			response.sendRedirect(path+"/view/covidlist/covidlist.jsp?msg="+msg+"&startDt="+startDt+"&endDt="+endDt);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
