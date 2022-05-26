<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 2:42
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
        <form action="/member/login" method="post" name="c">
            <input type="text" name="mId" placeholder="아이디" class="form-control mb-2" id="mId2">
            <input type="text" name="mPass" placeholder="비밀번호" class="form-control mb-2" id="mPass2">
            <input type="button" value="로그인" class="btn btn-primary" id="a" onclick="idCheck()">
        </form>
    </div>
</div>
</body>
<script>
    const idCheck = () => {
        const mId2 = document.getElementById("mId2").value;
        const mPass2 = document.getElementById("mPass2").value;
        const mIdDB = '${member.mId}';
        const mPassDB = '${member.mPass}';
        $.ajax({
            type: "get",
            url: "/member/detail",
            data: {"mId2": mId2, "mPass2":mPass2, "mIdDB":mIdDB,"mPassDB":mPassDB},
            data_type: "json",
            success: function (){
                if(mId2 == mIdDB && mPass2 == mPassDB){
                    c.submit();
                }else {
                    alert("틀림")
                }
            },
            error: function (){
              alert("에러")
            }
        });
    }
</script>
</html>
