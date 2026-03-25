<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .welcome-container {
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            width: 400px;
            text-align: center;
        }

        .welcome-container h2 {
            margin-bottom: 20px;
        }

        .student-info {
            text-align: left;
            margin-top: 20px;
        }

        .student-info p {
            margin: 5px 0;
        }

        .btn {
            background-color: #007BFF;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            margin-top: 20px;
        }

        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="welcome-container">
        <h2>Welcome, ${student.name}!</h2>
        <div class="student-info">
            <p><strong>Student ID:</strong> ${student.id}</p>
            <p><strong>Email:</strong> ${student.email}</p>
            <p><strong>Phone:</strong> ${student.phone}</p>
            <p><strong>Address:</strong> ${student.address}</p>
            <p><strong>Department:</strong> ${student.departmentname}</p>
        </div>
        <button class="btn" onclick="logout()">Logout</button>
    </div>

    <script>
        function logout() {
            // Redirect to a logout URL or clear session (not implemented here)
            alert("Logout functionality not implemented yet.");
        }
    </script>
</body>
</html>
