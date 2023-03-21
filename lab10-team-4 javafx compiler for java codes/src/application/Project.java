package application;

import java.util.*;
import java.io.*;

class Project implements Serializable
{
   String name;
   ArrayList<JavaFile> listOfFiles;
   String path;
   
   Project(String prjName, String path)
   {
      name = prjName;
      listOfFiles = new ArrayList<JavaFile>();
      this.path = path;
   }
   
   static Project getInitialInstance(String path)
   {
	   Project prj = new Project("UsingPerson", path);
	   JavaFile f = new JavaFile("Person", path);
	   prj.addFile(f);
	   f = new JavaFile("UsingPerson", path);
	   prj.addFile(f);
	   
	   return prj;
   }
   
   static void saveProject(Project p) throws IOException
   {
	      FileOutputStream fos = new FileOutputStream(p.getPath() + "\\" +
	    		  										p.getName() + ".dat");
	      ObjectOutputStream outfile = new ObjectOutputStream(fos);
          outfile.writeObject(p);
          outfile.close();
   }
      
   static Project loadProject(String name, String path) throws IOException, ClassNotFoundException
   {
	      FileInputStream fis = new FileInputStream(path + "\\" + name + ".dat");
	      ObjectInputStream infile = new ObjectInputStream(fis);
          Project p = (Project) infile.readObject();
          infile.close();
          return p;
   }
   
   String getName()
   {
	   return name;
   }
   
   String getPath()
   {
	   return path;
   }
      
   void addFile(JavaFile file)
   {
      listOfFiles.add(file);
   }
   
   JavaFile get(int index)
   {
	   if (index >= 0 && index < listOfFiles.size())
		   return listOfFiles.get(index);
	   else
		   return null;
   }
   
   JavaFile search(String filename)
   {
      JavaFile temp = new JavaFile(filename, path);
      int index = listOfFiles.indexOf(temp);
      if (index == -1)
    	  return null;
      return listOfFiles.get(index);
   }
   
   String[] getListFilenames()
   {
	   String[] list = new String[listOfFiles.size()];
	   for (int i=0; i<listOfFiles.size(); i++)
		   list[i] = listOfFiles.get(i).getName();
	   
	   return list;
   }
   
   String compile()
   {
	  String output = "";
      Runtime env = Runtime.getRuntime();
      Process p;
      File dir = new File(path);
      String filename;
      
      boolean OK = true;
      int i = 0;
      while (i<listOfFiles.size() && OK)
      {
    	 filename = listOfFiles.get(i).getName();
    	 output += "\nCompiling " + filename + "\n";
         try {
        	 p = env.exec("javac " + filename + ".java", null, dir);
         } catch (IOException e) {
        	 return "Error compiling files";
         }
         Scanner scan = new Scanner(p.getErrorStream());
         if (!scan.hasNext())
        	 output += "Sucessfully compiled " + filename + "\n\n";
         else
         {
        	 output += "Compiling errors with " + filename + "\n\n";
        	 while (scan.hasNext())
        	 {
        		 output += scan.nextLine() + "\n";
        	 }
        	 OK = false;
         }
         i++;
      }
      
      return output;
   }

   String run()
   {
	  String output = "";
      Runtime env = Runtime.getRuntime();
      File dir = new File(path);
      Process p;
      try {
    	  p = env.exec("java " + name, null, dir);
      } catch (IOException e) {
    	  return "Error running the program";
      }
      Scanner scan = new Scanner(p.getInputStream());
      while (scan.hasNext())
      {
         output += scan.nextLine() + "\n";
      }
      scan.close();
      return output;
   }

   public String toString()
   {
      String str = "Project " + name + " contains:\n";
      for (int i=0; i<listOfFiles.size(); i++)
      {
         str += "\t" + listOfFiles.get(i) + "\n";
      }
      return str;
   }
}