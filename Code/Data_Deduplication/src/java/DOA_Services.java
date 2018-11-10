/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author cloudsim
 */
public class DOA_Services {
    
    
     public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;


  public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/securedds";
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, "root", "");
        return con;
    }
    
  public static int addUser2Cloud(String name,String pwd,String email,String dob,int key,String usertype)
  {
      int res=0;
      try{
      Connection con=getDBConnection();
      Statement st=con.createStatement();
      String sql="INSERT INTO `securedds`.`user` ( `uname`, `pwd`, `email`, `dob`, `u_key`,`usr_typ`) "
              + "VALUES ('"+name+"', '"+pwd+"', '"+email+"', '"+dob+"', '"+key+"','"+usertype+"');";
      
      res=st.executeUpdate(sql);
      }catch(Exception ex){}
      return res;
  }

  
  
  
  
  
  
  
  
  
  
  
  
   public static int deleteCloud(String email,String fname)
  {
      int res=0;
      try{
      Connection con=getDBConnection();
      Statement st=con.createStatement();
      String sql="delete  FROM `fileinfotab` WHERE `u_email`='"+email+"' and `f_name`='"+fname+"'";
      
      res=st.executeUpdate(sql);
      }catch(Exception ex){}
      return res;
  }
  
  
  
  public static int getUserKey()
  {
      int key=0;
      Random r=new Random();
      key=r.nextInt(100000);
      return key;
  }
  
  
   public static boolean VerifycloudUserAccount(String email,String pwd) throws SQLException, ClassNotFoundException {
        boolean res = false;
        int chk = 0;
        Connection con1 = getDBConnection();
        stmt = con1.createStatement();
        String sql = "SELECT * FROM `user` WHERE `email`='"+email+"' and `pwd`='"+pwd+"'";
        System.out.println(sql);
        rs = stmt.executeQuery(sql);
        // System.out.print("===>"+ rs.getFetchSize());

        
        while (rs.next()) {
           chk=1;
            
            }

    
         if (chk == 1) {
            res = true;
        } else {
            res = false;
        }
        con1.close();
        return res;
    }
  
 public static void uploadFile2CloudServers(String email,String tagid,String fname,String fsize,String blockdir,String usrtyp)
 {
     try{
     Connection con=getDBConnection();
     Statement st=con.createStatement();
     String sql="INSERT INTO `securedds`.`fileinfotab` (`u_email`, `tag_id`, `f_name`, `f_size`, `b_dir`,`utype`) "
             + "VALUES "
             + "('"+email+"', '"+tagid+"', '"+fname+"', '"+fsize+"', '"+blockdir+"','"+usrtyp+"');";
         System.out.println("query:"+sql);
     int res=st.executeUpdate(sql);
     }catch(Exception ex){}
 }
   
public static String getUserkey(String email)
{
    String key="";
    try{
    Connection con=getDBConnection();
      stmt = con.createStatement();
        String sql = "SELECT `u_key` FROM `user` WHERE `email`='"+email+"'";
        System.out.println(sql);
        rs = stmt.executeQuery(sql);
       while(rs.next())
       {
           key=rs.getString(1);
       }
        
        
    }catch(Exception ex){}
    return key;
}



public static String getUserType(String email ,String pwd)
{
    String usertype="";
    try{
    Connection con=getDBConnection();
      stmt = con.createStatement();
        String sql = "SELECT `usr_typ` FROM `user` WHERE `email`='"+email+"' and `pwd`='"+pwd+"'";
        System.out.println(sql);
        rs = stmt.executeQuery(sql);
       while(rs.next())
       {
           usertype=rs.getString(1);
       }
        
        
    }catch(Exception ex){}
    return usertype;
}



public static boolean VerifycloudFileDuplication(String email,String pwd) throws SQLException, ClassNotFoundException {
        boolean res = false;
        int chk = 0;
        Connection con1 = getDBConnection();
        stmt = con1.createStatement();
        String sql = "SELECT * FROM `fileinfotab` WHERE `u_email`='"+email+"' and `tag_id`='"+pwd+"'";
        System.out.println(sql);
        rs = stmt.executeQuery(sql);
       
        
        while (rs.next()) {
           chk=1;
            
            }

    
         if (chk == 1) {
            res = true;
        } else {
            res = false;
        }
        con1.close();
        return res;
    }


public static boolean verfiytheFileDeDuplication(String file)
{  boolean res = false;
         try {
           
             int chk = 0;
             Connection con1 = getDBConnection();
             stmt = con1.createStatement();
             String sql = "SELECT * FROM `fileinfotab` WHERE `f_name`='"+file+"'";
             System.out.println(sql);
             rs = stmt.executeQuery(sql);
             
             
             while (rs.next()) {
                 chk=1;
                 
             }
             
             
             if (chk == 1) {
                 res = true;
             } else {
                 res = false;
             }
             con1.close();
           
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(DOA_Services.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(DOA_Services.class.getName()).log(Level.SEVERE, null, ex);
         }
           return res;
    
}
 

public static void ExcutionTimeCalc(String Fielaname,String data)
{
    try{
    BufferedWriter bw=new BufferedWriter(new FileWriter(Fielaname));
    bw.write(data+"\n");
    bw.close();
    
    }catch(Exception ex){}
}

}
