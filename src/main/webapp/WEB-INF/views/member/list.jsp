<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-18
  Time: 오후 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="/resources/js/jquery.js"></script>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<table class="table">
    <tr>
        <th>id</th>
        <th>아이디</th>
        <th>이메일</th>
        <th>이름</th>
        <th>전화번호</th>
        <th>삭제</th>
    </tr>
    <c:forEach var="member" items="${member}">
        <tr>
            <td>${member.id}</td>
            <td>${member.mId}</td>
            <td>${member.mEmail}</td>
            <td>${member.mName}</td>
            <td>${member.mPhone}</td>
<%--            <td><a href="/detail?id=${member.id}">조회</a></td> <!-- ?뒤는 파라미터 -->--%>
            <td><a href="/member/delete?id=${member.id}">삭제</a></td>
<%--            <td><button class="btn btn-outline-info" onclick="detailByAjax('${member.id}')">조회</button></td>--%>
            <!-- 클릭한 회원의 정보를 DB에서 가져와서 detail.jsp에 출력 -->
        </tr>
    </c:forEach>
</table>
<%--<div id="detail">--%>

<%--</div>--%>
</body>
<%--<script>--%>
<%--    const detailByAjax = (id) => {--%>
<%--        console.log(id);--%>
<%--        const detail = document.getElementById("detail");--%>
<%--        $.ajax({--%>
<%--            type: "get", // http request method--%>
<%--            url: "detail-ajax", // 요청주소(컨트롤러 주소값)--%>
<%--            data: {"id": id}, // 전송하는 파라미터--%>
<%--            dataType: "json", // 리턴받을 데이터 형식--%>
<%--            success: function (result) {--%>
<%--                let output = "<table class='table'>";--%>
<%--                output += "<tr>" +--%>
<%--                    "<th>id</th> <th>id2</th> <th>pass</th> <th>name</th>" +--%>
<%--                    "<th>age</th> <th>phone</th> " +--%>
<%--                    "</tr>";--%>
<%--                output += "<tr>";--%>
<%--                output += "<td>" + result.id            + "</td>";--%>
<%--                output += "<td>" + result.id2           + "</td>";--%>
<%--                output += "<td>" + result.pass          + "</td>";--%>
<%--                output += "<td>" + result.name          + "</td>";--%>
<%--                output += "<td>" + result.age           + "</td>";--%>
<%--                output += "<td>" + result.phone         + "</td>";--%>
<%--                output += "</tr>";--%>
<%--                output += "</table>";--%>

<%--                detail.innerHTML = output;--%>
<%--            },--%>
<%--            error: function () {--%>
<%--                alert("오타체크");--%>
<%--            }--%>
<%--        });--%>

<%--    }--%>
<%--</script>--%>
</html>
