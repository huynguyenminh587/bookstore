<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nhà Sách Vinh Thanh</title>
<link rel="stylesheet" type="text/css" href="css/TrangChu.css" />
<link rel="stylesheet" type="text/css"
	href="font-awesome/css/fontawesome-all.css">
<!-- mới thêm 2 dòng -->
<link rel="stylesheet" type="text/css"
	href="font-awesome/css/fontawesome.css">
</head>
<body>


	<div id="menu_top">
		<ul>
			<li><a href="TrangChuController" class="active">Trang Chủ</a></li>
			<% if(session.getAttribute("account")==null){ %>
				<li><a  href="DangNhap.jsp"
					title="Đăng nhâp/Đăng ký">Đăng nhâp/Đăng ký</a></li>
			<%}else{ %>
			 
				<li><a href="ThongTinTaiKhoan" title="Thông tin tài khoản">Thông tin tài khoản </a></li>
			<%} %>
			<!--  <h1session.getAttribute("user")r") %></h1>
			<h1>${sessionScope.user }</h1>-->

			<li><a>
					<form action="TimKiemController">
						<button>Tìm kiếm</button>
						<input type="text" name="Tensachcantim">


					</form>
			</a></li>
			<li><a href="GioHang.jsp" title="Giỏ hàng">Giỏ hàng</a></li>
		</ul>

	</div>
	<div id="banner">
		<h2>Nhà Sách Vinh Thanh</h2>
		<img src="images/banner.jpg">

	</div>
	<div id="main">
		<div id="left">

			<ul>
				<c:forEach var="tempSach" items="${book_list }">
					<li><img width="120" height="180" src="${tempSach.image}">
						<h3>${tempSach.name}</h3>
						<h4>${tempSach.price}đồng</h4>
						<form class="chitiet" action="CartController" method="get">
							<input type="hidden" name="teservlet" value=""> <input
								type="hidden" name="name" value="${tempSach.name}"> <input
								type="hidden" name="price" value="${tempSach.price}"> <input
								type="hidden" name="image" value="${tempSach.image}">
							<button>
								<div style="font-size: 13px;">
									<i class="fas fa-cart-plus"></i>
								</div>
							</button>
						</form>
						<form class="chitiet" action="ChiTietController" method="get">
							<input type="hidden" value="${tempSach.id}" name="id">
							<button>Chi Tiết</button>
						</form></li>


				</c:forEach>

			</ul>






		</div>
		<div id="right">

			<div class="menu_right">
				<h3>Danh mục sách</h3>
				<ul>
					<li><a href="DanhMucSachController?param=2">Sách Kỹ Năng
							Sống</a></li>
					<li><a href="DanhMucSachController?param=3">Sách quản
							lý-kinh doanh</a></li>
					<li><a href="DanhMucSachController?param=4">Sách kiến thức
							bách khoa</a></li>
					<li><a href="DanhMucSachController?param=5">Sách tình yêu</a></li>


				</ul>

			</div>

			<img src="images/anhsachdep.jpg">


		</div>
	</div>
	<div id="footer">
		<!-- <h4>Nhà sách Vinh Thanh</h4> -->
		<p>Nhà sách Vinh Thanh.Địa chỉ:Hòa Khánh,Liên Chiểu,Đà Nẵng.Điện
			thoại:0365477388</p>

	</div>
</body>
</html>
