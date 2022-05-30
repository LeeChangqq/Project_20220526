<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-24
  Time: 오후 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<form action="/board/update" method="post" name="updateForm">
    <input type="hidden" class="form-control mb-2" name="id" value="${board.id}" readonly>
    제목: <input type="text" class="form-control mb-2" name="bTitle" placeholder="제목" value="${board.bTitle}">
    작성자: <input type="text" class="form-control mb-2" name="bWriter" placeholder="작성자" value="${board.bWriter}" readonly>
    <%--    내용: <input type="text" class="form-control mb-2" name="boardContents" placeholder="내용">--%>
    내용: <textarea name="bContents" class="form-control mb-2" cols="30" rows="10" placeholder="내용">${board.bContents}</textarea>
    <input class="btn btn-primary" type="button" value="정보수정" onclick="update()">
</form>
</body>
<script>
    const  update = () => {
        updateForm.submit();
    }
</script>
</html>