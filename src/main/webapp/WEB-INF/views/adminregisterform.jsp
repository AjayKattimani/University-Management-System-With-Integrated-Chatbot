<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Registration</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="mt-4">Admin Registration</h2>
        <form action="/postandlogin" method="post" enctype="multipart/form-data" class="mt-4">
            <div class="form-group">
                <label for="gmail">Gmail:</label>
                <input type="email" id="gmail" name="gmail" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="adminPhoto">Admin Photo:</label>
                <input type="file" id="adminPhoto" name="adminPhoto" class="form-control-file" accept="image/*" required>
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
    </div>
    <!-- Bootstrap JS (optional, if you need JavaScript features) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
