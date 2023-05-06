<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng Ký</title>
<link rel="stylesheet" type="text/css" href="css/DangKy.css">

</head>
<body id="Dangki">
	<script type="text/javascript" src="JavaScript/DangKi.js"></script>

	<h2>Đăng Ký</h2>
	<form method="post" action="DangKiController" name="dangky"
		onsubmit="return kiemtra()">
		<div id="Dangkii">
			<input type="text" name="username" placeholder="Tên tài Khoản"
				onblur="kiemtrataikhoan()"><br> <span
				style="font-size: 15px; color: red" id="tk"></span><br> <input
				type="password" name="password" placeholder="Mật Khẩu"> <input
				type="password" name="password" placeholder="Nhập lại mật khẩu"
				onblur="kiemtramatkhau()"><br> <span
				style="font-size: 15px; color: red" id="mk"></span><br> <input
				type="text" name="FullName" placeholder="Họ và tên"> <br>
		</div>


		<div class="radio">
			<label>Nam</label> <input type="radio" name="Gender" value="Nam"
				checked="checked"> <label>Nữ</label> <input type="radio"
				name="Gender" value="Nữ">
		</div>
		<br>
		<div id="Dangkii">
			Ngày Sinh: <br> <input type="date" name="Birthday"> <input
				type="text" name="Address" placeholder="Địa chỉ"> <input
				type="email" name="Email" placeholder="Email"> <input
				type="text" name="Phone" placeholder="Phone">

			<button type="submit">Đăng Ký</button>
		</div>

	</form>


	<div class="a">
		<a href="TrangChuController">Trang Chủ</a> <a href="DangNhap.jsp">Đăng
			Nhập</a>

	</div>


</body>
</html>