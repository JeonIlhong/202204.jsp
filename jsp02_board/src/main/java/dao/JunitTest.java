package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dto.Board;

class JunitTest {

	@Test
	void testInsert() {
		Board board = new Board();
		board.setWriter("홍길동");
		board.setSubject("나는바보다");
		board.setContent("야너두?");
		
		BoardDAO bdao = new BoardDAO();
		int cnt = bdao.insert(board);
		System.out.println(cnt+"건 추가");
	}

	@Test
	void testUpdate() {
		Board board = new Board();
		board.setWriter("이순신");
		board.setSubject("너도바보다");
		board.setContent("그게맞다");
		board.setSeq(2);
		
		BoardDAO bdao = new BoardDAO();
		int cnt = bdao.update(board);
		System.out.println(cnt+"건 수정");
		
	}

	@Test
	void testDelete() {
		Board board = new Board();
		
		
		BoardDAO bdao = new BoardDAO();
		int cnt = bdao.delete(1);
		System.out.println(cnt+"건 삭제");
	}

	@Test
	void testSelectList() {
		
//		BoardDAO bdao = new BoardDAO();
//		List<Board> blist = bdao.selectList();
//		System.out.println(blist);
	}

	@Test
	void testSelectOne() {
		BoardDAO bdao = new BoardDAO();
		Board board = new Board();
		
		bdao.selectOne(1);
		System.out.println(board);
	}

}
