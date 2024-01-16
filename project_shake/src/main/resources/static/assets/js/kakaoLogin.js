Kakao.init('d93428e804ee6afd7407d793c6be34cb'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단

//카카오로그인
function kakaoLogin() {
	Kakao.Auth.login({
			success: function(response) {
				Kakao.API.request({
					url: '/v2/user/me',
					success: function(response) {
						console.log(response.id);
						// ID, 이름, 이메일 정보 화면에 출력
						document
							.getElementById('user-info').innerHTML = 'ID: '
							+ response.id
						// 서버로 사용자 정보 전송
						$.ajax({
							url: '/user_info_kakao', // POST 요청을 처리할 서버 URL 변경
							type: 'POST',
							data: JSON.stringify(response), // JSON 형태의 문자열로 변환
							contentType: 'application/json', // 데이터 타입 지정 
							dataType: 'json',
							success: function(data) {
								console.log('success');
								console.log(data);
							},
							error: function(e) {
								console.log('error');
								console.log(e);
							}
						});
					},
					fail: function(error) {
						console.log(error)
					},
				})
			},
		fail: function(error) {
			console.log(error)
		},
	})
}

// 카카오로그아웃  
function kakaoLogout() {
	if (Kakao.Auth.getAccessToken()) {
		Kakao.API.request({
			url: '/v1/user/unlink',
			success: function(response) {
				console.log(response)
				// 로그아웃 시 화면에서 사용자 정보 제거
				document.getElementById('user-info').innerHTML = '';
			},
			fail: function(error) {
				console.log(error)
			}
		})
		Kakao.Auth.setAccessToken(undefined);
	}
}