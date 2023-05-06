<%@page import="DangKiDangNhap.AccountDetail"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thông tin chi tiết tài khoản</title>
<link rel="stylesheet" type="text/css"
	href="css/QuanLyTaiKhoan/ThongTinChiTietTaiKhoan.css">
<link rel="stylesheet" type="text/css"
	href="font-awesome/css/fontawesome-all.css">
<link rel="stylesheet" type="text/css"
	href="font-awesome/css/fontawesome.css">

</head>
<body>
	<script type="text/javascript" src=""></script>
	<div class="admin">

		<ul>
			<li class="QuanTriVien"><i class="fas fa-home"></i> Quản trị
				viên</li>

			<li><a href="TrangQuanTriVien/QuanTriVien.jsp"><i
					class="fas fa-address-card"></i> Trang chủ Quản trị viên</a></li>
			<li><a href="#"><i class="fas fa-align-justify"></i> Quản lý
					danh mục</a>
				<ul class="sub-menu">
					<li><a href="SachController"> Quản lý sách</a></li>
					<li><a href="TacGiaController"> Quản lý tác giả</a></li>
					<li><a href="LayDuLieuThemSuaXoaNhaXuatBan"> Quản lý nhà
							xuất bản</a></li>
					<li><a href="LayDuLieuThemSuaXoaLoaiSach"> Quản lý loại
							sách</a></li>
				</ul></li>
			<li><a href="DonHangController"><i class="fas fa-archive"></i> Quản lý đơn
					hàng</a></li>
			<li><a href="AccountController"><i class="fas fa-info"></i> Quản lý tài
					khoản</a></li>
			<li><a href="ThongTinTaiKhoan"><i class="fa fa-id-badge"
					aria-hidden="true"></i>Trở về tài khoản của bạn</a></li>
			
		</ul>
	</div>
	<div class="right">
		
			
				<h1>Thông tin chi tiết tài khoản</h1>
			
			


					<%
					AccountDetail accountDetail = (AccountDetail) request.getAttribute("accountDetail");
					%>

					<label>Họ tên:</label> <input type=text name="fullName"
						value="<%=accountDetail.getFullName() %>" readonly> <br>
					<label>Giới tính:</label> <input type=text name="gender"
						value="<%=accountDetail.getGender() %>" readonly> <br>
					<label>Ngày sinh:</label> <input type="date" name="birthday"
						value="<%=accountDetail.getBirthday() %>" readonly> <br>
					<label>Địa chỉ:</label> <input type=text name="address"
						value="<%=accountDetail.getAddress() %>" readonly> <br>
					<label>Email:</label> <input type=text name="email"
						value="<%=accountDetail.getEmail() %>" readonly> <br>
					<label>Điện thoại:</label> <input type=text name="phone"
						value="<%=accountDetail.getPhone() %>" readonly>

				</div>
		

</body>
</html>