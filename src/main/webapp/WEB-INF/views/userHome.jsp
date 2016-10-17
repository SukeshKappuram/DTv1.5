<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<head>
  <title>Niit Reconnect</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
        <li><a href="blog"> Blog</a></li>
        <li><a href="forum"> Forum</a></li>
        <li><a href="chats"> Chat</a></li>
        <li><a href="logout">logout</a></li>
      </ul>
    </div>
  </div>
</nav>
<div>
<hr></hr>
</div> 
<h1></h1>
 <div class="padding">
                    <div class="full col-sm-9">
                      
                        <!-- content -->                      
                      	<div class="row">
                          
                         <!-- main col left --> 
                         <div class="col-sm-5">
                           
                              <div class="panel">
                               <p>Welcome : ${username}</p>
                                <div><img src="resources/images/${useremail}.jpg" class="img-thumbnail" alt="Cinque Terre" style="width: 350px; height: 250px"></div>
                                <!--  <div class="panel-body">
                                <form:form action="changePro?name=${username}" modelAttribute="profilePicChange"  enctype="multipart/form-data">
                                 Change DP:<form:input type="file" path="file"/>
                                 <input type="submit" value="change">
                                 </form:form>
                                </div>-->
                              </div>
                              </div>
                              </div>
                              </div>
                              </div>


</body>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%@ include file="footer.jsp" %>
</html>
