// cockinfo의 검색 기능
$("#searchBtn").on("click", () => {
	console.log($("#search").val());
	$.ajax({
		url: "search",
		type: "get",
		data: {
			"input": $("#search").val()
		},
		success: (res) => {
			console.log(res);
			const detail = $("#cocktailPrv");
			detail.html("");

			for (let i = 0; i < res.length; i++) {
				let list = res[i];
				let content = `
                    <div id="cocktailPrv">
                        <details>
                            <summary>${list.cock_name}</summary>
                            <P>${list.cock_desc}</P>
                            <img src="${list.cock_image}" style="height: 200px; width: 200px">
                            <div class="cockInfoChart" id="cockInfoChart${i}" style="max-width: 300px; height: 300px;"></div>
                        </details>
                    </div>
            `;
				detail.append(content);
				$.ajax({
					url: "cockChart",
					type: "get",
					data: {
						"cock_idx": list.cock_idx
					}, success: (result) => {
						let listTaste = result[i];
						// 캔버스 생성
						let canvas = document.createElement('canvas');
						canvas.id = `cockCanvas${i}`;
						document.getElementById(`cockInfoChart${i}`).appendChild(canvas);

						// 데이터 적재
						let ctx = document.getElementById(`cockCanvas${i}`).getContext('2d');
						let myChart = new Chart(ctx, {
							type: 'radar',
							data: {
								labels: ['단맛', '신맛', '쓴맛', '짠맛', '매운맛', '떫은맛'],
								datasets: [{
									label: '#',
									data: [listTaste.sweet, listTaste.sour, listTaste.bitter, listTaste.salty, listTaste.spicy, listTaste.puckery],
									backgroundColor: 'pink',
									borderColor: 'black',
									borderWidth: 1
								}]
							},
							options: {
								responsive: false,
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
			}
		}
	});
});