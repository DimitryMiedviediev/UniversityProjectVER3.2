<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Reset password</title>

    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css'>
    <link rel="stylesheet" href="resources/css/authentication.css">

</head>

<body>
<div class="container-fluid">
    <div class="row vertical-center">
        <form class="col-xs-8 col-xs-offset-2  col-sm-6 col-sm-offset-3 col-md-4 col-sm-offset-4 col-lg-2 col-lg-offset-5">
            <h1>Reset password</h1>
            <p>
                <label class="sr-only" for="email">Email Address</label>
                <input id="email" class="form-control" type="email" name="email" placeholder="Email Address" required
                       autofocus>
            </p>
            <button class="btn btn-primary btn-block" type="submit" name="Reset" value="true">Reset my password</button>
        </form>
    </div>
</div>

<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.js'></script>

</body>

</html>