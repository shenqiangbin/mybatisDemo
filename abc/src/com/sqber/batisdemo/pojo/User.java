package com.sqber.batisdemo.pojo;

public class User {
	private int userId;
	private String userCode;
	private String userName;
	private int status;
	
	@Override
	public String toString() {
		return "userId:"+userId
			+" userCode:"+userCode
			+" userName:"+userName
			+" status:"+status;
	}	
	
	public int getId() {
		return this.userId;
	}
	
	public void setId(int userId) {
		this.userId = userId;
	}
	
	public void setUserCode(String userCode){
		this.userCode = userCode;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
