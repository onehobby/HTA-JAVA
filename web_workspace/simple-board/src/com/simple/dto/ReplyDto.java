package com.simple.dto;

import java.util.Date;

public class ReplyDto {
	
	private int replyNo;
	private String replyContent;
	private String replyDelYN;
	private Date replyCreateDate;
	private String UserId;
	
	public ReplyDto() {
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyDelYN() {
		return replyDelYN;
	}

	public void setReplyDelYN(String replyDelYN) {
		this.replyDelYN = replyDelYN;
	}

	public Date getReplyCreateDate() {
		return replyCreateDate;
	}

	public void setReplyCreateDate(Date replyCreateDate) {
		this.replyCreateDate = replyCreateDate;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}
	
}
