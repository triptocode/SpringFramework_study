<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>학생 등록</h1>

<%-- <form action="${pageContext.request.contextPath}/student/register" method="post"> --%>
<form action="register2" method="post">
	<input type="text" name="name" placeholder="이름"><br><br>
	<input type="text" name="age" placeholder="나이"><br><br>
	<input type="text" name="score" placeholder="점수"><br><br>
	<input type="submit" value="등록">
</form>