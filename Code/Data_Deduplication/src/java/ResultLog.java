/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author cloudsim
 */
public class ResultLog {
    
    
  public static void writeProcessResult(String data,String file_name)
  {
      try{
      BufferedWriter bw=new BufferedWriter(new FileWriter(file_name,true));
      bw.write(data+"\n");
      bw.close();
      }catch(Exception ex){}
  }
  
  public static ArrayList getResultLog(String Filename)
  {
      String line="";
      ArrayList data=new ArrayList();
      try{
      BufferedReader br=new BufferedReader(new FileReader(Filename));
      while((line=br.readLine())!=null)
      {
          data.add(line);
      }
      }catch(Exception ex){}
      return data;
  }
  
  public static void deleteResultLogFiles(String filename)
  {
      File f=new File(filename);
      if(f.exists())
      {
          f.delete();
      }
  }
  
    
}
