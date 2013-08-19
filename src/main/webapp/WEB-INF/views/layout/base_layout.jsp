<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="/resources/css/bootstrap-responsive.min.css" rel="stylesheet">

    <script src="/resources/js/vendor/jquery-1.9.1.min.js"></script>
    <script src="/resources/js/vendor/jquery-ui.min.js"></script>
    <script src="/resources/js/vendor/raphael-min.js"></script>
    <script src="/resources/js/vendor/angular.min.js"></script>
    <script src="/resources/js/vendor/angular-locale_ru.js"></script>
    <script src="/resources/js/teos.js"></script>
</head>
<body>

<tiles:insertAttribute name="header" />

<tiles:insertAttribute name="body" />

<tiles:insertAttribute name="footer" />

<!-- Le javascript
================================================== -->
<script src="/resources/js/vendor/bootstrap.min.js"></script>
</body>
</html>
