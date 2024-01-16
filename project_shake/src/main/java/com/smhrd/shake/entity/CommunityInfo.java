package com.smhrd.shake.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// id는 어노테이션으로 따로 잡을 것. 따른 것은 맘대로.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommunityInfo {
	private int comm_idx;
	private String user_id;
	private String comm_title;
	private String comm_content;
	private String comm_image;
	private Date created_at;
	private int comm_views;
	private String user_nick;
}
