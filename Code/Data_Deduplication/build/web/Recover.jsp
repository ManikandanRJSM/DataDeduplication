
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%-- 
    Document   : Home
    Created on : Jan 8, 2016, 5:51:29 PM
    Author     : cloudsim
--%>

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
          <%
                    try{
                        String email=request.getParameter("email").toString();
                         String usertyp=request.getParameter("type").toString();
                %>
        <div class="header">
            <div class="container">
                <div class="header-top">
                    <div class="logo">

                       <a href="#"><h3>Sign In:<%=email%></h3></a>
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
                    <h3>File Download/Delete </h3><br/>
                    <%
                      String url = "jdbc:mysql://localhost:3306/securedds";
        Class.forName("com.mysql.jdbc.Driver");
      Connection  con = DriverManager.getConnection(url, "root", "");
      Statement stmt = con.createStatement();
        String sql = "SELECT DISTINCT f_name,tag_id,f_size,b_dir FROM `fileinfotab` WHERE `u_email`='"+email+"' ";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
       
        
        
                    %>                    

                        <table border="1">
                            <thead>
                                <tr>
                                    
                                    <th>ECC Encrypted File</th>
                                      <th>ECC public Key File</th>
                                    <th>ECC Private key</th>
                                     <th>Size</th>
                                    <th>Download</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            
                      <%
        while (rs.next()) {
            
            String  dataenc=rs.getString(1).toString().trim().replace("enc", "key");
                      %>      
                            <tbody>
                                <tr>
                                    <td><%=rs.getString(1) %></td>
                                    <td> <%=dataenc%></td>
                                     <td><%=rs.getString(2) %></td>
                                        <td><%=rs.getString(3)%></td>
                                            <td><a href="Download?fn=<%=rs.getString(1)%>">Download</a></td>
                                          <td><a href="Recover?fn=<%=rs.getString(1)%>&d=<%=rs.getString(1)%>&e=<%=email%>">Delete</a></td>
                                        
                                </tr>
                             
                            </tbody>
                            
                         <%
        }
                         %>   
                        </table>

                     

                  

                    <div class="clearfix"></div>
                    <br/>
                  <%
                    
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
