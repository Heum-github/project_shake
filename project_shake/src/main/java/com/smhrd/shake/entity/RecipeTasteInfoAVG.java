package com.smhrd.shake.entity;

import lombok.Data;

@Data
public class RecipeTasteInfoAVG {
	private int rcp_taste_idx;
	private int rcp_idx;
	private double sweet;
	private double bitter;
	private double salty;
	private double sour;
	private double spicy;
	private double puckery;
	private String user_id;
}
