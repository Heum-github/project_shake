package com.smhrd.shake.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smhrd.shake.entity.CocktailInfo;
import com.smhrd.shake.entity.CocktailTasteInfo;
import com.smhrd.shake.entity.UserInfo;
import com.smhrd.shake.service.CocktailService;

@Controller
public class CocktailController {
	
	@Autowired
	CocktailService service;
	
	@GetMapping("/cocktailInfo") // 칵테일 정보 페이지 산출
	public String cocktailList(HttpSession session, Model model){
		UserInfo member = (UserInfo) session.getAttribute("loginMember");
		if (member != null) {
			List<CocktailInfo> list = service.cocktailList();
			model.addAttribute("list", list);
		}
		return "cocktailInfo";
	}
	
	@GetMapping("/cockTasteAccess") // 칵테일 맛평가 정보 산출
	public String cockTasteAccess(CocktailTasteInfo cock) {
		service.cockTasteAccess(cock);
		return "redirect:/cocktailInfo";
	}
}
