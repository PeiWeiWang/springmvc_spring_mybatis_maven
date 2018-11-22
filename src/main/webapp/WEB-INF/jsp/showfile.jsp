<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/11
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table align="center">

        <c:forEach items="${list}" var="file">
            <tr><td><a href="/file/open?isFile=${file.isFile}&&name=${file.name}">${file.name}</a></td><td>${file.size}</td><td>${file.lastModifyTime}</td><td><c:if test="${file.isFile==true}" >文件</c:if><c:if test="${file.isFile==false}" >文件夹</c:if></td></tr>
        </c:forEach>
    </table>




    <form action="testFileUpload" method="POST" enctype="multipart/form-data">
        File: <input type="file" name="file"/>
        <input type="submit" value="Submit"/>
    </form>

</body>
</html>
