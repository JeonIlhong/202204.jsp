package contoller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExamDAO;
import dto.Emember;

@WebServlet("/member/*")
public class MemberContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩 (utf-8)
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath(); 
		System.out.println(uri);
		
		if(uri.contains("join")) {
			//회원등록
			
			String custname = request.getParameter("custname");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String joindate = request.getParameter("joindate");
			String grade = request.getParameter("grade");
			String city = request.getParameter("city");
			
			Emember emember = new Emember( custname, phone, address, joindate, grade, city);
			System.out.println(emember);
			
			ExamDAO edao = new ExamDAO();
			int cnt = edao.Insert(emember);
			System.out.println(cnt+"건 추가");
			
			//redirect 이동
			
			System.out.println(contextPath);
			String msg = URLEncoder.encode("등록이 완료되었습니다","utf-8");
			response.sendRedirect(contextPath+"/view/memberAdd.jsp?msg=" +msg);
			
		}else if(uri.contains("list")) {
			ExamDAO edao = new ExamDAO();
			List<Emember> mlist = edao.selectList();
			System.out.println(mlist);
			
			request.setAttribute("mlist", mlist);
			request.getRequestDispatcher("/view/memberList.jsp")
				.forward(request, response);
			}else if(uri.contains("modiform")) {
				//수정폼으로 
				int custno = Integer.parseInt(request.getParameter("custno"));
				
				
				//한건조회
				//dao호출
				ExamDAO edao = new ExamDAO();
				Emember emember = edao.selectOne(custno);
				
				
				
				System.out.println(emember);
				request.setAttribute("emember", emember);
				request.getRequestDispatcher("/view/memberModify.jsp")
				.forward(request, response);
			}else if(uri.contains("modify")) {
				
				//수정
				
				int custno= Integer.parseInt(request.getParameter("custno"));
				String custname = request.getParameter("custname");
				String phone = request.getParameter("phone");
				String address = request.getParameter("address");
				String joindate = request.getParameter("joindate");
				String grade = request.getParameter("grade");
				String city = request.getParameter("city");
				Emember emember = new Emember(custno, custname, phone, address, joindate, grade, city);
				System.out.println(emember);
				ExamDAO edao = new ExamDAO();
				int cnt = edao.update(emember);
				System.out.println(cnt+"건 수정");
				
				//redirect 이동
				String msg = URLEncoder.encode("수정이 완료되었습니다.", "utf-8");
				//수정폼으로 이동시 기존데이터 조회필요=>컨트롤러 재호출
				response.sendRedirect(contextPath + "/member/modiform?custno="+custno+"&msg=" + msg);
			}else {
				System.out.println("잘못된 url");
			}
			
		}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
