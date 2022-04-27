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

import dao.CountryDAO;
import dto.Country;

import java.io.BufferedReader;
import java.io.IOException;

public class CountryJSONService {
	//데이터포털: 외교부_국가.지역별 최신안전소식(코로나관련)
	 private CountryDAO condao = new CountryDAO();
    public  int countryParsing(String iso)  {
    	//반환값
    	List<Map<String, String>> clist = new ArrayList<>();
    	
    	try {
    	String serviceKey = "qrqQHff3sWohx9ofqT5rVqSIAx02SrX%2Fw%2FdFKgUfz%2BNg0bHqDeNH%2FLzxX3uGXR4KtaNl4wtaeib%2FER8Sz3Hr5Q%3D%3D";
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1262000/CountryCovid19SafetyServiceNew/getCountrySafetyNewsListNew"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*XML 또는 JSON*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("20", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
//        urlBuilder.append("&" + URLEncoder.encode("cond[country_nm::EQ]","UTF-8") + "=" + URLEncoder.encode("가나", "UTF-8")); /*한글 국가명*/
        urlBuilder.append("&" + URLEncoder.encode("cond[country_iso_alp2::EQ]","UTF-8") + "=" + URLEncoder.encode(iso, "UTF-8")); /*ISO 2자리코드*/
        System.out.println(urlBuilder.toString());
       
        
        
        URL url = new URL(urlBuilder.toString());
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
        //파싱 라이브러리 : json-simple - 1.1.1 jar
        JSONParser parser = new JSONParser();
       JSONObject object = (JSONObject) parser.parse(sb.toString()); //문자열을 Json 객체로 변경
       JSONArray array = (JSONArray)object.get("data");
       System.out.println(array);
       System.out.println("-------------------");
       for(int i=0;i<array.size();i++) {
    	 Map<String,String> map = new HashMap<>(); 
    	 object = (JSONObject)array.get(i);
//    	 String country_nm = (String)object.get("country_nm");
//    	 String wrt_dt = (String)object.get("wrt_dt");
//    	 System.out.println(country_nm);
//    	 System.out.println(wrt_dt);
    	 
    	 // key의 목록가져와서 반복문
    	 // set특징: 중복데이터 안됨 
    	 Set<String> kset = object.keySet();
    	 for(String key :kset) {
    		
    		 map.put(key,(String)object.get(key));
    		 
    	 }
    	 
    	 
    	 clist.add(map);
    	 
       }
       
    } catch (Exception e) {
		e.printStackTrace();
	}
    //dao에 clist 넘기기
    	int cnt = condao.insert(clist);
    	System.out.println(cnt+"건 저장");
    	return cnt;
    }

	public List<Map<String, String>> selectlist_iso() {
		// iso 조회
		return condao.selectList_iso();
	}
	
	public List<Country> selectlist(String iso) {
		
		return condao.selectList(iso);
	}

	public Country selectOne(String	sfty_notice_id) {
		
		return condao.selectOne(sfty_notice_id);
	}
}
