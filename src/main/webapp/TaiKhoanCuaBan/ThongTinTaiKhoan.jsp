<%@page import="DangKiDangNhap.AccountDetail"%>
<%@page import="DangKiDangNhap.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Tài khoản của bạn</title>
<link rel="stylesheet" type="text/css" href="css/ThongTinTaiKhoan.css">
<link rel="stylesheet" type="text/css"
	href="font-awesome/css/fontawesome-all.css">
<link rel="stylesheet" type="text/css"
	href="font-awesome/css/fontawesome.css">
<!-- có sửa dấu ../ -->
</head>
<body>
	<div class="admin">
<% Account a=(Account)session.getAttribute("account");
   String userName=a.getUserName();
   int isAdmin=a.getIsAdmin();
%>
		<ul>
			<li class="QuanTriVien"><i class="fas fa-home"></i> Xin chào <%=userName %> </li>
			<%if(isAdmin==1){ %>
			<li><a href="TrangQuanTriVien/QuanTriVien.jsp"><i class="fa fa-unlock-alt" aria-hidden="true"></i> Trang Admin</a></li>
			<%} %>
			<li><a href="TrangChuController"><i class="fas fa-address-card"></i> Trở về trang chủ</a></li>
			<li><a href="DonHangDaMuaController"><i class="fas fa-align-justify"></i> Đơn hàng đã mua</a>
				</li>
			<li><a href="#"><i class="fas fa-archive"></i> Thông tin tài khoản</a></li>
			<li><a href="TaiKhoanCuaBan/DoiMatKhau.jsp"><i class="fas fa-info"></i>Đổi mật khẩu</a></li>
			<li><a href="DangXuat"><i class="fas fa-user-circle"></i> Đăng xuất</a></li>
		</ul>
	</div>
	<div class="right">
	   <h1>Thông tin tài khoản</h1>
		<div id="form">
		<%AccountDetail accountDetail=(AccountDetail)request.getAttribute("accountDetail"); %>
		<form action="TaiKhoanCuaBan/CapNhatThongTinTaiKhoan.jsp" method="get">
		<label>Họ tên:</label> <input type=text name="fullName" value="<%=accountDetail.getFullName()%>" readonly>
		<br>
		<label>Giới tính:</label> <input type=text name="gender" value="<%=accountDetail.getGender() %>" readonly>
		<br>
		<label>Ngày sinh:</label> <input type="date" name="birthday" value="<%=accountDetail.getBirthday() %>" readonly>
		<br>
		<label>Địa chỉ:</label> <input type=text name="address" value="<%=accountDetail.getAddress() %>" readonly>
		<br>
		<label>Email:</label> <input type=text name="email" value="<%=accountDetail.getEmail() %>" readonly>
		<br>
		<label>Điện thoại:</label> <input type=text name="phone" value="<%=accountDetail.getPhone() %>" readonly>
		<br>
		<input class="submit" type="submit" value="Cập Nhật">
        </form>
        </div>

	</div>

</body>
</html>
