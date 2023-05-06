/**
 * 
 */
function guidiserver() {
	
	var request;
	
	
	

	var url = "LuuThongTinOrder";

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
				setTimeout("location.reload(true);",1000);
				
				


				
			}
		};
		request.open("GET", url, true);

		request.send();
	} catch (e) {
		alert("Unable to connect to server");
	}
	document.getElementById('tinhtien').innerHTML="Tính tiền thành công";

}