package com.vasanth.client;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class ExampleNodeJs {
	public static void main(String[] args) throws IOException, InterruptedException{
		String cmdPrompt="cmd";
		String path="/c";
		String npmUpdate="npm update";
		String mochaCmd="mocha";
		String filePath="E:\\DeveloperAutomationTask\\TaskExecutor\\NodeJS\\Nodejs";
		File jsFile=new File(filePath);
		String options="-R";
		String reporterCmd="xunit-file";
		
		/*List<String> updateCommand=new ArrayList<String>();
		updateCommand.add(cmdPrompt);
		updateCommand.add(path);
		updateCommand.add(npmUpdate);
		*/
		List<String> mochaCommand=new ArrayList<String>();
		mochaCommand.add(cmdPrompt);
		mochaCommand.add(path);
		mochaCommand.add(mochaCmd);
		mochaCommand.add(filePath);
		mochaCommand.add(options);
		mochaCommand.add(reporterCmd);
		
		//System.out.println(updateCommand);
		
		ProcessBuilder pb=new ProcessBuilder(mochaCommand);
		/*	Process result=pb.start();
		int errorCode=result.waitFor();
		System.out.println("NPM Update Command"+(errorCode==0?"\t Update Successfull":"\tUpdate Failure"));
		BufferedReader br=new BufferedReader(new InputStreamReader(result.getInputStream()));
		String line=null;
		StringBuilder sb=new StringBuilder();
		while((line=br.readLine())!=null){
			System.out.println(br.readLine());
			sb.append(line+System.getProperty("line.separator"));
		}
		System.out.println(sb);
	*/	
		System.out.println(mochaCommand);
		//pb.directory(jsFile);
	//	pb.command(mochaCommand);
		Process result1=pb.start();
		int errorCode1=result1.waitFor();
		System.out.println("RUN Command"+(errorCode1==0?"\t Mocha Successful":"\t Mocha failure"));
		BufferedReader br1=new BufferedReader(new InputStreamReader(result1.getInputStream()));
		StringBuffer sb1=new StringBuffer();
		String line1;
		
		while((line1=br1.readLine())!=null){
			
			sb1.append(line1+System.getProperty("line.separatore"));
			System.out.println(line1);
		}
		System.out.println(br1.toString().length());
		
	}
}
