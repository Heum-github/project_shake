// 이거 뭐지...?

//id가 preImage인 img 태그 요소를 가져오기.
let preImage = document.getElementById("preImage");
let photo = document.getElementById("photo");

//photo(input)에 이벤트(파일 선택, 변경)가 발생했을 때 img src속성값 변경
photo.addEventListener("change", e => {
	setImage(e.target) // change한 주체인 input태그가 타겟이 됨.
})

function setImage(input) { // input : 첨부된 파일을 포함한 input 태그요소
	// input태그에 추가된 파일이 있는지 확인.
	if (input.files && input.files[0]) {
		console.log(input.files);
		// FileReader 생성
		const reader = new FileReader();
		console.log(reader);
		reader.readAsDataURL(input.files[0]) // -> onload 발생
		reader.onload = e => {
			// fileReader가 생성이 되었는지 확인
			console.log(e)
			preImage.src = e.target.result;
		}
	}
}