package net.remind.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/keyboard")
	public @ResponseBody Map<String, Object> keyboard(){
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		
		jsonObject = new HashMap<String, Object>();
		jsonObject.put("type","text");
		return jsonObject;
	}
}
