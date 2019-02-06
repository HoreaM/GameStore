<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.net.URLDecoder" %>

<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/app.css"/>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <title>Game Store - Game Details</title>
</head>

<body>
<div class="logo">
    <a href="/"><img src="images/gs.png" alt="logo"></a>
</div>

<div class="container">
    <div class="card">
        <a href="/" class="btn btn-info btn-lg btn-block">< Back Home</a>
        <table id="gamesTable" align="center" class="table table-bordered gamesDetailTable">
            <tbody>
            <c:set var="iter" scope="session" value="${1}"/>
            <c:forEach var="i" items="${list}">
            <tr>
                <td colspan="2" class="centerRow">
                    <img alt="<c:out value="${i.id}"/>"
                         src="https://steamcdn-a.akamaihd.net/steam/apps/<c:out value="${i.id}"/>/header.jpg"
                         class="games-img-big">
                </td>
            </tr>
            <tr>
                <th scope="row">Name</th>
                <td><c:out value="${i.name}"/></td>
            </tr>
            <tr>
                <th scope="row">Developer</th>
                <td><c:out value="${i.developer}"/></td>
            </tr>
            <tr>
                <th scope="row">Genre</th>
                <td><c:out value="${i.genre}"/></td>
            </tr>
            <tr>
                <th scope="row">User Score</th>
                <td><c:out value="${i.userscore}%"/></td>
            </tr>
            <tr>
                <th scope="row">Positive Reviews</th>
                <td><c:out value="${i.positivereviews}"/></td>
            </tr>
            <tr>
                <th scope="row">Negative Reviews</th>
                <td><c:out value="${i.negativereviews}"/></td>
            </tr>
            <tr>
                <th scope="row">Initial Price</th>
                <td><c:out value="$${i.initialprice/100}"/></td>
            </tr>
            <tr>
                <th scope="row">Discount</th>
                <td><c:out value="${i.discount}%"/></td>
            </tr>
            <tr>
                <th scope="row">Price</th>
                <td><c:out value="$${i.price/100}"/></td>
            </tr>
            <tr>
                <td colspan="2" class="centerRow">
                    <a class="btn btn-info btn-lg btn-block"
                       href="https://store.steampowered.com/app/<c:out value="${i.id}"/>/?cc=us"
                       target="_blank">Buy Game</a>
                </td>
            </tr>
            </c:forEach>
            <tbody>
        </table>
    </div>
</div>
</body>
</html>
