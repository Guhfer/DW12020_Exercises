<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.File" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8">
		<title>Data file</title>
	</head>
	<body>
		<h1>
			Data sent files:
		</h1>
		
		<c:choose>
			<c:when test="${fn:length(files) > 0}">
				<c:forEach var="file" items="${files}" varStatus="counter">
					<p>File: ${counter.count}</p>
					<p>Tittle: ${file.title}</p>
					<p>Size: ${file.size}</p>
					<p>Type: ${file.type}</p>
					<p>------------------------------</p>			
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:out value="File don't have any data"></c:out>
			</c:otherwise>
		</c:choose>
	</body>
</html>