/**
 * 
 */
function kiemtra(){
	var choice=confirm("Xác nhận xóa");
	/**var Id=document.XoaSach.Id.value;
	console.log(Id);*/
	var Id=document.getElementsByName("Id")[0];
	console.log(Id);
	if(choice==0){ return false;}
	return true;
}
