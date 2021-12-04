<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<h1>게시판 목록</h1>
<table border = "1">
<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
</thead>
	<tbody>
		<c:forEach var="bdto" items="${modelList}">
		<tr>
			<td>${bdto.board_no}</td>
			<td>${bdto.board_title}</td>
			<td>${bdto.board_writer}</td>
			<td>${bdto.board_date}</td>
			<td>${bdto.board_read}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
		
		
		