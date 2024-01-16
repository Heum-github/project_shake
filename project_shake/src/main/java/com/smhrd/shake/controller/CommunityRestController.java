package com.smhrd.shake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.shake.entity.CommunityComment;
import com.smhrd.shake.service.CommunityService;

@RestController
public class CommunityRestController {
    
    @Autowired
    CommunityService service;

    @GetMapping("/commCount") // 커뮤니티 조회수 기능
    public String count(@RequestParam("comm_idx") int comm_idx) {
        System.out.println(comm_idx);
        int cnt = service.count(comm_idx);
        System.out.println(cnt);
        return String.valueOf(cnt);
    }
    
	@GetMapping("/commCmtList") // 커뮤니티 게시글 댓글 내역 산출 기능
	public List<CommunityComment> commCmtList(@RequestParam("comm_idx") int comm_idx){
		List<CommunityComment> list = service.commCmtList(comm_idx);
		return list;
	}
}