<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,br.com.adrianob.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Produtos</title>
</head>
<body>
<h1>Lista</h1>
<a href="index.html">inicio</a>
<hr/>
<table>
<jsp:useBean id="dao" class="br.com.adrianob.DaoProduto"/>
<c:forEach var="produto" items="${dao.lista}">
<tr>
	<td>${produto.id}</td>
	<td>${produto.nome}</td>
</tr>
</c:forEach>
</table>
<hr/>
<jsp:useBean id="data" class="java.util.Date"/>
<fmt:formatDate value="${data}" pattern="dd/MM/yyyy"/>
</body>
</html>