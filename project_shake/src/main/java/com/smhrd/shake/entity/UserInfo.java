package com.smhrd.shake.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
public class UserInfo {
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_nick;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date user_birthdate;
	private Date user_joindate;	
	private String social_id;	
}
