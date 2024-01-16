package com.smhrd.shake.entity;

import java.util.Date;

import lombok.Data;

@Data
public class RecipeComment {
	private int cmt_idx;
	private int rcp_idx;
	private String cmt_content;
	private Date created_at;
	private String user_nick;
}
