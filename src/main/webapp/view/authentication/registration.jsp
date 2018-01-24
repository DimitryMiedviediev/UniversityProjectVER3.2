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