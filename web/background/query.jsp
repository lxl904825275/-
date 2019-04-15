<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/15
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>111</title>
</head>
<body>
    <table>
        <tr>
            <td>ID</td>
            <td>姓名</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${list}" var="list">
            <tr>
                <td>${list.id}</td>
                <td>${list.name}</td>
                <td>
                    <a href="<%=request.getContextPath()%>/background/add.jsp">添加</a>
                    <a href="<%=request.getContextPath()%>/UserServlet?action=queryOne&id=${list.id}">修改</a>
                    <a href="<%=request.getContextPath()%>/UserServlet?action=delete&id=${list.id}">删除</a>
                </td>
             </tr>
        </c:forEach>

    </table>
    <div>
        <tr>
            <c:forEach begin="1" end="${page}"   var="i">
                <a href="/UserServlet?action=query&pageIndex=${i}">
                        ${i}
                </a>

            </c:forEach>
        </tr>
    </div>
</body>
</html>
