package com.smhrd.shake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.shake.entity.CockIngredient;
import com.smhrd.shake.entity.CocktailInfo;
import com.smhrd.shake.service.MainService;

@RestController
public class MainRestController {

	@Autowired
	MainService service;
	
	@GetMapping("/cockSelect")  // 재료에 따른 칵테일 산출
	public List<CocktailInfo> cockSelect(String[] cockIngArr, CockIngredient cockIng) {
		 if (cockIngArr.length >= 1) {cockIng.setIngredient1(cockIngArr[0]);};	
		 if (cockIngArr.length >= 2) {cockIng.setIngredient2(cockIngArr[1]);};	
		 if (cockIngArr.length >= 3) {cockIng.setIngredient3(cockIngArr[2]);};	
		 if (cockIngArr.length >= 4) {cockIng.setIngredient4(cockIngArr[3]);};	
		 if (cockIngArr.length >= 5) {cockIng.setIngredient5(cockIngArr[4]);};	
		 if (cockIngArr.length >= 6) {cockIng.setIngredient6(cockIngArr[5]);};	
		 if (cockIngArr.length >= 7) {cockIng.setIngredient7(cockIngArr[6]);};	
		 if (cockIngArr.length >= 8) {cockIng.setIngredient8(cockIngArr[7]);};	
		 if (cockIngArr.length >= 9) {cockIng.setIngredient9(cockIngArr[8]);};	
		 if (cockIngArr.length >= 10) {cockIng.setIngredient10(cockIngArr[9]);};	
		 System.out.println(cockIng);
		 List<CocktailInfo> list = service.cockSelect(cockIng);
		 System.out.println(list);
		 return list;
	}
}
