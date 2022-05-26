<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/member/save-form">회원가입</a>
    <a href="/member/login-form">로그인</a>
    세션에 담은 memberId : ${sessionScope.memberId}    <br>
    세션에 담은 id : ${sessionScope.memberMId} <br>
</body>
</html>
