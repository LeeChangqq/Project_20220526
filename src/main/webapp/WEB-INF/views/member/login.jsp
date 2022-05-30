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
    <meta name="viewport" content="width=device-width, height=device-height, minimum-scale=1.0, maximum-scale=1.0, initial-scale=1.0">
    <style>
        .input-box{
            position:relative;
            margin:10px 0;
        }
        .input-box > input{
            background:transparent;
            border:none;
            border-bottom: solid 1px #ccc;
            padding:20px 0px 5px 0px;
            font-size:14pt;
            width:100%;
        }
        input::placeholder{
            color:transparent;
        }
        .input:placeholder-shown + label{
            color:#aaa;
            font-size:14pt;
            top:15px;
        }
        .input:focus + label, label {
            color: #8aa1a1;
            font-size: 10pt;
            pointer-events: none;
            position: absolute;
            left: 0px;
            top: 0px;
            transition: all 0.2s ease;
            -webkit-transition: all 0.2s ease;
            -moz-transition: all 0.2s ease;
            -o-transition: all 0.2s ease;
        }
        input:focus, input:not(:placeholder-shown){
            border-bottom: solid 1px #8aa1a1;
            outline:none;
        }
    </style>
</head>
<body>
        <form action="/member/login" method="post" name="c">
            <div class="input-box">
              <input type="text" name="mId" placeholder="아이디" class="form-control mb-2" id="mId2">
            </div>
            <div class="input-box">
                <input type="text" name="mPass" placeholder="비밀번호" class="form-control mb-2" id="mPass2">
            </div>
                <input type="submit" value="로그인">
        </form>

</body>
<%--<script>--%>
<%--    const idCheck = () => {--%>
<%--        const mId2 = document.getElementById("mId2").value;--%>
<%--        const mPass2 = document.getElementById("mPass2").value;--%>
<%--        const mIdDB = '${member.mId}';--%>
<%--        const mPassDB = '${member.mPass}';--%>
<%--        $.ajax({--%>
<%--            type: "get",--%>
<%--            url: "/member/detail",--%>
<%--            data: {"mId2": mId2, "mPass2":mPass2, "mIdDB":mIdDB,"mPassDB":mPassDB},--%>
<%--            data_type: "json",--%>
<%--            success: function (){--%>
<%--                if(mId2 == mIdDB && mPass2 == mPassDB){--%>
<%--                    c.submit();--%>
<%--                }else {--%>
<%--                    alert("틀림")--%>
<%--                }--%>
<%--            },--%>
<%--            error: function (){--%>
<%--              alert("에러")--%>
<%--            }--%>
<%--        });--%>
<%--    }--%>
<%--</script>--%>
</html>
