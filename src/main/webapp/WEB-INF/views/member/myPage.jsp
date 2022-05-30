<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-30
  Time: 오전 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
    <form action="/member/update" method="post" name="updateForm" enctype="multipart/form-data">
        <input type="hidden" class="form-control mb-2"  name="id" placeholder="아이디" value="${updateMember.id}" readonly>
        <input type="text" class="form-control mb-2" name="mId" placeholder="아이디" value="${updateMember.mId}" readonly>
        <input type="text" class="form-control mb-2" name="mPass" placeholder="비밀번호" id="pwConfirm">
        <input type="hidden" class="form-control mb-2" name="mPass2" placeholder="비밀번호" value="${updateMember.mPass2}">
        <input type="text" class="form-control mb-2" name="mName" placeholder="이름" value="${updateMember.mName}">
        <input type="text" class="form-control mb-2" name="mEmail" placeholder="이메일" value="${updateMember.mEmail}">
        <input type="text" class="form-control mb-2" name="mPhone" placeholder="전화번호" value="${updateMember.mPhone}">
        <input type="file" class="form-control mb-2" name="mFile" placeholder="파일이름" value="${updateMember.mFile}">
        <input class="btn btn-primary" type="button" value="정보수정" onclick="update()">
    </form>
</body>
<script>
    const  update = () => {
        const pass = document.getElementById("pwConfirm").value;
        const passDB = "${updateMember.mPass}";
        if(pass == passDB) {
            updateForm.submit();
        }else {
            alert("비밀번호가 틀립니다.");
        }
    }
</script>
</html>
