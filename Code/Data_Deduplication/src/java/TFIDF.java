
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sentech
 */
public class TFIDF {
    public static void main(String path)
    {
        File fpath=new File(path);
         try{
               
          Stopwordremoval swt=new Stopwordremoval();            
         String line="";
        // String path=jList1.getSelectedValue().toString();
           BufferedReader br=new BufferedReader(new FileReader(path));
           while((line=br.readLine())!=null)
           {
             // al.add(line);
                swt.main(line);
           }
           
           }catch(Exception ex){}
     
          Stopwordremoval.setTotalNumwords();
            double totwtmean=0.0,meanavg=0.0;
           try {
            // TODO add your handling code here:
            
           // File dir=new File("/home/sentech/hdfs/datanode/alt.atheism");
            
         //   File fl[]=dir.listFiles();
            
          String line1="";
            BufferedReader br1=new BufferedReader(new FileReader("/home/code/Deduplication/Code/Data_Deduplication/cstorage/Stemming.res"));
            double df=0.0;
            while((line1=br1.readLine())!=null)
            {
                String word=line1;
                System.out.println("Tokenization:"+word);
                
                
                 String abc = word;
      int []arr = new int[abc.length()];
     // System.out.println("THe asscii value of each character is: ");
      for(int i=0;i<arr.length;i++){
          arr[i] = abc.charAt(i); // assign the integer value of character i.e ascii
         // System.out.print(" "+arr[i]);
         String aaa= AsciiToBinary(""+arr[i]);
          System.out.println("Binary Conversion:"+aaa);
      }
                 double idf= FrequencyCount.findIDF(word);
           // for(int i=0;i<fl.length;i++)
          //  {
              df= FrequencyCount.findDF(word, fpath.getAbsolutePath());
                    double tw=df*idf;
               totwtmean=totwtmean+tw;
                     
                     if(df>0.0){
                         System.out.println(word+"===>Term Weighting(df*idf):("+df+"*"+idf+")="+tw);
                ResultLog.writeProcessResult(fpath.getName()+"#"+word+"#("+df+"*"+idf+")#"+tw , "Tearm_Weight.res");
        //    ResultLog.writeProcessResult(fl[i].getName()+"#"+word+"#"+df,"Fs2.res");
            break;
          
                //     }
            }
          
         meanavg=totwtmean/22;
               
            }
        
        }catch(Exception ex){
            System.out.println(""+ex.getMessage());
        }
        
     
        
    }
    
    public static String AsciiToBinary(String asciiString){  

          byte[] bytes = asciiString.getBytes();  
          StringBuilder binary = new StringBuilder();  
          for (byte b : bytes)  
          {  
             int val = b;  
             for (int i = 0; i < 8; i++)  
             {  
                binary.append((val & 128) == 0 ? 0 : 1);  
                val <<= 1;  
             }  
            // binary.append(' ');  
          }  
          return binary.toString();  
    }  
    
}
