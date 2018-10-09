<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="UTF-8"/>
<title>Cadastro de Produtos</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="produtos" method="post">
		<div>
			<label for="title">Título</label>
			<input type="text" name="title" id="title"/>
		</div>
		<div>
			<label for="description">Descrição</label>
			<textarea rows="10" cols="20" name="description" id="description"></textarea>
		</div>
		<div>
			<label for="pages">Número de paginas</label>
			<input type="text" name="pages" id="pages">
		</div>
		<!--<c:forEach items="${types}" var="bookType" varStatus="status">
			<div>
				<label for="price_${bookType}"> ${bookType} </label>
				<input type="text" name="prices[${status.index}].value" id="price_${bookType}">
				<input type="hidden" name="prices[${status.index}].bookType" value="${bookType}">
			</div>
		</c:forEach>-->
		<div>
			<input type="submit" value="Enviar"/>
		</div>
	</form>
</body>
</html>