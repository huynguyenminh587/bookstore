<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sửa thông tin tác giả</title>
<link rel="stylesheet" type="text/css" href="../css/SuaSach.css">
<link rel="stylesheet" type="text/css"
	href="../font-awesome/css/fontawesome-all.css">
<link rel="stylesheet" type="text/css"
	href="../font-awesome/css/fontawesome.css">

</head>
<body>
<script type="text/javascript" src="../JavaScript/ThemTacGia.js"></script>
	<div class="admin">

		<ul>
			<li class="QuanTriVien"><i class="fas fa-home"></i> Quản trị
				viên</li>

			<li><a href="QuanTriVien.jsp"><i class="fas fa-address-card"></i>
					Trang chủ Quản trị viên</a></li>
			<li><a href="#"><i class="fas fa-align-justify"></i> Quản lý
					danh mục</a>
				<ul class="sub-menu">
					<li><a href="../SachController"> Quản lý sách</a></li>
					<li><a href="../TacGiaController"> Quản lý tác giả</a></li>
					<li><a href="../LayDuLieuThemSuaXoaNhaXuatBan"> Quản lý nhà xuất bản</a></li>
					<li><a href="../LayDuLieuThemSuaXoaLoaiSach"> Quản lý loại sách</a></li>
				</ul></li>
			<li><a href="../DonHangController"><i class="fas fa-archive"></i> Quản lý đơn
					hàng</a></li>
			<li><a href="AccountController"><i class="fas fa-info"></i> Quản lý tài
					khoản</a></li>
			<li><a href="../ThongTinTaiKhoan"><i class="fa fa-id-badge" aria-hidden="true"></i>Trở về tài khoản của bạn</a></li>
			
		</ul>
	</div>
	<div class="right">
		<div class="header">
			<h3>Sửa thông tin tác giả</h3>
		</div>
		<form action="../SuaThongTinTacGiaController" method="get" name="ThemTacGia" onsubmit="return kiemtra()">
			<table> 
				<tbody>
					<tr>
						<td><label>Id: <%=request.getParameter("Id")%></label>
						<td><input type="hidden" value="<%=request.getParameter("Id")%>" name="Id">
					<tr>
						<td><label>NameAuthor: <%=request.getParameter("NameAuthor")%></label></td>
					</tr>
					<tr>
						<td><input type="text" name="NameAuthor"></td>
					</tr>

					<tr>
						<td><label>Birthday: <%=request.getParameter("Birthday") %></label></td>
					</tr>
					<tr>
						<td><input type="text" name="Birthday"></td>
					</tr>
					<tr>
						<td><label>Email: <%=request.getParameter("Email") %></label></td>
					</tr>
					<tr>
						<td><input type="text" name="Email"></td>
					</tr>
					<tr>
						<td><label>Phone: <%=request.getParameter("Phone") %></label></td>
					</tr>
					<tr>

						<td><input type="text" name="Phone"></td>
					</tr>

					

					

				</tbody>
			</table>
			<input type="submit" value="Save" class="save">
			<input type="reset" value="Reset" class="save">
		</form>


	</div>

</body>
</html>
