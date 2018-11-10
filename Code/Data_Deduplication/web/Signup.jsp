
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>SDD</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />

<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Charity Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
<!---->
<div class="header">
	 <div class="container">
		 <div class="header-top">
			 <div class="logo">
                          
				<!-- <a href="index.html"><h1>Secure <span>Distributed  Systems</span></h1></a>-->
			 </div>
			  
		
			 <div class="clearfix"> </div>
			 <!-- search-scripts -->
			 
			 
			<!-- //search-scripts -->
		 </div>
		<!-- <div class="top-menu">
			 <span class="menu">MENU</span>
			 <ul>
			 <li class="active"><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
			 <li><a href="about.html"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>About</a></li>
			 <li><a href="shortcodes.html"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>Shortcodes</a></li>
			 <li><a href="gallery.html"><span class="glyphicon glyphicon-picture" aria-hidden="true"></span>Gallery</a></li>
			 <li><a href="contact.html"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>Contact</a></li>
			 </ul>
		 </div>-->
		 <!-- script-for-menu -->
		  
		 <!-- script-for-menu -->	
		 <div class="clearfix"></div>
	 </div>
</div>
<!---->
<div class="banner">
	 <div class="container">			
			 
			  
			 <div class="slider">
				 <div class="callbacks_container">
				     <ul class="rslides" id="slider">
						 
					  </ul>
				 </div>
			 </div>
			  <!----->		  

	 </div>
</div>
<!---->
<div class="welcome">
	 <div class="container">
		 <div class="welcome-top">
                     <h3>Sign Up the User</h3><br/>
                     <center>
                         <form action="Signup" method="post">
                               
                         <table>
                            
                             <tbody>
                                 <tr>
                                     <td>Name:</td>
                                     <td></td>
                                     <td><input type="text" name="uname" value="" placeholder="username is minimum 4 letters" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'uname';}" required=""/></td>
                                 </tr>
                                                      
                                 <tr>
                                     <td>Password</td>
                                     <td></td>
                                     <td><input type="password" name="pwd" value="" placeholder="######" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'pwd';}" required=""/></td>
                                 </tr>
                                 
                                     <tr>
                                     <td>Email:</td>
                                     <td></td>
                                     <td><input type="text" name="email" value="" placeholder="username@domain.com" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'email';}" required=""/></td>
                                 </tr>
                                 
                                 
                                    <tr>
                                     <td>DOB:</td>
                                     <td></td>
                                     <td><input type="text" name="dob" value="" placeholder="yyyy-mm-DD" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'dob';}" required="" /></td>
                                 </tr>
                                     
                                 
                                 
                                 <tr>
                                     <td></td>
                                     <td></td>
                                     <td><input type="submit" value="SignUp" />&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear" /></td>
                                 </tr>
                             </tbody>
                         </table>
                         </form></center>
                     <p>Back to <a href="index.jsp"> SignIn </a> Page </p>
                   
                     <%
                         try{
                             String msg=request.getAttribute("msg").toString();
                             if(msg!=null||msg.equalsIgnoreCase("")==false )
                             {%>
                                
                             <p style="color: #990099 "><%=msg%></p>
                            <% }
                             
                         }catch(Exception ex){}
                     %>
                     
		 </div>
			 
	 </div>
</div>
<!---->

<!---->

<!---->
<div class="bottom-grids">
	 <div class="container">
		
		 <div class="clearfix"></div>
	 </div>
</div>
<!---->
<div class="copywrite">
	 <div class="container">
			 
	 </div>
</div>
<!---->
</body>
</html>
