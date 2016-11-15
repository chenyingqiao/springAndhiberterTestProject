<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 16-11-8
  Time: 下午7:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html lang="">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Title Page</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">

</head>
<body>
<div class="container">
  <nav class="navbar navbar-inverse">
    <div class="container">
      <ul class="nav navbar-nav">
        <li class="active">
          <a href="/">首页</a>
        </li>
        <li>
          <a href="/home/login">登录</a>
        </li>
        <li>
          <a href="/home/register">注册</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
    <h1 class="text-center">图书种类</h1>
    <ul class="list-group">
      <li class="list-group-item">Item 1</li>
      <li class="list-group-item">Item 2</li>
      <li class="list-group-item">Item 3</li>
    </ul>
  </div>
  <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
    <h1 class="text-center">图书列表</h1>
    <ul class="list-group">
      <li class="list-group-item">
        <span class="badge">5</span>
        Item 1
      </li>
      <li class="list-group-item">
        <span class="badge">10</span>
        Item 2
      </li>
      <li class="list-group-item">
        <span class="badge">15</span>
        Item 3
      </li>
      <li class="list-group-item">
        <span class="badge">5</span>
        Item 1
      </li>
      <li class="list-group-item">
        <span class="badge">10</span>
        Item 2
      </li>
      <li class="list-group-item">
        <span class="badge">15</span>
        Item 3
      </li>
    </ul>
  </div>
</div>
</body>
</html>

