package com.smhrd.shake.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.shake.entity.CommunityComment;
import com.smhrd.shake.entity.CommunityInfo;

@Mapper
public interface CommunityMapper {
	public List<CommunityInfo> commuinityList();
	public List<CommunityInfo> communitySearch(String communitySearch);
	public void communityWrite(CommunityInfo comm);
	public CommunityInfo communityContent(int comm_idx);
	public int communityDelete(int comm_idx);
	public int commCmt(CommunityComment cmt);
	public List<CommunityComment> commCmtList(int comm_idx);

	public int count(int comm_idx);
}
