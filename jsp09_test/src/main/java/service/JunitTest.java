package service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

class JunitTest {
	AirconditionService as = new AirconditionService();
	@Test
	void acTest() throws IOException, ParseException  {
		
		as.airconditionParsing("전북");
	}

}
