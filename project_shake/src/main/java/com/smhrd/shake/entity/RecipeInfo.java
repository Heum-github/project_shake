package com.smhrd.shake.entity;

import java.util.Date;

import lombok.Data;

@Data
public class RecipeInfo {
	private int rcp_idx;
	private String user_id;
	private String rcp_name;
	private String rcp_ingredient;
	private String rcp_image;
	private String rcp_desc;
	private Date created_at;
	private int rcp_views;
	private int likes_count;	
	private String user_nick;
}
