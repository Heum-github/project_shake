package com.smhrd.shake.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.shake.entity.RecipeInfo;
import com.smhrd.shake.entity.UserInfo;

@Mapper
public interface UserMapper {
	public UserInfo login(UserInfo user);
	public int join(UserInfo user);
	public int update(UserInfo user);
	public List<RecipeInfo> userLike(String user);
	public UserInfo socialLoginCheck(String socialLogin);
	public int socialJoin(UserInfo user, String social_id);
	public int deleteUser(String user_id);
}
