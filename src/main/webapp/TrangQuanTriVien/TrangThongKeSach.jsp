<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Trang thống kê sách</title>
<link rel="stylesheet" type="text/css" href="./css/TrangThongKeSach.css">
<link rel="stylesheet" type="text/css"
	href="./font-awesome/css/fontawesome-all.css">
<link rel="stylesheet" type="text/css"
	href="./font-awesome/css/fontawesome.css">

</head>
<body>
<script type="text/javascript" src="./JavaScript/XoaSach.js"></script>
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
					<li><a href="LayDuLieuThemSuaXoaNhaXuatBan"> Quản lý nhà xuất bản</a></li>
					<li><a href="LayDuLieuThemSuaXoaLoaiSach"> Quản lý loại sách</a></li>
				</ul></li>
			<li><a href="DonHangController"><i class="fas fa-archive"></i> Quản lý đơn
					hàng</a></li>
			<li><a href="AccountController"><i class="fas fa-info"></i> Quản lý tài
					khoản</a></li>
			<li><a href="ThongTinTaiKhoan"><i class="fa fa-id-badge" aria-hidden="true"></i>Trở về tài khoản của bạn</a></li>
			
		</ul>
	</div>
	<div class="right">
		<!-- 		<h1>phai</h1> 
		<input type="search" placeholder="Tìm kiếm" name="Tên">-->
		<div id="wrapper">
			<div id="header">
				<h2>Bảng thống kê sách</h2>
			</div>
			<div id="container">
				<!-- the nội dung -->
				<div id="content">
					<!-- put new button:Add Student -->
					<input type="button" value="Thêm Sách"
						onclick="window.location.href='CategoryPublisherAuthorController';return false;"
						class="add-student-button">
					<!-- thẻ nội dung
                                 
 id : là vùng chọn selector của thẻ (bạn có thể chọn class đều được. Nhưng vì đây là các thẻ chính của trang web nên khuyên bạn nên dùng id).
 id = “wrapper” : là vùng chọn bao quanh toàn bộ nội dung bên trong trang web. Nói dễ hiểu là vùng chọn Cha.
 id = “header” : Là vùng chọn trên cùng trang web. Thường là để các banner, logo.
 id = “menu” : là vùng chọn menu của website
 id = “left” : là vùng chọn nội dung bên tay trái trang web
 id = “content” : là vùng chọn nội dung chính trang web.
 id = “right” : là vùng chọn nội dung bên tay phải trang web
 id = “footer” : là vùng chọn dưới chân trang web.       
                                 
   -->

					<table>

						<tr>

							<th>Id</th>
							<th>BookName</th>
							<th>Price</th>
							<th>Image</th>
							<th>BookCategory</th>
							<th>NamePublisher</th>
							<th>NameAuthor</th>
							<th>PublishYear</th>
							<th>TotalPage</th>
							<th>Language</th>
							<th></th>
							<th></th>


						</tr>
						<c:forEach var="tempSach" items="${Sach}">


							<tr>
								<td>${tempSach.id}</td>
								<td>${tempSach.name}</td>
								<td>${tempSach.price}đồng</td>
								<td><img width="100" height="130" src="${tempSach.image}"></td>
								<td>${tempSach.bookCategory}</td>
								<td>${tempSach.namePublisher}</td>
								<td>${tempSach.nameAuthor }</td>
								<td>${tempSach.publishYear}</td>
								<td>${tempSach.totalPage}</td>
								<td>${tempSach.language }</td>

								<td>
									<form action="CategoryPublisherAuthorController">
										<input type="hidden" value="${tempSach.id}" name="Id">
										<input type="hidden" value="${tempSach.name}" name="Name">
										<input type="hidden" value="${tempSach.price}" name="Price">
										<input type="hidden" value="${tempSach.image}" name="Image">
										
										<input type="hidden" value="${tempSach.publishYear}" name="PublishYear">
										<input type="hidden" value="${tempSach.totalPage}" name="TotalPage">
										<input type="hidden" value="${tempSach.language}" name="Language">
										<input type="hidden" value="${tempSach.description}" name="Description">
										<input type="submit" value="Sửa" >
									</form>
								</td>
								<td><form action="XoaSachController" method="get" name="XoaSach" onsubmit="return kiemtra()">
								<input type="hidden" value="${tempSach.id}" name="Id">
								<input type="submit" value=xóa>
								
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