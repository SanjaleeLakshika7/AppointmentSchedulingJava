<!-- partial:partials/_sidebar.html -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<nav class="sidebar">
	      <div class="sidebar-header">
	        <a href="#" class="sidebar-brand">
	          The<span>Jobs</span>
	        </a>
	        <div class="sidebar-toggler not-active">
	          <span></span>
	          <span></span>
	          <span></span>
	        </div>
	      </div>
	      <div class="sidebar-body">
	        <ul class="nav">
	          <li class="nav-item nav-category">Main</li>
	          <li class="nav-item ${param.dashboard}">
	            <a href="index.jsp" class="nav-link">
	              <i class="link-icon" data-feather="box"></i>
	              <span class="link-title">Dashboard </span>
	            </a>
	          </li>
	          <c:if test="${sessionScope.user_type eq 'admin'}">
	          <li class="nav-item nav-category">Administration</li>
	          
	          <li class="nav-item ${param.Employee}">
	            <a href="EmployeeControllerServlet" class="nav-link">
	              <i class="link-icon" data-feather="message-square"></i>
	              <span class="link-title">Employees</span>
	            </a>
	          </li> 
	          
	           <li class="nav-item ${param.Consultant}">
	            <a href="ConsultantControllerServlet" class="nav-link">
	              <i class="link-icon" data-feather="message-square"></i>
	              <span class="link-title">Consultants</span>
	            </a>
	          </li>
	          
	          <li class="nav-item ${param.Country}">
	            <a href="CountryControllerServlet" class="nav-link">
	              <i class="link-icon" data-feather="message-square"></i>
	              <span class="link-title">Country</span>
	            </a>
	          </li>
	          
	          <li class="nav-item ${param.Job}">
	            <a href="JobTypeControllerServlet" class="nav-link">
	              <i class="link-icon" data-feather="message-square"></i>
	              <span class="link-title">Job Type</span>
	            </a>
	          </li>
	          
	           <li class="nav-item ${param.ShowAll}">
	            <a href="AppointmentControllerServlet?command=SHOW-ALL" class="nav-link">
	              <i class="link-icon" data-feather="message-square"></i>
	              <span class="link-title">View Appointments </span>
	            </a>
	          </li> 
	        </c:if>
	        
	         <c:if test="${sessionScope.user_type eq 'normal'}">
	          <li class="nav-item nav-category">Appointment   </li>
	          
	          <li class="nav-item   ">
	            <a href="AppointmentControllerServlet?command=SHOW-NEW" class="nav-link">
	              <i class="link-icon" data-feather="message-square"></i>
	              <span class="link-title">View New </span>
	            </a>
	          </li> 
	          
	           <li class="nav-item  ">
	            <a href="AppointmentControllerServlet?command=SHOW-ACCEPT" class="nav-link">
	              <i class="link-icon" data-feather="message-square"></i>
	              <span class="link-title">View OnGoing </span>
	            </a>
	          </li> 
	          
	          
	          <li class="nav-item">
	            <a href="AppointmentControllerServlet?command=SHOW-COMPLETE" class="nav-link">
	              <i class="link-icon" data-feather="message-square"></i>
	              <span class="link-title">View Completed </span>
	            </a>
	          </li> 
	        </c:if>
	       
 
	         </ul>
	      </div>
	    </nav>
	    
	    
	    
	    <nav class="settings-sidebar">
	      <div class="sidebar-body">
	        <a href="#" class="settings-sidebar-toggler">
	          <i data-feather="settings"></i>
	        </a>
	        <h6 class="text-muted">Sidebar:</h6>
	        <div class="form-group">
	          <div class="form-check form-check-inline">
	            <label class="form-check-label">
	              <input type="radio" class="form-check-input" name="sidebarThemeSettings" id="sidebarLight" value="sidebar-light" checked>
	              Light
	            </label>
	          </div>
	          <div class="form-check form-check-inline">
	            <label class="form-check-label">
	              <input type="radio" class="form-check-input" name="sidebarThemeSettings" id="sidebarDark" value="sidebar-dark">
	              Dark
	            </label>
	          </div>
	        </div>
	        </div>
	    </nav>
			<!-- partial -->
		>