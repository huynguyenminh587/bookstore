<%@page import="QuanLyTacGia.TacGia"%>
<%@page import="QuanLyNhaXuatBan.Publisher"%>
<%@page import="QuanLyLoaiSach.BookCategory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thêm sách</title>
<link rel="stylesheet" type="text/css" href="./css/ThemSach.css">
<link rel="stylesheet" type="text/css"
	href="./font-awesome/css/fontawesome-all.css">
<link rel="stylesheet" type="text/css"
	href="./font-awesome/css/fontawesome.css">


</head>
<body>
	<script type="text/javascript" src="./JavaScript/ThemSach.js"></script>
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
			<li><a href="ThongTinTaiKhoan"><i class="fa fa-id-badge" aria-hidden="true"></i>Trở về tài khoản của bạn</a></li>
			
		</ul>
	</div>
	<div class="right">
		<div class="header">
			<h3>Thêm sách</h3>
		</div>
		<form action="ThemSachController" method="get" name="ThemSach"
			onsubmit="return kiemtra()">
			<table>
				<tbody>


					<tr>
						<td><label>Bookname:</label></td>
						<td><input type="text" name="Name" id="Name"></td>
					</tr>

					<tr>
						<td><label>Price: </label></td>
						<td><input type="text" name="Price" id="Price"></td>
					</tr>
					<tr>
						<td><label>Image: </label></td>
						<td><input type="text" name="Image" id="Image"></td>
					</tr>
					<tr>
						<td><label>BookCategory: </label></td>
						<td><select name="BookCategoryId" class="option">
								<%
								List<BookCategory> categoryName = (List<BookCategory>) request.getAttribute("categoryName");
								for (BookCategory a : categoryName) {
								%>
								<option value="<%=a.getId()%>"><%=a.getName()%></option>
								<%
								}
								%>


						</select></td>
					</tr>

					<tr>
						<td><label>Publisher: </label></td>
						<td><select name="PublisherId" class="option">
								<%
								List<Publisher> publisherName = (List<Publisher>) request.getAttribute("publisherName");
								for (Publisher a : publisherName) {
								%>
								<option value="<%=a.getId()%>"><%=a.getNamePublisher() %></option>
								<%
								}
								%>
						</select></td>
					</tr>
					<tr>
						<td><label>Author: </label></td>
						<td><select name="AuthorId" class="option">
								<%
								List<TacGia> authorName = (List<TacGia>) request.getAttribute("authorName");
								for (TacGia a : authorName) {
								%>
								<option value="<%= a.getId()%>"><%=a.getNameAuthor() %></option>
								<%
								}
								%>
						</select></td>
					</tr>
					<tr>
						<td><label>PublishYear: </label></td>
						<td><input type="text" name="PublishYear" id="PublishYear"></td>
					</tr>
					<tr>
						<td><label>TotalPage: </label></td>
						<td><input type="text" name="TotalPage" id="TotalPage"></td>
					</tr>
					<tr>
						<td><label>Language: </label></td>
						<td><input type="text" name="Language" id="Language"></td>
					</tr>
					<tr>
						<td><label>Description: </label></td>
						<td><input type="text" name="Description" id="Description"></td>
					</tr>







				</tbody>
			</table>
			<input type="submit" value="Save" class="save"> <input
				type="reset" value="reset" class="save">
		</form>


	</div>

</body>
</html>
