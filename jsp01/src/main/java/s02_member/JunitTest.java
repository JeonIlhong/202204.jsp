package s02_member;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class JunitTest {

	@Test
	void testDBConn() {
		//db커넥션
		Connection con = DBConn.getConnection();
		System.out.println(con);
		assertNotNull(con);
		
	}
	
	@Test
	void testInsert() {
		Member member = new Member();
		member.setUserid("oracle");
		member.setPasswd("1234");
		member.setName("오라클");
		member.setEmail("oracle@gamil.com");
		System.out.println(member);
		
		
		
		MemberDAO mdao = new MemberDAO();
		int cnt = mdao.insert(member);
		System.out.println(cnt+"건 추가");
	}

}
