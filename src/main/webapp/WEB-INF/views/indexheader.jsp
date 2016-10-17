<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <li><a href="SignUp">Sign Up</a></li>
        <li><a href="UserCheck">Sign In</a></li>
      </ul>
    </div>
  </div>
</nav>
    </div>
	  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src="<c:url value="/resources/images/EDUCATION.jpg"/>" alt="sss" style="width:600px; height:400px">
        <div class="carousel-caption">
		 <form class="form-inline" role="form">
          <div class="form-group">
     
	  </form>
    </div>
        </div>
      </div>

      <div class="item">
        <img src="<c:url value="/resources/images/DIGINXT.jpg"/>" alt="Chania" style="width:600px; height:400px">
        <div class="carousel-caption">
         <form class="form-inline" role="form">
          <div class="form-group">
	  </form>
    </div>
        </div>
      </div>
      <div class="item">
        <img src="<c:url value="/resources/images/i.jpg"/>" alt="Flower" style="width:600px; height:400px">
        <div class="carousel-caption">
         <form class="form-inline" role="form">
          <div class="form-group">
     
	  </form>
    </div>
        </div>
      </div>
      <div class="item">
        <img src="<c:url value="/resources/images/niittv.jpg"/>" alt="Flower" style="width:600px; height:400px">
        <div class="carousel-caption">
         <form class="form-inline" role="form">
          <div class="form-group">
	  </form>
    </div>
        </div>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <br><br>
</div>
<div>

<div>
<center><h3>What We Offer You</h3></center>
<hr></hr>
</div>
<div class="row">
    <div class="col-md-4">
      <a href="<c:url value="userCheck" />" class="thumbnail">  
        <img src="<c:url value="/resources/images/blog.jpg"/>" alt="Pulpit Rock" style="width:250px;height:250px">
		
      </a>
	    
    </div>
    <div class="col-md-4">
      <a href="<c:url value="userCheck" />" class="thumbnail">
       
        <img src="<c:url value="/resources/images/forum.jpg"/>" alt="Moustiers Sainte Marie" style="width:250px;height:250px">
      </a>
    </div>
    <div class="col-md-4">
      <a href="<c:url value="userCheck" />" class="thumbnail">
           
        <img src="<c:url value="/resources/images/discuss.jpg"/>" alt="Cinque Terre" style="width:250px;height:250px">
      </a>
    </div>
  </div>
</div>
</body>
<div><hr></hr></div>
