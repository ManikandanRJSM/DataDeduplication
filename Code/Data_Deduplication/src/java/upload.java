/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author cloudsim
 */
@WebServlet(urlPatterns = {"/upload"})
public class upload extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ///  String sa = "0";
        //   String sd = "0";
        List fileItemsList = null;
        float filesize = 0;
        String _fileLink;
        String _fileName = null;
        //   String _uploadDir = getServletContext().getRealPath("//myfile//");
//Change upload with your directory
        //   HttpSession session = request.getSession(true);

        if (ServletFileUpload.isMultipartContent(request)) {
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
            //  System.out.println("--------------Enter---------->");
            try {
                fileItemsList = servletFileUpload.parseRequest(request);
            } catch (FileUploadException ex) {
                Logger.getLogger(upload.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("" + ex.getMessage());
                //Change above line replace FileUploadExample with your file name
            }

            //  String  srcip=request.getRemoteHost();
            //  int srcprt=request.getServerPort();
            //  String desip="127.0.0.1";
            // int desprt=2000;
            //String port=request.getRemot
            String optionalFileName = "";
            String username = "";
            String dd = "";
            String mm = "";
            String yy = "";
            String age = "";
            String sex = "";
            String email = "";
            String connum = "";
            String addr_name = "";
            String hno = "";
            String street = "";
            String area = "";
            String pstoff = "";
            String dist = "";
            String pincde = "";
            String photo = "";
            String usrtyp="";
            System.out.println("--------------Enter---------->");
            FileItem fileItem = null;

            long srt = System.currentTimeMillis();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat st = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            System.out.println(dateFormat.format(date));

            Iterator it = fileItemsList.iterator();
            while (it.hasNext()) {
                FileItem fileItemTemp = (FileItem) it.next();
                if (fileItemTemp.isFormField()) {
                    if (fileItemTemp.getFieldName().equals("myfile")) {
                        optionalFileName = fileItemTemp.getString();
                        System.out.println(optionalFileName);
                    }

                    if (fileItemTemp.getFieldName().equals("email")) {
                        email = fileItemTemp.getString();
                        System.out.println(optionalFileName);
                    }
                    
                      if (fileItemTemp.getFieldName().equals("ut")) {
                        usrtyp = fileItemTemp.getString();
                        System.out.println(usrtyp);
                    }

                } else {
                    fileItem = fileItemTemp;
                }
            }

            String dob = yy + "-" + mm + "-" + dd;

            String fulladd = addr_name + "," + hno + "," + area + "," + street + "," + dist + "," + pincde;

            System.out.println("--------------Enter2---------->");

            if (fileItem != null) {
                long size_long = fileItem.getSize();
                filesize = size_long / 1024;
                filesize = filesize / 1000;

                if (filesize > 60.0) {

                } else {
                    _fileName = fileItem.getName();
                    if (fileItem.getSize() > 0) {

                        if (optionalFileName.trim().equals("")) {
                            _fileName = FilenameUtils.getName(_fileName);
                        } else {
                            _fileName = optionalFileName;
                        }
                        _fileLink = "//cloudserver//" + _fileName;
                        try {
                            out.println("fnz:" + fileItem.getName() + filesize);

                            String relativePath = getServletContext().getRealPath("");
                            String rpath=relativePath;
                            System.out.println("relativePath = " + relativePath);
                            relativePath = "/home/code/Deduplication/Code/Data_Deduplication/cstorage/";
                            String path = relativePath.trim() + "/data/";
                            //  String aadharnum=DOA_Services.getAadhaarNum();
                            File file = new File(path + fileItem.getName() );
                            fileItem.write(file);
                           
                            TFIDF.main(file.getAbsolutePath());
                            String mac = SHASEcure.SecureMAC(file.getAbsolutePath());

                            long fz = (file.length() / (1024));
                            String filz = fz + ":KB";
                            String bpath = path + "chunk/";
                            String fnname = file.getName();
                            int l = fnname.length();
                            String ext = fnname.substring(0, (l - 4));
                            File mk = new File(bpath + "/" + email);

                            if (!mk.exists()) {
                                mk.mkdir();
                            }
                            File mk1 = new File(bpath + "/" + email + "/" + ext);
                            if (!mk1.exists()) {
                                mk1.mkdir();
                            }
                            int sh = mac.getBytes().length;
                            String key = DOA_Services.getUserkey(email);
                            String umac = SHASEcure.userMAC(key);
                            String ss = mk1.getAbsolutePath();
                            //ss = ss.replace("\\", "\\\\");

                          FileEncryptUI sec=new FileEncryptUI();
                          double be=System.currentTimeMillis();
                                sec.secure(file.getAbsolutePath(), ss, mac);
                            double end=System.currentTimeMillis();
                            double Time=(end-be);
                             String path1 = rpath.trim() + "/cloudserver/" + fileItem.getName();
                             File f2=new File(path1);
                            fileItem.write(f2);
                           // String data="AESENC:"+Time+":"+filz;
                           // DOA_Services.ExcutionTimeCalc("/home/sentech/hdfs/namenode/AESENC.txt", data);
                            Boolean res = DOA_Services.VerifycloudFileDuplication(email, mac);
                            boolean fres=DOA_Services.verfiytheFileDeDuplication(file.getName()+".enc");
                            if (res || fres) {
                                BuildingBlocks b = new BuildingBlocks();
                              //  File f1 = new File(path + fileItem.getName());
                                // fileItem.write(f1);
                                long size = file.length();
                                int sz = (int) (size / 3);
                                ArrayList al = b.readAndFragment(file.getAbsolutePath(), sz, ss);                               
                                     request.setAttribute("bl", "DataDeduplicationtoShareblocks");
                                  DOA_Services.uploadFile2CloudServers(email, mac, file.getName()+".enc", filz, ss,usrtyp);
                            }else
                            {
                                  DOA_Services.uploadFile2CloudServers(email, mac, file.getName()+".enc", filz, "NoDuplication",usrtyp);
                            }
                         //  String aadharnum=DOA_Services.getAadhaarNum();
                            // String data="reg$"+aadharnum+"#"+username+"#"+email+"#"+sex+"#"+age+"#"+dob+"#"+fulladd+"#"+file.getName(); 
                            //    DB_Form.addAcount(username, email, aadharnum, connum, dob);
                            //DOA_Services das=new DOA_Services();
                            //    das.getAadhaarinfo(data);
                            //  String msg="your Informaation Added cloud successfuly! check your mail\n Thank You!";

                            request.setAttribute("fn", file.getName());
                            request.setAttribute("fz", filz);
                            request.setAttribute("SHA", sh + " bytes");
                            request.setAttribute("fmac", mac);
                            request.setAttribute("umac", umac);
                            RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp?email=" + email+"&type="+usrtyp);
                            dispatcher.forward(request, response);
//              

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
            // String referer = request.getHeader("Referer");
            // response.sendRedirect(referer);
        }

        try {
            /* TODO output your page here
             out.println("<html>");
             out.println("<head>");
             out.println("<title>Servlet upload</title>");
             out.println("</head>");
             out.println("<body>");
             out.println("<h1>Servlet upload at " + request.getContextPath () + "</h1>");
             out.println("</body>");
             out.println("</html>");
             */
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
