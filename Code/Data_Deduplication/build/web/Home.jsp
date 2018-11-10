
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> </title>
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
          <%
                    try{
                        String ut="";
                        String email=request.getParameter("email").toString();
                         String usertyp=request.getParameter("type").toString();
                         if(usertyp.equalsIgnoreCase("1"))
                         {
                             ut="DataOwner";
                         }else
                         {
                               ut="DataHolder";  
                                 }
                %>
        <div class="header">
            <div class="container">
                <div class="header-top">
                    <div class="logo">

                      <a href="#"><h3>Welcome:<%=email%></h3></a>
                    </div>
                    <div class="hdr-address">
                        <div class="address1">

                        </div>
                        <div class="call">

                        </div>
                        <div class="clearfix"></div>
                    </div>

                    <div class="clearfix"> </div>
                    <!-- search-scripts -->
                    <script src="js/classie.js"></script>
                    <script src="js/uisearch.js"></script>
                    <script>
                        new UISearch(document.getElementById('sb-search'));
                    </script>
                    <!-- //search-scripts -->
                </div>
              
                
                <div class="top-menu">
                    <span class="menu">MENU</span>
                    <ul>
                        <li class="active"><a href="Home.jsp?email=<%=email%>&type="<%=usertyp%>><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
                        <li><a href="Recover.jsp?email=<%=email%>&type="<%=usertyp%>><span class="glyphicon glyphicon-picture" aria-hidden="true"></span>View</a></li>
                        <li><a href="index.jsp"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>Logout</a></li>
                    </ul>
                </div>		 <!-- script-for-menu -->
                <script>
                    $("span.menu").click(function() {
                        $(".top-menu ul").slideToggle("slow", function() {
                        });
                    });
                </script>
                <!-- script-for-menu -->	
                <div class="clearfix"></div>
            </div>
        </div>
        <!---->
        <div class="banner">
            <div class="container">			
                <script src="js/responsiveslides.min.js"></script>
                <script>
                    $(function() {
                        $("#slider").responsiveSlides({
                            auto: true,
                            nav: false,
                            speed: 500,
                            namespace: "callbacks",
                            pager: true,
                        });
                    });
                </script>
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
                    
                    <h3> Signed User Type :<%=ut%></h3><br/>
                    <h3>File Upload</h3><br/>
                    <center>
                        <form action="upload" method="POST"  enctype="multipart/form-data">   

                            <table>

                                <tbody>
                                    <tr>
                                        <td>Load File </td>
                                        <td></td>
                                        <td><input type="file" name="myfile" value="" /></td>
                                    </tr>
                                    <tr>
                                        <td><input type="hidden" name="email" value="<%=email%>" /></td>
                                        <td><input type="hidden" name="ut" value="<%=usertyp%>" /></td>
                                        <td>&nbsp;&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td><input  type="submit" value="Submit" />&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear" /></td>
                                    </tr>
                                </tbody>
                            </table>
                        </form></center>

                    <%

                    %>

                    <div class="clearfix"></div>
                    <br/>
                    <h4><u>File Upload Details:</u></h4>

                    <%                              try {
                            String fz = request.getAttribute("fz").toString();
                            String fmac = request.getAttribute("fmac").toString();
                            String umac = request.getAttribute("umac").toString();
                            String fn = request.getAttribute("fn").toString();
                            String sha = request.getAttribute("SHA").toString();
                           
                    %>

                    <p style="color: #990099 ">File Name :<%=fn%></p>
                    <p style="color: #990099 ">File Size :<%=fz%></p>
                    <p style="color: #990099 ">SHA-3 Output Size :<%=sha%></p>
                    <p style="color: #990099 ">File secure key:<%=fmac%></p>
                    <p style="color: #990099 ">user secure key:<%=umac%></p>
                    <%
                     String bl = request.getAttribute("bl").toString();
                    if(bl!=null){
                    %>

                      <p style="color: #990099 ">De-Duplication:<%=bl%></p>
                    
                      <% } } catch (Exception ex) {
                       }
                    
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
