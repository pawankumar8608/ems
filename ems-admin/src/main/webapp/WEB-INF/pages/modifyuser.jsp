<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/dashboard.css" rel="stylesheet" type="text/css">
<link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/ajax-loader.css" rel="stylesheet" type="text/css" />
<%@ include file="header.jsp" %>
<div class="container">
<form:form method="POST" action="modifyUser" commandName="user">
	<div style="text-align:center; background-color:#107fc9; color:#fff; padding:5px; font-size:large;" class="form-group">Manage User</div>
				<div class="row">
						<div class="col-sm-6 col-md-6 form-group">
							<label for="uname">User Name<span class="required">*</span></label>
						    <form:input path="userName" class="form-control" id="uname" readonly="true"/>
					    </div>
						 
						<div class="col-sm-6 col-md-6  form-group">
							<label for="name" id="lblfname">First Name<span class="required">*</span></label> 
							<form:input path="firstName" class="form-control" id="fname" />
						</div>
						<div class="clear"></div>
						<div class="col-sm-6 col-md-6 form-group">
							<label for="lastname">Last Name</label>
							<form:input path="lastName" class="form-control" id="lname" />
						</div>

						<div class="col-sm-6 col-md-6  form-group">
							<label for="email" id="lblemail">Email <span class="required">*</span></label>
							<form:input path="email" class="form-control" id="email"/>
						</div>
						
						<div class="col-sm-6 col-md-6  form-group">
							<label for="mnumber">Mobile Number<span class="required">*</span></label>
							 <form:input path="mobileNo" class="form-control" id="mnumber" />
						</div>

						<div class="col-sm-6 col-md-6  form-group">
							<label for="address" id="lbladdress">Address<span class="required">*</span></label>
							<form:input path="address" class="form-control" id="address"/>
						</div>

						 <div class="col-sm-6 col-md-6  form-group">
						     <label for="country" id="lblcountry">Country<span class="required">*</span></label>
						     <form:select path="countryId" id="countryId" class="form-control" >
								<option value="0">Select</option>
                                <form:options items="${countryList}" itemValue="id" itemLabel="name"/>
                             </form:select>
					     </div>

						 <div class="col-sm-6 col-md-6  form-group">
							  <label for="state" id="lblstate">State<span class="required">*</span></label>
							   <form:select path="stateId" id="stateId" class="form-control" >
								<option value="0">Select</option>
                                <form:options items="${stateList}" itemValue="id" itemLabel="name"/>
                             </form:select>
						 </div>

						 <div class="col-sm-6 col-md-6  form-group">
							  <label for="city" id="lblcity">City<span class="required">*</span></label>
							  <form:select path="cityId" id="cityId" class="form-control">
								 <option value="0">Select</option>
                                 <form:options items="${cityList}" itemValue = "id" itemLabel="name"/>
                              </form:select>
						 </div>

						<div class="col-sm-6 col-md-6  form-group">
							<label for="enabled">Enabled</label>
							<form:checkbox path="enabled" class="checkbox" />
						</div>
					  </div>
					  <form:hidden path="id" />
					  <div class="row">
						 <div class="col-sm-12 text-left">
					        <input type="submit" value="Update" id="btnSubmit" class="btn btn-primary" />
							<input type="reset" id="resetBtn" value="Reset" class="btn" /> 
					     </div>
			         </div>
	            </form:form>
            </div>
            <script type="text/javascript" src="resources/js/jquery.min.js"></script>
            <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
            <script type="text/javascript" src="resources/js/ajax-loader.js"></script>
            <script type="text/javascript" src="resources/js/csc.js"></script>
            <script>
               $(document).ready(function(){
            	   $("#user").submit(function(){
                	   ajaxLoader.started();
            		   $.post("modifyUser", $("#user").serialize()).done(function(res){
            			   if(res == "update"){
            				   ajaxLoader.finished("User Modified Successfully");
            			   }
            		   });
            		       return false; 
            	   });
            	   
            	   $("#btnSubmit").click(function(){
             		  
            		   var flag= true;
            		  
	            	   if ($('#fname').val() == '') {
	           		        $('#fname').css('border-color', 'red');
	           		        $('#lblfname').css('color', 'red');
	            		    flag= false;

	           		   }else {
	           		        $('#fname').css('border-color', '');
	           		        $('#lblfname').css('color', '');
	           		   }
	            	   
            	       if ($('#email').val() == '') {
           		            $('#email').css('border-color', 'red');
           		            $('#lblemail').css('color', 'red');
	            		    flag= false;

           		       }else {
           		            $('#email').css('border-color', '');
           		            $('#lblemail').css('color', '');
           		       }
            	       
            	       if ($('#address').val() == '') {
           		            $('#address').css('border-color', 'red');
           		            $('#lbladdress').css('color', 'red');
	            		    flag= false;

           		       }else {
           		            $('#address').css('border-color', '');
           		            $('#lbladdress').css('color', '');
           		       }
            	      
            	       if ($('#countryId').val() == '0') {
           		            $('#countryId').css('border-color', 'red');
           		            $('#lblcountry').css('color', 'red');
	            		    flag= false;

           		       }else {
           		            $('#countryId').css('border-color', '');
           		            $('#lblcountry').css('color', '');
           		       }
            	       
            	       if ($('#stateId').val() == '0') {
         		            $('#stateId').css('border-color', 'red');
         		            $('#lblstate').css('color', 'red');
	            		    flag= false;
	            		    
         		       }else {
         		            $('#stateId').css('border-color', '');
         		            $('#lblstate').css('color', '');
         		       }
            	       
            	       if ($('#cityId').val() == '0') {
         		            $('#cityId').css('border-color', 'red');
         		            $('#lblcity').css('color', 'red');
	            		    flag= false;

         		       }else {
         		            $('#cityId').css('border-color', '');
         		            $('#lblcity').css('color', '');
         		       }
            	       
            	       if(flag){
            	    	    return true;
            	    	    
            	       }else{
            	    	    return false;
            	       }
            	       
            	   });
            	   
               });
            </script>
