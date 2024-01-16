package com.smhrd.shake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.shake.entity.CockIngredient;
import com.smhrd.shake.entity.CockMix;
import com.smhrd.shake.entity.CocktailInfo;
import com.smhrd.shake.mapper.MainMapper;

@Service
public class MainService {
	
	@Autowired
	MainMapper mapper;
	
	public List<CockMix> mainPage(){
		return mapper.mainPage();
	}
	
	public List<CocktailInfo> cockSelect(CockIngredient cockIng){
		return mapper.cockSelect(cockIng);
	};
	
}
