package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class JunitTest {

	@Test
	void test() {
		CovidDAO codao = new CovidDAO();
		
		Map cmap = new HashMap<>();
		cmap.put("startDt","20220410");
		cmap.put("endDt", "20220413");
		codao.selectList(cmap);
	}

}
