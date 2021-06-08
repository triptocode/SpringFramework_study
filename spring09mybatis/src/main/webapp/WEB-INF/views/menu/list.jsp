<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<h1>목록</h1>
<p>
	데이터 개수 : ${mlist.size()}
</p>

<c:forEach var="menu" items="${mlist}">
	<h3>${menu.name}, ${menu.price} 원</h3>
</c:forEach>




