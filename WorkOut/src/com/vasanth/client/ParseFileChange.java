/**
 * 
 */
package com.vasanth.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author EE206105
 *
 */
public class ParseFileChange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String appiumURL="\"http://10.51.2.68:8080/da/ensemble/device/27c881d2-1c78-4c2e-8857-949c8cb141d3/25053/web/appium/wd/hub/\"";
			String app1="'http://ssubram1-lt73.clients.dynatrace.org:6232/resource/device/appium/wd/hub/'";
			String line=null;
			List<String> lines=new ArrayList<String>();
			//File f=new File("E:\\DeveloperAutomationTask\\ProjectBundle\\Nodejs\\android-test.js");
			//String f="C:\\Users\\ee206105\\Desktop\\AddExpense.cs";
			String f="C:\\Users\\ee206105\\Desktop\\android-test-1.js";
			String newText="var appiumUrl = url.parse('http://ssubram1-lt73.clients.dynatrace.org:6232/resource/device/appium/wd/hub/');";
			try{
			FileReader fr = new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			FileWriter fw = new FileWriter(f.replace(".js", "-1.js"));
			BufferedWriter bw=new BufferedWriter(fw);
			while((line=br.readLine())!=null){
				if(line.contains("<URL>")){
					line=line.replace(line, newText);
				/*	System.out.println(line.indexOf("url.parse("));
					System.out.println(line.indexOf(")"));*/
					System.out.println(line);
					/*System.out.println(line.replace(line.subSequence(line.indexOf("(")+1, line.indexOf(")")), app1));
					line=line.replace(line.subSequence(line.indexOf("(")+1, line.indexOf(")")), app1);*/
					//line=line.replace("url.parse(",appiumURL);
					bw.write(line);
					bw.newLine();
				}else{
					bw.write(line);
					bw.newLine();
				}
				
			}
			br.close();
			fr.close();
			bw.close();
			fw.close();
			}
			/*FileWriter wr=new FileWriter(f);
			BufferedWriter bw=new BufferedWriter(wr);			
			for(String s:lines){
					bw.write(s);
			}
			bw.flush();
			bw.close();
			wr.close();
			}*/
			catch(Exception e){
				System.out.println(e.getStackTrace());
			}
	}

}
