<%@page import="Login.mvc.model.LoginCase"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
   if(${rCode} == <%=LoginCase.NO_ID%>){
	   alert("로긴 실패( 없는 아이디입니다 )");
   }else if(${rCode} == <%=LoginCase.NO_PWD%>){
	   alert("로긴 실패( 틀린 비번입니다 )");
   }else{
	   alert("💝💘로긴 성공했습니다👀💗");
   }
   
   location.href="../../";
</script>