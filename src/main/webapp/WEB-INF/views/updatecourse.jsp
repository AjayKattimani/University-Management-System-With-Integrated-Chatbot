<%@ include file="header.jsp" %>
			<div class="col py-3">

				<h2 class="text-center">Course Information</h2>

				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link"
						href="/addcourse">
							<button type="button" class="btn" data-bs-toggle="modal"
								data-bs-target="#exampleModal">Add Course</button>
					</a></li>


					<li class="nav-item"><a class="nav-link"
						href="/showcourse"><button class="btn">View
								Course</button></a></li>


				</ul>

				<br> <br>
				
				<div class="container">
					<div class="row justify-content-center">

						<div class="col-5">
							<form action="/updatecourse" method="post" class="shadow p-3">
								<div>
									<h4 class="text-center">Update Course Information</h4>
								</div>
								<div class="mb-3">
									<label for="exampleInputEmail1" class="form-label">Course
										Code </label> <input name="coursecode" type="text"
										class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" value=${sm.semestercode}>

								</div>
								<div class="mb-3">
									<label for="exampleInputPassword1" class="form-label">Course
										Name</label> <input name="coursename" type="text"
										class="form-control" id="exampleInputPassword1"  value=${sm.semestername}>
								</div>
								<div class="mb-3">
									<label for="exampleInputPassword1" class="form-label">Semester
										Name</label> <input name="semestername" type="text"
										class="form-control" id="exampleInputPassword1" >
										<c:forEach var="s" items="${de }">
										<option value="${s.semestername}">${s.semestername}</option>>
										</c:forEach>
								</div>


                               <!--   <div class="col-md-6">
									<label for="id" class="form-label">Department Name</label>
								<select name="departmentname" class="form-select" aria-label="Default select example" id="id">
									<c:forEach var="d" items="${de }">
									<option value="${d.departmentname }">${d.departmentname }</option>
									</c:forEach>-->


								<button type="submit" class="btn btn-primary"
									style="margin-left: 110px">Update Course</button>
							</form>
						</div>
					</div>
				</div>

			</div>
		<%@ include file="footer.jsp" %>