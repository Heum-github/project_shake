package com.smhrd.shake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.shake.entity.CommunityComment;
import com.smhrd.shake.entity.CommunityInfo;
import com.smhrd.shake.mapper.CommunityMapper;

@Service
public class CommunityService {
	@Autowired
	CommunityMapper mapper;
	
	public List<CommunityInfo> commuinityList(){
		return mapper.commuinityList();
	}
	
	public List<CommunityInfo> communitySearch(String communitySearch){
		return mapper.communitySearch(communitySearch);
	}

	public void communityWrite(CommunityInfo comm) {
		mapper.communityWrite(comm);
	}
	
	public CommunityInfo communityContent(int comm_idx) {
		return mapper.communityContent(comm_idx);
	}
	
	public int count(int comm_idx) {
		return mapper.count(comm_idx);
	}
	
	public int communityDelete(int comm_idx) {
		return mapper.communityDelete(comm_idx);
	}
	
	public int commCmt(CommunityComment cmt) {
		return mapper.commCmt(cmt);
	}
	
	public List<CommunityComment> commCmtList(int comm_idx){
		return mapper.commCmtList(comm_idx);
	}
}
