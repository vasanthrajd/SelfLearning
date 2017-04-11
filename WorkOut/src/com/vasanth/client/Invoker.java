
/*package com.vasanth.client;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;


public class Invoker {

 private static String nuGetPackageCmd = "nuget restore";
 private static String msBuildCmd = "msbuild";
 private static String msBuildCmdOptions1 =" /t:ReBuild /p:Configuration=Debug;TargetFrameworkVersion=v4.5 /noconlog /fileLoggerParameters:LogFile=";
 private static String msBuildCmdOptions2 = ";Verbosity=n;Encoding=UTF-8 /m";
 private static String nunitConsole = "NUnit3-console";
    
 public static void main(String[] args) throws Exception {
	   System.out.println("Welcome !!!!!!");
	   Invoker i = new Invoker();
	   String arg=args[0];
	   boolean status = i.execute(arg);
	   
	   if(status)
		   System.out.println("Your Solution Executed Successfully ");
	   
}
//open command prompt
//Navigate to project folder
//run cmd npm update
//run cmd mocha <file-path> -R xunit-file


 private static String projectLocation;
 private static String projectResult;

 private static String NO_SOLUTION_FILE = "No Solution File";


  public Invoker()
  {
     projectLocation = System.getenv("project_home");
     
     projectResult = System.getenv("project_result");
     
  }
 

  public boolean execute(String arg)
  {
	  try{
		   //runSystemCommand("cd C:\\Users\\rajui\\Desktop\\NodeJs\\nodejs");
		   //runSystemCommand("notepad.exe");
	    //runSystemCommand("npm");
	    //runSystemCommand("mocha test\\andriod-test.js -R xunit-file");
		runSystemCommand(nuGetPackageCmd +" "+ arg);
		
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
       
        return true;
     
  }

  public void runSystemCommand(String command) throws IOException, InterruptedException
  {
   System.out.println("Process Launched");
   
      int p = Runtime.getRuntime().exec(command).waitFor();
      
      if(p > -1)
      {
         System.out.println(command);
         System.out.println("Process Completed");
      }
  }

  public String getProjectSolutionFile()
  {
     try
     {
         File folder = new File(projectLocation);
         File[] listOfFiles = folder.listFiles();

         for (int i = 0; i < listOfFiles.length; i++) 
         {
           if (listOfFiles[i].isFile()) 
           {
             String name = listOfFiles[i].getName();
             if(name.contains(".sln"))
             return name;
             System.out.println("File " + listOfFiles[i].getName());
           } 
        }
    }
    catch(Exception e)
    {
       e.printStackTrace();
    }
  
    return NO_SOLUTION_FILE;
 }
  

  
}*/
package com.vasanth.client;
import java.io.*;
import java.io.ObjectInputStream.GetField;

public class Invoker {
  public static void main(String args[]) {
    try {
      String line,line1;
     /*  Process p=Runtime.getRuntime().exec("cmd /c npm update ",
    	        null, new File("E:\\RunPgms\\Nodejs"));
      
      //Process p = Runtime.getRuntime().exec("cmd /c cd E:\\RunPgms\\Nodejs");
      //p=Runtime.getRuntime().exec("cmd /c npm update");
      BufferedReader bri = new BufferedReader
        (new InputStreamReader(p.getInputStream()));
      BufferedReader bre = new BufferedReader
        (new InputStreamReader(p.getErrorStream()));
      while ((line = bri.readLine()) != null) {
        System.out.println(line);
      }
      bri.close();
      while ((line = bre.readLine()) != null) {
        System.out.println(line);
      }
      bre.close();
      p.waitFor();
      System.out.println("Done.");
    */  
      Process p1=Runtime.getRuntime().exec("cmd /c mocha -R xunit-file",
  	        null, new File("E:\\Run Pgms\\Nodejs"));
      BufferedReader bri1 = new BufferedReader
    	        (new InputStreamReader(p1.getInputStream()));
    	      BufferedReader bre1 = new BufferedReader
    	        (new InputStreamReader(p1.getErrorStream()));
    	      while ((line1 = bri1.readLine()) != null) {
    	        System.out.println(line1);
    	      }
    	      bri1.close();
    	      while ((line1 = bre1.readLine()) != null) {
    	        System.out.println(line1);
    	      }
    	      bre1.close();
    	      p1.waitFor();
    	      System.out.println("Done.Second");
    }
    catch (Exception err) {
      err.printStackTrace();
    }
  }
}