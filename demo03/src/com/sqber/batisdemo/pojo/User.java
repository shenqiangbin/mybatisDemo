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
}
