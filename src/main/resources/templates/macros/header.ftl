<#macro header>

<!DOCTYPE html>
<head xmlns="http://www.w3.org/1999/html">
    <meta name="_csrf" id="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" id="_csrf_header" content="${_csrf.headerName}"/>
    <link rel="stylesheet" type="text/css" href="/css/font-awsome.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap-editable.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link href='http://fonts.googleapis.com/css?family=Spinnaker' rel='stylesheet' type='text/css'></link>
    <link href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" rel="Stylesheet"></link>

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.js"></script>
    <script type="text/javascript" src="/js/bootstrap-editable.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.10.3.min.js"></script>
    <script type="text/javascript" src="/js/searchName.js"></script>

    <#if editJS??>
        <script type="text/javascript" src="/js/editPatient.js"></script>
        <script type="text/javascript" src="/js/editAnimal.js"></script>
    </#if>

</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Project name</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
    </div>
</nav>

<div class="container">

</#macro>