<%@ page import="com.fasterxml.jackson.databind.JsonNode" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change password</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.css">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.js"></script>
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
                    <h3>Change password</h3>
                    <input type="password" class="form-control" id="changePassword1"
                           placeholder="Enter old password" name="old_password">
                    <input type="password" class="form-control"
                           placeholder="Enter new password" name="new_password">
                    <input type="password" class="form-control" id="changePassword3"
                           placeholder="Repeat new password" name="new_password_repeat">
                </div>
                <button type="submit" class="btn btn-primary btn-block" name="Confirm" value="true">Confirm</button>
            </form>
        </div>
        <div class="col-sm"></div>
    </div>
</div>

</body>
</html>