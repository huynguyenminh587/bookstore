<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="QuanLyTacGia.TacGia"%>
<%@page import="QuanLyNhaXuatBan.Publisher"%>
<%@page import="QuanLyLoaiSach.BookCategory"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sửa sách</title>
<link rel="stylesheet" type="text/css" href="./css/SuaThongTinSach.css">
<link rel="stylesheet" type="text/css"
	href="./font-awesome/css/fontawesome-all.css">
<link rel="stylesheet" type="text/css"
	href="./font-awesome/css/fontawesome.css">

</head>
<body>
	<script type="text/javascript" src="./JavaScript/SuaSach.js"></script>
	<div class="admin">

		<ul>
			<li class="QuanTriVien"><i class="fas fa-home"></i> Quản trị
				viên</li>

			<li><a href="QuanTriVien.jsp"><i class="fas fa-address-card"></i>
					Trang chủ Quản trị viên</a></li>
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
			<h3>Sửa Sách</h3>
		</div>
		<form action="SuaSachController" method="get" name="SuaSach"
			onsubmit="return kiemtra()">
			<table>
				<tbody>
					<tr>
						<td><label>Id: <%=request.getParameter("Id")%></label>
						<td><input type="hidden"
							value="<%=request.getParameter("Id")%>" name="Id">
					<tr>
						<td><label>Bookname:</label></td>
					</tr>

					<tr>
						<td><input type="text" name="Name"
							value=" <%=request.getParameter("Name")%>"></td>
					</tr>

					<tr>
						<td><label>Price:</label></td>
					</tr>

					<tr>
						<td><input type="text" name="Price"
							value="<%=request.getParameter("Price")%>"></td>
					</tr>
					<tr>
						<td><label>Image: </label></td>
					</tr>

					<tr>
						<td><input type="text" name="Image"
							value="<%=request.getParameter("Image")%>"></td>
					</tr>
					<tr>
						<td><label>BookCategory: </label></td>
					</tr>
					<tr>

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
						<td><label>Publisher:</label></td>
					</tr>
					<tr>
						<td><select name="PublisherId" class="option">
								<%
								List<Publisher> publisherName = (List<Publisher>) request.getAttribute("publisherName");
								for (Publisher a : publisherName) {
								%>
								<option value="<%=a.getId()%>"><%=a.getNamePublisher()%></option>
								<%
								}
								%>
						</select></td>
					</tr>
					<tr>
						<td><label>Author:</label></td>
					</tr>
					<tr>
						<td><select name="AuthorId" class="option">
								<%
								List<TacGia> authorName = (List<TacGia>) request.getAttribute("authorName");
								for (TacGia a : authorName) {
								%>
								<option value="<%=a.getId()%>"><%=a.getNameAuthor()%></option>
								<%
								}
								%>
						</select></td>
					</tr>
					<tr>
						<td><label>PublishYear: </label></td>
					</tr>

					<tr>
						<td><input type="text" name="PublishYear"
							value="<%=request.getParameter("PublishYear")%>"></td>
					</tr>
					<tr>
						<td><label>TotalPage: </label></td>
					</tr>
					<tr>
						<td><input type="text" name="TotalPage"
							value="<%=request.getParameter("TotalPage")%>"></td>
					</tr>
					<tr>
						<td><label>Language: </label></td>
					</tr>
					<tr>
						<td><input type="text" name="Language"
							value="<%=request.getParameter("Language")%>"></td>
					</tr>
					<tr>
						<td><label>Description: </label></td>
					</tr>

					<tr>
						<td><input type="text" name="Description"
							value="<%=request.getParameter("Description")%>"></td>
					</tr>



				</tbody>
			</table>
			<input type="submit" value="Save" class="save"> <input
				type="reset" value="Reset" class="save">
		</form>


	</div>

</body>
</html>
