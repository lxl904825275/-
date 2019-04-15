<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2019/4/11
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/UserServlet?action=update" method="post">
<table >
<tr>
    <td>编号</td>
    <td>
        <input type="text" name="id" value="${user.id}">
    </td>

</tr>
    <tr>
        <td>姓名</td>
        <td>
            <input type="text" name="name" value="${user.name}">
        </td>

    </tr>
    <tr>
        <td colspan="2"><input type="hidden" value="update"
                               name="action" /> <input type="submit" value="更新数据" /></td>
    </tr>




</table>

</form>
</body>
</html>
