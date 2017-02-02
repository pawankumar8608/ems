<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/dashboard.css" rel="stylesheet" type="text/css">
<link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
<%@ include file="header.jsp" %>
<div class="container">
    <h2 align="center">Search User</h2>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label><strong>Search User</strong></label>
                <input type="text" placeholder="Search User" class="form-control">
            </div>
        </div>
        <div style="border-right:0px solid #fff;" class="col-md-2">
            <div class="form-group">
                <label style="color:#fff; width:100%;">&nbsp;</label>
                <button data-target="#findpharmacy" data-toggle="collapse" class="btn btn-primary " type="button">Search</button>
            </div>
        </div>
        <div>
            <h1><a style="background-color:#9acd32; margin: 5px;" href="createUser" class="btn btn-small">Create New User</a></h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="table-responsive">
                <table id="searchUserResultTable" style="margin:auto;" class="table table-bordered">
                    <thead>
                    <tr><th colspan="8" style="text-align:center; background-color:#107fc9; color:#fff;">Search User Result</th></tr>
                    <tr>
                        <th class="col-xs-2">USER NAME</th>
                        <th class="col-xs-2">FIRST NAME</th>
                        <th class="col-xs-2">EMAIL</th>
                        <th class="col-xs-2">ADDRESS</th>
                        <th class="col-xs-2">ACTION</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="user">
			           <tr>
			               <td class="col-xs-2 cap">${user[1]}</td>
			               <td class="col-xs-2 strong">${user[2]}</td>
			               <td class="col-xs-2">${user[3]}</td>
			               <td class="col-xs-2">${user[4]}</td>
			               <td><a href="updateUser?id=${user[0]}" class="btn btn-small btn-primary">edit</a>
			               <a class="btn btn-small btn-danger">delete</a></td>
			           </tr>
				     </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.dataTables.min.js" ></script>
<script>
	$(document).ready(function() {
    	$('#searchUserResultTable').DataTable();
    	$(".dataTables_empty").html("User not found");
	});
</script>