<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="../../css/style.css">
    <script src="https://kit.fontawesome.com/51db22a717.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css2?family=Alata&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../css/qna.css">
        <link rel="stylesheet" href="../../css/semantic.min.css">
      <link rel="stylesheet" href="../../css/index.css">        
    <script language="javascript"> 
</script>
</head>
<body>
	<div class="container">
            <div class="header">
                    <div class="nav">
                        <ul>
                            <li><button type="button" onclick="location.href='#'">회원</button></li>
                            <li><button type="button" onclick="location.href='tour/main.do?m=qna'">결제</button></li>
                            <li><button type="button" onclick="location.href='tour/login/review.do'">후기쓰기</button></li>
                            <li><button type="button" onclick="location.href='tour/main.do?m=product'">상품</button></li>
                            <li><button type="button" onclick="location.href='tour/main.do?m=qna'">Q&A</button></li>
                        </ul>
                    </div>  
               </div>
	
    <div class="page-container">
        <div class="login-form-container shadow">
            <div class="login-form-right-side">
                <div class="top-logo-wrap">
                    
                </div>
                <h1>비트투어와 떠나는<br>즐거운 여행을<br>경험해보세요~</h1>
                <p>다시 만나고 싶은 여행 - 비트투어는 해외여행, 국내여행, 패키지여행, 에어텔, 항공권, 호텔 등 각종 여행정보를 제공하는 국내 최대 여행포탈사이트 입니다.</p>
            </div>
            <div class="login-form-left-side">
                <div class="login-top-wrap">
                    <span>비트투어의 가족이 되어주세요👉</span>
                    <a href="login.do?m=join" class="create-account-btn shadow-light">회원가입</a>
                </div>
                    <form name="f" action="../../tour/login/login.do?m=check" method="post">                
                <div class="login-input-container">
                    <div class="login-input-wrap input-id">
                        <i class="far fa-envelope"></i>
                        <input name="email" placeholder="email" type="text">
                    </div>
                    <div class="login-input-wrap input-password">
                        <i class="fas fa-key"></i>
                        <input name="pwd" placeholder="Password"  type="password">
                    </div>
                </div>
                <div class="login-btn-wrap">
                    <!-- <button class="login-btn">로그인</button> -->                   
                    <!-- <a href="login.do?m=check" >로그인</a>  -->
                    	<button type="submit">로그인</button>
                    </form>
                    <a href="login.do?m=findId" >아이디찾기</a>
                    <a href="login.do?m=findPwd" >비밀번호찾기</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>