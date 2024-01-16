// 레시피 게시판의 추천 기능.

// 세션의 아이디와 board의 idx가져오기.
// 정보를 보내고 확인하기.
$(function() {
	// myRecipeRestController로 이동
	$.ajax({
		url: "../checkLike",
		type: "get",
		data: {
			"rcp_idx": $("#rcp_idx").val(),
			"user_id": $("#rcp_user_id").val(),
			"rcp_likes": 0
		},
		success: (res) => {
			const like = $("#likeBtn");
			like.html("");
			if (res == 0) {
				// 좋아요 안했을 경우 빈 하트 제시
				let content = `
					<div id = "likeBtn">
						<input type="hidden" name = "rcp_likes" value = "0">
						<button type ="submit"><i class="fa-regular fa-heart fa-beat fa-2xl"></i></button>
					</div>				
					`;
				like.append(content);
			} else {
				// 좋아요 했을 경우 빨간 하트 제시
				let content = `
					<div id = "likeBtn">
						<input type="hidden" name = "rcp_likes" value = "1">
						<button type ="submit"><i class="fa-solid fa-heart fa-beat fa-2xl" style="color: #e90c0c;"></i></button>
					</div>
				`;
				like.append(content);
			}
		},
		error: function(error) {
			console.log("서버 응답 실패 : " + error);
		}
	});
});