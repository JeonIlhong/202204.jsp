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

import dto.Country;
import service.CountryJSONService;

@WebServlet("*.country")
public class CountryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CountryJSONService countryService = new CountryJSONService(); 
   
  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String path = request.getContextPath();
		 if (uri.contains("jspform")) {
			//countrylist.jsp. 이동
			
			//iso조회
			List<Map<String,String>> isolist = countryService.selectlist_iso();
			System.out.println(isolist);
			
			//forward
			request.setAttribute("isolist", isolist);
			request.getRequestDispatcher("/view/countrylist.jsp")
			.forward(request, response);
		}else if(uri.contains("list")) {
			//db에서 조회
			
			String iso = request.getParameter("iso");
			List<Country> clist = countryService.selectlist(iso);
			System.out.println("clist:"+clist);
			
			request.setAttribute("clist", clist);
			request.getRequestDispatcher(path+"/jspform.country?iso="+iso)
			.forward(request, response);
			
		}else if(uri.contains("dbsave")) {
			String iso = request.getParameter("iso");
		
			//파싱 후 db저장
			int cnt = countryService.countryParsing(iso);
			
			//redirect방식 : url변경
			String msg = URLEncoder.encode(cnt+"건 저장","utf-8");
			response.sendRedirect(path+"/jspform.country?msg="+msg+"&iso="+iso);
			
			
		}else if (uri.contains("detail")) {
			//상세조회로 이동
			String sfty_notice_id = request.getParameter("sfty_notice_id");
			//한건 조회
			Country country = countryService.selectOne(sfty_notice_id);
			//forward방식 : detail.jsp로 이동
			request.setAttribute("country", country);
			request.getRequestDispatcher("/view/detail.jsp")
			.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
