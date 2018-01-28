<%@ page import="com.fasterxml.jackson.databind.JsonNode" %>
<%@ page import="jSONextracter.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change full name</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.css">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.js"></script>
    <script>
        function getName () {
            let name = "<%=UserInfo.getUserName((JsonNode) request.getSession().getAttribute("UserInfo"))%>";
            if (name === "null") name = "";
            return name;
        }
        function getLastname () {
            let lastname = "<%=UserInfo.getUserLastname((JsonNode) request.getSession().getAttribute("UserInfo"))%>";
            if (lastname === "null") lastname = "";
            return lastname;
        }
    </script>
</head>
<body>

<jsp:include page="/view/included_parts/fixed_top_navbar.jsp"/>

<div style="padding-top: 20%"></div>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm"></div>
        <div class="col-sm ">
            <form>
                <div class="form-group">
                    <h3>Change full name</h3>
                    <input type="text" class="form-control"
                           placeholder="Enter name" name="name" id="name">
                    <input type="text" class="form-control"
                           placeholder="Enter lastname" name="lastname" id="lastname">
                </div>
                <button type="submit" class="btn btn-primary btn-block" name="Confirm" value="true">Confirm</button>
            </form>
        </div>
        <div class="col-sm"></div>
    </div>
</div>

<script>
    document.getElementById("name").value = getName();
    document.getElementById("lastname").value = getLastname();
</script>
</body>
</html>
