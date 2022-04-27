package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dto.Member;





public class JunitTest {

	@Test
	void testInsert() {
		
		Member member = new Member();
		member.setUserid("hong");
		member.setPasswd("2222");
		member.setSalt("salt");
		member.setZipcode("78954");
		member.setAddrload("저기거기어디");
		member.setAddrdetail("어디저기거기");
		member.setFilename("c.png");
		
		MemberDAO mdao = new MemberDAO();
		int cnt = mdao.insert(member);
		System.out.println(cnt + "건추가");
	}

	@Test
	void testUpdate() {
		Member member = new Member();
		
		member.setPasswd("3333");
		member.setSalt("salt");
		member.setZipcode("15765");
		member.setAddrload("거기어딘가");
		member.setAddrdetail("여기저기");
		member.setFilename("d.png");
		member.setUserid("hong");
		
		MemberDAO mdao = new MemberDAO();
		int cnt = mdao.update(member);
		System.out.println(cnt+"건 수정");
	}

	@Test
	void testDelete() {
		Member member = new Member();
		MemberDAO mdao = new MemberDAO();
		int cnt= mdao.delete("lee");
		System.out.println(cnt+"건 삭제");
		
		
	}

	@Test
	void testSelectOne() {
		
	}

	@Test
	void testSelectList() {
		
	}

}
