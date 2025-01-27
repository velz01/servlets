<%@ page import="com.velz.service.EmployeeService" %>
<%@ page import="com.velz.dto.EmployeeDto" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 27.01.2025
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TestPage</title>
</head>
<body>
<h1>YOYOYOYO</h1>

<%
    EmployeeService service = EmployeeService.getInstance();
    for (EmployeeDto employeeDto : service.findAll()) {
        out.write(employeeDto.toString());
    }


%>
</body>
</html>
