// 레시피 게시글의 댓글 정보 가져오는 JS파일
console.log($("#rcp_idx").val())
$(function() {
	// MyrecipeRestController로 이동
	$.ajax({
		url: "../recipeCmtList",
		type: "get",
		data: {
			"rcp_idx": $("#rcp_idx").val(),
		},
		success: (res) => {
			const commentCount = $("#commentCount");
			commentCount.html("");
			let summarycommentCount = `<span>${res.length}</span>`
			commentCount.append(summarycommentCount);

			const commentSummary = $("#commentSummary");
			commentSummary.html("");
			let summaryContent =`COMMENT <span>(${res.length})</span>`
			commentSummary.append(summaryContent);
			
			const commentDiv = $("#commentDiv");

			for (let i = 0; i < res.length; i++) {
				let comment = res[i];
				// JavaScript로 날짜 형식화
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

