<%@page import="DangKiDangNhap.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đổi mật khẩu</title>
<link rel="stylesheet" type="text/css" href="../css/DoiMatKhau.css">
<link rel="stylesheet" type="text/css"
	href="../font-awesome/css/fontawesome-all.css">
<link rel="stylesheet" type="text/css"
	href="../font-awesome/css/fontawesome.css">

</head>
<body>
<script type="text/javascript" src="../JavaScript/DoiMatKhau.js"></script>
	<div class="admin">

		<ul>
			<li class="QuanTriVien"><i class="fas fa-home"></i> Xin chào Huy</li>

			<li><a href="../TrangChuController"><i class="fas fa-address-card"></i> Trở về trang chủ</a></li>
			<li><a href="../DonHangDaMuaController"><i class="fas fa-align-justify"></i> Đơn hàng đã mua</a>
				</li>
			<li><a href="../ThongTinTaiKhoan"><i class="fas fa-archive"></i> Thông tin tài khoản</a></li>
			<li><a href="#"><i class="fas fa-info"></i>Đổi mật khẩu</a></li>
			<li><a href="../DangXuat"><i class="fas fa-user-circle"></i> Đăng xuất</a></li>
		</ul>
	</div>
	<div class="right">
	   <h1>Đổi mật khẩu</h1>
		<div id="form">
		<form action="../DoiMatKhau" method="post" onsubmit="return kiemtra()">
		<label>Nhập mật khẩu cũ:</label>
		<br>
		
		
		<input type="password" name=""  onblur="kiemtramatkhaucu()" >
		<br>
		<span id="mk"></span>
		<br>
		<label>Nhập mật khẩu mới:</label> 
		<br>
		<input type="password" name="password" value="" >
		<br>
		<label>Nhập lại mật khẩu mới:</label>
		<br>
		 <input type="password" name="password" value="" onblur="kiemtramatkhau()">
		<br>
		<span id="mkm" ></span>
		<br>
		<input class="submit" id="submit" type="submit" value="Cập Nhật">
        </form>
        </div>

	</div>

</body>
</html>
