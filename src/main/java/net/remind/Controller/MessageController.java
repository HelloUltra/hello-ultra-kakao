package net.remind.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.remind.Service.Answer;

@RestController
public class MessageController {
	
	private static final Logger log = LoggerFactory.getLogger(MessageController.class);

	@PostMapping("/message")
	public @ResponseBody Map<String, Object> message( @RequestBody Map<String,Object> getMessage) throws ParseException{
		
		log.debug("메세지 받았습니다!");
		Map <String, Object> sendMessage = new HashMap<String, Object>();
		Map <String, Object> sendObject = new HashMap<String, Object>();
		log.debug("getMessage : {}", getMessage);
		
		String user_key = getMessage.get("user_key").toString();
		String type = getMessage.get("type").toString();
		String content = getMessage.get("content").toString();
		log.debug("user_key : {}",user_key);
		log.debug("type : {}",type);
		log.debug("content : {}",content);

		Answer answer = new Answer();
		String makedMessage = answer.make_Message(content);
		sendMessage.put("text", makedMessage);
		log.debug("리턴할 메시지 : {}", sendMessage);
		sendObject.put("message",sendMessage.get("text"));
		return sendObject;
	}
}
