package com.smhrd.shake.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.shake.entity.RecipeInfo;
import com.smhrd.shake.entity.UserInfo;
import com.smhrd.shake.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/login/check") // 로그인 서비스
	public String loginCheck(UserInfo user, HttpSession session) {
		UserInfo member = service.loginCheck(user);
		if (member != null) {
			session.setAttribute("loginMember", member);
			return "redirect:/main";
		} else {
			System.out.println("로그인실패");
			return "redirect:/login";
		}
	}

	@PostMapping("/join/check") // 회원가입 서비스
	public String joinCheck(UserInfo user) {
		int row = service.joinCheck(user);
		if (row == 1) {
			return "redirect:/login";
		} else {
			System.out.println("로그인 실패"); // 자바 스크립트로 에러메세지 산출 시킬 것.
			return "redirect:/login";
		}
	}

	@GetMapping("/logout")   // 로그아웃 서비스
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@PostMapping("userUpdate/update")  // 회원정보 수정 서비스
	public String update(UserInfo user, HttpSession session) {
		int num = service.update(user);
		if (num != 0) {
			session.invalidate();
			return "redirect:/";
		}
		return "redirect:/";
	}

	@GetMapping("/userLike")      // 레시피 좋아요를 누를 목록 표시 서비스
	public String userLike(HttpSession session, Model model, @RequestParam(defaultValue = "1") int page)
			throws IOException {
		UserInfo member = (UserInfo) session.getAttribute("loginMember");
		String user = member.getUser_id();
		if (member != null) {
			int pageSize = 6; // 한 페이지에 표시할 항목 수
			List<RecipeInfo> recipes = service.userLike(user);
			int totalRecipes = recipes.size();
			int totalPages = (int) Math.ceil((double) totalRecipes / pageSize);

			int startIndex = (page - 1) * pageSize;
			int endIndex = Math.min(startIndex + pageSize, totalRecipes);

			List<RecipeInfo> recipesToDisplay = recipes.subList(startIndex, endIndex);

			model.addAttribute("recipes", recipesToDisplay);
			model.addAttribute("page", page);
			model.addAttribute("totalPages", totalPages);
		}
		return "userLike";
	}
	
	@GetMapping("/deleteUser")  // 회원 탈퇴 서비스
	public String deleteUser(HttpSession session, String user_id) {
		UserInfo user = (UserInfo) session.getAttribute("loginMember");
		int row = service.deleteUser(user.getUser_id());
		if (row > 0) {
			System.out.println("회원탈퇴 완료");
			return "redirect:/";
		} else {
			System.out.println("회원탈퇴 실패");
			return "redirect:/userUpdate";
		}
	}

}