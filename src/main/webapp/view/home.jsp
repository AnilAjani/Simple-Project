<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tomcat.apache.org/hello-taglib" prefix="h" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Application</title>
    <style type="text/css">
        .error{
            border: 1px solid red;
        }
        .errorMessage{
        color: red
        }
     </style>
</head>
<body>
<h1>${message} ${name}!</h1>
<br>
<img src="/static/smashgeek.jpg"/>
<br>
<form:form action ="/add" modelAttribute="book">
    <form:input path="title" placeholder="title" cssErrorClass="error" />
    <form:errors path="title" errorMessage="" />
    <form:input path="author" placeholder="author" cssErrorClass="error" />
    <form:errors path="author" errorMessage="" />
    <input type="submit" value"Add Book">
</form:form>
<c:forEach items="${books}" var="book" varStatus="i">
    <a href="/book?id=${i.index}">
        <i>${book.title}</i> by ${book.author}<br>
</c:forEach>
</body>
</html>