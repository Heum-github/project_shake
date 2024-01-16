// 게시글 조회수 기능.

$(function() {
	let comm_idx = Number($("input[type=hidden]").val());
	console.log(comm_idx);
	
	// CommunityRestController로 이동
	$.ajax({
		url: "../commCount",
		type: "get",
		data: {
			"comm_idx": comm_idx
		},
		success: (res) => {
			console.log(res);
			if (res > 0) {
				console.log("조회수 올리기 성공");
			}
		},
		error: function(error) {
			console.log("서버 응답 실패 : " + error);
		}
	});
});