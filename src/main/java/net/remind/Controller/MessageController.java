package net.remind.Controller;


import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.remind.Model.Message;
import net.remind.Service.Answer;
import net.remind.Service.ReturnObject;

@RestController
public class MessageController {
	
	private static final Logger log = LoggerFactory.getLogger(MessageController.class);

	

	@PostMapping("/message")
	public Object message( @RequestBody Message message) throws ParseException{
	
		System.out.println("메세지받음");
	
		
		String user_key = message.getUser_key();
		String type = message.getType();
		String content = message.getContent();
		
		log.debug("user_key : {}",user_key);
		log.debug("type : {}",type);		
		log.debug("content : {}",content);
	
		Answer answer = new Answer();
		String makedMessage = answer.makeMessage(message);
		
		ReturnObject returnObject = new ReturnObject();
		
		if(answer.getIsButton()){
			return returnObject.buttonObject(makedMessage, message);
		}
		
		return returnObject.textObject(makedMessage, message);
	}
}
