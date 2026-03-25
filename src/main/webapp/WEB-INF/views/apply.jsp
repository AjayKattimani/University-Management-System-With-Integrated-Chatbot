<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job Application</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	width: 50%;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	color: #333;
}

form {
	display: flex;
	flex-direction: column;
}

label {
	margin-bottom: 5px;
	font-weight: bold;
}

input, select {
	margin-bottom: 20px;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 5px;
}

input[type="file"] {
	padding: 0;
}

button {
	padding: 10px;
	color: #fff;
	background-color: #0073e6;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

button:hover {
	background-color: #005bb5;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Job Application Form</h1>
		<form action="/confirm" method="post" enctype="multipart/form-data">
			<label for="firstName">First Name:</label> <input type="text"
				id="firstName" name="firstName" required> <label
				for="lastName">Last Name:</label> <input type="text" id="lastName"
				name="lastName" required> 
				<label for="dob">Date ofBirth:</label> 
				<input type="date" id="dob" name="dateOfBirth" required>


			<label for="mobile">Mobile Number:</label> <input type="tel"
				id="mobile" name="mobileNumber" pattern="[0-9]{10}" required>

			<label for="job">Job Position:</label> <select id="job"
				name="jobPosition" required>
				<option value="java_teacher">Java Teacher</option>
				<option value="python_teacher">Python Teacher</option>
				<option value="webdev_teacher">Web Development Teacher</option>
				<option value="db_teacher">Database Management Teacher</option>
				<option value="datascience_teacher">Data Science Teacher</option>
				<option value="ml_teacher">Machine Learning Teacher</option>
				<option value="cybersec_teacher">Cyber Security Teacher</option>
				<option value="ai_teacher">Artificial Intelligence Teacher</option>
				<option value="cloud_teacher">Cloud Computing Teacher</option>
				<option value="network_teacher">Network Administration
					Teacher</option>
			</select> <label for="experience">Experience (years):</label> <select
				id="experience" name="experience" required>
				<% for (int i = 0; i <= 10; i++) { %>
				<option value="<%=i%>"><%=i%></option>
				<% } %>
			</select> <label for="resume">Upload Resume (PDF only, max 5MB):</label> <input
				type="file" id="resume" name="resume" accept=".pdf" required>

			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>
