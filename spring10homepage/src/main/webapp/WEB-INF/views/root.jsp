<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>




<!-- 아래 3개중 하나로 표현 가능  -->
    
   <h1> 현재 로그인 상태 : ${sessionScope.userinfo!=null}  </h1> 
   <h1> 현재 로그인 상태 : ${userinfo!=null}  </h1> 
   <h1> 현재 로그인 상태 : ${not empty userinfo}  </h1> 
         