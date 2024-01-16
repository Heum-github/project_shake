package com.smhrd.shake.entity;

import lombok.Data;

@Data
public class CocktailTasteInfo {
	private int cock_taste_idx;
	private int cock_idx;
	private int sweet;
	private int bitter;
	private int salty;
	private int sour;
	private int spicy;
	private int puckery;
	private String user_id;
}
