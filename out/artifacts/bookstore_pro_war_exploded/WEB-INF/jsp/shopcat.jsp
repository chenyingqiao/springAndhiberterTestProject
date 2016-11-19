<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 16-11-19
  Time: 上午10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">
    <script src="<c:url value='/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
</head>
<body>
    <div class="container">
        <c:import url="/WEB-INF/jsp/nav.jsp"></c:import>
        <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
            <div class="list-group">
                <c:forEach var="item" items="${list}">
                <span href="#" class="list-group-item">
                    <a class="btn btn-danger" style="float:right;" href="/home/shopCatDel?bookid=${item.id}">删除</a>
                    <h4 class="list-group-item-heading">${item.name}</h4>
                    <p class="list-group-item-text">价格：${item.price}</p>
                </span>
                </c:forEach>
            </div>
           <form action="/home/shopCount" method="post">
               <button type="submit" class="btn btn-danger">结算</button>
           </form>
        </div>
    </div>
</body>
</html>
