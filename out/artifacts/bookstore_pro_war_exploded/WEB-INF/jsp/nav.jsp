<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 16-11-19
  Time: 上午11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index.html">网上书店</a>
        </div>
        <form class="navbar-form navbar-left" role="search" action="/" >
            <div class="form-group">
                <input type="text" class="form-control" placeholder="图书名" name="search">
            </div>
            <button type="submit" class="btn btn-default">搜索图书</button>
        </form>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <c:choose>
                <c:when test="${login==null}">
                    <ul class="nav navbar-nav">
                        <li><a href="/home/login">登录</a></li>
                        <li><a href="/home/register">注册</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="nav navbar-nav">
                        <li><a href="/home/shopCat">购物车</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">${login} <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/home/logoutPost">退出登陆</a></li>
                            </ul>
                        </li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>
