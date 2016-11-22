<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 16-11-8
  Time: 下午7:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title Page</title>

    <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">
    <script src="<c:url value='/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/js/bootstrap.min.js'/>"></script>

</head>
<body>
<div class="container">
    <c:import url="/WEB-INF/jsp/nav.jsp"></c:import>
    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
        <h1 class="text-center">图书种类</h1>
        <li class="list-group-item"><a href="/index.html">全部</a></li>
        <ul class="list-group">
            <c:forEach var="item" items="${bookTypeList}">
                <li class="list-group-item">
                    <a href="/index.html?typeid=${item.id}">${item.name}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
        <h1 class="text-center">图书列表</h1>
        <%--<form action="/" method="post" class="margin-30px">--%>
            <%--<input type="search" name="search" id="input" class=" width-200px form-control" value="" required="required" title="">--%>
            <%--<button type="submit" class="margin-5px btn btn-danger">搜索图书</button>--%>
        <%--</form>--%>
        <ul class="list-group">
            <c:forEach var="item" items="${list}">
                <li class="list-group-item">
                    <img src="<c:url value='${item.face}'/>" width="200" height="300">
                    <span class="badge">库存量:${item.number}</span>
                        <b>${item.name}</b>
                    <span>购买人数：${item.buyNumber}</span>
                    <span>价格：${item.price}</span>
                    <a href="/home/shopCatAdd?bookid=${item.id}" type="button" class="btn btn-primary">购买</a>
                </li>
            </c:forEach>
        </ul>
        <c:import url="/WEB-INF/jsp/p.jsp"></c:import>
    </div>
</div>
</body>
</html>

