package net.remind.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.remind.Model.Message;

@Service
public class ReturnObject {
	public ArrayList<String> btList = new ArrayList<String>();

	public Map <String, Object> msMap = new HashMap<String, Object>();
	public Map <String, Object> upperMsMap = new HashMap<String, Object>();
	public Map <String, Object> keyboardMap = new HashMap<String, Object>();
	public Map <String, Object> upperKeyboardMap = new HashMap<String, Object>();
	public Map <String, Object> sendObject = new HashMap<String, Object>();
	
	public Map<String,Object> buttonObject(String makedMessage, Message ms){
		
	

		if(ms.getContent().equals("#회원가입")){
			btList.add("확인");
			btList.add("취소");
		}
		//키보드
		//맵안에 keybord : 다시 맵안에 type:buttons, buttons: btList
		keyboardMap.put("type","buttons");
		keyboardMap.put("buttons",btList);	
		
		//메시지
		//맵안에  message : 다시 맵안에 text:content
		msMap.put("text",makedMessage);
		
		sendObject.put("message", msMap);
		sendObject.put("keyboard", keyboardMap);
		
		return sendObject;
	}
	
	public Map <String, Object> textObject(String makedMessage, Message ms){
		msMap.put("text", makedMessage);
		sendObject.put("message", msMap);
		return sendObject;
	}
	
	
}
