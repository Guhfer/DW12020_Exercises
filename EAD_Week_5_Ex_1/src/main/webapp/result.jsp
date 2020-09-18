<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sent data student</title>
</head>
<body>
    <h1>
        Data student sent:
    </h1>

        <%
            Student student = (Student) request.getAttribute("student");
        %>
        <br/>
        <%
            out.println("Name: " + student.getName());
        %>
        <br/>
        <%
            out.println("Emails: " + student.getEmails());
        %>
        <br/>
        <%
            out.println("Courses: " + student.getCourses());
        %>
</body>
</html>
