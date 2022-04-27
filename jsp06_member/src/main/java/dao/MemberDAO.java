package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import dto.Member;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private String sql;
	
	//추가
	public int insert(Member member) {
		int cnt=0;	
		con = DBConn.getConnection();
		sql="insert into member(userid,passwd,salt,zipcode,addrload,addrdetail,filename )\r\n"
				+ "values (?,?,?,?,?,?,\r\n"
				+ "?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getSalt());
			pstmt.setString(4, member.getZipcode());
			pstmt.setString(5, member.getAddrload());
			pstmt.setString(6, member.getAddrdetail());
			pstmt.setString(7, member.getFilename());
			
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return cnt;
	}
	
	
	// 수정 
	
	public int update(Member member) {
		int cnt=0;
		con = DBConn.getConnection();
		
		sql="update member \r\n"
				+ "set passwd = ?,\r\n"
				+ "salt = ?,\r\n"
				+ "zipcode=?,\r\n"
				+ "addrload=?,\r\n"
				+ "addrdetail=?,\r\n"
				+ "filename =?\r\n"
				+ "where userid=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getSalt());
			pstmt.setString(3, member.getZipcode());
			pstmt.setString(4, member.getAddrload());
			pstmt.setString(5, member.getAddrdetail());
			pstmt.setString(6, member.getFilename());
			pstmt.setString(7, member.getUserid());
			
			cnt= pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cnt;
	}
	//삭제
		public int delete(String userid) {
			int cnt = 0;
			con = DBConn.getConnection();
			
			try {
				sql = "DELETE FROM member\r\n"
						+ "WHERE userid = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userid);
				cnt = pstmt.executeUpdate(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return cnt;
		}	
	
	//한건조회
	public Member selectOne(String userid) {
		Member member = null;
		con = DBConn.getConnection();
		
		sql="select*FROM member\r\n"
				+ "where userid = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				member = new Member();
				member.setUserid(rs.getString("userid"));
				member.setPasswd(rs.getString("passwd"));
				member.setSalt(rs.getString("salt"));
				member.setZipcode(rs.getString("zipcode"));
				member.setAddrload(rs.getString("addrload"));
				member.setAddrdetail(rs.getString("addrdetail"));
				member.setFilename(rs.getString("filename"));
				member.setRegidate(rs.getTimestamp("regidate")); //날짜 시분초까지 가져오기
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	
	}
	
	//리스트
	
	public List<Member> selectList(Map<String,String>findmap){
		List<Member> mlist = new ArrayList<>();
		con = DBConn.getConnection();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM member\r\n");
		//오라클의 데이터가 null이면 조회되지 않는다
		if (!findmap.get("findvalue").equals(""))
			sb.append("WHERE " + findmap.get("findkey") + " like '%' || ? ||'%'\r\n");

		sb.append( "ORDER BY " + findmap.get("findkey"));
		try {
			pstmt = con.prepareStatement(sb.toString());
			if(!findmap.get("findvalue").equals(""))	
			pstmt.setString(1, findmap.get("findvalue"));
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Member member = new Member();
				member.setUserid(rs.getString("userid"));
				member.setPasswd(rs.getString("passwd"));
				member.setSalt(rs.getString("salt"));
				member.setZipcode(rs.getString("zipcode"));
				member.setAddrload(rs.getString("addrload"));
				member.setAddrdetail(rs.getString("addrdetail"));
				member.setFilename(rs.getString("filename"));
				member.setRegidate(rs.getTimestamp("regidate"));
				
				mlist.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mlist;
	}
}
