<!DOCTYPE html>
<head>
</head>

<body>
    <div class="container">
        <form class="form-signin" name="user" action="login" method="post" >
            <h2 class="form-signin-heading">Please sign in</h2>
            <label for="inputEmail" class="sr-only">Email cím</label>
            <input name="username" type="text" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
            <label for="inputPassword" class="sr-only">Jelszó</label>
            <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <input class="btn btn-lg btn-primary btn-block" type="submit">Bejelentkezés</input>
        </form>
    </div>
</body>
</html>