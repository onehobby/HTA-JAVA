package com.simple.dto;

import java.util.Date;

public class BoardDto {
	
	private int boardNo;
	private String boardTitle;
	private int boardHit;
	private int boardReplyCnt;
	private String boardDelYN;
	private Date boardCreateDate;
	private String userId;
	private String boardContent;
	
	public BoardDto() {
		// TODO Auto-generated constructor stub
	}
	
	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	
	public int getBoardHit() {
		return boardHit;
	}

	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}

	public int getBoardReplyCnt() {
		return boardReplyCnt;
	}
	public void setBoardReplyCnt(int boardReplyCnt) {
		this.boardReplyCnt = boardReplyCnt;
	}
	public String getBoardDelYN() {
		return boardDelYN;
	}
	public void setBoardDelYN(String boardDelYN) {
		this.boardDelYN = boardDelYN;
	}
	public Date getBoardCreateDate() {
		return boardCreateDate;
	}
	public void setBoardCreateDate(Date boardCreateDate) {
		this.boardCreateDate = boardCreateDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
