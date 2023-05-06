function kiemtra(){
	var NameAuthor = document.ThemTacGia.NameAuthor.value;
	var Birthday = document.ThemTacGia.Birthday.value;
	var Email = document.ThemTacGia.Email.value;
	var Phone = document.ThemTacGia.Phone.value;
	console.log(NameAuthor);
	if (NameAuthor == ""|| Birthday==""||Email==""||Phone=="" ){
		alert("Vui lòng nhập đầy đủ thông tin");
		return false;
	}
	
	var choice = confirm("Xác nhận lưu");
	if (choice == 0) return false;
	return true;
}