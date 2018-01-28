<%@ page import="com.fasterxml.jackson.databind.JsonNode" %>
<%@ page import="jSONextracter.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: Dimitry
  Date: 14.01.2018
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Settings</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.css">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.js"></script>
    <script>
        function getEmail () {
            let email = "<%=UserInfo.getUserEmail((JsonNode) request.getSession().getAttribute("UserInfo"))%>";
            if (email === "null") email = "";
            return email;
        }
    </script>
</head>
<body>

<jsp:include page="/view/included_parts/fixed_top_navbar.jsp"/>

<div style="padding-top: 20%"></div>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm"></div>
        <div class="col-sm">
            <div class="list-group">
                <a href="change_email" class="list-group-item list-group-item-action flex-column align-items-start">
                    <div class="d-flex w-100 justify-content-between">
                        <h5 class="mb-1">Change email</h5>
                    </div>
                    <p class="mb-1" id="userEmail"></p>
                </a>
                <a href="change_password" class="list-group-item list-group-item-action flex-column align-items-start">
                    <div class="d-flex w-100 justify-content-between">
                        <h5 class="mb-1">Change password</h5>
                    </div>
                    <p class="mb-1">************</p>
                </a>
            </div>
        </div>
        <div class="col-sm"></div>
    </div>
</div>

<script>
    document.getElementById("userEmail").innerHTML = getEmail();
</script>
</body>
</html>
