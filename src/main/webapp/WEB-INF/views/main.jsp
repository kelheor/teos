<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html ng-app>
<head>
    <title>Home</title>
    <!-- Le styles -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 80px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <link href="/resources/css/bootstrap-responsive.css" rel="stylesheet">

    <script src="/resources/js/vendor/jquery-1.9.1.min.js"></script>
    <script src="/resources/js/vendor/jquery-ui.min.js"></script>
    <script src="/resources/js/vendor/raphael-min.js"></script>
    <script src="/resources/js/vendor/angular.min.js"></script>
    <script src="/resources/js/vendor/angular-locale_ru.js"></script>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="#">Teos project</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#contact">Contact</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container">
    <div>
        <label>Name:</label>
        <input type="text" ng-model="yourName" placeholder="Enter a name here">
        <hr>
        <h1>Hello {{yourName}}!</h1>
    </div>

</div> <!-- /container -->

<!-- Le javascript
================================================== -->
<script src="/resources/js/vendor/bootstrap.min.js"></script>
</body>
</html>
