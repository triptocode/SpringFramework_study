<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<h1> 구매 가능한 과일  </h1>

<form action="fruit2" method="post">
<%-- form action ="도착할 (컨트롤러) url " --%>
<!--form name ="(컨트롤러) fruit 변수에 담게 된다 " -->
	<input type="checkbox" name="fruit" value="apple"> 사과
	<input type="checkbox" name="fruit" value="kiwi"> 키위
	<input type="checkbox" name="fruit" value="grape"> 포도
	<input type="checkbox" name="fruit" value="cherry"> 체리
	
	
	<br><br>
	<input type="submit" value="장바구니 담기">
	
</form>


