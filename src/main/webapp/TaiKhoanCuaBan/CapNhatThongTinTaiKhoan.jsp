<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cập nhật thông tin tài khoản</title>
<link rel="stylesheet" type="text/css" href="../css/CapNhatThongTinTaiKhoan.css">
<link rel="stylesheet" type="text/css"
	href="../font-awesome/css/fontawesome-all.css">
<link rel="stylesheet" type="text/css"
	href="../font-awesome/css/fontawesome.css">

</head>
<body>
<script type="text/javascript" src="../JavaScript/ThemNhaXuatBan.js"></script>
	<div class="admin">

		<ul>
			<li class="QuanTriVien"><i class="fas fa-home"></i> Xin chào Huy</li>

			<li><a href="../TrangChuController"><i class="fas fa-address-card"></i> Trở về trang chủ</a></li>
			<li><a href="DonHangDaMuaController"><i class="fas fa-align-justify"></i> Đơn hàng đã mua</a>
				</li>
			<li><a href="../ThongTinTaiKhoan"><i class="fas fa-archive"></i> Thông tin tài khoản</a></li>
			<li><a href="DoiMatKhau.jsp"><i class="fas fa-info"></i>Đổi mật khẩu</a></li>
			<li><a href="../DangXuat"><i class="fas fa-user-circle"></i> Đăng xuất</a></li>
		</ul>
	</div>
	<div class="right">
	   <h1>Cập nhật thông tin tài khoản</h1>
		<div id="form">
		<form action="../CapNhatThongTinTaiKhoan" method="post" onsubmit="return kiemtra()">
		<label>Họ tên:</label>
		<br>
		 <input type="text" name="fullName" value="<%=request.getParameter("fullName") %>" >
		<br>
		<label>Giới tính:</label> 
		<br>
		<div id="radio">
		Nam:<input type="radio" name="gender" value="Nam"  checked>Nữ:
		<input type="radio" name="gender" value="Nữ" >
		</div>
		
		<label>Ngày sinh:</label> 
		<br>
		<input type="date" name="birthday" value="<%=request.getParameter("birthday") %>" >
		<br>
		<label>Địa chỉ:</label>
		<br>
		 <input type=text name="address" value="<%=request.getParameter("address") %>" >
		<br>
		<label>Email:</label>
		<br>
		<input type=text name="email" value="<%=request.getParameter("email") %>" >
		<br>
		<label>Điện thoại:</label> 
		<br>
		<input type=text name="phone" value="<%=request.getParameter("phone") %>" >
		<br>
		<input class="submit" type="submit" value="Cập Nhật">
        </form>
        </div>

	</div>

</body>
</html>
