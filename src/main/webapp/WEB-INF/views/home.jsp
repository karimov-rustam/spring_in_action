<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/css/style.css"/> ">
</head>
<body>
<h1><s:message code="spitter.welcome" text="Welcome"/></h1>

<a href="<c:url value="/spittles" />">Spittles</a>
<a href="<c:url value="/spitter/register" />">Register</a>

</body>
</html>
