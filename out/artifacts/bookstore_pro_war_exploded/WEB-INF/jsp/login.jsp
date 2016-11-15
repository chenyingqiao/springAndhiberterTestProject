<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 16-11-14
  Time: 下午2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title Page</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/my.css'/>">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <div class=" panel panel-info normal top-10 center-login-from">
        <div class="panel-heading">
            <h3 class="panel-title">请登录</h3>
        </div>
        <div class="panel-body">
            <form action="/home/loginPost" method="POST"  role="form">
                <div class="form-group">
                    <label for="">用户名</label>
                    <input type="text" name="username" class="form-control" id="" placeholder="请输入">
                </div>
                <div class="form-group">
                    <label for="">密码</label>
                    <input type="password" name="password" class="form-control" id="" placeholder="请输入">
                </div>
                <button type="submit" class="btn btn-primary">登陆</button>
            </form>
        </div>
    </div>

</div>
</body>
</html>
