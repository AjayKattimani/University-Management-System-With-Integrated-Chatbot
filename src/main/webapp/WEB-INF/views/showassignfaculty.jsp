
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="studentheader.jsp"%>
<%@ include file="studentsidebar.jsp"%>

        <div class="col py-3">
        
            <div class="container">
					<div class="row justify-content-center">

						<div class="col-12">

							<div class="container ">
								<div class="row">
									<div class="col">
										<h5>All Faculty</h5>
									</div>
									<div class="col">
										<form class="d-flex" role="search" action="" method="post">
											<input name="semestercode" class="form-control me-2" type="search"
												placeholder="Search by Semester code" aria-label="Search">
											<button class="btn btn-outline-success" type="submit">Search</button>
										</form>
									</div>
								</div>

							</div>

							<br>

							<table class="table table-hover shadow ">
								<thead>
									<tr class="table-primary">

										<th scope="col">Faculty Name</th>
										<th scope="col">Course Name</th>
										<th scope="col">Semester Name</th>
										<th scope="col">Department Name</th>
										


									</tr>
								</thead>
								<tbody>
									<c:forEach var="f" items="${f}">
										<tr>
											<td>${f.name }</td>
											<td>${f.coursename }</td>
											<td>${f.semestername }</td>
											<td>${f.departmentname }</td>
											
											
										</tr>
									</c:forEach>


								</tbody>
							</table>

						</div>
					</div>
				</div>
            
           
        </div>
    </div>
</div>

</body>
</html>