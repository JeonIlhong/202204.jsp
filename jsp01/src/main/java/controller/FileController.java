package controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileController
 */
@WebServlet("*.file")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String uri = request.getRequestURI();
			System.out.println(uri);
		
			
			if(uri.contains("upload")) {
				// 파일 업로드 처리
				
				String savedir ="C:/JIH/savedir"; //파일저장경로
				int size = 1024*1024*10;   //10mb
				 
				//파일저장하기
				
				MultipartRequest multi = 
						new MultipartRequest(request, savedir, size,"utf-8",new DefaultFileRenamePolicy());
				
				
				//저장된 파일이름 가져오기
				String filename = multi.getFilesystemName("file1");
				System.out.println(filename);
				
				
				
				
				//forward방식 이동
				request.setAttribute("filename", filename);
				request.getRequestDispatcher("/view/file/20220426_file.jsp")
				.forward(request, response);
			}else if(uri.contains("download")) {
				//파일 다운로드
				String filename = request.getParameter("filename");
				System.out.println("다운로드 파일:"+filename);
				String savedir = "C:/JIH/savedir"; //파일저장경로
				String fileurl = savedir + "/" + filename;
				System.out.println(fileurl);
				
				//마임타입: 파일의 종류
				String mimeType = getServletContext().getMimeType(filename);
				System.out.println(mimeType);
				if(mimeType == null) 
					mimeType = "application/octet-stream;charset = utf-8";
				response.setContentType(mimeType);
				
				//첨부파일로 보내기
				response.setHeader("Content-Disposition", "attachment;filename="+filename);
				
				
				//서버의 파일을 읽어서 전송
				//파일 입력스트림 생성
				FileInputStream fis = new FileInputStream(fileurl);
				//응답 출력스트림 생성
				ServletOutputStream out  = response.getOutputStream();
				
				//반복문을 이용해서 파일 읽어서 전송
				byte[] b = new byte[4096]; //파일읽어서 저장할 배열
				int numRead=0;
				while((numRead = fis.read(b,0,b.length)) != -1) {
					
					out.write(b,0,numRead);
				}
				out.flush(); //내보내기
				out.close();
				fis.close();
				
				
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
