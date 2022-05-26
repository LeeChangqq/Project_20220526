<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="/resources/js/jquery.js"></script>
</head>
<body>
<div class="container">
    <div class="display-4 fw-normal">
        <form action="/member/save" method="post" enctype="multipart/form-data">
            <input type="text" name="mId" placeholder="아이디" class="form-control mb-2">
            <input type="text" name="mPass" placeholder="비밀번호" class="form-control mb-2">
            <input type="text" name="mName" placeholder="이름" class="form-control mb-2">
            <input type="text" name="mEmail" placeholder="이메일" class="form-control mb-2">
            <input type="text" name="mPhone" placeholder="전화번호" class="form-control mb-2">
<%--            <input type="file" name="mPro" placeholder="프로필 설정" class="form-control mb-2">--%>
            <input type="submit" value="가입하기" class="btn btn-primary">
        </form>
    </div>
</div>
</body>
<script>

</script>
</html>
