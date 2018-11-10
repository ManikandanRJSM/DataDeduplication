/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author cloudsim
 */

import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.IOException; 
import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Collections; 
import java.util.HashSet; 
import java.util.List; 
import java.util.Set; 


public class FrequencyCount { 
 




public static double findDF(String word,String filename) throws FileNotFoundException, IOException
{
    double df=0.0,c=0.0;

boolean res=false;
    File file=new File(filename); 
FileReader fr=new FileReader(file); 
BufferedReader br=new BufferedReader(fr); 
String str=""; 
ArrayList al=new ArrayList();
al.clear();
while((str=br.readLine())!=null) 
{
    //System.out.println(""+str);
    //String s[]=str.split(" ");
    String line=str;
  int fw =line.indexOf(word);
   if(fw>=0)
   {
        // System.out.println(line);
    // System.out.println(fw);
       res=true;
     c++;
   }
    
}
//System.out.println(word+" : "+Collections.frequency(al, word)); 
double wrdfrq=c;
  //  System.out.println(c+"====>"+wrdfrq);
double totwrds=(double)getTotalnumberOfwords();
if(wrdfrq >= 1.0){
  df=(wrdfrq/totwrds);
//  if(res==true){
////ResultLog.writeProcessResult(word+":"+df, filename+".res");
//}

  }
br.close(); 

 
return df;

}



public static double findIDF(String word) throws FileNotFoundException, IOException
{
    double idf=0.0;
File file=new File("/home/code/Deduplication/Code/Data_Deduplication/cstorage/Stemming.res"); 
FileReader fr=new FileReader(file); 
BufferedReader br=new BufferedReader(fr); 
String str=""; 
ArrayList al=new ArrayList();
while((str=br.readLine())!=null) 
{
//str=str+" ";
//System.out.println(str); 
al.add(str);
}

//Set<String> uniqueWords=new HashSet<String>(al); 
//for(String word : uniqueWords) 
//{
//System.out.println(word+" : "+Collections.frequency(al, word)); 
int c=Collections.frequency(al, word);
double doc_con_wrd=(double)c;
if(doc_con_wrd>= 1.0){
 double val=(22.0/doc_con_wrd);
 idf=Math.log(val);
//System.out.println(word+" : "+Collections.frequency(al, word)+":"+idf); 

//}
}
br.close(); 
return idf;
}
        

public static double  getSumTv(String word)
        {
            double tot=0.0;
            try{
             String line1="";
            BufferedReader br1=new BufferedReader(new FileReader("/home/sentech/hdfs/Weight.res"));
            double val=0.0;
            double mean=0.0;
            while((line1=br1.readLine())!=null)
            {
                String word1=line1;
                String s[]=word1.split("#");   
                String mword=s[1];
                if(mword.equalsIgnoreCase(word))
                {
                 double value=Double.valueOf(s[2]);
                 val=val+value;
                }
              
            }         
         
             tot=val;
        
        }catch(Exception ex){
            System.out.println("error :"+ex.getMessage());
        }
            return tot;
    
}

public static long getTotalnumberOfwords()
{
    long tot=0;
    try{
    String line="";
      BufferedReader br=new BufferedReader(new FileReader("/home/sentech/hdfs/common.res"));
          while((line=br.readLine())!=null)
          {
           
              String dat=line;
              tot=Long.valueOf(dat);
              
          }
    }catch(Exception ex){}
    return tot;
}

} 