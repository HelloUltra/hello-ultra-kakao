package net.remind.Controller;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.remind.Service.Answer;

@RestController
public class MessageController {
	@PostMapping("/message")
	public @ResponseBody Map<String, Object> message(@RequestParam Map<String,Object> getMessage) throws ParseException{
		System.out.println("메세지 받았습니다!");
		Map <String, Object> sendMessage = new HashMap<String, Object>();
		Map <String, Object> sendObject = new HashMap<String, Object>();
		String user_key = getMessage.get("user_key").toString();
		String type = getMessage.get("type").toString();
		String content = getMessage.get("content").toString();
		System.out.println("user_key : "+user_key);
		System.out.println("type : "+type);
		System.out.println("content : "+content);
		
		Answer answer = new Answer();
		String makedMessage = answer.make_Message(content);
		sendMessage.put("text", makedMessage);
		System.out.println("리턴할 메시지 : "+sendMessage);
		sendObject.put("message",sendMessage.get("text"));
		return sendObject;
	}
}
