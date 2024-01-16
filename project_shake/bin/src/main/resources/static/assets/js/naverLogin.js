// 네이버 로그인 객체 생성
const naverLogin = new naver.LoginWithNaverId({
   clientId: "XXwCsOVFr_clI402l5vD",
   callbackUrl: "http://localhost:8089/shake/naver",
   loginButton: {color: "green", type: 1, height: 36}
});

// 네이버 로그인 초기화
naverLogin.init();

// 사용자의 로그인 상태 확인
naverLogin.getLoginStatus(function (status) {
   if (status) {
       const enc_id = naverLogin.user.getId(); // 사용자 ID 가져오기  
       const nickName=naverLogin.user.getNickName();
       const age=naverLogin.user.getAge();
       const birthday=naverLogin.user.getBirthday();

       if(nickName===null||nickName===undefined ){
           alert("별명이 필요합니다. 정보제공을 동의해주세요.");
           naverLogin.reprompt();
           return;  
        } else {
           setLoginStatus(enc_id, nickName, age, birthday);
        }
    }
});

function setLoginStatus(enc_id, nickName, age, birthday){ // enc_id 등의 정보 받기

    // 화면에 사용자 정보 출력
    document.getElementById('message').innerHTML=`
        <h3> Login 성공 </h3>
        <div>user Encrypted ID : ${enc_id}</div> <!-- enc_id 출력 -->
        <div>user Nickname : ${nickName}</div>
        <div>user Age(범위) : ${age}</dibv><br/>
		<div>User Birthday : ${birthday}</div>`;

    // 서버로 사용자 정보 전송
    $.ajax({
       url: '/user_info_naver', // POST 요청을 처리할 서버 URL 변경
       type: 'POST',
       data: JSON.stringify({id: enc_id, nickname: nickName, age: age, birthday: birthday}), // JSON 형태의 문자열로 변환
       contentType:'application/json',  // 데이터 타입 지정 
       dataType:'json',  
       success:function(data){
         console.log('success');
         console.log(data);
        },
        error:function(e){
          console.log('error');
          console.log(e);
        }
     });

    // 로그아웃 버튼 추가
    document.getElementById('button_area').innerHTML="<button id='btn_logout'>로그아웃</button>";

    // 로그아웃 버튼 클릭 이벤트 추가
    document.getElementById('btn_logout').addEventListener('click',(e)=>{
        naverLogin.logout();
        location.replace("http://localhost:8089/shake/naver");
      })
}
