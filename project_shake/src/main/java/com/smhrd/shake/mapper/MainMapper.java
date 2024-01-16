package com.smhrd.shake.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.shake.entity.CockIngredient;
import com.smhrd.shake.entity.CockMix;
import com.smhrd.shake.entity.CocktailInfo;

@Mapper
public interface MainMapper {
	public List<CockMix> mainPage();
	public List<CocktailInfo> cockSelect(CockIngredient cockIng);
}
