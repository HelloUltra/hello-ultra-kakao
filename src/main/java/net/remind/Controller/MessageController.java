package net.remind.Controller;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.remind.Model.Message;
import net.remind.Service.Answer;

@RestController
public class MessageController {
	
	private static final Logger log = LoggerFactory.getLogger(MessageController.class);
	

	@PostMapping("/message")
	public Map<String, Object> message( @RequestBody Message message) throws ParseException{
	
		System.out.println("메세지받음");
	
		Map <String, Object> sendMessage = new HashMap<String, Object>();
		Map <String, Object> sendObject = new HashMap<String, Object>();
		//log.debug("getMessage : {}", getMessage);
		
		//String user_key = getMessage.get("user_key").toString();
		String user_key = message.getUser_key();
		
		//String type = getMessage.get("type").toString();
		String type = message.getType();
		//String content = getMessage.get("content").toString();
		String content = message.getContent();
		log.debug("user_key : {}",user_key);
		log.debug("type : {}",type);		
		log.debug("content : {}",content);
	
		Answer answer = new Answer();
		String makedMessage = answer.make_Message(content);
		sendMessage.put("text", makedMessage);
		log.debug("리턴할 메시지 : {}", sendMessage);
		
		sendObject.put("message",sendMessage);
		return sendObject;
	}
}
