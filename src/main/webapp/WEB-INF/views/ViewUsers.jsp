<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
  <title>Niit Reconnect</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script>document.write('<base href="' + document.location + '" />');</script>
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="./resources/css/style.css" rel="stylesheet" media="screen">
    <script data-require="angular.js@1.0.x" src="http://code.angularjs.org/1.0.7/angular.min.js" data-semver="1.0.7"></script>
    <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
	.carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  </style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid" style="background-color:#003366">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#" style="color:white">NIIT CONNECT</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="ViewUsers"> View Users</a></li>
        <li><a href="logout">logout</a></li>
      </ul>
    </div>
  </div>
</nav>
<div>
<hr></hr>
</div>
<div class="container">
  <div ng-app="myApp" ng-controller="dataCtrl">
Enter  Name:  <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
    <hr></hr>
    <div>
   <center><h2> ${param.res}</h2></center>
    </div>
    <table class="table table-striped">
    <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email id</th>
    <th>Gender</th>
    <th>Image</th>
    </tr>
        <tr ng-repeat="resource in names | filter:search">
             <td>{{resource.firstName}}</td>
            <td>{{ resource.lastName}}</td>
            <td>{{ resource.email}}</td>
            <td>{{ resource.gender}}</td>
            <td><img src="resources/images/{{resource.email}}.jpg" style="width: 200px;height:150px"></td>
            <td><a href="deactivateUser?id={{resource.user_id}}&&name={{resource.firstName}}">DeActivate</a></td>
            <td><a href="activateUser?id={{resource.user_id}}&&name={{resource.firstName}}">Activate</a></td>
            <td><a href="makeAdmin?id={{resource.user_id}}&&name={{resource.firstName}}">Make Admin</a></td>
        </tr>    
    </table>
</div>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${usersdata};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
</body>
<%@ include file="footer.jsp" %>
</html>