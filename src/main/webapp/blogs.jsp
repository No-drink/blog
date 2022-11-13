<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<input type="button" value="新增"><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>题目</th>
        <th>封面</th>
        <th>内容</th>
 

    </tr>


    <c:forEach items="${blogs}" var="blog" varStatus="status">
        <tr align="center">
            <%--<td>${blog.id}</td>--%>
            <td>${status.count}</td>
            <td>${blog.title}</td>

            <td>${blog.text}</td>

            <td><a href="#">修改</a> <a href="#">删除</a></td>
        </tr>

    </c:forEach>




</table>


<hr>


</body>
</html>