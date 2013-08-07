<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sec:authorize access="isAnonymous()">

    <div class="navbar  navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="brand" href="#"> T.E.O.S </a>

                <div class="nav-collapse collapse">
                    <ul class="nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                    <form class="navbar-form pull-right" method="POST" action="/j_spring_security_check">
                        <input name="j_username" placeholder="Enter login" type="text" value="${SPRING_SECURITY_LAST_USERNAME}"/>
                        <input name="j_password" placeholder="Enter password" type="password"/>
                        <input type="submit" class="btn btn-default navbar-btn" value="Sign in"/>
                        <button type="button"  onclick="window.location.href='/signup'" class="btn btn-primary navbar-btn">Register</button>
                    </form>
                </div>
                <!--/.nav-collapse -->
            </div>
        </div>
    </div>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <div class="navbar  navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="brand" href="#"> T.E.O.S </a>

                <div class="nav-collapse collapse">
                    <ul class="nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                    <ul class="nav pull-right">
                        <li id="fat-menu" class="dropdown">
                            <a href="#" id="account-button" role="button" class="dropdown-toggle"
                               data-toggle="dropdown">Account <b class="caret"></b></a>
                            <ul class="dropdown-menu" role="menu" aria-labelledby="account-button">
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Show details</a></li>
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Edit account</a></li>
                                <li role="presentation" class="divider"></li>
                                <li role="presentation"><a role="menuitem" tabindex="-1"
                                                           href="/j_spring_security_logout">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
        </div>
    </div>
</sec:authorize>
