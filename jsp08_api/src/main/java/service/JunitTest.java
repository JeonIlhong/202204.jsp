package service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

class JunitTest {
	CovidXMLService covidService = new CovidXMLService();
	CultureService culservice = new CultureService();
	@Test
	void test() throws IOException, SAXException, ParserConfigurationException {
		
		covidService.covidParsing("20220410","20220413");
		
	}
	
	CountryJSONService countryservice = new CountryJSONService();
	@Test
	void countryTest() {
		 
		 
		 countryservice.countryParsing("GB");
		 
	}
	
	@Test
	void cultureTest() {
		
		Map<String,Object> map = new HashMap<>();
		map = culservice.CultureParsing("노원정보도서관");
		System.out.println(map);
		
		
		
	}
	
	@Test
	void geocodinTest() {
		
		
		 culservice.geocoding("서울 광진구 능동 18-11");
		
		
		
	}

}
