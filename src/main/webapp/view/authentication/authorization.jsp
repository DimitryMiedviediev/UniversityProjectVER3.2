<%--
  Created by IntelliJ IDEA.
  User: Dimitry
  Date: 05.01.2018
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Authorization</title>
    <link type="text/css" rel="stylesheet" href="../../resources/pure/pure.css">
</head>
<body>
<div class="pure-g" style="padding-top: 20%">
    <div class="pure-u-1-3"></div>
    <div class="pure-u-1-3">
        <form class="pure-form pure-form-aligned">
            <fieldset>

                <h2>Authorization</h2>

                <div class="pure-control-group">
                    <label for="email">Email Address</label>
                    <input id="email" type="email" placeholder="Email Address">
                </div>

                <div class="pure-control-group">
                    <label for="password">Password</label>
                    <input id="password" type="password" placeholder="Password">
                </div>

                <div class="pure-controls">
                    <button type="submit" class="button-large pure-button pure-button-primary">Sign In</button>
                </div>

                <a href="authorization.jsp">Sign Up</a>
            </fieldset>
        </form>
    </div>
    <div class="pure-u-1-3"></div>
</div>
</body>
</html>
