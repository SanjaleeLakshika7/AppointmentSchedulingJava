 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Update Employee - The Jobs</title>
	<jsp:include page="shared/header.html"></jsp:include>
</head>
<body class="sidebar-dark">

	  <%
	   response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if(session.getAttribute("employee_id") == null  ){
			response.sendRedirect("login.jsp");
			
		}
	%>
	<div class="main-wrapper">

		<jsp:include page="shared/sidebar.jsp">
			<jsp:param name="Employee" value="active"/>
		</jsp:include>
		<div class="page-wrapper">
					
		<jsp:include page="shared/searchbar.jsp"></jsp:include>

		<div class="page-content">
	
	        <div class="d-flex justify-content-between align-items-center flex-wrap grid-margin">
		          <div>
		            <h4 class="mb-3 mb-md-0">Update Emloyee</h4>
		          </div>
            </div>
            
            
    <div class="row">
        <div class="col-md-6 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
					 <form action="EmployeeControllerServlet" method="post">
	                   <div class="alert alert-danger col-md-12 ${exceptionerrorshow}" id="divShowError" role="alert">
							<span id="showerrormsg"class="text-danger">${exceptionerror}</span>
						</div>
	
	                 	<div class="form-group row d-none">
	                       <input type="hidden" name="command" value="UPDATEDATA">
	                    </div>
	
                        <div class="form-group row d-none">
                            <label class="col-4 col-form-label" for="txtcountry_specialization_id">Employee ID</label>
                            <div class="col-8">
                                <input type="text" class="form-control" name="country_specialization_id" id="txtcountry_specialization_id" value="${employee.employee_id }">

                            </div>
                        </div>
	
	                     
				        <div class="form-group row">
				            <label class="col-4 col-form-label" for="full_name">Full Name</label>
				            <div class="col-8">
				                <input type="text" class="form-control" name="full_name" id="full_name" value="${employee.fullName }"  >
				            </div>
				        </div>

				        <div class="form-group row">
				            <label class="col-4 col-form-label" for="dob">Date of Birth</label>
				            <div class="col-8">
				                <input type="date" class="form-control" name="dob" id="dob" value="${employee.dob }"  >
				            </div>
				        </div>

				        <div class="form-group row">
				            <label class="col-4 col-form-label" for="nic">NIC</label>
				            <div class="col-8">
				                <input type="text" class="form-control" name="nic" id="nic"  value="${employee.nic }">
				            </div>
				        </div>

				      <div class="form-group row">
						    <label class="col-4 col-form-label" for="user_type">User Type</label>
						    <div class="col-8">
						        <select class="form-control" name="user_type" id="user_type">
						            <option value="admin" ${employee.userType == 'admin' ? 'selected' : ''}>Admin</option>
						            <option value="normal" ${employee.userType == 'normal' ? 'selected' : ''}>Normal</option>
						             
						        </select>
						    </div>
						</div>

				        <div class="form-group row">
				            <label class="col-4 col-form-label" for="address">Address</label>
				            <div class="col-8">
				                <input type="text" class="form-control" name="address" id="address" value="${employee.address }" >
				            </div>
				        </div>

				        <div class="form-group row">
				            <label class="col-4 col-form-label" for="contact_no">Contact Number</label>
				            <div class="col-8">
				                <input type="tel" class="form-control" name="contact_no" id="contact_no"  value="${employee.contactNo }">
				            </div>
				        </div>

				        <div class="form-group row">
				            <label class="col-4 col-form-label" for="email">Email</label>
				            <div class="col-8">
				                <input type="email" class="form-control" name="email" id="email"  value="${employee.email }">
				            </div>
				        </div>

				        <div class="form-group row">
				            <label class="col-4 col-form-label" for="password">Password</label>
				            <div class="col-8">
				                <input type="password" class="form-control" name="password" id="password" value="${employee.password }" >
				            </div>
				        </div>

     

                         
                         <div class="form-group row ">
                             <code>${error }</code>
                         </div>
	                    
	
	                    <div class="form-group row">
	                        <div class="col-4">
	                        </div>
	                        <div class="col-8">
	                            <button type="submit" class="btn btn-primary mr-2">Add</button>
	                            &nbsp;
	                            <a href="EmployeeControllerServlet">Cancel</a>
	                        </div>
	                    </div>
 					</form>

                </div>
            </div>
        </div>
    </div>
            
			
		</div>

			<jsp:include page="shared/footer.html"></jsp:include>
		
		</div>
	</div>
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
 
 