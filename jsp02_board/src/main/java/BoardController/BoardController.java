package BoardController;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.Board;


/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩 (utf-8)
				request.setCharacterEncoding("utf-8");
				String uri = request.getRequestURI();
				System.out.println(uri);
				
		// add 
		if(uri.contains("add")) {
			//게시물 등록
			String writer = request.getParameter("writer");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			
			//보드객체생성
			Board board = new Board(writer,subject,content);
			System.out.println(board);
			
			//DAO객체 생성
			
			BoardDAO mdao = new BoardDAO();
			int cnt = mdao.insert(board);
			System.out.println(cnt+"건 추가");
			
			//게시물등록으로 이동
			String msg = URLEncoder.encode("추가완료", "utf-8");
			response.sendRedirect("/jsp02_board/board/add.jsp?msg="+msg);
		}else if (uri.contains("list")) {
			//리스트
			String findkey = request.getParameter("findkey");
			String findvalue = request.getParameter("findvalue");
			BoardDAO bdao = new BoardDAO();
			List<Board> blist = bdao.selectList(findkey,findvalue);
			System.out.println(blist);
			
			//forward 이동
			request.setAttribute("blist", blist);
			request.getRequestDispatcher("/board/list.jsp")
			.forward(request, response);
			
			
			
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
