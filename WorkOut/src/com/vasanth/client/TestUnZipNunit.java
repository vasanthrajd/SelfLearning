package com.vasanth.client;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.*;

public class TestUnZipNunit {

		public static void main(String[] args) throws IOException, InterruptedException{
			String zipFilePath="E:\\DeveloperAutomationTask\\TaskExecutor\\NodeJS\\Nodejs.zip";
			//String destFolder="E:\\HarmonyHead\\tmp\\31e0758d-b0b2-4e2b-95cf-1d449e441883\\0140807a-8161-4a66-a209-aaf8672f9324\\559";
			String destFolder="E:\\DeveloperAutomationTask\\TaskExecutor\\NodeJS\\Nodejs";
			String strFile="E:\\DeveloperAutomationTask\\xunit.xml";
			String dummy="E:\\DeveloperAutomationTask\\vasanth.json";
			/*String move=destFolder+File.separator;
			 
			 * Reading the ZIPFile Entry
			 
			String outZip=destFolder;
			try {
				ZipInputStream zipRead=new ZipInputStream(new FileInputStream(zipFilePath));
				try {
					ZipEntry zipContent=zipRead.getNextEntry();
					move=move+zipContent.getName().substring(0, zipContent.getName().length()-1);
					while(zipContent!=null){
						outZip=destFolder+File.separator+zipContent.getName();
						if(zipContent.isDirectory()){
							File directory=new File(outZip);
							directory.mkdir();
						}else{
							BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(outZip));
							byte[] cont=new byte[4096];
							int i;
							while((i=zipRead.read(cont))!=-1){
								bos.write(cont, 0, i);
							}
							bos.close();
						}
						zipRead.closeEntry();
						zipContent=zipRead.getNextEntry();
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/		
			System.out.println(destFolder);
			System.out.println(dummy);
			File f=new File(dummy);
				
			
				
				
			String cmdPrompt="cmd";
			String path="/c";
			String npmUpdate="npm update";
			String npm="npm";
			String update="update";
			String mochaCmd="mocha";
			File jsFile=new File(destFolder);
			String options="-R";
			String reporterCmd="xunit-file";
			
			
		/*	String commnad="cmd /c "+npm+" update \""+destFolder+"\"";
			System.out.println(commnad);
	        int p=Runtime.getRuntime().exec(commnad).waitFor();
	        if(p>-1){
	        	System.out.println("SUCCESS");
	        }*/
			/*int count=0;
			File[] listOfFiles=jsFile.listFiles();
			for(int i=0;i<listOfFiles.length;i++){
	            if(listOfFiles[i].isFile()){
	                String name=listOfFiles[i].getName();
	                System.out.println(name);
	                if(name.contains(".js"))
	                    count++;  
	                if(name.endsWith(".js"))
	                	System.out.println("ENDS WITH WORKED");
	            }	
	        }
			System.out.println(count);*/
			
			/*
			String runUpdate=cmdPrompt+" "+path+" "+npmUpdate+" \""+destFolder+"\"";
			System.out.println("Executing Command in the File Path"+runUpdate);
			
			Process p=Runtime.getRuntime().exec(runUpdate);
			BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
		    BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		    String line;
		      while ((line = bri.readLine()) != null) {
		        System.out.println(line);
		      }
		      bri.close();
		      while ((line = bre.readLine()) != null) {
		        System.out.println(line);
		      }
		      bre.close();
		    
			if(p.waitFor()>-1){
				System.out.println("Command Executed Succssfulyy");
			}*/
			
			String runUpdte="\""+destFolder+"\"";
			List<String> updateCommand=new ArrayList<String>();
			/*updateCommand.add(cmdPrompt);
			updateCommand.add(path);*/
			updateCommand.add(npm);
			updateCommand.add(update);
			/*updateCommand.add(npm);
			updateCommand.add(update);*/
			//updateCommand.add(runUpdte);
			
			runExecution(updateCommand,jsFile);

			List<String> mochaCommand=new ArrayList<String>();
			mochaCommand.add(cmdPrompt);
			mochaCommand.add(path);
			mochaCommand.add(mochaCmd);
			mochaCommand.add(options);
			mochaCommand.add(strFile);
			
			//runExecution(mochaCommand, jsFile);
			
		}
		public static void runExecution(List<String> command, File navigatePath) throws IOException, InterruptedException{
			try{
			System.out.println(command);
			ProcessBuilder executeProcess=new ProcessBuilder(command);
			if(command.get(0)=="npm update"){
				String strFileNpm="C:\\Program Files\\nodejs";
			/*	Map<String, String> shellEnv=executeProcess.environment();
				shellEnv.put("npm", strFileNpm);*/
			}
			if(command.get(0)=="mocha"){
				String strFile="E:\\DeveloperAutomationTask\\TaskExecutor\\NodeJS\\xunit.xml";
				/*Map<String,String> shellEnvir=executeProcess.environment();
				shellEnvir.put("XUNIT_FILE", strFile);*/
								
			}
			/*
			 * This is to Show Environmnet Variable allocation.
			System.out.println("Execute Environment>>>"+executeProcess.environment());
			
			Set<String> keys=executeProcess.environment().keySet();
			for(String str:keys){
				System.out.println("Key ="+str+"\t Value = "+executeProcess.environment().get(str));
			}*/
			
			executeProcess.directory(navigatePath);
			
			Process resultExecution=executeProcess.start();
			BufferedReader br=new BufferedReader(new InputStreamReader(resultExecution.getInputStream()));
			StringBuffer sb=new StringBuffer();
			BufferedReader br1=new BufferedReader(new InputStreamReader(resultExecution.getErrorStream()));
			StringBuffer sb1=new StringBuffer();
			
			String line, line1;
			while((line=br.readLine())!=null){
				sb.append(line+System.getProperty("line.separator"));
				System.out.println(line);
			}
			while((line1=br1.readLine())!=null){
				sb1.append(line1+System.getProperty("line.separator"));
			}
			br.close();
			br1.close();
			System.out.println("size of string Buffer\t"+br.toString().length());
			int resultStatust=resultExecution.waitFor();
			System.out.println("Result of Execution"+(resultStatust==0?"\tSuccess":"\tFailure"));
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
		
		}
		
	}


