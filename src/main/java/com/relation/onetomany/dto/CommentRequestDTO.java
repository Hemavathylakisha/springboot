package com.relation.onetomany.dto;

public class CommentRequestDTO {
    private String text;
    private String userName;
    
	public CommentRequestDTO(String text, String userName) {
		super();
		this.text = text;
		this.userName = userName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
    
}
