

/**
 * 
 */

function kiemtra() {

   
	var arr = document.getElementsByTagName("input");
	var s = arr.length;
	console.log(arr);
	console.log(s);
	for (var i = 0; i < s-1; i++){
		console.log(arr[i].value);
	}
	for (var i = 0; i < s; i++) {
		if (arr[i].value == "") {
			console.log("đã vào  đây");
			alert("Vui lòng nhập đủ thông tin");
			return false;
		}
	}
	return true;

}
function kiemtrataikhoan() {


	var request;
	
	var u = document.dangky.username.value;
	console.log(u);

	var url = "KiemTraTaiKhoanDangKi?username=" + u;

	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}

	try {
		request.onreadystatechange = function() {
			if (request.readyState == 4) {
				var val = request.responseText;
				console.log(val);
				/**  document.getElementById('ketqua').innerHTML=val;*/


				if (val == "tk da ton tai") {
					document.getElementById("tk").style.display = "block";
					document.getElementById("tk").innerHTML = "Tài khoản đã được sử dụng";

					const button = document.querySelector('button');
					button.disabled = true;
				}
				else {
					document.getElementById("tk").style.display = "none";
					const button = document.querySelector('button');
					button.disabled = false;			
				}
			}
		};
		request.open("GET", url, true);

		request.send();
	} catch (e) {
		alert("Unable to connect to server");
	}
}

function kiemtramatkhau() {
	var a = document.getElementsByName("password");
	if (a[0].value != a[1].value) {
		document.getElementById("mk").style.display = "block";
		document.getElementById("mk").innerHTML = "Mật khẩu không trùng nhau"

		const button = document.querySelector('button');
		button.disabled = true;


	}
	else {
		document.getElementById("mk").style.display = "none";
		const button = document.querySelector('button');
		button.disabled = false;
	}
}


