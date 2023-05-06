/**

 
 */
/**
function send(){
	var arr =document.getElementsByTagName("input");
	var Name= arr[0].value;
	var Price =arr[1].value;
	var Image =arr[2].value;
	var BookCategoryId= arr[3].value;
	var PublisherId=arr[4].value;
	var AuthorId=arr[5].value;
	var PublishYear=arr[6].value;
	var Totalpage=arr[7].value;
	var Language =arr[8].value;
	var Description=arr[9].value;
	if(Name=="" || Price=="" || Image ==""||BookCategoryId==""||PublisherId==""
	    ||AuthorId==""|| PublishYear==""|| Totalpage==""||Language==""|| Description=="" ){
		alert("Vui lòng nhập đủ thông tin");
		return;
	}
	if(isNaN(Price)){//không phải là sô
		alert("Price là một số");
		return;
	}
	if(isNaN(Totalpage)){
		alert("TotalPage  là mốt số");
		return;
	}
	confirm("Xác nhận lưu");
};
 */

 function kiemtra(){
	var Name=document.ThemSach.Name.value;
	var Price=document.ThemSach.Price.value;
	var Image=document.ThemSach.Image.value;
	var BookCategoryId=document.ThemSach.BookCategoryId.value;
	var PublisherId=document.ThemSach.PublisherId.value;
	var AuthorId=document.ThemSach.AuthorId.value;
	var PublishYear=document.ThemSach.PublishYear.value;
	var Totalpage=document.ThemSach.TotalPage.value;
	var Language=document.ThemSach.Language.value;
	var Description=document.ThemSach.Description.value;
	console.log(Name);
	
	if(Name=="" || Price=="" || Image ==""||BookCategoryId==""||PublisherId==""
	    ||AuthorId==""|| PublishYear==""|| Totalpage==""||Language==""|| Description=="" ){
		alert("Vui lòng nhập đủ thông tin");
		return false;
	}
	if(isNaN(Price)){//không phải là sô
		alert("Price là một số");
		return false;
	}
	if(isNaN(Totalpage)){
		alert("TotalPage  là một số");
		return false;
	}
	var choice=confirm("Xác nhận lưu");
	if(choice==0) return false;
	return true;
	
}
