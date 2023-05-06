<%@page import="java.util.List"%>
<%@page import=" ChiTiet.Sach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- List<Sach> a = (List<Sach>) request.getAttribute("book_list");
	for (Sach p : a) {
		out.println(p.getName());
		out.println(p.getPrice());
		out.println(p.getNameAuthor());
		out.println(p.getNamePublisher());
		out.println(p.getLanguage());
		out.println(p.getId());
		out.println(p.getPublishYear());
		out.println(p.getTotalPage());
		out.println(p.getDescription());
	}}
	%>
	
	-->
	<h1>${sessionScope.user }</h1>
	<img alt="" height="180" width="120" src="images/anh.jpg">
</body>
</html>