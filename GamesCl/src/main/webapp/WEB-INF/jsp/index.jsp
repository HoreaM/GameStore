<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.net.URLDecoder" %>

<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/app.css"/>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.dataTables.min.js"></script>
    <script src="js/dataTables.bootstrap4.min.js"></script>
    <script src="js/script.js"></script>

    <title>Game Store</title>
</head>

<body>
<div class="logo">
    <a href="/"><img src="images/gs.png" alt="logo"></a>
</div>

<div class="container">
    <div class="card">
        <button type="button" class="btn btn-info btn-lg btn-block" data-toggle="collapse"
                data-target="#addGameCollapse">+ Add Game
        </button>
        <div class="collapse" id="addGameCollapse">
            <div class="card card-body">
                <div class="container">

                    <form class="addGameForm" action="${pageContext.request.contextPath}/" method="post">
                        <div class="form-group">
                            <label for="id">ID:</label>
                            <input type="text" class="form-control" placeholder="Enter ID" id="id" name="id"/>
                        </div>
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" class="form-control" placeholder="Enter Name" id="name" name="name"/>
                        </div>
                        <div class="form-group">
                            <label for="developer">Developer:</label>
                            <input type="text" class="form-control" placeholder="Enter Developer" id="developer"
                                   name="developer"/>
                        </div>
                        <div class="form-group">
                            <label for="userscore">User Score:</label>
                            <input type="text" class="form-control" placeholder="Enter User Score" id="userscore"
                                   name="userscore"/>
                        </div>
                        <div class="form-group">
                            <label for="initialprice">Initial Price:</label>
                            <input type="text" class="form-control" placeholder="Enter Initial Price" id="initialprice"
                                   name="initialprice"/>
                        </div>
                        <div class="form-group">
                            <label for="discount">Discount:</label>
                            <input type="text" class="form-control" placeholder="Enter Discount" id="discount"
                                   name="discount"/>
                        </div>
                        <div class="form-group">
                            <label for="price">Price:</label>
                            <input type="text" class="form-control" placeholder="Enter Price" id="price" name="price"/>
                        </div>
                        <input type="submit" value="Add Game" name="Add Game" class="btn btn-primary addGameButton"/>
                    </form>
                </div>
            </div>
        </div>
        <table id="gamesTable" align="center"
               class="gameTable sortable table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th scope="row">#</th>
                <th scope="row">Name</th>
                <th scope="row">Developer</th>
                <th scope="row">User Score</th>
                <th scope="row">Initial Price</th>
                <th scope="row">Discount</th>
                <th scope="row">Price</th>
                <th scope="row">More Info</th>
                <th scope="row">Buy</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="iter" scope="session" value="${1}"/>
            <c:forEach var="i" items="${list}">
                <tr>
                        <%--<td><c:out value="${i.id}"/></td>--%>
                    <td><c:out value="${iter}"/>
                        <c:set var="iter" scope="session" value="${iter + 1}"/>
                    </td>
                    <td>
                        <div class="left-div">
                            <img alt="<c:out value="${i.id}"/>"
                                 src="https://steamcdn-a.akamaihd.net/steam/apps/<c:out value="${i.id}"/>/capsule_184x69.jpg"
                                 class="games-img">
                        </div>
                        <div class="right-div">
                            <c:out value="${i.name}"/>
                        </div>
                    </td>
                    <td><c:out value="${i.developer}"/></td>
                    <td><c:out value="${i.userscore}%"/></td>
                    <td><c:out value="$${i.initialprice/100}"/></td>
                    <td><c:out value="${i.discount}%"/></td>
                    <td><c:out value="$${i.price/100}"/></td>
                    <td>
                        <div class="details">
                            <form action="/" method="get">
                                <input type="hidden" name="id" value="<c:out value="${i.id}"/>">
                                    <%--<input type="submit" value="Game Details"/>--%>
                                <input type="submit" class="btn btn-primary" value="Game Details"/>
                            </form>
                        </div>
                    </td>
                    <td><a class="btn btn-info"
                           href="https://store.steampowered.com/app/<c:out value="${i.id}"/>/?cc=us" target="_blank">Buy
                        Game</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            </tfoot>
        </table>
    </div>
</div>
</body>
</html>
