package com.vasanth.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExampleProcessBuilder {
	public static void main(String[] args) throws IOException, InterruptedException{
		ProcessBuilder pb=new ProcessBuilder("cmd","/c","echo","This is ECHO Functionality Checking");//,"echo","This is Process Builder Example for Echo");
		System.out.println("Running ECHO Command from Process Builder");
		Process process=pb.start();
		System.out.println("Process Started");
		int errCode=process.waitFor();
		System.out.println("Echo Command Executed "+(errCode==0?"\tNo Errors":"\tErrors"));
		System.out.println("Output of Echo Command Passed\t"+outputResult(process.getInputStream()));
		
	}
	private static String outputResult(InputStream inputResult) throws IOException{
		
		StringBuilder sb=new StringBuilder();
		BufferedReader br=null;
		
		try{
			
			br=new BufferedReader(new InputStreamReader(inputResult));
			String line=null;
			
			while((line=br.readLine())!=null){
				sb.append(line+System.getProperty("line.separator"));
				
			}
		}finally{
			br.close();
		}
		
		return sb.toString();
	}
}
/*package com.vasanth.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExampleProcessBuilder{
	public static void main(String[] args) throws InterruptedException,
			IOException {
		
		ProcessBuilder pb=new ProcessBuilder("cmd","dir");
		//ProcessBuilder pb = new ProcessBuilder("cmd","echo This is ProcessBuilder Example from JCG");
		System.out.println("Run echo command");
		Process process = pb.start();
		System.out.println("Process Started and Waiting");
		int errCode = process.waitFor();
		System.out.println("Echo command executed, any errors? " + (errCode == 0 ? "No" : "Yes"));
		System.out.println("Echo Output:\n" + output(process.getInputStream()));	
	}

	private static String output(InputStream inputStream) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + System.getProperty("line.separator"));
			}
		} finally {
			br.close();
		}
		return sb.toString();
	}
}
*/