package s01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class J20220325_01
 */

//서블릿클래스
//HttpServlet를 상속받는 클래스
//어노테이션: 매핑정보(url)를 표현
@WebServlet("/servletTest")
public class J20220325_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public J20220325_01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //get 방식 호출시 실행되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request: 요청객체
		//response:응답객체
		//response.getWriter().append("contxtePath: ").append(request.getContextPath());
		//1) 
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<header>");
		out.println("<title>서블릿테스트</title>");
		out.println("<body>");
		
		
		int a = 10;
		String s = (a%2==0)?"even":"odd";	
		
		out.println(s);
		
		out.println("</body>");
		out.println("/<html>");
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//post방식 호출시 실행되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
