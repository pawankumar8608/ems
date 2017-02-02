<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/dashboard.css" rel="stylesheet" type="text/css">
<link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/ajax-loader.css" rel="stylesheet" type="text/css" />
<%@ include file="header.jsp" %>
<div class="container">
<form method="POST" action="/admin/addUser" id="user">
	<div style="text-align:center; background-color:#107fc9; color:#fff; padding:5px; font-size:large;" class="form-group">Create User</div>
				<div class="row">
						 <div class="col-sm-6 col-md-6 form-group">
							<label for="uname" id="lbluname">User Name<span class="required">*</span></label>
							<input type="text" name="userName" class="form-control" id="uname"/>
						 </div>
						 
						 <div class="col-sm-6 col-md-6  form-group">
							<label for="name" id="lblfname">First Name<span class="required">*</span></label> 
							<input type="text" name="firstName" class="form-control" id="fname"/>
						</div>
						<div class="clear"></div>
						<div class="col-sm-6 col-md-6 form-group">
							<label for="lastname">Last Name</label>
							 <input type="text" name="lastName" class="form-control" id="lname" />
						</div>

						<div class="col-sm-6 col-md-6  form-group">
							<label for="email" id="lblemail">Email <span class="required">*</span></label>
							 <input type="email" name="email" class="form-control" id="email"/>
						</div>
						
						<div class="col-sm-6 col-md-6  form-group">
							<label for="mnumber">Mobile Number</label>
							 <input type="text" name="mobileNo" class="form-control" id="mnumber" />
						</div>

						<div class="col-sm-6 col-md-6  form-group">
							<label for="address" id="lbladdress">Address<span class="required">*</span></label>
							<input type="text" name="address" class="form-control" id="address"/>
						</div>

						 <div class="col-sm-6 col-md-6  form-group">
						     <label for="country" id="lblcountry">Country<span class="required">*</span></label>
						     <select id="countryId" class="form-control" name="countryId">
								 <option value="0">Select</option>
						         <c:forEach items="${countryList}" var="country">
						           <option value="${country.id}">${country.name}</option>
						         </c:forEach>
						     </select>
					     </div>

						 <div class="col-sm-6 col-md-6  form-group">
							  <label for="state" id="lblstate">State<span class="required">*</span></label>
							  <select id="stateId" name="stateId" class="form-control" disabled required >
								 <option value="0" selected>Select</option>
							  </select>
						 </div>

						 <div class="col-sm-6 col-md-6  form-group">
							  <label for="city" id="lblcity">City<span class="required">*</span></label>
							  <select id="cityId" name="cityId" class="form-control" disabled required >
								 <option value="0" selected>Select</option>
							  </select>
						 </div>

						<div class="col-sm-6 col-md-6  form-group">
							<label for="enabled">Enabled</label>
							<input type="checkbox" name="enabled" value="true" class="checkbox" />
						</div>
					  </div>
					  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					  <div class="row">
						 <div class="col-sm-12 text-left">
					        <input type="submit" value="Save" id="btnSubmit" class="btn btn-primary" />
							<input type="reset" id="resetBtn" value="Reset" class="btn" /> 
					     </div>
			         </div>
	            </form>
            </div>
            <script type="text/javascript" src="resources/js/jquery.min.js"></script>
            <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
            <script type="text/javascript" src="resources/js/ajax-loader.js"></script>
            <script type="text/javascript" src="resources/js/csc.js"></script>
            <script type="text/javascript" src="resources/js/user.js"></script>
            
