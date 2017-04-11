package com.vasanth.client;
import java.io.*;
public class LocateFilePath {

	static String fileName="";
	static String fileName1="";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileLocation="C:\\Users\\ee206105\\Desktop\\Today's Task\\NunitFile\\NunitFile";
		String fileLocation1="C:\\Users\\ee206105\\Desktop\\Today's Task\\Nodejs\\Nodejs1";
		String filePath="Path to the .sln File";
		
		/*filePath=getSLNFilePath(fileLocation);
	
		File slnFile=new File(filePath);
		
		if(filePath.isEmpty()){
			System.out.println("No Solution File");
		}
		
		if(slnFile.isFile()&&slnFile.getName().contains(".sln")){
			System.out.println(slnFile.getName());
			System.out.println(slnFile.getParent());
			System.out.println(slnFile.getParentFile());
			System.out.println(slnFile.getName());
			System.out.println("sln file");
			
			
		}else{
			System.out.println("No .sln File");
		}*/
		String jsonFile=getJSONFilePath(fileLocation1);
		File jsonFilePath=new File(jsonFile);
		
		if(jsonFilePath.getName().contains("package.json")){
			System.out.println(jsonFilePath);
		}
		
		String jsFile=getJSFile(jsonFilePath.getParent());
		
		System.out.println(jsFile);
		
	}
	private static String getSLNFilePath(String file){
			
		try{
			File folder=new File(file);
			File[] listofFiles=folder.listFiles();
			
			for(int i=0;i<listofFiles.length;i++){
				if(listofFiles[i].isFile()){
					String name=listofFiles[i].getName();
					if(name.contains(".sln")){
						
						fileName=listofFiles[i].getCanonicalPath();
													
					}
				} else {
					
					if(listofFiles[i].isDirectory()){
						getSLNFilePath(listofFiles[i].toString());
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	 
	  return fileName;
	}
	private static String getJSONFilePath(String file){
		
		try{
			
			File folder=new File(file);
			File[] listofFiles=folder.listFiles();
			for(int i=0;i<listofFiles.length;i++){
				if(listofFiles[i].isFile()){
					String name=listofFiles[i].getName();
					if(name.contains(".json")){
						fileName1=listofFiles[i].getCanonicalPath();
					}
				} 
				else 
				{
					if(listofFiles[i].isDirectory()&&listofFiles.length==1){
							getJSONFilePath(listofFiles[i].toString());
					}
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return fileName1;
	}
	private static String getJSFile(String file){
		try{
			File folder=new File(file+"\\test");
			File[] fileList=folder.listFiles();
			for(int i=0;i<fileList.length;i++){
				if(fileList[i].isFile()){
					String name=fileList[i].getName();
					if(name.contains(".js")){
						//System.out.println(name);
						return fileList[i].getName();
					}
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
}
