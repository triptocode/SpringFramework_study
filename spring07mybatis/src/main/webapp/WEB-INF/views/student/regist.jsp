<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>등록 페이지</h1>
 
<form action="regist2" method="post"> <!-- form action=" 컨트롤러의 도착 url" -->
	<input type="text" name="name" placeholder="이름"><br><br>
	<input type="text" name="age" placeholder="나이"><br><br>
	<input type="text" name="score" placeholder="점수"><br><br>
	<input type="submit" value="등록">
</form>