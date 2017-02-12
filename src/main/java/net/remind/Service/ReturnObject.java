package net.remind.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.remind.Model.Message;

@Service
public class ReturnObject {
	public ArrayList<String> btList = new ArrayList<String>();
	public ArrayList<Map<String, Object>> keyBoardList = new ArrayList<Map<String, Object>>();
	public ArrayList<Map<String, Object>> messageList = new ArrayList<Map<String, Object>>();
	public ArrayList<ArrayList<Map<String, Object>>> objectList = new ArrayList<ArrayList<Map<String, Object>>>();
	
	public Map <String, Object> msMap = new HashMap<String, Object>();	
	public Map <String, Object> keyboardMap = new HashMap<String, Object>();
	
	public Map <String, Object> sendObject = new HashMap<String, Object>();
	
	public Object buttonObject(String makedMessage, Message ms){
		
		//텍스트에 담아낼 메시지

		if(ms.getContent().equals("#회원가입")){
			btList.add("확인");
			btList.add("취소");
		}
		keyboardMap.put("type","buttons");
		keyboardMap.put("buttons",btList);
		
		keyBoardList.add(keyboardMap);
		
		msMap.put("text",makedMessage);
		messageList.add(msMap);
		
		objectList.add(messageList);
		objectList.add(keyBoardList);
		
		return objectList;
	}
	
	public Map <String, Object> textObject(String makedMessage, Message ms){
		msMap.put("text", makedMessage);
		sendObject.put("message", msMap);
		return sendObject;
	}
	
	
}
