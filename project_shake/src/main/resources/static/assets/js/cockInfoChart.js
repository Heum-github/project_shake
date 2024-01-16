// 토글된 데이터의 summary 요소를 모두 선택
let summaries = document.querySelectorAll('.cockDetail summary');

// 각 summary 요소 클릭 시
summaries.forEach(function(summary) {
	summary.addEventListener('click', function() {
		// 토글된 섹션 내부의 input 요소를 선택
		let inputElement = this.parentElement.querySelector('.cockNames');
		let cockInfoChart = this.parentElement.querySelector('.cockInfoChart');

		// input 요소의 값 가져오기
		let cock_value = inputElement.value;

		// 정보 가져와서 차트 산출
		console.log('선택된 값: ' + cock_value);
		$.ajax({
			url: "cockChart",
			type: "get",
			data: {
				"cock_idx": cock_value
			}, success: (res) => {
				new Chart(cockInfoChart, {
					type: 'radar',
					data: {
						labels: ['단맛', '신맛', '쓴맛', '짠맛', '매운맛', '떫은맛'],
						datasets: [{
							label: "#",
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
									min: 0,
									max: 10,
									stepSize: 1
								}
							}
						}
					}
				});
			}
		})
	});
});

//칵테일 검색어 입력후 엔터 기능
document.getElementById('search').addEventListener('keyup', function(event) {
	if (event.key === 'Enter') {
		document.getElementById('searchBtn').click();
	}
});