<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 11.01.20
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transport List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mainPage.css"/>
</head>
<body>
<div class="wrapper container">
    <jsp:include page="/fragments/header.jsp"/>


    <nav class="navbar navbar-default">

        <ul class="nav navbar-nav">
            <div class="row">
                <div class="col-md-4">
                    <li><!-- class="nav-item">-->
                        <a class="nav-link" href="#">${userDto.username}</a>
                    </li>
                </div>
                <div class="col-md-4">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/personalCabinet">Personal cabinet</a>
                    </li>
                </div>
                <div class="col-md-4">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/login">Log out</a>
                    </li>
                </div>
            </div>
        </ul>
    </nav>


    <div class="heading"></div>


    <div class="row">
        <aside class="col-md-3">
            <div class="panel panel-primary">
                <div class="panel-heading">MENU</div>
                <div class="panel-body">
                    <ul class="list-group submenu">
                        <li class="list-group-item active">Places</li>
                        <li class="list-group-item"><a href="${pageContext.request.contextPath}/commentList">Comments</a></li>
                        <li class="list-group-item"><a href="${pageContext.request.contextPath}/tripList">Trips</a></li>
                        <li class="list-group-item"><a href="${pageContext.request.contextPath}/transportList">Transports</a></li>
                    </ul>
                </div>
            </div>
        </aside>


        <section class="col-md-9">
            <div class="jumbotron">
                <blockquote>
                    <p>
                        Quet
                    </p>
                    <small> Author</small>
                </blockquote>
            </div>
            <div class="container features">
                <div class="row">
                    <c:forEach items="${transportList}" var="transport">
                        <div class="col-lg-4 col-md-4 col-sm-12">
                            <div class="col-sm">
                                <fieldset>
                                    <c:out value="${transport.transportName}"/>
                                        <%--                        <c:out value="${place.country}"/>--%>
                                        <%--                        <c:out value="${place.town}"/>--%>
                                        <%--                        <c:out value="${place.name}"/>--%>
                                        <%--                        <c:out value="${place.description}"/>--%>
                                </fieldset>
                            </div>
                        </div>
                    </c:forEach>

                </div>




                <h2>Our trip</h2>
                <div class="trip">
                    <div class="row">
                        <div class="col col-md-4">
                            <img src="" alt="John Doe" class="thumbnail">
                            <div class="caption">
                                <h3>John Doe</h3>
                                <p></p>
                            </div>
                        </div>
                        <div class="col col-md-4 col-md-offset-1">
                            <img src="" alt="Saundra Pittsley" class="thumbnail">
                            <div class="caption">
                                <h3>Saundra Pittsley</h3>
                                <p></p>
                            </div>
                        </div>
                        …
                    </div>
                    <div class="row">
                        <div class="col col-md-4">
                            <img src="" alt="Ericka Nobriga" class="thumbnail">
                            <div class="caption">
                                <h3>Ericka Nobriga</h3>
                                <p></p>
                            </div>
                        </div>
                        <div class="col col-md-4 col-md-offset-1">
                            <img src="" alt="Cody Rousselle" class="thumbnail">
                            <div class="caption">
                                <h3>Cody Rousselle</h3>
                                <p></p>
                            </div>
                        </div>
                        …
                    </div>
                </div>

            </div>
        </section>
    </div>
</div>



<jsp:include page="/fragments/footer.jsp"/>
</body>
</html>
