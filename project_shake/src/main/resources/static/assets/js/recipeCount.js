// 레시피 게시판의 조회수 기능

$(function() {
	let rcp_idx = $("#rcp_idx").val();
	
	$.ajax({
		url: "../rcpCount",
		type: "get",
		data: {
			"rcp_idx": rcp_idx
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