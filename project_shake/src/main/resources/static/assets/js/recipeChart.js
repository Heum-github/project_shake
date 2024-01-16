// 레시피 게시글에 레시피에 대한 맛평가 제시

const crt = document.getElementById('recipeChart');
console.log($("#rcp_idx").val());
$.ajax({
	// 레시피 게시글 idx 정보와 같이 MyrecipeRestController로 이동
	url: "../recipeChart",
	type: "get",
	data: {
		"rcp_idx": $("#rcp_idx").val(),
	},
	success: makeChart,
	error: function(error) {
		console.log("서버 응답 실패 : " + error);
	}
});


function makeChart(res) {
	console.log(res)
	new Chart(crt, {
		type: 'radar',
		data: {
			labels: ['단맛', '신맛', '쓴맛', '짠맛', '매운맛', '떫은맛'],
			datasets: [{
				label: $("#rcp_name").val(),
				data: [res[0].sweet, res[0].sour, res[0].bitter, res[0].salty, res[0].spicy, res[0].puckery],
				backgroundColor: 'pink',
				borderColor: 'black',
				borderWidth: 1
			}]
		},
		options: {
			resposive: false,
			scale: {
				r: {
					ticks: {
						beginAtZero: true,
						min : 0,
						max: 10,
						stepSize : 1
					}
				}
			}
		}
	});
};