package com.poha.test1.board.vo;

import lombok.Getter;

@Getter
public class testVO {
	private int testId;
	private String content;
	
	public int gettestId() {
		return testId;
	}
	public void setId(int testId) {
		this.testId = testId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}