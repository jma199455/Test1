<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!--백터로 넘겨줘서 for문을 써야하기 때문에 taglibrary를 써줘야한다  -->
	<h2> 모든회원보기 </h2>
	<table border="1" bordercolor="gray">
		<tr height="40">
			<td width="50" align="center"> 아이디 </td>
			<td width="200" align="center"> 이메일 </td>
			<td width="150" align="center"> 전화번호 </td>
			<td width="150" align="center"> 취미 </td>
			<td width="150" align="center"> 직업 </td>			
			<td width="100" align="center"> 나이 </td>			
		</tr>
		<!-- items부분은 백터에서 받아온 v를 말한다 -->
		<c:forEach var="bean" items="${v }">
		<tr height="40">
			<td width="50" align="center"> ${bean.id } </td>
			<td width="200" align="center"> <a href="*">${bean.email }</a> </td>
			<td width="150" align="center"> ${bean.tel } </td>
			<td width="150" align="center"> ${bean.hobby } </td>
			<td width="150" align="center"> ${bean.job } </td>			
			<td width="100" align="center"> ${bean.age } </td>			
		</tr>
		</c:forEach>
	
	
	
	
	</table>

</body>
</html>