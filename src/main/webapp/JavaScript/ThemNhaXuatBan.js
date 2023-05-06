function kiemtra() {
	var arr = document.getElementsByTagName("input");
	var s = arr.length;
	for (var i = 0; i < s-1; i++) {
		if (arr[i].value == "") {
			alert("Vui lòng nhập đủ thông tin");
			return false;
		}
	}
	var choice = confirm("Xác nhận ");
	if (choice == 0) return false;
	return true;
}