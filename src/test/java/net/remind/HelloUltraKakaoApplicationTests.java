package net.remind;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloUltraKakaoApplicationTests {
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void contextLoads() {
		Map test = testRestTemplate.getForObject("/message", HashMap.class);
		
	}

}
