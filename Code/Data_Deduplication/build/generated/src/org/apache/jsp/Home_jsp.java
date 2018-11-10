package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title> </title>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel='stylesheet' type='text/css' />\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <!-- Custom Theme files -->\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <!-- Custom Theme files -->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <meta name=\"keywords\" content=\"Charity Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, \n");
      out.write("              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design\" />\n");
      out.write("        <script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!---->\n");
      out.write("          ");

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
                
      out.write("\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"header-top\">\n");
      out.write("                    <div class=\"logo\">\n");
      out.write("\n");
      out.write("                       <a href=\"#\"><h3>Sign In:");
      out.print(email);
      out.write("</h3></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"hdr-address\">\n");
      out.write("                        <div class=\"address1\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"call\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"clearfix\"></div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"clearfix\"> </div>\n");
      out.write("                    <!-- search-scripts -->\n");
      out.write("                    <script src=\"js/classie.js\"></script>\n");
      out.write("                    <script src=\"js/uisearch.js\"></script>\n");
      out.write("                    <script>\n");
      out.write("                        new UISearch(document.getElementById('sb-search'));\n");
      out.write("                    </script>\n");
      out.write("                    <!-- //search-scripts -->\n");
      out.write("                </div>\n");
      out.write("              \n");
      out.write("                \n");
      out.write("                <div class=\"top-menu\">\n");
      out.write("                    <span class=\"menu\">MENU</span>\n");
      out.write("                    <ul>\n");
      out.write("                        <li class=\"active\"><a href=\"Home.jsp?email=");
      out.print(email);
      out.write("&type=\"");
      out.print(usertyp);
      out.write("><span class=\"glyphicon glyphicon-home\" aria-hidden=\"true\"></span>Home</a></li>\n");
      out.write("                        <li><a href=\"Recover.jsp?email=");
      out.print(email);
      out.write("&type=\"");
      out.print(usertyp);
      out.write("><span class=\"glyphicon glyphicon-picture\" aria-hidden=\"true\"></span>View</a></li>\n");
      out.write("                        <li><a href=\"index.jsp\"><span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span>Logout</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\t\t <!-- script-for-menu -->\n");
      out.write("                <script>\n");
      out.write("                    $(\"span.menu\").click(function() {\n");
      out.write("                        $(\".top-menu ul\").slideToggle(\"slow\", function() {\n");
      out.write("                        });\n");
      out.write("                    });\n");
      out.write("                </script>\n");
      out.write("                <!-- script-for-menu -->\t\n");
      out.write("                <div class=\"clearfix\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!---->\n");
      out.write("        <div class=\"banner\">\n");
      out.write("            <div class=\"container\">\t\t\t\n");
      out.write("                <script src=\"js/responsiveslides.min.js\"></script>\n");
      out.write("                <script>\n");
      out.write("                    $(function() {\n");
      out.write("                        $(\"#slider\").responsiveSlides({\n");
      out.write("                            auto: true,\n");
      out.write("                            nav: false,\n");
      out.write("                            speed: 500,\n");
      out.write("                            namespace: \"callbacks\",\n");
      out.write("                            pager: true,\n");
      out.write("                        });\n");
      out.write("                    });\n");
      out.write("                </script>\n");
      out.write("                <div class=\"slider\">\n");
      out.write("                    <div class=\"callbacks_container\">\n");
      out.write("                        <ul class=\"rslides\" id=\"slider\">\n");
      out.write("                             \n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!----->\t\t  \n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!---->\n");
      out.write("        <div class=\"welcome\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"welcome-top\">\n");
      out.write("                    \n");
      out.write("                    <h3> Signed User Type :");
      out.print(ut);
      out.write("</h3><br/>\n");
      out.write("                    <h3>File Upload</h3><br/>\n");
      out.write("                    <center>\n");
      out.write("                        <form action=\"upload\" method=\"POST\"  enctype=\"multipart/form-data\">   \n");
      out.write("\n");
      out.write("                            <table>\n");
      out.write("\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Load File </td>\n");
      out.write("                                        <td></td>\n");
      out.write("                                        <td><input type=\"file\" name=\"myfile\" value=\"\" /></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td><input type=\"hidden\" name=\"email\" value=\"");
      out.print(email);
      out.write("\" /></td>\n");
      out.write("                                        <td><input type=\"hidden\" name=\"ut\" value=\"");
      out.print(usertyp);
      out.write("\" /></td>\n");
      out.write("                                        <td>&nbsp;&nbsp;</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td></td>\n");
      out.write("                                        <td></td>\n");
      out.write("                                        <td><input  type=\"submit\" value=\"Submit\" />&nbsp;&nbsp;&nbsp;<input type=\"reset\" value=\"Clear\" /></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                        </form></center>\n");
      out.write("\n");
      out.write("                    ");


                    
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"clearfix\"></div>\n");
      out.write("                    <br/>\n");
      out.write("                    <h4><u>File Upload Details:</u></h4>\n");
      out.write("\n");
      out.write("                    ");
                              try {
                            String fz = request.getAttribute("fz").toString();
                            String fmac = request.getAttribute("fmac").toString();
                            String umac = request.getAttribute("umac").toString();
                            String fn = request.getAttribute("fn").toString();
                            String sha = request.getAttribute("SHA").toString();
                           
                    
      out.write("\n");
      out.write("\n");
      out.write("                    <p style=\"color: #990099 \">File Name :");
      out.print(fn);
      out.write("</p>\n");
      out.write("                    <p style=\"color: #990099 \">File Size :");
      out.print(fz);
      out.write("</p>\n");
      out.write("                    <p style=\"color: #990099 \">SHA-3 Output Size :");
      out.print(sha);
      out.write("</p>\n");
      out.write("                    <p style=\"color: #990099 \">File secure key:");
      out.print(fmac);
      out.write("</p>\n");
      out.write("                    <p style=\"color: #990099 \">user secure key:");
      out.print(umac);
      out.write("</p>\n");
      out.write("                    ");

                     String bl = request.getAttribute("bl").toString();
                    if(bl!=null){
                    
      out.write("\n");
      out.write("\n");
      out.write("                      <p style=\"color: #990099 \">De-Duplication:");
      out.print(bl);
      out.write("</p>\n");
      out.write("                    \n");
      out.write("                      ");
 } } catch (Exception ex) {
                       }
                    
                    }catch(Exception ex){}
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!---->\n");
      out.write("\n");
      out.write("        <!---->\n");
      out.write("\n");
      out.write("        <!---->\n");
      out.write("        <div class=\"bottom-grids\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <div class=\"clearfix\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!---->\n");
      out.write("        <div class=\"copywrite\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!---->\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
