package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CultureService;


@WebServlet("*.culture")
public class CultureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
				String uri = request.getRequestURI();
				System.out.println(uri);
				String path = request.getContextPath();
				CultureService cs = new CultureService();
				
				
				if(uri.contains("addr")) {
					
					
					String addrname = request.getParameter("name");
					// 주소를 검색 
					Map<String, Object> cmap = cs.CultureParsing(addrname);
					System.out.println("cmap:"+cmap);
					//위도경도 구하기
					Map<String,Double> geomap =cs.geocoding((String) cmap.get("ADDR"));	
					
					
					
					request.setAttribute("cmap", cmap);
					request.setAttribute("geomap", geomap);
					request.getRequestDispatcher("/view/cultureaddr.jsp")
					.forward(request, response);
				}
		
		
		
	
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
