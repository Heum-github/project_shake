package com.smhrd.shake.entity;

import lombok.Data;

@Data
public class RecipeTasteInfo {
	private int rcp_taste_idx;
	private int rcp_idx;
	private int sweet;
	private int bitter;
	private int salty;
	private int sour;
	private int spicy;
	private int puckery;
	private String user_id;
}
