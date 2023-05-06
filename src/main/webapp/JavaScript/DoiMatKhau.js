/**
 * 
 */
function kiemtra() {

	
	var arr = document.getElementsByTagName("input");

	
	
	for (var i = 0; i < arr.length; i++) {
		if (arr[i].value == "") {
			alert("Vui lòng điền đủ thông tin");
			return false;

		}

	}
	
	return true;
}

function kiemtramatkhaucu() {

	/** //var account = '<%= Session["account"] %>';
	//alert(account);
	
	//console.log(account);*/

	//var arr=document.getElementsByTagName("input");
	//if(arr[0].value!=arr[1].value){
	//	alert("Mật khẩu cũ không đúng")
	//}
	var request;
	var arr = document.getElementsByTagName("input");
	var url = "../KiemTraMatKhauCu";
	var a = "password=" + arr[0].value;
	console.log(a);

	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}

	try {
		request.onreadystatechange = function() {

			if (request.readyState == 4 && this.status == 200) {
				var val = request.responseText;
				//	document.getElementById('mk').innerHTML=val;
				if (val == "true") {

					document.getElementById("mk").style.display = "none";
					arr[3].disabled = false;

				} else {
					document.getElementById("mk").style.display = "block";
					document.getElementById('mk').innerHTML = "Mật khẩu sai";
					arr[3].disabled = true;

					//document.getElementsByClassName('submit')[0].disabled=true; 2 cách này đều được
					//document.getElementById("submit").disabled=true;

				}
			}

		};
		request.open("POST", url, true);
		request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		request.send(a);


	} catch (e) {
		elert("Không vào được server");
	}

}

function kiemtramatkhau() {
	var arr = document.getElementsByTagName("input");
	if (arr[1].value != arr[2].value) {
		document.getElementById("mkm").style.display = "block";
		document.getElementById("mkm").innerHTML = "Mật khẩu không trùng nhau";
		arr[3].disabled = true;
	}
	else {

		document.getElementById("mkm").style.display = "none";
		arr[3].disabled = false;
	}
}

