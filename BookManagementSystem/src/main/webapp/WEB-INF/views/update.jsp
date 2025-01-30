<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Book</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2>Update Book Details</h2>
        <form action="${pageContext.request.contextPath}/book/update" method="POST">
            <div class="form-group">
                <label for="BId">Book ID:</label>
                <input type="text" class="form-control" id="BId" name="BId" value="${BId}" readonly>
            </div>
            <div class="form-group">
                <label for="bAuthor">Author:</label>
                <input type="text" class="form-control" id="bAuthor" name="bAuthor" required>
            </div>
            <div class="form-group">
                <label for="BPublisher">Publisher:</label>
                <input type="text" class="form-control" id="BPublisher" name="BPublisher" required>
            </div>
            <div class="form-group">
                <label for="BPrice">Price:</label>
                <input type="number" class="form-control" id="BPrice" name="BPrice" required>
            </div>
            <button type="submit" class="btn btn-primary">Update Book</button>
        </form>
    </div>
</body>
</html>
