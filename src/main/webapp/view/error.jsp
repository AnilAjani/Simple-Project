<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tomcat.apache.org/hello-taglib" prefix="h" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Application</title>
    <style type="text/css">
        .errorMessage{
            color: red
            }
     </style>
</head>
<body>
<h1>System Error</h1>
<h2 class=${errorClass}>${errorMessage}</h2>
</body>
</html>