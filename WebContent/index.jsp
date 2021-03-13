<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bit Tour</title>
        <link rel="stylesheet" href="css/index.css">
    </head>
    <body>
        <div class="container">
            <div class="header">
                    <div class="nav">
                        <ul>
                            <li><button type="button" onclick="location.href='#'">Home</button></li>
                            <li><button type="button" onclick="location.href='tour/login/login.do'">여행후기</button></li>
                            <li><button type="button" onclick="location.href='tour/qna.do?m=list'">문의하기</button></li>
                            <li><button type="button" onclick="location.href='tour/login/login.do'">로그인</button></li>
                        </ul>
                    </div>
                
            </div>
            <div class="img-container">
                <div class="hero">
                    <h2>Welcome Bit Tour</h2><br/>
                    <p class="kor">비트 투어는 당신의 모든 여행에 함께합니다.</p>
                    <p class="main-sub">Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                    <button type="button" onclick="location.href='tour/main.do?m=spain'">스페인</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="button" onclick="location.href='#'">하노이</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="button" onclick="location.href='#'">도  쿄</button>
                </div>
            </div>
        </div>
    </body>
</html>