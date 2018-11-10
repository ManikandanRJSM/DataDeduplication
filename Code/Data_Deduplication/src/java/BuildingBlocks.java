/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cloudsim
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import javax.swing.*;


public class BuildingBlocks {


 public ArrayList<String> readAndFragment ( String SourceFileName, int CHUNK_SIZE ,String dest ) throws IOException
 {
  //log ("File Is Reading "+ SourceFileName );
  File willBeRead = new File ( SourceFileName );
  int FILE_SIZE = (int) willBeRead.length();
  ArrayList<String> nameList = new ArrayList<String> ();
  
  System.out.println("Total File Size: "+FILE_SIZE);
  
  int NUMBER_OF_CHUNKS = 0;
  byte[] temporary = null;
  
  try {
   InputStream inStream = null;
   int totalBytesRead = 0;
   
   try {
    inStream = new BufferedInputStream ( new FileInputStream( willBeRead ));
    
    while ( totalBytesRead < FILE_SIZE )
    {
     String PART_NAME ="data"+NUMBER_OF_CHUNKS+".bin";
     int bytesRemaining = FILE_SIZE-totalBytesRead;
     if ( bytesRemaining < CHUNK_SIZE ) // Remaining Data Part is Smaller Than CHUNK_SIZE
                // CHUNK_SIZE is assigned to remain volume
     {
      CHUNK_SIZE = bytesRemaining;
      System.out.println("CHUNK_SIZE: "+CHUNK_SIZE);
     }
     temporary = new byte[CHUNK_SIZE]; //Temporary Byte Array
     int bytesRead = inStream.read(temporary, 0, CHUNK_SIZE);
     
     if ( bytesRead > 0) // If bytes read is not empty
     {
      totalBytesRead += bytesRead;
      NUMBER_OF_CHUNKS++;
     }
     
     write(temporary, dest+"/"+PART_NAME);
        try {
            SHASEcure.SecureMAC(dest+"/"+PART_NAME);
        } catch (Exception ex) {
            Logger.getLogger(BuildingBlocks.class.getName()).log(Level.SEVERE, null, ex);
        }
     nameList.add(dest+"/"+PART_NAME);
     System.out.println("Total Bytes Read: "+totalBytesRead);
    }
    
   }
   finally {
    inStream.close();
   }
  }
  catch (FileNotFoundException ex)
  {
   ex.printStackTrace();
  }
  catch (IOException ex)
  {
   ex.printStackTrace();
  }
  return nameList;
 }
 
 void write(byte[] DataByteArray, String DestinationFileName){
     try {
       OutputStream output = null;
       try {
         output = new BufferedOutputStream(new FileOutputStream(DestinationFileName));
         output.write( DataByteArray );
         System.out.println("Writing Process Was Performed");
          output.close();
       }
       finally {
        
       } output.close();
     }
     catch(FileNotFoundException ex){
      ex.printStackTrace();
     }
     catch(IOException ex){
      ex.printStackTrace();
     }
 }
 
 public void mergeParts ( ArrayList<String> nameList, String DESTINATION_PATH )
 {
  File[] file = new File[nameList.size()];
  byte AllFilesContent[] = null;
     System.out.println(""+DESTINATION_PATH);
  int TOTAL_SIZE = 0;
  int FILE_NUMBER = nameList.size();
  int FILE_LENGTH = 0;
  int CURRENT_LENGTH=0;
  
  for ( int i=0; i<FILE_NUMBER; i++)
  {
   file[i] = new File (nameList.get(i));
   TOTAL_SIZE+=file[i].length();
  }
  
  try {
   AllFilesContent= new byte[TOTAL_SIZE]; // Length of All Files, Total Size
   InputStream inStream = null;
   
   for ( int j=0; j<FILE_NUMBER; j++)
   {
    inStream = new BufferedInputStream ( new FileInputStream( file[j] ));
    FILE_LENGTH = (int) file[j].length();
    inStream.read(AllFilesContent, CURRENT_LENGTH, FILE_LENGTH);
    CURRENT_LENGTH+=FILE_LENGTH;
    inStream.close();
   }
   
  }
  catch (FileNotFoundException e)
  {
   System.out.println("File not found " + e);
  }
  catch (IOException ioe)
  {
    System.out.println("Exception while reading the file " + ioe);
  }
  finally 
  {
   write (AllFilesContent,DESTINATION_PATH);
  }
  
  System.out.println("Merge was executed successfully.!");
  
 }
 
//public static void main(String a[])
//{
////     try {
//////         File F=new File("D:\\PSMPA.docx");
//////               long size=F.length();
//////               int sz=(int) (size/3);
//////         BuildingBlocks b=new BuildingBlocks();
//////         ArrayList al=b.readAndFragment(F.getAbsolutePath(), sz);
//////         System.out.println("-->"+al.toString());
////         
//////         ArrayList al=new ArrayList();
//////         al.add("E:\\2015\\java\\Distributed_Deduplication\\blocks\\data0.bin");
//////         al.add("E:\\2015\\java\\Distributed_Deduplication\\blocks\\data1.bin");
//////         al.add("E:\\2015\\java\\Distributed_Deduplication\\blocks\\data2.bin");
//////          al.add("E:\\2015\\java\\Distributed_Deduplication\\blocks\\data3.bin");
//////         al.add("E:\\2015\\java\\Distributed_Deduplication\\blocks\\data4.bin");
//////         al.add("E:\\2015\\java\\Distributed_Deduplication\\blocks\\data5.bin");
//////          al.add("E:\\2015\\java\\Distributed_Deduplication\\blocks\\data6.bin");
//////         al.add("E:\\2015\\java\\Distributed_Deduplication\\blocks\\data7.bin");
//////         al.add("E:\\2015\\java\\Distributed_Deduplication\\blocks\\data8.bin");
////         b.mergeParts(al, "E:\\2015\\java\\Distributed_Deduplication\\blocks\\"+F.getName());
////     } catch (Exception ex) {
////         Logger.getLogger(BuildingBlocks.class.getName()).log(Level.SEVERE, null, ex);
////     }
//    
//}
}