package net.remind.Service;

import org.springframework.stereotype.Service;

@Service
public class Answer {

	public String make_Message(String content) {
		if(content.equals("안녕")){
			return "안녕하세욤";
		}
		
		return content;
	}

}
