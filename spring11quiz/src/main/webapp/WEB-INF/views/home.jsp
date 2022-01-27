<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1> 상품 관리 </h1>
<h3><a href="add"> 상품 등록 </a> </h3>
<h3><a href="${pageContext.request.contextPath}/item/add"> 상품 등록 </a></h3>
<h3><a href="list"> 상품 목록 </a></h3>
<h3><a href="<%=request.getContextPath()%>/item/list"> 상품 목록 </a></h3>