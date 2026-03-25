<%@ include file="header.jsp" %>
<div class="col py-3">

    <h2 class="text-center">Contact Requests</h2>

    <table class="table table-hover shadow">
        <thead>
            <tr class="table-primary">
                <th scope="col">Full Name</th>
                <th scope="col">Phone</th>
                <th scope="col">Email</th>
                <th scope="col">Concern</th>
                <th scope="col">Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="contact" items="${contactRequests}">
                <tr>
                    <td>${contact.fullname}</td>
                    <td>${contact.phone}</td>
                    <td>${contact.email}</td>
                    <td>${contact.concern}</td>
                    <td>
                        <form action="/deletecontactrequest" method="post">
                            <input type="hidden" name="phone" value="${contact.phone}">
                            <button type="submit" class="btn btn-outline-danger btn-sm">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>
<%@ include file="footer.jsp" %>
