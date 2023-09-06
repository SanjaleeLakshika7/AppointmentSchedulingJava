 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
     	<jsp:include page="shared/headercus.html"></jsp:include>
</head>

<body>
   


   
		<jsp:include page="shared/navigationcus.jsp">
			<jsp:param name="appointment" value="active"/>
		</jsp:include>
    <!-- Page Header Start -->
    <div class="container-fluid bg-dark p-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="display-4 text-white">Appointment</h1>
                <a href="">Home</a>
                <i class="far fa-square text-primary px-2"></i>
                <a href="">Appointment</a>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Contact Start -->
    <div class="container-fluid bg-secondary px-0">
        <div class="row g-0">
            <div class="col-lg-12 py-6 px-5">
                <h1 class="display-5 mb-4">Schedule Appointment</h1>
                <form action="AppointmentControllerServlet" method="post">
                <div class="alert alert-danger col-md-12 ${exceptionerrorshow}" id="divShowError" role="alert">
							<span id="showerrormsg"class="text-danger">${exceptionerror}</span>
						</div>
							<div class="form-group row d-none">
	                       <input type="hidden" name="command" value="ADDDATA">
	                    </div>
                    <div class="row g-3">
                        <div class="col-6">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="full_name" id="form-floating-1" placeholder="John Doe">
                                <label for="form-floating-1">Full Name</label>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="contact_number"  id="form-floating-2" placeholder="name@example.com">
                                <label for="form-floating-2">Contact Number</label>
                            </div>
                        </div>
                        
                         <div class="col-6">
                            <div class="form-floating">
                                <input type="email" class="form-control" name="email"  id="form-floating-1" placeholder="John Doe">
                                <label for="form-floating-1">Email</label>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="address"  id="form-floating-2" placeholder="name@example.com">
                                <label for="form-floating-2">Address</label>
                            </div>
                        </div>
                        
                          <div class="col-6">
                            <div class="form-floating">
                                <input type="date" class="form-control" name="appointmentDate"  id="form-floating-1" placeholder="John Doe">
                                <label for="form-floating-1">Appointment Date</label>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-floating">
                                <input type="time" class="form-control" name="appointmentTime"  id="form-floating-2" placeholder="name@example.com">
                                <label for="form-floating-2">Appointment Time</label>
                            </div>
                        </div>
                        
                        <div class="col-6">
                       <div class="row">
						    <div class="col-md-12">
						        <div class="form-floating">
						            <select name="country_specialization_id" class="form-control">
						                <c:forEach items="${Country_SpecializationDrp}" var="Country_SpecializationDrp">
						                    <option value="${Country_SpecializationDrp.country_specialization_id}">
						                        ${Country_SpecializationDrp.country_name}
						                    </option>
						                </c:forEach>
						            </select>
						            <label for="txtcountry_specialization_id"> Select Country</label>
						        </div>
						    </div>
						</div>
                        </div>
                        
                          <div class="col-6">
                       <div class="row">
						    <div class="col-md-12">
						        <div class="form-floating">
						            <select name="job_type_specialization_id" class="form-control">
						                <c:forEach items="${jobTypesDrp}" var="jobTypesDrp">
						                    <option value="${jobTypesDrp.job_type_specialization_id}">
						                        ${jobTypesDrp.job_type_name}
						                    </option>
						                </c:forEach>
						            </select>
						            <label for="txtjob_type_specialization_id"> Select Job </label>
						        </div>
						    </div>
						</div>
                        </div>
                        
                        <div class="col-12">
                            <button class="btn btn-primary w-100 py-3" type="submit">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
             
        </div>
    </div>
    <!-- Contact End -->


    <jsp:include page="shared/footercus.html"></jsp:include>
     <script type="text/javascript">

	$(document).ready(function () {

		show_Error();
    });

	function show_Error() {
		var showerror = $("#showerrormsg").text();
		if(showerror ==""){
			$("#divShowError").hide();
		}


	}


    </script>
</body>

</html>