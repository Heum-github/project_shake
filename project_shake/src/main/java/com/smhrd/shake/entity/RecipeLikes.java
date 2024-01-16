package com.smhrd.shake.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecipeLikes {
	private int rcp_idx;
	private String user_id;
	private String rcp_likes;
	
}
