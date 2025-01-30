<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Book List</title>
</head>
<body>
	<div class="container mt-4">
		<h1>Book List</h1>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Book ID</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Publisher</th>
					<th scope="col">Price</th>
					<th scope="col">Actions</th> <!-- New column for actions -->
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty books}">
						<c:forEach var="book" items="${books}" varStatus="status">
							<tr>
								<th scope="row">${status.count}</th>
								<td>${book.BId}</td>
								<td>${book.BName}</td>
								<td>${book.BAuthor}</td>
								<td>${book.BPublish}</td>
								<td>${book.BPrice}</td>
								<td>
									<!-- Update Button -->
									<a href="${pageContext.request.contextPath}/book/update/${book.BId}" class="btn btn-warning btn-sm">Update</a>
									
									<!-- Delete Button -->
									<a href="${pageContext.request.contextPath}/book/delete/${book.BId}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this book?');">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="7" class="text-center">No books available</td>
						</tr>
					</c:otherwise>
				</c:choose>
				<p>${msg}</p>
			</tbody>
		</table>
	</div>
</body>
</html>
