package com.smhrd.shake.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.shake.entity.UserInfo;
import com.smhrd.shake.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	UserService service;

	@PostMapping("/user_info_naver") // naver 로그인 및 회원 정보 받아오기
	public String handleUserInfoNaver(@RequestBody Map<String, Object> userInfo) {
		System.out.println(userInfo); // 콘솔 확인용
		return "success"; // 성공 메시지 반환
	}

	@PostMapping("/user_info_kakao") // kakao 로그인 및 회원 정보 받아오기
	public String handleUserInfo(@RequestBody Map<String, Object> userInfo) {
		System.out.println(userInfo); // 콘솔 확인용
		return "success"; // 성공 메시지 반환
	}

}
