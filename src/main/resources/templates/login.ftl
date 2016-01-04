<#import "spring.ftl" as spring />
<#include "macros/general.ftl">

<!DOCTYPE html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/css/signin.css">

    <script type="text/javascript" src="/js/bootstrap.js"></script>
</head>

<body>
    <div class="container">
        <form class="form-signin" name="user" action="login" method="post" >
            <h2 class="form-signin-heading"><@label "login.h2.please_sign_in" /></h2>
            <label for="inputEmail" class="sr-only"><@label "login.label.email_address" /></label>
            <input name="username" type="text" id="inputEmail" class="form-control" placeholder="<@label "login.label.email_address" />" required autofocus>
            <label for="inputPassword" class="sr-only"><@label "login.label.password" /></label>
            <input name="password" type="password" id="inputPassword" class="form-control" placeholder="<@label "login.label.password" />" required>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"><@label "login.label.remember_me" /></input>
                </label>
            </div>
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit"><@label "button.login" /></button>
        </form>
    </div>
</body>
</html>