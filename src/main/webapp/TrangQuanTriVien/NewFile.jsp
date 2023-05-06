<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1><%=request.getParameter("Phone")%></h1>

	<table>
		<colgroup>
			<col width="800" span="2">
			<col width="150" span="1">
			<col width=auto span="2">
			<col width="200" span="1">
		</colgroup>
		<tr>
			<th>ISBN</th>
			<th>Title</th>
			<th>Price</th>
			<th>ISBN</th>
			<th>Title</th>
			<th>Price</th>

		</tr>
		<tr>
			<td>80px</td>
			<td>80xp</td>
			<td>150px</td>
			<td>Auto</td>
			<td>Auto</td>
			<td>200px</td>
		</tr>
	</table>

</body>
</html>