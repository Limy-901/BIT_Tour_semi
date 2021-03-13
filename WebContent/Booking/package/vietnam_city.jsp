<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    autoFlush="true"
    %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="package.css?ver=1">
</head>
<body>
    <div class="wrapper">
        <div class="title">
            <h1>어디로 떠날까?</h1>
        </div>
        <ul class="package">      
            <li class="package-item" OnClick="location.href ='../flight&hotel/booking.jsp'" style="cursor:pointer";>
                   <div class="intro">                      
                        <img src="../image/city1.jpg">
                        <div class="intro-contents">
                            <h2>하노이<span>3박4일 1,200,000원</span></h2>
                        </div>
                   </div>
            </li>
            <li class="package-item" OnClick="location.href ='../flight&hotel/booking.jsp'" style="cursor:pointer";>     
                <div class="intro">
                    <img src="../image/city2.jpg">
                    <div class="intro-contents">
                        <h2>호치민<span>3박4일 1,100,000원</span></h2>
                    </div>
                </div>
            </li>
            <li class="package-item" OnClick="location.href ='../flight&hotel/booking.jsp'" style="cursor:pointer";>     
                <div class="intro">
                    <img src="../image/city1.jpg">
                    <div class="intro-contents">
                        <h2>다낭<span>5박6일 1,300,000원 </span></h2>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</body>
</html>