<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="DangKiDangNhap.AccountDetail"%>
<%@page import="DangKiDangNhap.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đơn hàng đã mua</title>
<link rel="stylesheet" type="text/css" href="css/DonHangDaMua.css">
<link rel="stylesheet" type="text/css"
	href="font-awesome/css/fontawesome-all.css">
<link rel="stylesheet" type="text/css"
	href="font-awesome/css/fontawesome.css">
<!-- có sửa dấu ../ -->
</head>
<body>
	<div class="admin">
		<script type="text/javascript"
			src="JavaScript/quanlytaikhoan/ThongTinCacTaiKhoan.js"></script>
		<% Account a = (Account) session.getAttribute("account");
	String userName = a.getUserName();
	int isAdmin = a.getIsAdmin();
%>

		<ul>
			<li class="QuanTriVien"><i class="fas fa-home"></i> Xin chào <%=userName%></li>
			
			<%
              if (isAdmin == 1) {
 			%>

			<li><a href="TrangQuanTriVien/QuanTriVien.jsp"><i
					class="fa fa-unlock-alt" aria-hidden="true"></i> Trang Admin</a></li>
			<%} %>
			<li><a href="TrangChuController"><i
					class="fas fa-address-card"></i> Trở về trang chủ</a></li>
			<li><a href="DonHangDaMuaController"><i
					class="fas fa-align-justify"></i> Đơn hàng đã mua</a></li>
			<li><a href="ThongTinTaiKhoan"><i class="fas fa-archive"></i>
					Thông tin tài khoản</a></li>
			<li><a href="TaiKhoanCuaBan/DoiMatKhau.jsp"><i
					class="fas fa-info"></i>Đổi mật khẩu</a></li>
			<li><a href="DangXuat"><i class="fas fa-user-circle"></i>
					Đăng xuất</a></li>
		</ul>
	</div>
	<div class="right">
		<h1>Đơn hàng đã mua</h1>
		<table>

			<tr>


				<th>quantity</th>
				<th>totalprice</th>
				<th>orderday</th>
				<th></th>
				<th></th>


			</tr>

			<c:forEach var="orderInfos" items="${orderInfos}">
				<tr>

					<td>${orderInfos.quantity }</td>

					<td>${orderInfos.totalPrice }</td>
					<td>${orderInfos.orderDate}</td>

					<td>
						<form action="ChiTietDonHangController" method="get">


							<input type="hidden" value="${orderInfos.id }" name="orderId">
							<input type="submit" value="Xem chi tiết đơn hàng">
						</form>
					</td>

					<td><form action="XoaDonHang" method="post" onsubmit="return kiemtra()">

							<input type="hidden" value="${orderInfos.id }" name="orderId">
							<input type="submit" value="Xóa đơn hàng">

						</form></td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>
