<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Student Information | Students</title>
    <link href="resources/sbadmin/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/sbadmin/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
    <link href="resources/sbadmin/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">
    <link href="resources/sbadmin/bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">
    <link href="resources/sbadmin/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="resources/sbadmin/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="">Student Information</a>
            </div>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="home">Home</a>
                        </li>
                        <li>
                            <a href="students">Students</a>
                        </li>
                        <li>
                            <a href="instructors">Instructors</a>
                        </li>
                        <li>
                            <a href="subjects">Subjects</a>
                        </li>
                        <li>
                            <a href="rooms">Rooms</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Student</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2 col-xs-12">
                    <h4 class="box-title">
                        <a href="#addStudentModal" role="button" class="btn btn-lg btn-success" data-toggle="modal" style="box-shadow: 0px 4px 8px #888888">
                            ADD STUDENT
                        </a>
                    </h4>
                </div>
            </div>

            <div id="addStudentModal" class="modal fade">
                <form id="studentForm" name="studentForm" method="post" action="addNewStudent" commandName="student">
                    <div class="modal-dialog">
                        <div class="modal-content" >
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title">Student Form</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row" style="margin-bottom:5px">
                                    <div class="col-md-8 col-xs-12">
                                        <label>Student ID</label>
                                        <input type="text" class="form-control input-sm" id="studentId" name="studentId">
                                    </div>
                                </div>
                                <div class="row" style="margin-bottom:5px">
                                    <div class="col-md-4 col-xs-12">
                                        <label>First Name</label>
                                        <input type="text" class="form-control input-sm" id="firstName" name="firstName">
                                    </div>
                                    <div class="col-md-4 col-xs-12">
                                        <label>Middle Name</label>
                                        <input type="text" class="form-control input-sm" id="middleName" name="middleName">
                                    </div>
                                    <div class="col-md-4 col-xs-12">
                                        <label>Last Name</label>
                                        <input type="text" class="form-control input-sm" id="lastName" name="lastName">
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-lg btn-block btn-success" id="btnSave" onclick="saveNewStudent()" >Save</button>
                                <button type="button" class="btn btn-lg btn-block btn-danger" data-dismiss="modal">Cancel</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div> 

            <div id="deleteModal" class="modal fade">
                <div class="modal-dialog" style="width:30%">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Confirmation</h4>
                        </div>
                        <div class="modal-body">
                            <h4>Are you sure you want to delete this record?</h4>
                            <p class="text-warning"><small>You cannot recover deleted records</small></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-lg btn-block btn-danger" id="btnDelete" onclick="deleteStudent()">Delete</button>
                            <button type="button" class="btn btn-lg btn-block btn-default" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Students
                        </div>
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-students">
                                    <thead>
                                        <tr>
                                            <th>Student ID</th>
                                            <th>Name</th>
                                            <th colspan="2">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${students}" var="student">
	                                        <tr>
	                                            <td><c:out value="${student.studentId}"/></td>
	                                            <td><c:out value="${student.lastName}"/>, <c:out value="${student.firstName}"/> <c:out value="${student.middleName}"/></td>
	                                        	<td style="width: 70px;"><input type="button" value="Update" class="btn btn-xs btn-block btn-flat" /></td>
	                                        	<td style="width: 70px;"><input type="button" value="Delete" class="btn btn-xs btn-block btn-flat" data-toggle="modal" data-target="#deleteModal"/></td>
	                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="resources/sbadmin/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="resources/sbadmin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="resources/sbadmin/bower_components/metisMenu/dist/metisMenu.min.js"></script>
    <script src="resources/sbadmin/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="resources/sbadmin/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
    <script src="resources/sbadmin/dist/js/sb-admin-2.js"></script>
    <script>
        $(document).ready(function() {
            $('#dataTables-students').DataTable({
                responsive: true
            });
        });

        function saveNewStudent() {
            $('#studentForm').submit();
        }

    </script>
</body>

</html>