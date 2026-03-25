<%@ include file="header.jsp" %>
<div class="col py-3">

    <h2 class="text-center">Job Applications</h2>

    <table class="table table-hover shadow">
        <thead>
            <tr class="table-primary">
                <th scope="col">ID</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Job Position</th>
                <th scope="col">Experience</th>
                <th scope="col">View Resume</th>
                <th scope="col">Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="app" items="${jobApplications}">
                <tr>
                    <td>${app.id}</td>
                    <td>${app.firstName}</td>
                    <td>${app.lastName}</td>
                    <td>${app.jobPosition}</td>
                    <td>${app.experience}</td>
                    <td>
                        <a href="/viewresume/${app.id}" class="btn btn-outline-primary btn-sm">View Resume</a>
                    </td>
                    <td>
                        <form action="/deletejobapplication" method="post">
                            <input type="hidden" name="id" value="${app.id}">
                            <button type="submit" class="btn btn-outline-danger btn-sm">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>
<%@ include file="footer.jsp" %>
