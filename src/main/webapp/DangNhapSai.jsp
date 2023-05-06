<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Đăng Nhập</title>
	<link rel="stylesheet" type="text/css" href="css/Dangnhap.css">

</head>
<body>
	<div id="DangNhap">
		<h2>Đăng Nhập</h2>
		<form action="DangNhapConTroller">
		<input type="text" name="username" placeholder="Tài Khoản" >
		<input type="password" name="password" placeholder="Mật Khẩu">
		<button>Đăng Nhập</button>
		</form>
		<div class="a">
		<h5 style="color:red">Sai tên tài khoản hoặc mật khẩu</h5>
		<a href="TrangChuController">Trang Chủ</a>			
		<a href="DangKy.jsp">Đăng Ký</a>
		</div>
	</div>

</body>
</html>