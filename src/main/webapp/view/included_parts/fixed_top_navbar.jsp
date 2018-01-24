<%@ page import="com.fasterxml.jackson.databind.JsonNode" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="home">
        <img src="../../resources/icons/brand.png" width="30" height="30" alt="">
    </a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Students</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Groups</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Documents</a>
            </li>
        </ul>
        <div class="my-2 my-lg-0">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <%= ((JsonNode) request.getSession().getAttribute("UserInfo")).get(0).get("email").asText() %>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="userDropdown">
                        <%--<a class="dropdown-item" href="settings">Settings</a>--%>
                        <a class="dropdown-item" href="account_settings">Account</a>
                        <a class="dropdown-item" href="profile_settings">Profile</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="exit">Exit</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>