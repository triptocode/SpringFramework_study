<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <h1> 회원목록 </h1>
    
    <table border ="1">
      <thead>
       <tr>
             <th>아이디</th>
             <th>닉네임</th>
             <th>권한</th>

       </tr>     
      </thead>
      <tbody>
      <c:forEach var="mdto" items="${modelList}">
          <tr>    
              <td>${mdto.member_id}</td>
              <td>${mdto.member_nick}</td>
              <td>${mdto.member_auth}</td>
          </tr>
       </c:forEach>       
      </tbody>
    </table>