<html>
<body>
<form method="POST" enctype="multipart/form-data"
      action="/upload">
    File to upload: <input type="file" name="file"><br /> Name: <input
        type="text" name="name"><br /> <br /> <input type="submit"
                                                     value="Upload"> Press here to upload the file!

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
</body>
</html>