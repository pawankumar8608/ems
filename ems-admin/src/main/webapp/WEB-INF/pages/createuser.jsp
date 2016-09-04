<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/dashboard.css" rel="stylesheet" type="text/css">
<link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <a class="navbar-brand" href="/admin/welcome">EMS Admin</a>
    </div>
    <!-- Top Menu Items -->
    <ul class="nav navbar-right top-nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>&nbsp;ADMIN<b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li>
                    <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-fw fa-wrench"></i>Change Password</a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                </li>
            </ul>
        </li>
    </ul>
</nav>
<div class="container">
<form method="POST" action="/admin/addUser">
	<div style="text-align:center; background-color:#107fc9; color:#fff; padding:5px; font-size:large;" class="form-group">Create User</div>
				<div class="row">
						 <div class="col-sm-6 col-md-6 form-group">
							<label for="uname">User Name<span class="required">*</span></label>
							<input type="text" name="userName" class="form-control" id="uname"/>
						 </div>
						 
						 <div class="col-sm-6 col-md-6  form-group">
							<label for="name">First Name<span class="required">*</span></label> 
							<input type="text" name="firstName" class="form-control" id="fname" />
						</div>
						<div class="clear"></div>
						<div class="col-sm-6 col-md-6 form-group">
							<label for="lastname">Last Name</label>
							 <input type="text" name="lastName" class="form-control" id="lname" />
						</div>

						<div class="col-sm-6 col-md-6  form-group">
							<label for="email">Email <span class="required">*</span></label>
							 <input type="email" name="email" class="form-control" id="email"/>
						</div>
						
						<div class="col-sm-6 col-md-6  form-group">
							<label for="mnumber">Mobile Number<span class="required">*</span></label>
							 <input type="text" name="mobileNo" class="form-control" id="mnumber" />
						</div>

						<div class="col-sm-6 col-md-6  form-group">
							<label for="address">Address<span class="required">*</span></label>
							<input type="text" name="address" class="form-control" id="address"/>
						</div>

						 <div class="col-sm-6 col-md-6  form-group">
						     <label for="country">Country<span class="required">*</span></label>
						     <select id="countryId" class="form-control" name="countryId">
								 <option value="0">Select</option>
					             <option value="3">India</option>
						     </select>
					     </div>

						 <div class="col-sm-6 col-md-6  form-group">
							  <label for="state">State<span class="required">*</span></label>
							  <select id="stateId" name="stateId" class="form-control">
								 <option value="0" selected>Select</option>
								 <option value="35">Madhya Pradesh</option>
							  </select>
						 </div>

						 <div class="col-sm-6 col-md-6  form-group">
							  <label for="city">City<span class="required">*</span></label>
							  <select id="cityId" name="cityId" class="form-control">
								 <option value="0" selected>Select</option>
								 <option value="1305" selected>Bhopal</option>
							  </select>
						 </div>

						<div class="col-sm-6 col-md-6  form-group">
							<label for="enabled">Enabled</label>
							<input type="checkbox" value="true" class="checkbox" id="enabled" />
						</div>
					  </div>
					  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					  <div class="row">
						 <div class="col-sm-12 text-left">
					        <input type="submit" value="Save" class="btn btn-primary" />
							<input type="reset" id="resetBtn" value="Reset" class="btn" /> 
					     </div>
			         </div>
	            </form>
            </div>


