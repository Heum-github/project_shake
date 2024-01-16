package com.smhrd.shake.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.shake.entity.RecipeComment;
import com.smhrd.shake.entity.RecipeInfo;
import com.smhrd.shake.entity.RecipeLikes;
import com.smhrd.shake.entity.RecipeTasteInfo;
import com.smhrd.shake.entity.RecipeTasteInfoAVG;

@Mapper
public interface MyRecipeMapper {
	public List<RecipeInfo> recipeList();
	public List<RecipeInfo> recipeSearch(String recipeSearch);
	public void recipeWrite(RecipeInfo rcp);
	public RecipeInfo recipeContent(int rcp_idx);
	public Integer checkLike(RecipeLikes like);
	public int recipeLike(RecipeLikes like);
	public int recipeDislike(RecipeLikes like);
	public int recipeDelete(int rcp_idx);
	public int count(int rcp_idx);
	public List<RecipeTasteInfoAVG> recipeChart(int rcp_idx);
	public int recipeAssess(RecipeTasteInfo rcp);
	public int recipeCmt(RecipeComment cmt);
	public List<RecipeComment> recipeCmtList(int rcp_idx);
	public int deleteCmt(int rcp_cmt_idx);
}
