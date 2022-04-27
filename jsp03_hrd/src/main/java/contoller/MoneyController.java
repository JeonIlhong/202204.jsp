package contoller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExamDAO;

/**
 * Servlet implementation class MoneyController
 */
@WebServlet("/money/*")
public class MoneyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ExamDAO edao = new ExamDAO();
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		if (uri.contains("list")) {
			//회원매출조회
			//dao호출
			List<Map<String, Object>> mlist = edao.salesList();
			System.out.println(mlist);
			
			request.setAttribute("mlist", mlist);
			request.getRequestDispatcher("/view/moneyList.jsp")
				.forward(request, response);
			
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
