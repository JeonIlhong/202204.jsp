package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;



public class examDAO {

	public int insert(List<Map<String, String>> alist) {
		int cnt=0;
		try (SqlSession session = MBConn.getSession()) {
			for(Map<String, String> map:alist) {
				try {
					cnt  += session.insert("AirMapper.insert",map);
				} catch (Exception e) {
					System.out.println(map.get("sn")+ ":에러");
				}
					
					
				
				
			
			}
			session.commit();
		} // close
		return cnt;
	}

	public List<Map<String, String>> selectList(String districtName) {
		try(SqlSession session = MBConn.getSession()) {
			return session.selectList("AirMapper.selectList",districtName);
		}
		
	}
	

	
}
