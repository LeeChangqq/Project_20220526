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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="display-4 fw-normal">
        <a href="/member/save-form" class="form-control">회원가입</a>
        <a href="/member/login-form" class="form-control">로그인</a>
    </div>
</div>
<%--    세션에 담은 memberId : ${sessionScope.memberId}    <br>--%>
<%--    세션에 담은 id : ${sessionScope.memberMId} <br>--%>
</body>
</html>
