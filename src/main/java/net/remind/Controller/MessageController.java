package net.remind.Controller;

import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.remind.Service.Answer;

@RestController
public class MessageController {
	
	@PostMapping("/message")
	public @ResponseBody String message(JSONObject getMessage) throws ParseException{
		getMessage = new JSONObject();
		JSONObject sendMessage = new JSONObject();
		String user_key = getMessage.get("user_key").toString();
		String type = getMessage.get("type").toString();
		String content = getMessage.get("content").toString();
		System.out.println("user_key : "+user_key);
		System.out.println("type : "+type);
		System.out.println("content : "+content);
		
		Answer answer = new Answer();
		String makedMessage = answer.make_Message(content);
		
		JSONParser parser = new JSONParser();
		sendMessage = (JSONObject) parser.parse(makedMessage);
		System.out.println("리턴할 메시지 : "+sendMessage);
		return sendMessage.toJSONString();
	}
}
