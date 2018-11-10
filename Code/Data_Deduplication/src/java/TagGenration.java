/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cloudsim
 */
import java.io.File;
import java.util.ArrayList;


import javax.swing.SwingUtilities;

import org.mcavallo.opencloud.Cloud;
import org.mcavallo.opencloud.Tag;

public class TagGenration {



protected void initUI() {

 Cloud cloud = new Cloud();
ArrayList al=new ArrayList();

for(int i=0;i<al.size();i++)
{

    String tag=al.get(i).toString();
    cloud.addTag(tag);
 }
 for (Tag tag : cloud.tags()) {
     
     System.out.println(""+tag.getName());

 }

 }



}
