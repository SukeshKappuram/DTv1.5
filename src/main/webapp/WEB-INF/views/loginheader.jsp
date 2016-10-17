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
        <li><a href="UserCheck"> Sign In</a></li>
    
      </ul>
    </div>
  </div>
</nav>
    </div>
<body onload='document.f.j_username.focus();'>

<div>

<center><img src="<c:url value="/resources/images/auth.jpg"/>" style="width: 400px"; height="300px"></center>
<hr></hr>  
<c:if test="${SPRING_SECURITY_LAST_EXCEPTION !=null}">
<div>
<center>Your login attempt was not successful, try again!!
caused:${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</center>
</div>
</c:if>
<div>
<br></br>
</div>
    <div align="center" class="form">
   <form name='f' action="<c:url value='j_spring_security_check'/>" method='POST' >
      <table>
         <tr>
           <td style="font-size: 20px">Enter email:</td> <td><input type='text' name='j_username' style="width:300px;height: 40px" placeholder="UserName Required"  required="required"/></td><td><br></br></td>
         </tr>
         <tr><td><br></br></td></tr>
         <tr>
           <td style="font-size: 20px">Enter Password:</td> <td><input type='password' name='j_password' style="width: 300px;height: 40px" placeholder="Password Required" required="required"/></td><td><br></br></td>
         </tr>
          <tr><td><br></br></td></tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
  </form>
 </div>
</div>
</body>
<br></br>