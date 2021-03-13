<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
  <title>BIT Tour </title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="../../css/qna.css">
		<link rel="stylesheet" href="../../css/semantic.min.css">
		<link rel="stylesheet" href="../../css/index.css">        
		<link rel="stylesheet" href="../../css/bootstrap.min.css">
 

	<!-- 위에까지는 템플릿 -->

	<!-- 추가한 부분 (로그인 확인 js)-->

</head>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300" onload="document.f.id.focus()">

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
  <div class="site-wrap" >

    <div class="site-section bg-light" >
      <div class="container">
        <div class="row" >
			
          <div class="col-lg-12">
            <div class="section-title mb-5" style="margin-top:100px;">
              <h1 >비밀번호 찾기</h1>
            </div>
  				
          </div>
          <div class="search-div">

		<form action="login.do?m=foundPwd" method="post">

			  <div class="row">
                <div class="col-md-12 form-group">
                   <label for="id">핸드폰</label>     
                     <input class="form-control form-control-lg" name="phone" size="20" align="center" value='${dto.phone}'>
               </div>
             </div>
              <div class="row">
                <div class="col-md-12 form-group">
                  <label for="email">이메일</label>
                  <input class="form-control form-control-lg" size="20" align="center" name="email" placeholder="ex) mail@email.com" value='${dto.email}'>
                   
                </div>
             </div>
			
                <br/> <br/>
                      <div class="col-12">
                          <input type="submit" value="find" class="btn btn-primary py-3 px-5">
                      </div>
                  
		</form>
		</div>

</div>
          
        </div>

        
      </div>
    </div>

 
  </div>
  <!-- .site-wrap -->


</body>

</html>