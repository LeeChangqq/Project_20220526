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
        <form action="/member/save" method="post" enctype="multipart/form-data" name="saveForm">
            <input type="text" name="mId" placeholder="아이디" class="form-control mb-2" id="mId" onblur="idCheck()">
            <span id="r" style="font-size: 10px;" ></span>
            <input type="text" name="mPass" placeholder="비밀번호" class="form-control mb-2" id="mPass" onblur="pCheck()">
            <span id="r1" style="font-size: 10px;"></span>
            <input type="text" name="mPass2" placeholder="비밀번호확인" class="form-control mb-2" id="mPass2" onblur="pCheck2()">
            <span id="r2" style="font-size: 10px;"></span>
            <input type="text" name="mName" placeholder="이름" class="form-control mb-2" id="mName" onblur="name1()">
            <span id="r3" style="font-size: 10px;"></span>
            <input type="text" name="mEmail" placeholder="이메일" class="form-control mb-2" id="mEmail" onblur="email1()">
            <span id="r4" style="font-size: 10px;"></span>
            <input type="text" name="mPhone" placeholder="전화번호" class="form-control mb-2" id="mPhone" onblur="phone1()">
            <span id="r5" style="font-size: 10px;"></span>
            <input type="file" name="mFile" placeholder="프로필 설정" class="form-control mb-2">
            <input type="button" value="가입하기" class="btn btn-primary" onclick="click1()">
        </form>
    </div>
</div>
</body>
<script>
    const idCheck = () => {
        const mId = document.getElementById("mId").value;
        const  r = document.getElementById("r");
        $.ajax({
            type: "post",
            url: "/member/check",
            data: {"mId": mId},
            dataType: "text",
            success: function (data) {
                if(mId == ""){
                    r.innerHTML = "아이디를 입력해 주세요.";
                    r.style.color = "red";
                }else if(data == "ok") {
                    r.innerHTML = "사용 가능한 아이디 입니다.";
                    r.style.color = "green";
                }else {
                    r.innerHTML = "중복된 아이디 입니다.";
                    r.style.color = "red";
                }
            },
            error: function (){
                alert("에러")
            }
        });
    }
    const pCheck = () => {
        const mPass = document.getElementById("mPass").value;
        const  r1 = document.getElementById("r1");
        const exp = /^(?=.*[a-z])(?=.*\d)(?=.*[-_!#$~`@%^&*()=+|/?.,><])[a-z\d-_!#$~`@%^&*()=+|/?.,><]{8,16}$/;
        if(mPass.match(exp)) {
            r1.innerHTML = "사용 가능한 비밀번호 입니다.";
            r1.style.color = "green";
            return true;
        }else {
            r1.innerHTML = "영어, 숫자, 대문자를 섞어 8자이상 16자 이하로 해주세요";
            r1.style.color = "red";
        }
    }
    const pCheck2 = () => {
        const mPass = document.getElementById("mPass").value;
        const mPass2 = document.getElementById("mPass2").value;
        const  r2 = document.getElementById("r2");
        if(mPass == mPass2){
            r2.innerHTML = "비밀번호가 일치합니다.";
            r2.style.color = "green";
            return true;
        }else {
            r2.innerHTML = "비밀번호가 일치하지 않습니다.";
            r2.style.color = "red";
        }
    }
    const name1 = () => {
        const mName = document.getElementById("mName").value;
        const  r3 = document.getElementById("r3");
        if(mName == ""){
            console.log(mName);
            r3.innerHTML = "이름을 입렵해주세요.";
            r3.style.color = "red";
        }else {
            r3.innerHTML = "";
            return true;
        }
    }
    const email1 = () => {
        const mEmail = document.getElementById("mEmail").value;
        const r4 = document.getElementById("r4");
        const exp = /^(?=.*[a-z])(?=.*\d)(?=.*[-@.])[a-z\d-@\d-.]{1,20}$/;
        if(mEmail.match(exp)) {
            r4.innerHTML = "사용 가능한 이메일 입니다.";
            r4.style.color = "green";
            return true;
        }else {
            r4.innerHTML = "형식에 맞게 작성해주세요";
            r4.style.color = "red";
        }

    }
    const phone1 = () =>{
        const mPhone = document.getElementById("mPhone").value;
        const r5 = document.getElementById("r5");
        const exp = /^\d{3}-\d{4}-\d{4}$/;
        if(mPhone.match(exp)) {
            r5.innerHTML = "사용 가능한 전화번호 입니다.";
            r5.style.color = "green";
            return true;
        }else {
            r5.innerHTML = "형식에 맞게 작성해주세요";
            r5.style.color = "red";
        }
    }
    const click1 = () => {
        const mId = document.getElementById("mId").value;
        $.ajax({
            type: "post",
            url: "/member/check",
            data: {"mId": mId},
            dataType: "text",
            success: function (data) {
                if(data == "ok" && pCheck() == true && pCheck2() == true && name1() == true && email1() == true && phone1() == true) {
                    saveForm.submit();
                }else {
                    alert("정보를 입력해주세요");
                }
            },
            error: function (){
                alert("에러")
            }
        });
    }
</script>
</html>
