package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.Covid;

public class CovidDAO {
	public int insert(List<Map<String,String>> covidList) {
		//반복문을 이용
		int cnt= 0;// 저장건수
		SqlSession session = MBConn.getSession(); //세션 맺기
		for(Map<String,String> covid:covidList) {
			
			try {
				
				cnt += session.insert("CovidMapper.insert",covid);
				
			} catch(Exception e) {
				System.out.println(covid.get("seq")+ ": 예외발생");
				
				//수정 
				cnt += session.update("covidMapper.update",covid);
				
				e.printStackTrace();
			}
				
		}
		
		session.commit(); //mybatisConfig의 transactionManager = > jdbc
		session.close();
	
		return cnt;
	}
	
	//코로나 확진 리스트
	public List<Covid> selectList(Map<String,String>map){
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("CovidMapper.selectList", map);
		}
	}
}
