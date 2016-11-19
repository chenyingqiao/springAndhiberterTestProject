<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 16-11-15
  Time: 下午4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<ul class="pagination">
    <c:forEach var="item" items="${page.list}">
        <li class=""><a href="${item.url}" class>${item.pageNum}</a></li>
    </c:forEach>
</ul>
