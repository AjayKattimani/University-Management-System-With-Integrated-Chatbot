<%@ include file="studentheader.jsp"%>
<%@ include file="studentsidebar.jsp"%>

<style>
    .student-details {
        margin: 20px;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 8px;
        background-color: #f9f9f9;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .student-details h2 {
        font-size: 24px;
        margin-bottom: 20px;
    }
    .student-details p {
        font-size: 18px;
        margin: 10px 0;
    }
    .student-details form {
        margin-top: 20px;
    }
    .student-details button {
        background-color: #007bff;
        color: white;
        border: none;
        padding: 10px 20px;
        font-size: 16px;
        border-radius: 4px;
        cursor: pointer;
    }
    .student-details button:hover {
        background-color: #0056b3;
    }
</style>

<div class="col py-3">
    <div class="student-details">
        <h2>Student Details</h2>
        <p><strong>ID:</strong> ${student.id}</p>
        <p><strong>Name:</strong> ${student.name}</p>
        <p><strong>Father's Name:</strong> ${student.father_name}</p>
        <p><strong>Mother's Name:</strong> ${student.mother_name}</p>
        <p><strong>Email:</strong> ${student.email}</p>
        <p><strong>Phone:</strong> ${student.phone}</p>
        <p><strong>Address:</strong> ${student.address}</p>
        <p><strong>Birthdate:</strong> ${student.birthdate}</p>
        <p><strong>Blood Group:</strong> ${student.blood_group}</p>
        <p><strong>Photo:</strong> <img src="${student.photo}" alt="Student Photo" width="100"></p>
        <p><strong>Gender:</strong> ${student.gender}</p>
        <p><strong>Semester Fee:</strong> ${student.semester_fee}</p>
        <p><strong>Quota:</strong> ${student.quta}</p>
        <p><strong>Department Code:</strong> ${student.departmentcode}</p>
        <p><strong>Department Name:</strong> ${student.departmentname}</p>

    </div>
</div>

<%@ include file="footer.jsp"%>
