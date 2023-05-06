<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>QuanTriVien</title>
<link rel="stylesheet" type="text/css" href="../css/QuanTriVien.css">
<link rel="stylesheet" type="text/css"
	href="../font-awesome/css/fontawesome-all.css">
<link rel="stylesheet" type="text/css"
	href="../font-awesome/css/fontawesome.css">

</head>
<body>
	<div class="admin">

		<ul>
			<li class="QuanTriVien"><i class="fas fa-home"></i> Quản trị
				viên</li>

			<li><a href="QuanTriVien.jsp"><i class="fas fa-address-card"></i> Trang
					chủ Quản trị viên</a></li>
			<li><a href="#"><i class="fas fa-align-justify"></i> Quản lý
					danh mục</a>
				<ul class="sub-menu">
					<li> <a href="../SachController"> Quản lý sách</a></li>
					<li> <a href="../TacGiaController"> Quản lý tác giả</a></li>
					<li> <a href="../LayDuLieuThemSuaXoaNhaXuatBan"> Quản lý nhà xuất bản</a></li>
					<li> <a href="../LayDuLieuThemSuaXoaLoaiSach"> Quản lý loại sách</a></li>
				</ul></li>
			<li><a href="../DonHangController"><i class="fas fa-archive"></i> Quản lý đơn
					hàng</a></li>
			<li><a href="../AccountController"><i class="fas fa-info"></i> Quản lý tài
					khoản</a></li>
			<li><a href="../ThongTinTaiKhoan"><i class="fa fa-id-badge" aria-hidden="true"></i>Trở về tài khoản của bạn</a></li>
			
		</ul>
	</div>
	<div class="right">
		<!-- 		<h1>phai</h1> -->
		


	</div>

</body>
</html>
