 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Add Consultants - The Jobs</title>
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
			<jsp:param name="Consultant" value="active"/>
		</jsp:include>
		<div class="page-wrapper">
					
		<jsp:include page="shared/searchbar.jsp"></jsp:include>

		<div class="page-content">
	
	        <div class="d-flex justify-content-between align-items-center flex-wrap grid-margin">
		          <div>
		            <h4 class="mb-3 mb-md-0">Add Consultants</h4>
		          </div>
            </div>
            
            
    <div class="row">
        <div class="col-md-6 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
					 <form action="ConsultantControllerServlet" method="post">
	                   <div class="alert alert-danger col-md-12 ${exceptionerrorshow}" id="divShowError" role="alert">
							<span id="showerrormsg"class="text-danger">${exceptionerror}</span>
						</div>
	
	                 	<div class="form-group row d-none">
	                       <input type="hidden" name="command" value="ADDDATA">
	                    </div>
	
                       
	
	                
   
                        
                           <div class="form-group row">
                                <label class="col-4 col-form-label" for="txtemployee_id">Employee Name</label>
                                <div class="col-8">
                                    <select name="employee_id" class="form-control">

                                        <c:forEach items="${employeesDrp}" var="employeesDrp">
                                            <option value="${employeesDrp.employee_id}">${employeesDrp.fullName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group row ">
                                <label class="col-4 col-form-label" for="txtcountry_specialization_id">Country</label>
                                <div class="col-8">
                                    <select name="country_specialization_id" class="form-control">

                                        <c:forEach items="${Country_SpecializationDrp}" var="Country_SpecializationDrp">
                                            <option value="${Country_SpecializationDrp.country_specialization_id}">${Country_SpecializationDrp.country_name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            
                               <div class="form-group row ">
                                <label class="col-4 col-form-label" for="txtjob_type_specialization_id">Job Type</label>
                                <div class="col-8">
                                    <select name="job_type_specialization_id" class="form-control">

                                        <c:forEach items="${jobTypesDrp}" var="jobTypesDrp">
                                            <option value="${jobTypesDrp.job_type_specialization_id}">${jobTypesDrp.job_type_name}</option>
                                        </c:forEach>
                                    </select>
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
	                            <a href="CountryControllerServlet">Cancel</a>
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
 
 