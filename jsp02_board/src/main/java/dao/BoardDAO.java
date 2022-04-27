package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.Board;


public class BoardDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private String sql;
	
	//추가
	public int insert(Board board) {
		int cnt=0;
		con = DBConn.getConnection();
		sql="insert into board (seq,writer,subject,content)\r\n"
				+ "values (b_seq.nextVal,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,board.getWriter());
			pstmt.setString(2,board.getSubject());
			pstmt.setString(3,board.getContent());
			
			cnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cnt;
	}
	//수정
   public int update(Board board) {
		int cnt =0;
		con = DBConn.getConnection();
		sql= "update board\r\n"
				+ "set writer = ?,\r\n"
				+ "subject = ?,\r\n"
				+ "content = ?,\r\n"
				+ "modidate = sysdate\r\n"
				+ "where seq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContent());
			
			pstmt.setInt(4, board.getSeq());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}
	//삭제
	
   public int delete(int seq) {
		int cnt = 0;
		con = DBConn.getConnection();
		sql = "delete from board\r\n"
				+ "where seq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	
	//리스트
   public List<Board> selectList(String findkey,String findvalue){
		List<Board> blist = new ArrayList<>();
		con = DBConn.getConnection();
		sql = "select * from board\r\n"
				+ "where"+findkey+"like '%' || ? || '%'\r\n"
				+ "order by"+findkey+", seq desc";
						
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, findvalue);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Board board = new Board();
				board.setSeq(rs.getInt("seq"));
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setRegidate(rs.getTimestamp("regidate"));
				board.setModidate(rs.getTimestamp("modidate"));
				blist.add(board);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return blist;
		
	}
	
	//한건조회
   public Board selectOne(int seq) {
		Board board = null;
		con = DBConn.getConnection();
		String sql = "select * from board\r\n"
				+ "WHERE seq = ?";
		
		try {
		 pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, seq);
		 ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new Board();
				board.setSeq(rs.getInt("seq"));
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setRegidate(rs.getTimestamp("regidate"));
				board.setModidate(rs.getDate("modidate"));
			}
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}
	

}
