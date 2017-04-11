package com.vasanth.client;

import java.io.File;
import java.io.IOException;

public class RunExecution {


	 private static String nuGetPackageCmd = "nuget restore";
	 private static String msBuildCmd = "msbuild";
	 private static String msBuildCmdOptions1 =" /t:ReBuild /p:Configuration=Debug;TargetFrameworkVersion=v4.5 /noconlog /fileLoggerParameters:LogFile=";
	 private static String msBuildCmdOptions2 = ";Verbosity=n;Encoding=UTF-8 /m";
	 private static String nunitConsole = "NUnit3-console";
	    

	//open command prompt
	//Navigate to project folder
	//run cmd npm update
	//run cmd mocha <file-path> -R xunit-file


	 private static String projectLocation;
	 private static String projectResult;

	 private static String NO_SOLUTION_FILE = "No Solution File";


	  public RunExecution()
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
			runSystemCommand(arg);
			  
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	       
	        return true;
	     
	  }

	  public void runSystemCommand(String command) throws IOException, InterruptedException
	  {
	   System.out.print("Process Launched");
	   
	      int p = Runtime.getRuntime().exec(command).waitFor();;
	 
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  System.out.println("Welcome !!!!!!");
		  String str=args[0];
		  RunExecution i=new RunExecution();
		  boolean status = i.execute(str);
		  System.out.println();
		  if(status)
			  System.out.println("Your Solution Executed Successfully ");

		 }

	}

