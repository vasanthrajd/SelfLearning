package com.vasanth.client;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ExampleNuGET {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println(" Ouput ");
		String NUGET="nuget.exe";
		String RESTORE="restore";
		//String filePath="C:\\Users\\ee206105\\Desktop\\Today's Task\\NunitFile\\TwoStepScript\\EMTest";
		String filePath="D:\\DeveloperAutomationTask\\TaskExecutor\\Nuget\\02-FirstSeleniumScriptWithTestClass";
		//String filePath="C:\\Users\\ee206105\\Desktop\\Today's Task\\NunitFile\\EMTest";
		String solutionFile="02-FirstSeleniumScriptWithTestClass.sln";
		//String solutionFile="02-FirstSeleniumScriptWithTestClass.sln";
		String cmdPrompt="cmd";
		String path="/c";
		
		List<String> runList=new ArrayList<String>();
		System.out.println("Curent Environment\t"+System.getenv());
		File fileLocation=new File(filePath);
		/*runList.add(cmdPrompt);
		runList.add(path);*/
		runList.add(NUGET);
		runList.add(RESTORE);
		runList.add(solutionFile);
		System.out.println(runList);
		//runList.add(filePath);
		
		/*String[] strList=filePath.split(" ");
		String str="";
		for(String s:strList){
			System.out.println(s);
			str+=s;
		}
		System.out.println(System.getProperty("file.separator"));
		System.out.println(str);
		runList.add(str);
		*/
		//runExecution(runList, fileLocation);
		
		/*ProcessBuilder pb=new ProcessBuilder(runList);
		System.out.println(pb.command());
		pb.directory(fileLocation);
		Process processResult=pb.start();
		int errCode=processResult.waitFor();
		System.out.println("Result of Execution"+(errCode==0?"\tSuccess":"\tFailure"));
		BufferedReader br=new BufferedReader(new InputStreamReader(processResult.getInputStream()));
		while((br.readLine())!=null){/
			System.out.println(br.readLine());
		}*/
		
		String msBuild="msbuild.exe";
		String option1="/t:ReBuild";
		String option2="/p:Configuration=Debug;TargetFrameworkVersion=v4.5";
		String option3="/noconlog";
		String option4="/fileLoggerParameters:LogFile=D:\\DeveloperAutomationTask\\TaskExecutor\\Nuget\\mylog.log;Verbosity=n;Encoding=UTF-8";
		String option5="/m";
		
		List<String> runList1=new ArrayList<String>();
		/*runList1.add(cmdPrompt);
		runList1.add(path);*/
		runList1.add(msBuild);
		runList1.add(solutionFile);
		runList1.add(option1);
		runList1.add(option2);
		runList1.add(option3);
		runList1.add(option4);
		runList1.add(option5);
		System.out.println(runList1);
		//runExecution(runList1, fileLocation);
		
		String NUCONSOLE="nunit3-console.exe";
		File dllPath=new File("D:\\DeveloperAutomationTask\\TaskExecutor\\Nuget\\02-FirstSeleniumScriptWithTestClass");
		String dllFile="02-FirstSeleniumScriptWithTestClass.sln";
		String resultCMD="-result";
		String resultFile="D:\\DeveloperAutomationTask\\TaskExecutor\\Nuget\\02-FirstSeleniumScriptWithTestClass\\result.xml";
		
		List<String> runList2=new ArrayList<String>();
		/*runList2.add(cmdPrompt);
		runList2.add(path);*/
		runList2.add(NUCONSOLE);
		runList2.add(dllFile);
		runList2.add(resultCMD);
		runList2.add(resultFile);
		System.out.println(runList2);
		//runExecution(runList2, dllPath);
		
		
	}
	public static void runExecution(List<String> command, File navigatePath) throws IOException, InterruptedException{
		System.out.println(command);
		ProcessBuilder executeProcess=new ProcessBuilder(command);
		executeProcess.directory(navigatePath);
		System.out.println(command);
		Process resultExecution=executeProcess.start();
		BufferedReader br=new BufferedReader(new InputStreamReader(resultExecution.getInputStream()));
		StringBuffer str=new StringBuffer();
		String line, line1;
		while((line=br.readLine())!=null){
			str.append(line+"line.separator");
			System.out.println(line);
		}
		System.out.println(br.toString());
		
		BufferedReader brErr=new BufferedReader(new InputStreamReader(resultExecution.getErrorStream()));
		StringBuffer strErr=new StringBuffer();
		while((line1=brErr.readLine())!=null){
			strErr.append(line1+"line.separator");
			System.out.println(line1);
		}
		System.out.println(brErr.toString());
		br.close();
		brErr.close();
		int resultCode=resultExecution.waitFor();
		System.out.println("Result of Method Execution"+(resultCode==0?"Success in Execution":"Error in Execution"));
		
	}

}
