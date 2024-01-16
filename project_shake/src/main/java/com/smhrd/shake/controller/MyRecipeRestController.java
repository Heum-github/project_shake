package com.smhrd.shake.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.shake.entity.RecipeComment;
import com.smhrd.shake.entity.RecipeLikes;
import com.smhrd.shake.entity.RecipeTasteInfoAVG;
import com.smhrd.shake.service.MyRecipeService;

@RestController
public class MyRecipeRestController {
	
	@Autowired
	MyRecipeService service;
	
	 @GetMapping("/rcpCount")  // 마이 레시피 조회수 기능
	    public String count(@RequestParam("rcp_idx") int rcp_idx) {
	        System.out.println(rcp_idx);
	        int cnt = service.count(rcp_idx);
	        System.out.println(cnt);
	        return String.valueOf(cnt);
	    }
	
	@GetMapping("/checkLike") // 마이 레시피 좋아요 기능 
	public Integer checkLike(@ModelAttribute RecipeLikes like) throws Exception {
		System.out.println(like);
		Integer cnt = service.checkLike(like);
		System.out.println(cnt);
		if (cnt == null) {
			cnt = 0;
		} else {
			cnt = 1;
		}
		System.out.println(cnt);
		return cnt;
	}
	
	@GetMapping("/recipeChart") // 마이 레시피 맛평가 차트 산출 기능
	public List<RecipeTasteInfoAVG> recipeChart(@RequestParam("rcp_idx") int rcp_idx){
		List<RecipeTasteInfoAVG> list = service.recipeChart(rcp_idx);
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/recipeCmtList") // 마이 레시피 댓글 리스트 산출 기능.
	public List<RecipeComment> recipeCmtList(@RequestParam("rcp_idx") int rcp_idx){
		List<RecipeComment> list = service.recipeCmtList(rcp_idx);
		return list;
	}
	
}
