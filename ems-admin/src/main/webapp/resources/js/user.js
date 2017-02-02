         $(document).ready(function(){
            	   $("#user").submit(function(){
                	   ajaxLoader.started();
            		   $.post("/admin/addUser", $("#user").serialize()).done(function(res){
            			   if(res == "Saved"){
            				   ajaxLoader.finished("User Saved Successfully");
       					       $( "#resetBtn" ).trigger( "click" );

            			   }
            		   });
            		       return false; 
            	   });
            	   
            	  // -----------------User Form Validation-----------------------
            	   
            	  $("#btnSubmit").click(function(){
            		  
            		   var flag= true;
            		  
	            	   if ($('#uname').val() == '') {
	            		    $('#uname').css('border-color', 'red');
	            		    $('#lbluname').css('color', 'red');
	            		    flag= false;
	            	   }else {
	            		    $('#uname').css('border-color', '');
	            		    $('#lbluname').css('color', '');
	            	   }
	            	   
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
