<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hi in the view Welcome Home

<a href="http://localhost:8080/ABCSpringMVC/emp/Ketaki?addr=Pune&dept=xyz">Ketaki</a>
<a href="http://localhost:8080/ABCSpringMVC/emp/john?addr=Ng&dept=yzx">john</a>

<br>

<b>Employee Registration form</b><br>


<sf:form modelAttribute="employee" method="post">

	ID::    <sf:input path="id" /> <br>
	Name::   <sf:input path="name" /> <br>
	<button type="submit" value="Register"/>

</sf:form>
</body>
</html>