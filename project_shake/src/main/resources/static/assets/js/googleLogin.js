function handleCredentialResponse(response) {
	// decodeJwtResponse() is a custom function defined by you
	// to decode the credential response.
	const responsePayload = parseJwt(response.credential);
	const social_id = responsePayload.sub;
	console.log("ID: " + responsePayload.sub);
	console.log('Full Name: ' + responsePayload.name);
	console.log('Given Name: ' + responsePayload.given_name);
	console.log('Family Name: ' + responsePayload.family_name);
	console.log("Image URL: " + responsePayload.picture);
	console.log("Email: " + responsePayload.email);

	sessionStorage.setItem("social_id", responsePayload.sub)

	$.ajax({
		url: "socialLoginCheck",
		type: "post",
		data: {
			"social_id": social_id
		},
		success: function(result) {
			if (result == "") {
				console.log("로그인 실패")
			} else {
				console.log("로그인 성공");
			}
		}
	});
};

function parseJwt(token) {
	const base64Url = token.split('.')[1];
	const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
	const jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
		return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
	}).join(''));

	return JSON.parse(jsonPayload);
};