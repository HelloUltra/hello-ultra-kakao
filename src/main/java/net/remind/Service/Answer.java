package net.remind.Service;

import org.springframework.stereotype.Service;

import net.remind.Model.Message;

@Service
public class Answer{
	private Boolean isButton = false;
	public String message;
	
	public Boolean getIsButton() {
		return isButton;
	}

	public String makeMessage(Message ms) {

		if(ms.getContent().equals("안녕")){
			message = "안녕하세욤";
			return message;
		}
		if(ms.getContent().contains("#회원가입")){
			isButton = true;	
			message ="본 서비스와 관련된 정보가 저장됩니다. 동의하십니까?"; 
			return message; 
		}
		
		return message;
	}

}
