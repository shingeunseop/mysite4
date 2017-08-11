package com.mysite.vo;

public class ReplyBoardVo {

	private int no;
	private String title;
	private String content;
	private int hit;
	private String regDate;
	private int userNo;
	private int groupNo;
	private int orderNo;
	private int depthNo;
	private String userName;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getDepthNo() {
		return depthNo;
	}

	public void setDepthNo(int depthNo) {
		this.depthNo = depthNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ReplyBoardVo() {

	}

	public ReplyBoardVo(int no, String title, String content, int hit, String regDate, int userNo, int groupNo,
			int orderNo, int depthNo, String userName) {

		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.regDate = regDate;
		this.userNo = userNo;
		this.groupNo = groupNo;
		this.orderNo = orderNo;
		this.depthNo = depthNo;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "ReplyBoardVo [no=" + no + ", title=" + title + ", content=" + content + ", hit=" + hit + ", regDate="
				+ regDate + ", userNo=" + userNo + ", groupNo=" + groupNo + ", orderNo=" + orderNo + ", depthNo="
				+ depthNo + ", userName=" + userName + "]";
	}
	
	

}
