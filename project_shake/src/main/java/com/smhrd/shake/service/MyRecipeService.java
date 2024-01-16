package com.smhrd.shake.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.smhrd.shake.converter.ImageConverter;
import com.smhrd.shake.converter.ImageToBase64;
import com.smhrd.shake.entity.RecipeComment;
import com.smhrd.shake.entity.RecipeInfo;
import com.smhrd.shake.entity.RecipeLikes;
import com.smhrd.shake.entity.RecipeTasteInfo;
import com.smhrd.shake.entity.RecipeTasteInfoAVG;
import com.smhrd.shake.mapper.MyRecipeMapper;

@Service
public class MyRecipeService {
	
	@Autowired
	 MyRecipeMapper mapper;
	
	public List<RecipeInfo> recipeList() throws IOException{
		List<RecipeInfo> list = mapper.recipeList();
		for(int i = 0; i < list.size(); i++) {
			RecipeInfo contents = list.get(i);
			File file = new File("c:\\uploadImage\\" + contents.getRcp_image());
			ImageConverter<File, String> converter= new ImageToBase64();
			String fileStringValue = converter.convert(file);
			list.get(i).setRcp_image(fileStringValue);
		}
		return list;		
	}	
	
	public List<RecipeInfo> recipeSearch(String recipeSearch) throws IOException{
		List<RecipeInfo> list = mapper.recipeSearch(recipeSearch);
		for(int i = 0; i < list.size(); i++) {
			RecipeInfo contents = list.get(i);
			File file = new File("c:\\uploadImage\\" + contents.getRcp_image());
			ImageConverter<File, String> converter= new ImageToBase64();
			String fileStringValue = converter.convert(file);
			list.get(i).setRcp_image(fileStringValue);
		}
		return list;
	}
	
	public void recipeWrite(RecipeInfo rcp) {
		mapper.recipeWrite(rcp);
	}
	
	public RecipeInfo recipeContent(int rcp_idx) {
		return mapper.recipeContent(rcp_idx);
	}
	public int recipeDelete(int rcp_idx) {
		return mapper.recipeDelete(rcp_idx);
	}
	
	public int count(int rcp_idx) {
		return mapper.count(rcp_idx);
	}
	
	public Integer checkLike(RecipeLikes like) {
		return mapper.checkLike(like);
	}
	
	public int recipeLike(RecipeLikes like) {
		System.out.println(like);
		return mapper.recipeLike(like);
	}
	
	public int recipeDislike(RecipeLikes like) {
		return mapper.recipeDislike(like);
	}
	
	public List<RecipeTasteInfoAVG> recipeChart(int rcp_idx) {
		return mapper.recipeChart(rcp_idx);
	}
	
	public int recipeAssess(RecipeTasteInfo rcp) {
		return mapper.recipeAssess(rcp);
	}
	
	public int recipeCmt(RecipeComment cmt) {
		return mapper.recipeCmt(cmt);
	}
	
	public List<RecipeComment> recipeCmtList(int rcp_idx){
		return mapper.recipeCmtList(rcp_idx);
	}
	
	public int deleteCmt(int rcp_cmt_idx) {
		return mapper.deleteCmt(rcp_cmt_idx);
	}
}
