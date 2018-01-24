<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>404 Page</title>

    <link rel="stylesheet" href="/../../resources/css/404.css">

    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="/../../resources/js/404.js"></script>

</head>

<body>
<div style="padding-top: 13%"></div>
<div class="center" align="center">
    <canvas height="300" width="700" id="canvas"></canvas>
    <div class="subtext"><span class="quip"></span>
        <div class="err-btn">Generate An Error Report?</div>
    </div>
</div>
<div class="err-rprt-cvr">
    <div class="prog" align="center">
        <svg class="spinner" width="65px" height="65px" viewBox="0 0 66 66" xmlns="http://www.w3.org/2000/svg">
            <circle class="path" fill="none" stroke-width="6" stroke-linecap="round" cx="33" cy="33" r="30"></circle>
        </svg>
        <br/><br/>
        <span class="loadtext">Gathering Data...</span>
    </div>
</div>

</body>

</html>
