<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-30
  Time: 오전 9:58
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
        <input type="text" name="mPass" placeholder="비밀번호" id="mPass" class="form-control">
        <input type="button" onclick="aa1()" value="입력" class="form-control">
    </div>
</div>
</body>
<script>
    const aa1 = () =>{
        const p = document.getElementById("mPass").value;
        const passDB = "${sessionScope.memberMPass}";
        if(p == passDB)
        {
            location.href ="/board/update?id=${board.id}";
        }else {
            alert("비밀번호가 틀립니다.")
        }
    }
</script>
</html>
