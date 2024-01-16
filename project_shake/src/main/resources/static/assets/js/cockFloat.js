// 메인 페이지의 칵테일 재료 클릭 시 띄위지는 칵테일 재료 띄우고 지우는 JS
const divs = document.querySelectorAll('.listdiv');

// 이미 추가된 값을 저장할 배열
let addedValues = [];

// 클릭한 div에서 클래스 찾기
divs.forEach((div) => {
	div.addEventListener('click', function() {
		const link = div.querySelector('.cocking');
		const value = link.getAttribute('value');

		// 이미 추가된 값인지 확인
		if (addedValues.includes(value)) {
			alert("이 값은 이미 추가되었습니다.");
			return; // 중복된 값이면 추가하지 않음
		}

		// 추가된 값이 13개 이상인 경우 경고창 표시
		if (addedValues.length >= 12) {
			alert("재료는 12개 까지만 추가할 수 있습니다.");
			return;
		}

		// input 생성
		const ingBox = $("#ingBox");
		// 새로운 input 요소를 생성하고 추가합니다.
		let content = "<input class='deleteInput' value='" + value + "' readonly>";
		ingBox.append(content);

		// 생성된 값 배열에 추가
		addedValues.push(value);

		// 클릭 시 input 삭제
		const newInput = ingBox.find(".deleteInput");
		newInput.on('click', function() {
			const deletedValue = $(this).val();
			addedValues.splice(addedValues.indexOf(deletedValue), 1);
			$(this).remove();
		});
	});
});


// 애니메이션 구성

function moveLeft() {
    const lid = document.getElementById('shakerLid');
    const head = document.getElementById('shakerHead');
    lid.style.transform = 'translateX(-250px)';
    head.style.transform = 'translateX(-250px)';
}

function moveLight() {
    const lid = document.getElementById('shakerLid');
    const head = document.getElementById('shakerHead');
    lid.style.transform = 'translateX(3px)';
    head.style.transform = 'translateX(3px)';
}



function shakeCup() {
    const cup = document.getElementById('animationDiv');
    cup.classList.add('shake-animation');
    setTimeout(() => {
        cup.classList.remove('shake-animation');
    }, 2000);
}

function executeAnimations() {
    moveLeft();
    setTimeout(shakeCup, 2000);
    setTimeout(moveLight, 4000);
    
}

// 버튼 클릭시 칵테일 정보 가져오기 + 애니메이션 실행

document.querySelector('.ani').addEventListener('click', function() {
	executeAnimations();
	const form = document.getElementById('ingForm');
	const inputElements = form.querySelectorAll('input');
	// input 요소들의 value 값을 배열로 만들기
	const cockIngArr = [];
	inputElements.forEach(input => {
		cockIngArr.push(input.value);
	});

	// 배열 값 cockSelect(MainRestController)로 보내기
	$.ajax({
		url: "cockSelect",
		type: "get",
		traditional: true,
		data: {
			"cockIngArr": cockIngArr
		},
		dataType: "json",
		success: (res) => {
			const detail = $("#carouselReel");
			detail.html("");
			if (res[0] != null) {
				// 칵테일 정보를 메인페이지 하단에 카드 형식으로 제시
				for (let i = 0; i < res.length; i++) {
					let list = res[i];
					let content = `
					<article class = "articleCock scroll cockBox">
						<a class="image featured">
							<img src = ${list.cock_image} /></a>
							<div class = "articleDesc">
								<header>
									<h3><a href="#">${list.cock_name}</a></h3>
								</header>
								<p>${list.cock_ingredient}</p>
								<p>${list.cock_desc}</p>
							</div>
					</article>
			`;
					detail.append(content);
				};
			} else {
				let content = `
					<div style = "text-align : center;">
						<h3>해당 재료를 조합하여 만들 수 있는 칵테일이 없습니다.</h3>
						<br>
						<h3>위 재료들로 나만의 칵테일을 만들어 레시피를 공유해보세요!</h3>
						<br>
						<a href = "myRecipe">나만의 칵테일 만들기로 이동 <i class="fa-solid fa-wine-glass-empty fa-bounce" style="color: #511f29;"></i></a>
					</div>
			`;
				detail.append(content);
			}
		}
	});
	const deleteInputs = document.querySelectorAll('.deleteInput');
	deleteInputs.forEach(function(deleteInput) {
		anime({
			targets: deleteInput,
			opacity: 0,
			duration: 1000,
			easing: 'easeOutExpo',
			complete: function(_anim) {
				deleteInput.remove();
				addedValues = [];
			}
		});
	});
});

//클릭시 쉐이크 소리
document.querySelector('.ani').addEventListener('click', function() {
   var audio = document.getElementById('audio');
   audio.play();
});

