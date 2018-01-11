<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: Dimitry--%>
  <%--Date: 05.01.2018--%>
  <%--Time: 21:37--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Registration</title>--%>
    <%--<link type="text/css" rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure.css">--%>
    <%--<link rel="stylesheet" href="resources/css/authentication.css">--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="pure-g" style="padding-top: 20%">--%>
    <%--<div class="pure-u-1-3"></div>--%>
    <%--<div class="pure-u-1-3">--%>
        <%--<form class="pure-form pure-form-aligned" action="registration" method="post">--%>
            <%--<fieldset>--%>

                <%--<h2>Registration</h2>--%>

                <%--<div class="pure-control-group">--%>
                    <%--<label for="name">Name</label>--%>
                    <%--<input id="name" type="text" name="name" placeholder="Name">--%>
                <%--</div>--%>

                <%--<div class="pure-control-group">--%>
                    <%--<label for="lastname">Lastname</label>--%>
                    <%--<input id="lastname" type="text" name="lastname" placeholder="Lastname">--%>
                <%--</div>--%>

                <%--<div class="pure-control-group">--%>
                    <%--<label for="email">Email Address</label>--%>
                    <%--<input id="email" type="email" name="email" placeholder="Email Address">--%>
                <%--</div>--%>

                <%--<div class="pure-control-group">--%>
                    <%--<label for="password">Password</label>--%>
                    <%--<input id="password" type="password" name="password" placeholder="Password">--%>
                <%--</div>--%>

                <%--<div class="pure-controls">--%>
                    <%--<button type="submit" class="button-large pure-button pure-button-primary" name="SignUp" value="true">Sign Up</button>--%>
                <%--</div>--%>

                <%--<a href="authorization">Sign In</a>--%>
            <%--</fieldset>--%>
        <%--</form>--%>
    <%--</div>--%>
    <%--<div class="pure-u-1-3"></div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>

    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css'>
    <link rel="stylesheet" href="resources/css/authentication.css">

</head>

<body>
<div class="container-fluid">
    <div class="row vertical-center">
        <form class="col-xs-8 col-xs-offset-2  col-sm-6 col-sm-offset-3 col-md-4 col-sm-offset-4 col-lg-2 col-lg-offset-5">
            <h1>Sign Up</h1>
            <p>
                <label class="sr-only" for="email">Email Address</label>
                <input id="email" class="form-control" type="email" name="email" placeholder="Email Address" required
                       autofocus>
            </p>
            <p>
                <label class="sr-only" for="password">Password</label>
                <input id="password" class="form-control" type="password" name="password" placeholder="Password"
                       required>
            </p>
            <p>
                <label class="sr-only" for="reset_password">Reset password</label>
                <input id="reset_password" class="form-control" type="password" name="reset_password" placeholder="Reset password"
                       required>
            </p>
            <button class="btn btn-primary btn-block" type="submit" name="SignUp" value="true">Sign Up</button>
            <p></p>
            <p>Already have an account?
                <a href="authorization">Sign In</a>
            </p>
        </form>
    </div>
</div>

<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.js'></script>

</body>

</html>