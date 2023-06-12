<%@ page import="dbwls.spring_servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: dbwls
  Date: 2023-06-12
  Time: 오전 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

성공
<ul>
  <li>id = ${member.id}</li>
  <li>username = ${member.username}</li>
  <li>age = <%=((Member)request.getAttribute("member")).getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
