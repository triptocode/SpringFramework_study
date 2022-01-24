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
		<c:forEach var="bdto" items="${jspListBoardDto}">
		<tr>
			<td>${bdto.board_no}</td>
			<td>${bdto.board_title}</td>
			<td>${bdto.board_writer}</td>
			<td>
				<fmt:parseDate value="${bdto.board_date}" 
							   var="a" pattern="yyyy-MM-dd HH:mm:ss"/>
				<fmt:formatDate value="${a}" pattern="yyyy-MM-dd"/>
<!--JSP 상단에 fmt  태그 라이브러리 추가후 사용 
fmt:parseDate : String 형을 받아서 워하는 포멧으로 자료형을 Date 형태로 변경 시켜 준다.
fmt:formatDate : Date 형을 받아서 원하는 포멧으로 날짜 형태를 변경시켜 준다.
 -->
			</td>
			<td>${bdto.board_read}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>



<!-- 검색창 구현하기  action 과 method 그리고 URI 관계  
 BoardController의 PostMapping uri 로 form 데이터가 처리되게 연결한다
  action="BoardController - PostMapping의 uri 명칭인 search" 
  method ="BoardController-search는 PostMapping이라서 post" -->
  
<!--<form action="search" method="post"> 대신에
 아래처럼 BoardController의 Uri가 listSearch인 메서드(조회 및 검색기능 통합)를 활용하면 
 boardList와 boardSearch 두개 삭제 가능해져서 코드가 간결해짐 -->
<form action="listSearch" method="post">
<!-- select name="type": 컨트롤러의 @RequestParam String type 과  일치해야한다  --> 	
<!-- select name="xtype" 으로 잘못 입력시 : 404 Required String parameter 'type' is not present -->
<!--(name키 = type, value값="board_title") type이라는 키로  value값board_title(옵션선택시)이 묶여서  함께-> 컨트롤러의  @RequestParam String type에 전달  --> 
	<select name="type">   
	<option value="board_title"  ${param.type == 'board_title' ? 'selected':''}>제목</option>
	<option value="board_writer" ${param.type == 'board_writer' ? 'selected':''} >작성자</option>
	</select>
<!-- option value="xboard_title"으로 잘못 입력시 : SQLSyntaxErrorException-->	
<!-- 삼항연사자인 ${param.type == 'board_writer' ? 'selected':''}를 안넣으면 작성자로 검색시, 제목으로 옵션 바뀜 -->	
	<input type="text" name="keyword" placeholder="검색어" value="${param.keyword}">
	<!--input name="xkeyword"으로 잘못 입력시 : 404 Required String parameter 'keyword' is not present -->
	<input type="submit" value="검색">	
</form>