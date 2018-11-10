/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.bouncycastle.jcajce.provider.digest.SHA3;

public class SHASEcure 
{
    public static String SecureMAC(String path)throws Exception
    {
        String mac="";
          SHA3 s=new SHA3();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream(path);
        
        byte[] dataBytes = new byte[1024];
     
        int nread = 0; 
        while ((nread = fis.read(dataBytes)) != -1) {
          md.update(dataBytes, 0, nread);
        };
        byte[] mdbytes = md.digest();
     
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mdbytes.length; i++) {
          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }

       // System.out.println("Hex format : " + sb.toString());
        
       //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<mdbytes.length;i++) {
    	  hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
    	}
mac=hexString.toString();
    return mac;
        //image2binary();
        
     
    }
    
  
   public static void main(String a[]) throws NoSuchAlgorithmException
   {
      String input = "Hello world !";
      SHA3 s=new SHA3();
     
  

   // System.out.println("SHA3-512 = " + Hex.toHexString(digest)));
   }
       
     
   public static String userMAC(String k)
   {
       String mac="";
        
        try{
       MessageDigest md = MessageDigest.getInstance("SHA-256");
       md.update(k.getBytes());
        byte[] mdbytes = md.digest();
          StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mdbytes.length; i++) {
          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }
     //   System.out.println("Hex format : " + sb.toString());
        mac=sb.toString();
        }catch(Exception ex){}
        return mac;
   }
   
   }
    
   
  
   
