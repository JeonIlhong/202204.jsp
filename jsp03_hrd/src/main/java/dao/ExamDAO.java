package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.Emember;
import dto.Emoney;

public class ExamDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private String sql;
	
	//member 등록
	
	public int Insert(Emember emember) {
		
		int cnt=0;
		con = DBConn.getConnection();
		sql="insert into member_tbl_02 (custno,custname,phone,address,joindate,grade,city)\r\n"
				+ "values ((select nvl(max(custno)+1,1)from member_tbl_02),\r\n"
				+ "?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emember.getCustname());
			pstmt.setString(2, emember.getPhone());
			pstmt.setString(3, emember.getAddress());
			pstmt.setString(4, emember.getJoindate());
			pstmt.setString(5, emember.getGrade());
			pstmt.setString(6, emember.getCity());
			
			cnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	//수정
	
	public int update(Emember emember) {
		int cnt=0;
		con = DBConn.getConnection();
		sql="update member_tbl_02\r\n"
				+ "set CUSTNAME = ?,\r\n"
				+ "phone =?,\r\n"
				+ "address = ?,\r\n"
				+ "joindate = ?,\r\n"
				+ "grade = ?,\r\n"
				+ "city = ?\r\n"
				+ "where CUSTNO = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emember.getCustname());
			pstmt.setString(2, emember.getPhone());
			pstmt.setString(3, emember.getAddress());
			pstmt.setString(4, emember.getJoindate());
			pstmt.setString(5, emember.getGrade());
			pstmt.setString(6, emember.getCity());
			pstmt.setInt(7, emember.getCustno());
			
			cnt= pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cnt;
	}
	
	//삭제
	
	
	//한건 조회
	
	public Emember selectOne(int custno) {
		Emember emember = null;
		con = DBConn.getConnection();
		sql="select custno, custname, phone, address, grade, city,\r\n"
				+ "        to_char(joindate,'YYYY-MM-DD') joindate\r\n"
				+ "from member_tbl_02\r\n"
				+ "where custno = ?";;
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, custno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				String custname = rs.getString("custname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String joindate = rs.getString("joindate");
				String grade = rs.getString("grade");
				String city = rs.getString("city");
				emember = new Emember(custno, custname, phone, address, joindate, grade, city);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emember;
	}
	
	// 회원리스트 조회
	public List<Emember> selectList(){
		List<Emember> mlist = new ArrayList<>();
		con = DBConn.getConnection();
		sql="select custno,custname,phone,address,to_char(joindate,'YYYY-MM-DD')joindate,\r\n"
				+ "decode(grade,'A','VIP','B','일반','C','직원') grade, city\r\n"
				+ "from member_tbl_02\r\n"
				+ "order by custno";
		
		try {
			pstmt =con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int custno = rs.getInt("custno");
				String custname = rs.getString("custname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String joindate = rs.getString("joindate");
				String grade = rs.getString("grade");
				String city = rs.getString("city");
				
				Emember emember = new Emember(custno, custname, phone, address, joindate, grade, city);
				mlist.add(emember);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mlist;
	}
	
	//매출 조회
	
	public List<Map<String, Object>> salesList() {
		List<Map<String, Object>> mlist = new ArrayList<>();
		con = DBConn.getConnection();
		sql="select mn.custno, mb.custname, \r\n"
				+ "    decode(mb.grade,'A','VIP','B', '일반', 'C', '직원') grade,\r\n"
				+ "    sum(mn.price) price\r\n"
				+ "from money_tbl_02 mn join member_tbl_02 mb on(mn.custno = mb.custno)\r\n"
				+ "group by mn.custno, mb.custname, mb.grade\r\n"
				+ "order by price desc";
		
		try {
			pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int custno=rs.getInt("custno");
				String custname =rs.getString("custname");
				String grade = rs.getString("grade");
				int price = rs.getInt("price");
				// map 생성
				Map<String,Object> map = new HashMap<>();
				map.put("custname", custname);
				map.put("custno", custno);
				map.put("grade", grade);
				map.put("price", price);
				mlist.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mlist;
	}
	
	
	
	
	
	
	
}
