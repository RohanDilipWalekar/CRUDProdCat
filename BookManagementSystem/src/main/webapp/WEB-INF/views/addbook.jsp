<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <form action="addingBook" method="POST">
        <div class="form-group">
            <label for="bookName">Book Name</label>
            <input type="text" class="form-control" id="bookName" name="BName" placeholder="Enter book name" required>
        </div>
        <div class="form-group">
            <label for="bookAuthor">Book Author</label>
            <input type="text" class="form-control" id="bookAuthor" name="BAuthor" placeholder="Enter author name" required>
        </div>
        <div class="form-group">
            <label for="bookPublisher">Book Publisher</label>
            <input type="text" class="form-control" id="bookPublisher" name="BPublish" placeholder="Enter publisher name" required>
        </div>
        <div class="form-group">
            <label for="bookPrice">Book Price</label>
            <input type="number" class="form-control" id="bookPrice" name="BPrice" placeholder="Enter book price" required>
        </div>
        <input type="submit" class="btn btn-primary" value="Add Book">
    </form>
</body>
</html>
