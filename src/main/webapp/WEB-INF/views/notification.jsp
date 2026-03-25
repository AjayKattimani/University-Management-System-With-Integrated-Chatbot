<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>University Notice Board</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    .container {
        max-width: 800px;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 5px;
    }
    h1 {
        color: #333;
        text-align: center;
    }
    .notice-list {
        list-style-type: none;
        padding: 0;
    }
    .notice {
        background-color: #f9f9f9;
        padding: 20px;
        margin-bottom: 20px;
        border-left: 5px solid #007bff;
        transition: background-color 0.3s ease;
    }
    .notice:hover {
        background-color: #e9e9e9;
    }
    .notice h2 {
        margin-top: 0;
        margin-bottom: 10px;
        color: #333;
    }
    .notice p {
        margin-top: 0;
        margin-bottom: 0;
        color: #555;
    }
    .download-link {
        display: block;
        color: #007bff;
        margin-top: 10px;
        text-decoration: none;
    }
    .download-link:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>

<div class="container">
    <h1>University Notice Board</h1>
    <ul class="notice-list">
        <li class="notice">
            <h2>Reminder: Last date for course registration</h2>
            <p>Dear students, this is to remind you that the last date for course registration for the upcoming semester is May 15, 2024.</p>
            <a href="#" class="download-link" onclick="alert('The download link is not functional in this example.');">Download PDF</a>
        </li>
        <li class="notice">
            <h2>Library Closure Notice</h2>
            <p>Attention all library users, please note that the library will remain closed on May 20, 2024, due to maintenance work. Sorry for the inconvenience.</p>
            <a href="#" class="download-link" onclick="alert('The download link is not functional in this example.');">Download PDF</a>
        </li>
        <li class="notice">
            <h2>Seminar on 'Artificial Intelligence in Healthcare'</h2>
            <p>We are pleased to announce a seminar on the topic 'Artificial Intelligence in Healthcare' scheduled for May 25, 2024. All interested faculty and students are invited to attend.</p>
            <a href="#" class="download-link" onclick="alert('The download link is not functional in this example.');">Download PDF</a>
        </li>
        <!-- Add more notices here -->
        <li class="notice">
            <h2>Guest Lecture by Dr. John Doe</h2>
            <p>Renowned expert Dr. John Doe will deliver a guest lecture on 'Climate Change and Sustainability' on June 1, 2024. Don't miss this opportunity!</p>
            <a href="#" class="download-link" onclick="alert('The download link is not functional in this example.');">Download PDF</a>
        </li>
        <li class="notice">
            <h2>Exam Schedule Announcement</h2>
            <p>The exam schedule for the current semester has been announced. Please check the university website for details.</p>
            <a href="#" class="download-link" onclick="alert('The download link is not functional in this example.');">Download PDF</a>
        </li>
        <li class="notice">
            <h2>Invitation to Sports Day</h2>
            <p>Get ready for the annual sports day event on June 10, 2024. Join us for a day of fun and games!</p>
            <a href="#" class="download-link" onclick="alert('The download link is not functional in this example.');">Download PDF</a>
        </li>
        <li class="notice">
            <h2>Important Announcement for Graduating Students</h2>
            <p>Graduating students, please note the deadlines for thesis submission and graduation ceremony registration.</p>
            <a href="#" class="download-link" onclick="alert('The download link is not functional in this example.');">Download PDF</a>
        </li>
        <li class="notice">
            <h2>Campus Recruitment Drive</h2>
            <p>Top companies will be conducting campus recruitment drives on June 15, 2024. Prepare yourself for interviews!</p>
            <a href="#" class="download-link" onclick="alert('The download link is not functional in this example.');">Download PDF</a>
        </li>
        <li class="notice">
            <h2>Call for Research Papers</h2>
            <p>The university is inviting research papers for publication in the upcoming journal. Submit your papers before the deadline.</p>
            <a href="#" class="download-link" onclick="alert('The download link is not functional in this example.');">Download PDF</a>
        </li>
        <li class="notice">
            <h2>Volunteer Opportunity</h2>
            <p>Volunteers needed for the annual charity event on June 20, 2024. Make a difference in your community!</p>
            <a href="#" class="download-link" onclick="alert('The download link is not functional in this example.');">Download PDF</a>
        </li>
    </ul>
</div>

</body>

    