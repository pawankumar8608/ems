           $(document).ready(function() {
                   $("#countryId").change(function(){
            		   if($("#countryId").val() != "0"){
            			   $.get("getStateByCountryId", {"countryId": $("#countryId").val()}).done(function(data){
            				   $("#stateId").prop("disabled", false);
                			   var select1 = $("#cityId").empty();
                			   $("#cityId").prop("disabled", true);
            				   var states = data;
            				   var select = $("#stateId").empty();
            				   var optionString = '<option value=\"0\">Select</option>';
            				   $.each(states, function(key, value){
            					   optionString += '<option value=\"'+value.id+'\">'+value.name+'</option>';
            				   });
            				     select.append(optionString);
            				     select1.append(optionString);
            			   });

            		    }else{
        				      var optionString = '<option value=\"0\">Select</option>';
            			      var select = $("#stateId").empty();
      				          select.append(optionString);
            			      $("#stateId").prop("disabled", true);
            			      var select1 = $("#cityId").empty();
      				          select1.append(optionString);
            			      $("#cityId").prop("disabled", true);
            		    }
            		   
            	   });
            	   
            	   $("#stateId").change(function(){
            		   if($("#stateId").val() != '0'){
            			   $.get("getCityByStateId", {"stateId" : $("#stateId").val()}).done(function(data){
            				   $("#cityId").prop("disabled", false);
            				   var cities = data;
            				   var select = $("#cityId").empty();
            				   var optionString = '<option value=\"0\">Select</option>';
            				   $.each(cities, function(key, value){
            					   optionString += '<option value=\"'+value.id+'\">'+value.name+'</option>';
            				   });
            				     select.append(optionString);
            			   });
            		    }else{
         				     var optionString = '<option value=\"0\">Select</option>';
            		    	 var select = $("#cityId").empty();
        				     select.append(optionString);
              			     $("#cityId").prop("disabled", true);
            		    }
            		   
            	   });
            });