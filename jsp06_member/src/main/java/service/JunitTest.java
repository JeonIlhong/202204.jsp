package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitTest {
		private MemberService memberService = new MemberService();
		String salt = memberService.saltmake();
	@Test
	void test() {
		memberService.sha256("1111",salt);
	}
	
	@Test
	void testSalt() {
		String salt = memberService.saltmake();
		System.out.println(salt);
		System.out.println(salt.length());
		
	}

}
