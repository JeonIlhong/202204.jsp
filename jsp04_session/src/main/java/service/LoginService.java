package service;

import java.util.HashMap;
import java.util.Map;

import dao.MemberDAO;
import dto.Member;

//컨트롤러와 dao를 연결
//비즈니스 로직 처리

	
	public class LoginService {
		//dao호출
		private MemberDAO mdao  = new MemberDAO();
		
		public Map<String,Object>  logincheck(String userid,String passwd) {
			
			//리턴값: 한개만 리턴(map 생성)
			//code: 0(성공) , 1(회원 미존재) , 2(비밀번호 불일치)
			//msg: 성공,회원미존재,비밀번호 불일치
			Map<String,Object> rmap = new HashMap<>();
			int code;
			String msg;
			
			
			
	    
		
		//userid를 기준으로 한건조회(selectOne)
		Member member = mdao.selectOne(userid);
		
		//만약에 리턴값이 null이면 회원이 존재하지않는다
	    if(member==null) {
	    	
	    	code= 1;
	    	msg="회원이 존재하지 않습니다";
	    	
	    }else if(!member.getPasswd().equals(passwd)) {
	    	code = 2;
	    	msg="비밀번호 불일치";
	    }else {
	    	code=0;
	    	msg="로그인성공";
	    }
		
	    rmap.put("code", code);
	    rmap.put("msg",msg);
	    	
	    	
	    	return rmap ;
	}

}
	
	
