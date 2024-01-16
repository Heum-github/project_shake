// 커뮤니티의 게시글의 댓글목록을 가져오는 JS파일

$(function() {
	// CommunityRestController로 게시글 idx 값 보내기.
	$.ajax({
		url: "../commCmtList",
		type: "get",
		data: {
			"comm_idx": $("#comm_idx").val(),
		},
		success: (res) => {
			const commentCount = $("#commentCount");
			commentCount.html("");
			let summarycommentCount = `<span>${res.length}</span>`
			commentCount.append(summarycommentCount);
			
			const commentSummary = $("#commentSummary");
			commentSummary.html("");
			let summaryContent = `COMMENT <span>(${res.length})</span>`
			commentSummary.append(summaryContent);
			const commentDiv = $("#commentDiv");
			for (let i = 0; i < res.length; i++) {
				let comment = res[i];
				// JavaScript 날짜 형식화
				let createdAt = new Date(comment.created_at);
				let formattedDate = createdAt.toLocaleString('ko-KR', { year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit', second: '2-digit' });

				let content = `
					<div class="media-body">
						<strong class="mt-0">${comment.user_nick}</strong><small class="text-muted"> ${formattedDate}</small>
						<p>ㄴ  ${comment.cmt_content}</p>
					</div>
					<br>
				`;
				commentDiv.append(content);
			}
		},
		error: function(error) {
			console.log("서버 응답 실패 : " + error);
		}
	});
});
