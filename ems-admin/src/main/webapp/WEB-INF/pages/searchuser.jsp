<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
                    <a href="<c:url value="/logout" />"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                </li>
            </ul>
        </li>
    </ul>
</nav>
<div class="container">
    <h2 align="center">Search User</h2>
    <div class="row">
        <div class="col-md-12">
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
                <table style="margin:auto;" class="table table-bordered">
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
		                        <td class="col-xs-2 cap">${user.userName}</td>
		                        <td class="col-xs-2 strong">${user.firstName}</td>
		                        <td class="col-xs-2">${user.email}</td>
		                        <td class="col-xs-2">${user.address}</td>
		                        <td><a href="#" class="btn btn-small btn-primary">edit</a>
		                        <a class="btn btn-small btn-danger">delete</a></td>
		                    </tr>
		                </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
