package com.smhrd.shake.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.shake.entity.CocktailInfo;
import com.smhrd.shake.entity.CocktailTasteInfo;

@Mapper
public interface CocktailMapper {
	public List<CocktailInfo> cocktailList();
	
	@Select("select *from cocktail_info where cock_name like '%${input}%'")
	public List<CocktailInfo> search(String input);
	
	public List<CocktailTasteInfo> cockChart(int cock_idx);
	
	public int cockTasteAccess(CocktailTasteInfo cock);
}
