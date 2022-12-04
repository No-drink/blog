<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

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
        <th>标题</th>
        <th>封面</th>
        <th>内容</th>
 

    </tr>


    <c:forEach items="${blogs}" var="blog" varStatus="status">
        <tr align="center">
            <%--<td>${blog.index}</td>--%>
            <td>${status.count}</td>
            <td><a href="/blog/selectIndexServlet?index=${blog.index}">${blog.title}</a></td>
            <td>${blog.image}</td>


        </tr>

    </c:forEach>




</table>


<hr>


</body>
</html>