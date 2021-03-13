<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*, Domain.Qna, Qna.mvc.vo.ListResult"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Bit Tour : 문의</title>
        <link rel="stylesheet" href="../css/qna.css" />
        <link rel="stylesheet" href="../css/semantic.min.css" />
        <link rel="stylesheet" href="../css/index.css" />
    </head>
    <body>
        <div class="header">
            <div class="nav">
                <ul>
                    <li><button type="button" onclick="location.href='../'">Home</button></li>
                    <li><button type="button" onclick="location.href='tour/login/login.do'">여행후기</button></li>
                    <li><button type="button" onclick="location.href='main.do?m=spain'">문의하기</button></li>
                    <li><button type="button" onclick="location.href='login/login.do'">로그인</button></li>
                </ul>
            </div>
        </div>
        <!-- nav끝 -->
        <div class="ui middle aligned center aligned grid">
            <div class="column">
                <h2 class="ui teal image header">
                    문&nbsp;&nbsp;의
                </h2>
                <br />
                <br />
                <br />
                <br />
                <div class="ui large form">
                    <div class="ui stacked segment">
                        <a href="qna.do?m=write">
                            <button class="ui fluid large teal sumbit button">질문 작성하기</button>
                        </a>
                        <table class="ui celled table">
                            <thead>
                                <tr class="col_name">
                                    <th>번호</th>
                                    <th>작성자</th>
                                    <th>제목</th>
                                    <th>내용</th>
                                    <th>작성일</th>
                                </tr>
                            </thead>
                            <tbody id="list">
                                <c:forEach items="${listResult.list}" var="list">
                                    <tr>
                                        <td>${list.seq}</td>

                                        <c:choose>
                                            <c:when test="${list.level>0}">
                                                <td>관리자</td>
                                                <td></td>
                                                <td>
                                                    <c:forEach begin="1" end="${list.level}" step="1">
                                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                                    </c:forEach>
                                                    <a href="qna.do?m=content&no=${list.seq}">ㄴ 답변</a>
                                                </td>
                                            </c:when>
                                            <c:otherwise>
                                                <td>${list.name}</td>
                                                <td>${list.subject}</td>
                                                <td><a href="qna.do?m=content&no=${list.seq}">${list.content}</a></td>
                                            </c:otherwise>
                                        </c:choose>

                                        <td>${list.rdate}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <c:forEach begin="1" end="${listResult.totalPageCount}" var="i">
                            <a href="qna.do?cp=${i}">
                                <c:choose>
                                    <c:when test="${i==listResult.currentPage}">
                                        <strong>${i}</strong>
                                    </c:when>
                                    <c:otherwise>
                                        ${i}
                                    </c:otherwise>
                                </c:choose>
                            </a>
                            &nbsp;&nbsp;
                        </c:forEach>
                        <div align="right"> ${listResult.currentPage}&nbsp;&nbsp;/&nbsp;&nbsp;${listResult.totalPageCount} </div>
                    </div>
                    <div class="ui error message"></div>
                </div>
            </div>
        </div>
        <div class="ui modal" id="view_modal">
            <i class="close">x</i>
            <div class="header" id="b_title"></div>
            <div class="content">
                <div class="description">
                    <p style="text-align: right;" id="b_review"></p>
                    <div id="b_content"></div>
                </div>
            </div>
            <div class="actions">
                <div class="ui black deny button">닫기</div>
            </div>
        </div>
    </body>
</html>
