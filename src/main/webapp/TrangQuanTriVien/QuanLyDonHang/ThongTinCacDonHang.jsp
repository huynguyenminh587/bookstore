<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thống kê các đơn hàng</title>
<link rel="stylesheet" type="text/css" href="css/QuanLyDonHang/ThongTinCacDonHang.css">
<link rel="stylesheet" type="text/css"
	href="font-awesome/css/fontawesome-all.css">
<link rel="stylesheet" type="text/css"
	href="font-awesome/css/fontawesome.css">

</head>
<body>
	<script type="text/javascript"
		src="JavaScript/quanlytaikhoan/ThongTinCacTaiKhoan.js"></script>
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
		
		<div id="wrapper">
			<div id="header">
				<h2>Thống kê đơn hàng</h2>
			</div>
			<div id="container">
				<!-- the nội dung -->
				<div id="content">


					<table>

						<tr>

							<th>username</th>
							<th>quantity</th>
							<th>totalprice</th>
							<th>orderday</th>

							<th></th>
							<th></th>
							<th></th>
							


						</tr>
						<c:forEach var="infos" items="${infos}">


							<tr>
								<td>${infos.userName}</td>
								<td>${infos.quantity}</td>
								
								<td>${infos.totalPrice}</td>
								<td>${infos.orderDate}</td>
								

								


								<td>
									<form action="XemTaiKhoanController" method="post">
										<input type="hidden" value="${infos.accountId}" name="accountId">

										<input type="submit" value="Xem tài khoản">
									</form>
								</td>
								
								<td>
									<form action="OrderInfoDetailController" method="get">
										
										
										<input type="hidden" value="${infos.id }" name="orderId">
										<input type="submit" value="Xem chi tiết đơn hàng">
									</form>
								</td>
								
								<td><form action="XoaDonHangController"
										method="post" onsubmit="return kiemtra()">

										<input type="hidden" value="${infos.id }" name="orderId">
										<input type="submit" value="Xóa đơn hàng">

									</form></td>
								
								
								
							</tr>
						</c:forEach>




					</table>

				</div>
			</div>


		</div>


	</div>

</body>
</html>