package application;

import java.io.*;
import java.util.*;

class JavaFile implements Serializable
{
   String name;
   String path;
   String content;
   
JavaFile(String filename, String path)
   {
      name = filename;
      this.path = path;
      
      File myfile = new File(path + "\\" + filename + ".java");
      if (!myfile.isFile())
      {
    	  content = "";
    	  try 
    	  {
    		  save();
    	  }
    	  catch (IOException e)
    	  {
    		  // do nothing
    	  }
      }
   }
   
   String getName()
   {
      return name;
   }
   
   String getContent()
   {
	  return content;
   }
   
   void setContent(String content)
   {
	   this.content = content;
   }
   
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;

      if (!(obj instanceof JavaFile))
         return false; 

      JavaFile f = (JavaFile) obj;
      
      return name.equals(f.name);
   }
   
   public void load() throws IOException
   {
	   Scanner scan = new Scanner(new File(path + "\\" + name + ".java"));
	   content = "";
	   while (scan.hasNext()) {
	   		content += scan.nextLine() + "\n";
	   }
	   scan.close();
   }
   
   public void save() throws IOException
   {
	   PrintWriter outFile = new PrintWriter(path + "\\" + name + ".java");
	   outFile.println(content);
	   outFile.close();
   }

   public String toString()
   {
      return name;
   }
}