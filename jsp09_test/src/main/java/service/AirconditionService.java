package service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import dao.examDAO;


import java.io.BufferedReader;
import java.io.IOException;

public class AirconditionService {
	
	examDAO adao = new examDAO();
    public  int airconditionParsing(String year)  {
        
    	//반환값
    	List<Map<String, String>> alist = new ArrayList<>();
    	
    	
    	try {
    	String serviceKey = "uMngqDWghlCUM7FKSQhTMPHD6Pw05QrJz2IoKje4tLozlhVZNfN1V6d78mbWCXI8Pixkrmhtd8vWQiMEwntxEA%3D%3D";
    	StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo"); /*URL*/ /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8")+ "="+ serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*xml 또는 json*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("year","UTF-8") + "=" + URLEncoder.encode(year, "UTF-8")); /*측정 연도*/
        urlBuilder.append("&" + URLEncoder.encode("itemCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*미세먼지 항목 구분(PM10, PM25), PM10/PM25 모두 조회할 경우 파라미터 생략*/
        
        URL url = new URL(urlBuilder.toString());
        System.out.println(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        //JSON 파싱 
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(sb.toString());
        
        //양파껍질
        JSONObject response = (JSONObject) object.get("response");
        JSONObject body = (JSONObject) response.get("body");
        JSONArray array = (JSONArray) body.get("items");
      
        
        for(int i=0;i<array.size();i++) {
        	object= (JSONObject) array.get(i);
        	System.out.println("------------------------------------------");
        	object.keySet();
        	
        	Set<String> kset = object.keySet();
        	//맵만들기
        	Map<String,String> map = new HashMap<>();
        	for(String key:kset) {
        		//키와 값
        		System.out.println(key+ ":" + object.get(key));
        		map.put(key,(String)object.get(key));
        	}
        	
        	alist.add(map); //리스트에 맵넣기
        	
        }
   
        
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        	
    	
    	
    	//db에 저장
    	int cnt = adao.insert(alist);
		return cnt;
    	
    }
    
    
    public List<Map<String, String>> selectList(String districtName) {
    		return adao.selectList(districtName);
    	}

}








