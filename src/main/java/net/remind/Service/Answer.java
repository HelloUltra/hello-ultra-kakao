package net.remind.Service;


public class Answer {

	public String make_Message(String content) {
		if(content.equals("안녕")){
			return "안녕하세욤";
		}
		if(content.equals("나어떤것같아")||content.equals("해리")){
			return "여신";
		}
		if(content.contains("솔비텍")){
			return "퇴사";
		}
		if(content.equals("주먹")){
			return "양기종,정현우,곽대용,박창우,형성관,박용옥";
		}
		if(content.contains("퇴사목록")){
			return "곽대용,이은희,김준혁,나성훈,조윤식,설재희";
		}
		return content;
	}

}
