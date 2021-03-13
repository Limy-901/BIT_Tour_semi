<%@ page language='java' contentType='text/html; charset=UTF-8'
   pageEncoding='UTF-8'
   import='Domain.Member'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 
<html>
   <c:if test='${empty Member}'></c:if>
   <head>
      <title>Join</title>
      <!-- <link rel='stylesheet' type='text/css' href='../../css/join.css'> -->
      <link rel="stylesheet" href="../../css/qna.css">
      <link rel="stylesheet" href="../../css/semantic.min.css">
      <link rel="stylesheet" href="../../css/bootstrap.min.css">
           
      <!-- <link rel='stylesheet'href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css?ver=1'> -->
   </head>
   <body>
      <div class="container">
      <!-- <div class="header">
                    <div class="nav">
                        <ul>
                            <li><button type="button" onclick="location.href='#'">회원</button></li>
                            <li><button type="button" onclick="location.href='tour/main.do?m=qna'">결제</button></li>
                            <li><button type="button" onclick="location.href='tour/login/review.do'">후기쓰기</button></li>
                            <li><button type="button" onclick="location.href='tour/main.do?m=product'">상품</button></li>
                            <li><button type="button" onclick="location.href='tour/main.do?m=qna'">Q&A</button></li>
                        </ul>
                    </div>  
               </div> -->
         <div class='join-form-box'>   
            <center><h1> 회원가입 양식 </h1></center>
            <div class='booking-form'>
            </div>
         <form name="f" action="../../tour/login/login.do?m=insert" method="post">
            <table class='join-t2'>
	            <tr class='e-mail'>
	               <td><span style='color:white'>E-mail</span> <span style='color:red;'>*</span></td>
	               <td><input name ='email' type='email' name='user_email1'   value='${dto.email}' ></td>
	            </tr>
               <tr>
                  <td><span style='color:white'>비밀번호</span> <span style='color:red;'>*</span></td>
                  <td><input name ='pwd' type='password' name='user_pwd1' value='${dto.pwd}'></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               <tr>
                  <td><span style='color:white'>이름</span> <span style='color:red;'>*</span></td>
                  <td class='name-box'><input name ='name' type='text' name='user_name' value='${dto.name}'></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               <tr>
                  <td><span style='color:white'>닉네임</span> <span style='color:red;'>*</span></td>
                  <td class='name-box'><input name ='nickname' type='text' name='nick_name' value='${dto.nickname}'></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               <tr>
                  <td><span style='color:white'>핸드폰</span> <span style='color:red;'>*</span></td>
                  <td class='name-box'><input name='phone' type='text' name='user_nickname' placeholder='11자 ex) 01023456789' value='${dto.phone}'></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               <tr>
                  <td><span style='color:white'>가입일</span> <span style='color:red;'>*</span></td>
                  <td class='rdate-box'><input name='rdate' type='text' name='user_rdate' placeholder='8자 ex) 19880808' value='${dto.rdate}'></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               <tr>
                  <td><span style='color:white'>여행횟수</span> <span style='color:red;'>*</span></td>
                  <td class='rdate-box'><input name='tripno' type='text' name='user_rdate' value='${dto.tripno}' ></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               <tr>
                  <td><span style='color:white'>생년월일</span> <span style='color:red;'>*</span></td>
                  <td class='birth-box'><input name='bdate' type='text' name='user_birth' placeholder='8자 ex) 19880808' value='${dto.bdate}'></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               <tr>
                  <td><span style='color:white'>탈퇴여부</span> <span style='color:red;'>*</span></td>
                  <td><label class='radiobox'><input name='withdrawal' type='radio' name='fruit' value='apple' style='width:15px;height:15px;cursor:pointer;' value='${dto.withdrawal}'> <span class='fm' style='color:white'>예</span></label>
                     <label class='radiobox2'><input name='withdrawal' type='radio' name='fruit' value='banana' style='width:15px;height:15px;cursor:pointer;' value='${dto.withdrawal}'> <span class='fm' style='color:white'>아니오</span></label>
                  </td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               
            </table>
            <table class='join-t3'>
               <tr>
                  <td colspan='2' align='center'>
                     <!-- <form name="f" action="../../tour/login/login.do?m=insert" method="post"> -->
                     <input type='submit' value='가입' />&nbsp;&nbsp;&nbsp;
                     <input type='reset' value='수정'/>                   
                     </div>
                  </td>
              </tr>
         	</table>
         </form>
      </div>
     
   </body>
</html>