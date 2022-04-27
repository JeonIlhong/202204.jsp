package s02_member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	// static : 정적 메소드
	static Connection getConnection() {
		Connection con = null;
		
		//url,user,password
		String url= "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		
		
		
		
		
		
		// 오라클드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩완료");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("커넥션 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("접속실패");
			e.printStackTrace();
		}
		return con;
	}
}
