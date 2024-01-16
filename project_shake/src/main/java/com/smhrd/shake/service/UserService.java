package com.smhrd.shake.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.shake.converter.ImageConverter;
import com.smhrd.shake.converter.ImageToBase64;
import com.smhrd.shake.entity.RecipeInfo;
import com.smhrd.shake.entity.UserInfo;
import com.smhrd.shake.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	public UserInfo loginCheck(UserInfo user) {
		return mapper.login(user);
	}
	
	public int joinCheck(UserInfo user) {
		return mapper.join(user);
	}
	
	public int update(UserInfo user) {
		return mapper.update(user);
	}

	public List<RecipeInfo> userLike(String user) throws IOException{
		List<RecipeInfo> list = mapper.userLike(user);
		for(int i = 0; i < list.size(); i++) {
			RecipeInfo contents = list.get(i);
			File file = new File("c:\\uploadImage\\" + contents.getRcp_image());
			ImageConverter<File, String> converter= new ImageToBase64();
			String fileStringValue = converter.convert(file);
			list.get(i).setRcp_image(fileStringValue);
		}
		return list;		
	}	
	
	public UserInfo socialLoginCheck(String socialLogin){
		return mapper.socialLoginCheck(socialLogin);
	}
	
	public int socialJoin(UserInfo user, String social_id) {
		return mapper.socialJoin(user, social_id);
	}
	
	public int deleteUser(String user_id) {
		return mapper.deleteUser(user_id);
	}
}
