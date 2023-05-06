<%@page import="DangKiDangNhap.Account"%>
<%@page import="giohang.item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Gio Hang</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/GioHang.css">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<script src="JavaScript/GioHang.js"></script>
	<div class ="container">
		<div>
			<div class="products">
				<%
				//để ngoài vòng if else để luôn được tạo
				if(session.getAttribute("cart")!=null){
				
					 
						
				%>
				<c:forEach var="item" items="${sessionScope.cart}" >
				 
				 
				<div class="product">
					<img width="120" height="180" src="${item.image }">
					<div class="product-info">
						<h3 class="product-name">${item.name }</h3>
						<h2 class="product-price">${item.price }đ</h2>
						<p class="product-quantity">Số Lượng: ${item.quantity}</p>
						<p class="product-remove">
							
							
                               <form class="thembotxoa" action="TinhToanSanPham" >
                                  <input type="hidden" value="${item.name}" name="tensp">
                                  <input type="hidden" value="${item.quantity}" name="soluong">
                                  <input type="submit" value="+" name="action">
                                  <input type="submit" value="-" name="action">
                                  <input type="submit" value="xóa" name="action">
                                </form>
                            
						</p>
					</div>
					
				</div>
				</c:forEach>
				
			</div>
			<%
             }//dấu này của lệnh else
			%>
			<%
			int tongtien=0;
			int soluong=0;
			if(session.getAttribute("cart")!=null){
				List<item> cart=(List<item>)session.getAttribute("cart");
				for(item p:cart){
					soluong=soluong+p.getQuantity();
					tongtien=tongtien+p.getPrice();
				  }
			
			}
			%>
			<div class="cart-total">
				<p>
				    <span style="color:blue ;font-size:50px;" id="tinhtien"></span>
				    <br>
				    
					<span>Số lượng</span>
					<span><%=soluong%></span>

				</p>
				<p>
					<span>Tổng Tiền</span> <!--Thẻ trung tinh -->
					<span><%=tongtien%> đồng</span>
				</p>
				<%
				Account account =(Account)session.getAttribute("account");
				if((account!=null)&&(session.getAttribute("cart")!=null)){
				%>
				 <a href="#" onclick="guidiserver()">Tính tiền</a>
				<!-- <button onclick="guidiserver()">Tính tiền</button>-->
				<%}else{
					if((account!=null)&&(session.getAttribute("cart")==null))
				{ %>
				<a href="TrangChuController">Hãy mua hàng</a>
				<% }else{%>
				<a href="DangNhap.jsp">Đăng nhập để tính tiền</a>
				<%}
					} %>
				<a href="TrangChuController">Tiếp tục mua</a>
                
			</div>
		</div>
		
	</div>

</body>
</html>